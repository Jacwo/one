package com.yyl.one.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * author:yangyuanliang Date:2019-12-11 Time:16:12
 **/
public class BestProductPriceCalculator {
    private static List<SynShop> shops= Arrays.asList(
            new SynShop("bestprice"),
            new SynShop("letSaveBig"),
            new SynShop("myFavoriteShop"),
            new SynShop("buyitall")
    );

    public static List<String> findPricesWithParalleStranm(String product){
        return shops.parallelStream().map(shop->shop.getName()+":"+shop.getPrice(product)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> mmmmmmm = findPricesWithParalleStranm("mmmmmmm");
        System.out.println(mmmmmmm);
    }
}
