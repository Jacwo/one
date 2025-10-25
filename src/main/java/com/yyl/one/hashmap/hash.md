### hashcode和equals
- 重写了equals方法为什么要重写hashcode
  更好的为hashMap等集合使用，如果不重写hashCode当使用对象作为key的时候
会出现 equals比较相同，但是在hashMap被认作不同的key，hashmap源码key是根据hashcode方法计算的


1.先判断数组是不是null 空的话调用resize进行数组的初始化。
2.数组不为null就利用hash和数组长度取余，定位在数组中的位置
3.如果此时数组为空，说明key没有hash冲突，直接newNode放在数组里
4.数组不为空，说明有了hash冲突，
5.然后会先比较头节点，判断key存在不存在（ 只有hash值相等并且key也相同）才算相同的key
5.存在key，就会进行value的替换
6.不存在key，就会判断是不是红黑树，是红黑树就执行红黑树方法 put
7.不是红黑树，就会启动for循环遍历每个结点判断key存不存在。存在就替换，不存在就会在链表尾部newNode放进去。
8.最后进行扩容检查


扩容

1.获取老数组的容量和阈值
2.定义新数组，容量和阈值*2
3.遍历老数组。
4.如果只有一个元素，直接放到新数组上、
5.然后判断类型是不是红黑树红黑树走红黑树的迁移
6.否则就是链表，遍历遍历链表，然后判断hash值和oldCap == 0 放地位
7.否则放高位链表。
8.低位链表放在低位数组
9.高位链表放在高位数组
```java

  static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	
	
	
```
- equals不同hashCode可以相同
```java
final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
			//  如果不重写hashcode方法，可能出现equals方法相等但是hashcode不同，可能导致悖论，明明相同的对象却查不出来。
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```
