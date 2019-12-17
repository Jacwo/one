package com.yyl.one.annotation;

/**
 * author:yangyuanliang Date:2019-12-17 Time:15:19
 **/
public class Apple {
    @FruitName("Apple")
    private String appleName;
    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;
    @FruitProvider(adress = "上海")
    private String appleProvider;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
