package com.yyl.one.hashmap;


/**
 * @author yyl
 * @date 2018/12/19 22:33
 */
public class MyHashMap<K,V> {
    private Entry<K,V> []table;
    private static  final Integer CAPACITY=8;
    private int size;
    public void put(K k,V v){

        if(table==null){
            init();
        }
        int hashCode=hash(k);
        int index=indexFor(hashCode);
        for (Entry<K,V> entry=table[index]; entry!=null;entry=entry.next){
            if(entry.key.equals(k)){
                entry.key=k;
            }

        }
        addEntry(k,v,index);

    }


    public V get(K k){
        int hashCode=hash(k);
        int index=indexFor(hashCode);
        for (Entry<K,V> entry=table[index]; entry!=null;entry=entry.next){
            if(entry.key.equals(k)){
                return entry.value;
            }

        }
        return null;
    }

    private void addEntry(K k,V v, int index) {
        Entry<K,V>newEntry=new Entry<>(k,v,table[index]);
        table[index]=newEntry;
        size++;
    }

    private int indexFor(int hashCode){
        return hashCode%table.length;
    }

    private int hash(K k){
        return k.hashCode();
    }

    private void init(){
        table=new Entry[CAPACITY];
    }
    class Entry<K,V>{
        public K key;
        public V value;
        public Entry<K,V> next;
        public Entry(K key,V value){
            this.key=key;
            this.value=value;
        }


        public Entry(K key,V value,Entry<K,V> next){
            this.key=key;
            this.value=value;
            this.next=next;
        }

        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String,String> myHashMap=new MyHashMap<>();
        myHashMap.put("1","1");
        myHashMap.put("1","8");
        myHashMap.put("2","2");
        System.out.println(myHashMap.get("1"));

    }
}
