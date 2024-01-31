package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2023/10/31 14:32
 * @Version 2.0
 **/
public class Strstr {
    public static  int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            String replace = haystack.replace(needle, "*");
            for(int i=0;i<replace.length();i++){
                if("*".equals(String.valueOf(replace.charAt(i)))){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 朴素匹配
     * 直观的解法的是：枚举原串 ss 中的每个字符作为「发起点」，每次从原串的「发起点」和匹配串的「首位」开始尝试匹配：
     * 匹配成功：返回本次匹配的原串「发起点」。
     * 匹配失败：枚举原串的下一个「发起点」，重新尝试匹配。
     * @param ss   sadbutsad
     * @param pp   sad
     * @return
     */

    public int strStr2(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        strStr("sadbutsad","sad");
    }
}
