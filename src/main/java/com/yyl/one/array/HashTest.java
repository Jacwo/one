package com.yyl.one.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yyl
 * @date 2018/12/3 下午11:32
 *
 *
 *
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，
 * 则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 *
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 *
 * 测试样例：
 * "abc",3,"bca",3
 * 返回：true
 */
public class HashTest {
    public static  boolean chkTransform(String a ,int lengthA,String b ,int lengthB){
        if(a==null||b==null || lengthA!=lengthB){
            return false;
        }
        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        int map[]=new int[256];
        for (int i=0;i<lengthA;i++){
            map[charsa[i]]++;
        }
        for (int i=0;i<lengthB;i++){
            if(map[charsb[i]]--==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       /* String a="1234";
        String b="4328";
        boolean b1 = chkTransform(a, 4, b, 4);
        System.out.println(b1);*/

        Map<String,Object> map=new HashMap<>();
        map.put("1",null);
        map.put("2",null);
        map.put("3",null);
        map.put("4",null);
        map.put("5",null);
        map.put("6",6);

        Map<String, Object> newMap = map.entrySet().stream().filter((e) -> e.getValue() != null).collect(Collectors.toMap(
                (e) -> (String) e.getKey(),
                (e) -> e.getValue()));
        System.out.println(newMap);
    }


}
