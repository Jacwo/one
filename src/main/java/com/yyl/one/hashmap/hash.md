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
