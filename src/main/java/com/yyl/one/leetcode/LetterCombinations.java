package com.yyl.one.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * author:yangyuanliang Date:2019-11-06 Time:15:55
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/submissions/
 **/
public class LetterCombinations {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    private  List<String> output=new ArrayList<>();
    
    public  List<String> solutation(String digits){
        if(digits.length()!=0){
            back("", digits);
        }
        return output;
    }

    private  void back(String s, String digits) {
        if(digits.length()==0){
            output.add(s);
        }else{
            // 2
            String substring = digits.substring(0, 1);
            //abc
            String s1 = phone.get(substring);
            for(int i=0;i<s1.length();i++){
                //a b c
                String substring1 = s1.substring(i, i + 1);
                String l=digits.substring(1);
                back(s+substring1,l);
            }
        }
    }

    public static void main(String[] args) {
        String s="23";
        LetterCombinations l=new LetterCombinations();
        System.out.println(l.solutation(s));
    }
}
