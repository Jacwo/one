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
- Collections.syncXxxx() 线程安全原理，内部有一个mutex对象，操作前都需要获取mutex对象锁，使用他保证线程安全。
- ArrayList和LinkedList异同
    1. 是否保证线程安全  都不能
    2. 底层数据结构 ArrayList底层使用的是Object数组  linkedList使用的是双向链表
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
不同的key可能经过Hash运算得到相同的地址，但是一个数组单位上只能存放一个元素
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
             //此处是hashMap线程不安全的点，假如线程A执行的此处，让出cpu，线程b也出现了hash冲突，进入此处，完成了节点的新增，
             //此时回到A之后，就会吧B线程的节点覆盖
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
        //++size线程不安全
        if (++size > threshold)
        //扩容
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```
扩容操作
```$xslt
/ ** 
   *    If the table is empty, it is not initialized. If threshold. is greater than 0, 
   * use its value as the length of the initialized table and the method ends; if threshold. is 0, 
   * use the default value as the length of the initialized table, method End; 
   * If the table is not empty, that is, it has been initialized, 
   * and the original table length is already very large (>= MAXIMUM_CAPACITY), 
   * then change the threshold to the maximum (Integer.MAX_VALUE) and return, no additional expansion operation is required
   * If the original table length is not very large, the table length is doubled. 
   * If the table length after the expansion is less than the maximum length (2^30), 
   * and the original table length is greater than the default initial length, 
   * the new threshold is the original threshold Double (that is, loadfactor times the new length)
   * If the table is not empty, it has been initialized, 
   * and the length of the table is changed, and the contents of the original table need to be copied
 * @return the table
 */
 
final Node<K,V>[] resize() {
    Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;
         if (oldCap> 0) {//The table has been initialized
                 //If the original table length is already very large (>= MAXIMUM_CAPACITY),
                 // The threshold becomes the maximum (Integer.MAX_VALUE),
                 // Just return, no additional expansion operation is required
        if (oldCap >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }
         else if (oldThr> 0) // Use a custom length. The initial table length is stored in the threshold. Note: The table length is not necessarily the specified length. The table length is greater than or equal to the minimum power of 2 of the custom length. Details See tableSizeFor() method
        newCap = oldThr;
         else {// threshold is 0 means use the default value
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
         if (newThr == 0) {//Use a custom length
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
         if (oldTab != null) {//table copy
        for (int j = 0; j < oldCap; ++j) {
            Node<K,V> e;
            if ((e = oldTab[j]) != null) {
                oldTab[j] = null;
                                 if (e.next == null)//Only one node recalculates the position of the bucket
                    newTab[e.hash & (newCap - 1)] = e;
                                 else if (e instanceof TreeNode)//The case of the red-black tree
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                                 else {// In the case of a linked list, keep the relative order in the original linked list
                                                 //Split the original linked list into two, the position of one bucket is still the original position (newTab[j), and the other is the position of the original bucket and the length of the original table (newTab[j + oldCap])
                                                 //The basis for splitting is whether the node hash value & oldCap is 0
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    do {
                        next = e.next;
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
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
线程安全性
在多线程使用场景中，应该尽量避免使用线程不安全的hashmap，而是使用线程安全的
ConcurrentHashMap

- HashMap和Hashtable
    1. hashtable使用synchronized来进行同步
    2. HashMap可以插入建为null的entry
    3. HashMap的迭代器是fail-fast迭代器
    4. Hashmap不能保证随着时间的推移map中的元素次序是不变的
- 小结
    1. 扩容是一个特别消耗性能的操作，所有当使用HashMap的时候，覆默认值，避免频繁扩容
    2. 负载因子是可以修改的，但也可以大于1
    3. HashMap是线程不安全的，不要在并发环境中操作HashMap 建议使用ConcurrentHashMap
    4. JDK1.8引入红黑树很大程度优化了HashMap性能
    
### ConcurrentHashMap
哈希表是非常高兴，复杂度为O(1)的数据结构，在JAVA开发中，我们最常见到最频繁使用的就是HashMap和
HashTable，但是在线程竞争激烈的并发场景中使用都不够合理
```$xslt
    //初始化数组
    //如果sizeCtl小于0，说明别的数组正在进行初始化，让出执行权
    //如果大于0 则出事后一个大小为sizeCtl的数组
    //否则出事后一个默认大小的数组
    //然后设置sizeCtl的值为数组长度的3/4
    private final Node<K,V>[] initTable() {
            Node<K,V>[] tab; int sc;
            while ((tab = table) == null || tab.length == 0) {
                if ((sc = sizeCtl) < 0)
                    Thread.yield(); // lost initialization race; just spin
                else if (U.compareAndSwapInt(this, SIZECTL, sc, -1)) {
                    try {
                        if ((tab = table) == null || tab.length == 0) {
                            int n = (sc > 0) ? sc : DEFAULT_CAPACITY;
                            @SuppressWarnings("unchecked")
                            Node<K,V>[] nt = (Node<K,V>[])new Node<?,?>[n];
                            table = tab = nt;
                            sc = n - (n >>> 2);
                        }
                    } finally {
                        sizeCtl = sc;
                    }
                    break;
                }
            }
            return tab;
        }

    //使用unsafe方法，通过直接操作内存的方式来保证并发处理的安全性，使用的是硬件安全机制
 static final <K,V> Node<K,V> tabAt(Node<K,V>[] tab, int i) {
        return (Node<K,V>)U.getObjectVolatile(tab, ((long)i << ASHIFT) + ABASE);
    }
    //cas原子操作，在指定位置设定值
    static final <K,V> boolean casTabAt(Node<K,V>[] tab, int i,
                                        Node<K,V> c, Node<K,V> v) {
        return U.compareAndSwapObject(tab, ((long)i << ASHIFT) + ABASE, c, v);
    }
    //原子操作，在指定位置设定值   
    static final <K,V> void setTabAt(Node<K,V>[] tab, int i, Node<K,V> v) {
        U.putObjectVolatile(tab, ((long)i << ASHIFT) + ABASE, v);
    }

 final V putVal(K key, V value, boolean onlyIfAbsent) {
        //key value不能为空，否则抛出异常
        if (key == null || value == null) throw new NullPointerException();
        //取得key的hash值
        int hash = spread(key.hashCode());
        //用来计算这个节点总共有多少元素，用来控制扩容或者转移树
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh;
            if (tab == null || (n = tab.length) == 0)
            //第一次put的时候table没有初始化，则初始化table
                tab = initTable();
                //通过hash计算出一个表中的位置，因为n是数组的长度哦所以(n-1)&hash不会出现数组越界
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
            //如果这个位置没有元素的化，则通过cas的方式尝试添加，这个时候没有加锁
                if (casTabAt(tab, i, null,
                             new Node<K,V>(hash, key, value, null))) //创建一个Node添加到数组中，null表示下一节点为空
                    break;                   // no lock when adding to empty bin
            }
            //如果检测到某个节点的hash值是MOVED，则表示正在进行数组扩张的数据复制阶段
            //则当前线程也会参与去复制，通过允许多线程编程复制的功能，一次来减少数组复制带来的损失
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else {
            /**
            * 如果这个位置有元素的话，就采用synchronized加锁
            * 如果链表的话，就对这个链表所有元素进行遍历
            * 如果找到key和key的hash值都一样的节点则把他的值替换
            * 如果没有找到则添加在链表的后面
            * 否则，是树的话则调用putTreeVal方法添加到树中
            * 在添加完之后会对该节点上关联的数目进行判断
            * 如果8个以上的话，则会转化为树或者扩容
            */
                V oldVal = null;
                synchronized (f) {
                //再次取出要存储位置的元素，跟前面取出来的比较
                    if (tabAt(tab, i) == f) {
                    //取出来的元素的hash值大于0，当转换树之后hash值为-2
                        if (fh >= 0) {
                            binCount = 1;
                            for (Node<K,V> e = f;; ++binCount) { //遍历链表
                                K ek;
                                //要存的元素的hash，key跟要存储的位置的节点相同的时候，替换调该节点value
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)//当使用putIfAbsend的时候，只有这个key没有设置值的时候裁设置
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                //如果不是同样的hash同样的key的时候则判断该节点的下一节点是否为空，空的话把这个要加入的节点
                                //设置为当前节点的下一节点
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key,
                                                              value, null);
                                    break;
                                }
                            }
                        }
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                    }
                }
                if (binCount != 0) {
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount);
        return null;
    }  
```
### HashSet
是对HashMap的简单包装，对HashSet的函数调用都会转换成合适的HashMap方法，因此HashSet的实现非常简单
```$xslt
//HashSet是对HashMap的简单包装
public class HashSet<E>
{
    ......
    private transient HashMap<E,Object> map;//HashSet里面有一个HashMap
    // Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();
    public HashSet() {
        map = new HashMap<>();
    }
    ......
    public boolean add(E e) {//简单的方法转换
        return map.put(e, PRESENT)==null;
    }
    ......
}

```
- 成员变量
```$xslt
    private transient HashMap<E,Object> map;

    // Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();

```
- 构造函数
```$xslt
public HashSet(){
    map=new HashMap<>();
}

public HashSet(int initialCapacity,float loadFactor){
    map=new HashMap<>(initialCapacity,loadFactor);
}
```
- add()
比较关键的就是这个add方法，可以看出它是将存放的对象当作HashMap的key学
由于HashMap的key是不能重复的，所以每当有重复的值写入到Hashset时value会被覆盖
但是key不会受到影响，这样就保证了HashSet中只能存放不重复的元素
```$xslt
public boolean add(E e){
    return map.put(e,present)==null;
}
```
### linkedHashSet和LinkedHashMap
LinkedHashMap
1.LinkedHashMap是继承于HashMap，是基于HashMap和双向链表来实现的。
2.HashMap无序；LinkedHashMap有序，可分为插入顺序和访问顺序两种。如果是访问顺序，那put和get操作已存在的Entry时，
都会把Entry移动到双向链表的表尾(其实是先删除再插入)。
3.LinkedHashMap存取数据，还是跟HashMap一样使用的Entry[]的方式，双向链表只是为了保证顺序。
4.LinkedHashMap是线程不安全的。
linkedHashSet
添加什么顺序就是什么顺序
hashset
会排序根据 hashCode值来决定该对象在HashSet中存储位置。

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

##
## Collections.synchronized(HashMap) 和concurrentHashMap

synchronized()内部有一个mutex对象，所有操作都需要获取这个对象的锁
concurrentHashMap ， 1.7使用的是分段锁，锁的力度较细，1.8使用cas加synchronized
实现线程安全，cas不会造成线程阻塞，synchronized会锁住node节点即链表，不会影响其他线程操作别的node节点


### 生产者消费者模型解决的问题
1.解偶、
2.异步