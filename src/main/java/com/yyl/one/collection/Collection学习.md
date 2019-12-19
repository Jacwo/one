### ArrayList源码
- 实现了RandomAccess接口说明是支持随机访问的。
```
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
```
- 默认的容量是10
```
    private static final int DEFAULT_CAPACITY = 10;
```
- 底层实现使用的是数组
```
//使用transient修饰表示数组不会被序列化，为什么加它修饰呢，因为arraylist具有动态扩容的特性。
transient Object[] elementData;
```
- 扩容
```
// JDK1.8 add()方法
public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
```
```
//校验数组是否越界
private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
}
```
```
private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }
```
```
//
private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // 当前容量大于数组长度则扩容
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
```
```
private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
				//扩容1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
				//数组复制
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```
- 删除元素
需要调用System.arraycopy将index+1后面的元素都复制到index位置上
```
 public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }
```

### Vector 源码
实现与ArrayList类似，但是使用了synchronized同步
```$xslt

public synchronized boolean add(E e) {
     modCount++;
     ensureCapacityHelper(elementCount + 1);
     elementData[elementCount++] = e;
     return true;
}

public synchronized E get(int index) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);

        return elementData(index);
}

```
- ArrayList和LinkedList异同
    1. 是否保证线程安全  都不能
    2. 底层数据结构 ArrayList底层使用的是Object数组  linkedLiest使用的是双向链表
    3. 插入和删除是否受元素位置影响
        - ArrayList采用数组存储插入和删除的时间复杂度受元素位置影响 插入表头和表尾复杂度为O(1) 指定位置插入需要移动位置复杂度近似O(N)
        - LinkedList采用链表存储 插入和删除元素的复杂度不受元素位置影响近似O(1)
    4. 是否支持快速访问
- ArrayList和Vector的区别
    1. Vector是同步的,开销比ArrayList要大，访问速度要慢，最好用ArrayList而不是Vector，因为同步操作，完全可以由我们自己控制。
    2. Vector每次扩容请求其大小2倍的空间，而ArrayList是1.5倍
- Vector的替代方案
    1. synchronizedList
        可以使用Collections.synchronizedList();得到一个线程安全的ArrayList
        ```
        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);
        ```
    2. CopyOnWriteArrayList
       ```$xslt
        List<String> list=new CopyOnWriteArrayList<>();
        ```
        这个容器即写时复制容器，通俗的理解就是当我们添加元素的时候，不直接往当前容器添加，而是先讲容器进行copy，复制出一个新的容器
        ，然后在新的容器中添加元素，添加之后在将原容器指向新的容器。读写分离的思想。
        ```
        public boolean add(E e) {
                final ReentrantLock lock = this.lock;
                lock.lock();
                try {
                    Object[] elements = getArray();
                    int len = elements.length;
                    //复制新数组
                    Object[] newElements = Arrays.copyOf(elements, len + 1);
                    //添加元素到新数组
                    newElements[len] = e;
                    //原数组引用指向新数组
                    setArray(newElements);
                    return true;
                } finally {
                    lock.unlock();
                }
            }

        ```
        读的时候不需要加锁，可能会造成，当前由多线程添加元素的同时，有个线程读取数据，会读到旧的数据
        ``` 
            public E get(int index) {
               return get(getArray(), index);
           }
        ```
        缺点
        1. 内存占用问题
        2. 数据一致性问题
### LinkedList
基于双向链表实现，内部使用Node来存储链表的节点信息，也是实现了list接口。
```
private static class Node<E> {
           E item;
           Node<E> next;
           Node<E> prev;
   
           Node(Node<E> prev, E element, Node<E> next) {
               this.item = element;
               this.next = next;
               this.prev = prev;
           }
       }
```
每个链表存储了Head和Tail指针,实现方式决定了所有跟下标操作相关的都是线性时间，而在首段或者末尾删除元素只需要常数
时间，没有使用synchroinized，如果需要支持同步，可以使用Collections.syachronizedList()方法包装
```
transient Node<E> first;
  transient Node<E> last;
```
add方法
```$xslt
public void addFirst(E e) {
        linkFirst(e);
    }

private void linkFirst(E e) {
        final Node<E> f = first;
        //新增节点
        final Node<E> newNode = new Node<>(null, e, f);
        //头节点指向新节点
        first = newNode;
        //如果原先链表为空
        if (f == null)
               //最后一个节点也指向新节点
            last = newNode;
        else
            //把原先的头节点挂到新节点后面
            f.prev = newNode;
        size++;
        modCount++;
    }

```
指定下标新增
```
public void add(int index, E element) {
            //检验是否越界  
           checkPositionIndex(index);
            //如果是最后一个直接链接到最后
           if (index == size)
               linkLast(element);
           else
           //
               linkBefore(element, node(index));
       }
       
Node<E> node(int index) {
        // assert isElementIndex(index);
        //通过下标去计算在链表的前半部分还是后半部分
        if (index < (size >> 1)) {
            //遍历链表查询该下标的节点，
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }       
       
void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        //保存插入节点的前驱节点信息
        final Node<E> pred = succ.prev;
        //新建节点
        final Node<E> newNode = new Node<>(pred, e, succ);
        //下标节点挂载到新建节点后面
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            //前驱节点指向新增节点
            pred.next = newNode;
        size++;
        modCount++;
    }
```
remove（）
```
public boolean remove(Object o) {
        //移除null元素
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
        //遍历链表移除非空元素
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }


E unlink(Node<E> x) {
        // assert x != null;
        // 待移除元素值
        final E element = x.item;
        //记录后继节点
        final Node<E> next = x.next;
        //记录前驱节点
        final Node<E> prev = x.prev;
        //如果前驱节点是null,移除的位置刚好是第一个
        if (prev == null) {
            //下一节点作为头节点
            first = next;
        } else {
            //前驱节点不是bull 前驱节点指向下一节点
            prev.next = next;
            //被删除的节点移除
            x.prev = null;
        }
        //如果后继节点是空，移除的位置刚好是最后一个
        if (next == null) {
        //前驱节点作为最后节点
            last = prev;
        } else {
        //后继节点指向前一个节点
            next.prev = prev;
        //被删除的节点移除
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }
```
get()
```
//分析过了，了解
public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
}
    
Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
```
### 总结
- LinkedList插入、删除都是移动指针效率较高
- 查找需要进行遍历效率低
- ArrayList和LinkedList
    1. ArrayList基于动态数组实现，LinkedList基于双向链表实现
    2. ArrayList支持随机访问，LinkedList不支持
    3. LinkedList在任意位置添加删除元素快

### HashMap
1. 底层如何存储数据的
2. HashMap几个主要的方法
3. HashMap是如何确定元素存储位置的一级如何处理哈希冲突的
4. HashMap的扩容机制是怎样的
5. Jdk1.8在扩容和解决Hash冲突上对H啊是M阿婆源码做了那些改动，有什么好处？

- JDK1.7之前采用拉链法来存储数据，即数组和链表结合的方式
拉链法又叫做链地址法，简单来说就是数组加链表的组合。在每个数组元素上存储的都是一个链表
不能的key可能经过Hash运算得到相同的地址，但是一个数组单位上只能存放一个元素
采用链地址放以后，如果遇到相同的hash值的key的时候，我们可以=将它放在数组元素的链表上
待我们去取元素的时候通过Hash运算的结果找到这个链表，在在链表中找到与key相同的节点，就能
找到key相应的值

- JDK1.8之后HashMap底层在解决哈希冲突的时候，就不蛋蛋使用数组加上链表的组合了，因为当处理hash值
冲突较多的情况下，链表的长度会越来越长，此时通过但链表寻找对应key对应的value时候时间复杂读达到O(n)
因此在1.8之后，在链表新增节点导致链表长度超过TREEIFY_THRESHOLD=8的时候，就会在添加元素的同时将原来
的链表转化为红黑树。

```$xslt
//Node是HashMap的一个内部类，实现了Map.Entry接口，本质是一个映射

static class Node<K,V> implements Map.Entry<K,V> {
        //用来定位数组索引位置
        final int hash; 
        final K key;
        V value;
        //链表的下一个node
        Node<K,V> next; 

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
```
HashMap是使用哈希表来存储的，哈希表为解决冲突可以采用开放地址法和链地址法等来解决问题
Java中的HashMap采用了链地址法。简单雷说就是数组加链表的组合，在每个数组元素上都加上一个链表
机构，当数据被hash后，得到数组下标，把数据放在对应下标元素的链表上
map.put("dog","二狗");
程序执行当前代码，系统将使用key的hashcode方法得到其hashCode值，然后在通过Hash算法的元素安确定建值对的存储
位置，又是两个key会定位到相同的位置，表示发生了Hash碰撞，Hash算法计算结果越分散均匀，Hash碰撞的概率就越小
map的存取效率就越高。

如果哈希桶数组很大，即使较差的hash算法也会比较分散。如果哈希桶数组很小，好的hash算法也会出现较多的碰撞
- 重要参数
1. buckets 在HashMap的注释里使用hash桶来形象的表示数组中每个地址的位置
2. capacity table的容量大小默认16 需要保证capacity必须保证是2的n次方
3. size     table的实际用量
4. threshold size的临界值 size必须小于threshold如果大于等于则进行扩容
5. loadFactor  装载因子，table能够使用的比例threshold=loadFactor*capacity
6. TREEIFY_THRESHOLD 大于8转化红黑树
7. UNTREEIFY_THRESHOLD 小于6转化链表
- 确定Hash桶数组的位置
int hash=hash(key);
int i=indexFor(hash,table.length);
1. 计算hash值
```$xslt
 static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

```
2. put方法1.8
```$xslt
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //1.tab为空则创建，初始化容量、加载因子threshold
        // Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
         //根据hash值判断在数组中的位置,如果当前没有值直接new节点存储
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            //如果寻找的table数组有值，则判断key有没有存在
            Node<K,V> e; K k;
            //通过key查找到value直接进行替换
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //没有找到。就判断是不是红黑树
            else if (p instanceof TreeNode)
            //新建红黑树节点
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
            //如果是链表
                for (int binCount = 0; ; ++binCount) {
                 //链表中没有找到相同key
                    if ((e = p.next) == null) {
                    //把新的节点挂载到最后面
                        p.next = newNode(hash, key, value, null);
                        //判断是不是到了转化红黑树的时机
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                           //链表转化红黑树
                            treeifyBin(tab, hash);
                        break;
                    }
                    //找到相同的key 存在
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            //找到相同的key 存在直接覆盖操作
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
        //扩容
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```
扩容操作
```$xslt
final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        // 原先有元素扩容
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        //重新计算在new数组的位置
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                            //如果是二叉树拆
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                      //
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            //原先索引
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            //原索引+oldCap
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        //原索引放到bucket里
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        //原索引+oldCap放到bucket里
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
```
```
public class DoubleLinkedList{
    private Node first;
    private Node last;
    private int length;
    class Node{
        int data;
        Node pre;
        Node next;
        public Node(Node pre,Node next,int data){
            this.data=data;
            this.next=next;
            this.pre=pre;
        }

    }
     public void addFirst(int data){
        if(first==null){
            Node node=new Node(null,null,data);
            this.first=node;
            this.last=node;
            this.length++;

        }else{
            Node node=new Node(null,first,data);
            this.first.pre=node;
            this.first=node;
            length++;
        }

     }


     public void addLast(int data){
        if(first==null){
             Node node=new Node(null,null,data);
             this.first=node;
             this.last=node;
             length++;
        }else{
            Node node=new Node(last,null,data);
            this.last.next=node;
            this.last=node;
            length++;
        }
     }

     //在某个元素之前插入
     public void insertPre(int ele,int data){
        Node index=this.first;
        while(index!=null){
            if(index.data==ele)
            break;
            index=index.next;
        }

        Node node=new Node(index.pre,index.last,index.data);
        index.pre=node;
        index.pre.next=node;
        length++;
     }
}
```