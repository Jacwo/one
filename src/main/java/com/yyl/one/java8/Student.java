package com.yyl.one.java8;
import lombok.Getter;
import lombok.Setter;

/**
 * author:yangyuanliang Date:2019-11-08 Time:17:26
 **/
public class Student {
    private String name;
    private int age;
    private int shengao;
    public Student(String name,int age,int shengao){
        this.name=name;
        this.age=age;
        this.shengao=shengao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getShengao() {
        return shengao;
    }

    public void setShengao(int shengao) {
        this.shengao = shengao;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", shengao=" + shengao +
                '}';
    }
}
