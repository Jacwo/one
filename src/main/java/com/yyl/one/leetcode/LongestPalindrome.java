package com.yyl.one.leetcode;

/**
 * author:yangyuanliang Date:2019-09-03 Time:17:17
 **/
public class LongestPalindrome {
    public static int max=0;
    public static int r = 0;
    public static int l = 0;
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }
        return s.substring(l, r+1);
    }

    public static void expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if(right-left+1>max){
                max=right-left+1;
                l = left;
                r = right;
            }
            left--;
            right++;
        }

    }


    public static void main(String[] args) {
        String s="zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        System.out.println(longestPalindrome(s));
    }
}
