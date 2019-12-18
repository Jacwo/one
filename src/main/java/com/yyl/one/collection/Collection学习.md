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
每个链表存储了Head和Tail指针,实现方式
```
transient Node<E> first;
  transient Node<E> last;
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