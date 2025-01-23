### hashcode和equals
- 重写了equals方法为什么要重写hashcode
  更好的为hashMap等集合使用，如果不重写hashCode当使用对象作为key的时候
会出现 equals比较相同，但是在hashMap被认作不同的key，hashmap源码key是根据hashcode方法计算的
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
