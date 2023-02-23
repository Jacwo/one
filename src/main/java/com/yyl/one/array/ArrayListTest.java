package com.yyl.one.array;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author yangyuanliang
 * @Date 2022/11/24 14:59
 * @Version 2.0
 **/
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("222");
        Object[] elementData = new Object[3];
        elementData[0] = "0";
        elementData[1] = "1";

        elementData[2] = "2";
        System.out.println(elementData.length);

        Object[] objects = Arrays.copyOf(elementData, 6);
        System.out.println(objects.length);
        // 每次新增会检测扩容，扩容是基于数组的复制
        /**
         *  Arrays.copyOf(elementData, newCapacity);
         *  System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
         */

        List<String> list2=new CopyOnWriteArrayList<>();
        // 写操作会先获取到锁，复制数组，生成一个新的，然后再新数组上操作写入，
        list2.add("222");
        // 读操作还在原数组获取，读写分离
        list2.get(0);
        /**
         * 基于双向
         */
        List<String> list3=new LinkedList<>();
        list3.add("3");
        list3.remove("3");
        // 方法是同步的
        List<String> list4 =new Vector<>();
        list4.add("4");
        list4.remove("4");
        // 线程安全继承了Vector，先进后出
        Stack<String> list5 =new Stack<>();
        //入栈放在最后
        list5.push("222");
        //从最后取
        list5.pop();
        // ---------------------------------------------------------
        /**
         *  final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
         *                    boolean evict) {
         *         Node<K,V>[] tab; Node<K,V> p; int n, i;
         *         if ((tab = table) == null || (n = tab.length) == 0)
         *             n = (tab = resize()).length;
         *         if ((p = tab[i = (n - 1) & hash]) == null)
         *             tab[i] = newNode(hash, key, value, null);
         *         else {
         *             Node<K,V> e; K k;
         *             if (p.hash == hash &&
         *                 ((k = p.key) == key || (key != null && key.equals(k))))
         *                 e = p;
         *             else if (p instanceof TreeNode)
         *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
         *             else {
         *                 for (int binCount = 0; ; ++binCount) {
         *                     if ((e = p.next) == null) {
         *                         p.next = newNode(hash, key, value, null);
         *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
         *                             treeifyBin(tab, hash);
         *                         break;
         *                     }
         *                     if (e.hash == hash &&
         *                         ((k = e.key) == key || (key != null && key.equals(k))))
         *                         break;
         *                     p = e;
         *                 }
         *             }
         *             if (e != null) { // existing mapping for key
         *                 V oldValue = e.value;
         *                 if (!onlyIfAbsent || oldValue == null)
         *                     e.value = value;
         *                 afterNodeAccess(e);
         *                 return oldValue;
         *             }
         *         }
         *         ++modCount;
         *         if (++size > threshold)
         *             resize();
         *         afterNodeInsertion(evict);
         *         return null;
         *     }
         */
        Map<String,Object> map =new HashMap<>();
        // 判断有没有冲突，没有冲突直接放到对应的table中，冲突的话，先到冲突的问题，然后替换他的value
        // 可以经过改造，变成去除最老的节点
        map.put("1","1");
        map.put("2","2");map.get("2");
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("5","5");
        map.put("4","4");
        map.put("6","6");
        map.put(null,"222");
        map.forEach((k,v)->{
            System.out.println("map:"+k+"---"+v);
        });
        // 节点是有序的，put的newNode方法，会把节点放在最后面
        /**
         *     Node<K,V> newNode(int hash, K key, V value, Node<K,V> e) {
         *         LinkedHashMap.Entry<K,V> p =
         *             new LinkedHashMap.Entry<K,V>(hash, key, value, e);
         *         linkNodeLast(p);
         *         return p;
         *     }
         */
        Map<String,Object> map2 =new LinkedHashMap<>();
        map2.put("1","1");
        map2.put("2","2");
        map2.put("3","3");
        map2.put("5","5");
        map2.put("4","4");
        map2.put("6","6");
        map2.forEach((k,v)->{
            System.out.println(k+"---"+v);
        });


        /**
         * key value不能为空
         * 保证线程安全的方式:乐观锁+Sysnchronized cas
         *
         */
        Map<String,Object> map3 =new ConcurrentHashMap<>();
        map3.put("1","1");
        map3.put("2","2");
        map3.put("3","3");
        map3.put("5","5");
        map3.put("4","4");
        map3.put("6","6");
        map3.forEach((k,v)->{
            System.out.println("map3"+k+"---"+v);
        });
        /**
         * 默认升序
         */
        Map<String,Object> map4 =new TreeMap<>();

        map4.put("1","1");
        map4.put("3","2");
        map4.put("2","3");
        map4.put("5","5");
        map4.put("4","4");
        map4.put("6","6");
        map4.forEach((k,v)->{
            System.out.println("map4"+k+"---"+v);
        });
        /**
         * 全局锁
         */
        Map<String,Object> map5 =new Hashtable<>();




    }
}
