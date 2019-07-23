package com.yyl.one.hashmap;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author yyl
 * @date 2018/12/20 22:47
 */
public class EqualsTest {

    public static void main(String[] args) {
        Person person1=new Person(1,"zs");
        Person person2=new Person(1,"zs");

        System.out.println(person1.equals(person2));
        HashMap<Person,String> map=new HashMap<>();
        map.put(person1,"test");
        System.out.println(map.get(person1));
        System.out.println(map.get(person2));

    }
    static class Person{
        private int id;
        private String name;
        private Person(int id,String name){
            this.id=id;
            this.name=name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id &&
                    Objects.equals(name, person.name);
        }

       @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
