package com.yyl.one.leetcode;

/**
 * author:yangyuanliang Date:2019-09-03 Time:17:17
 **/
public class LongestPalindrome {
    /*public static int max=0;
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
*/
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        String s="abacc2222";

       // System.out.printf(s.substring(0,1));
        System.out.println(longestPalindrome(s));
    }
}
