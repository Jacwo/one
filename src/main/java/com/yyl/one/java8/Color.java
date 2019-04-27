package com.yyl.one.java8;

public enum Color {
    RED("red","红色"),
    YELLOW("yellow","黄色"),
    GREEN("green","黄色");
    private String name;
    private String value;

     Color(String name,String value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
