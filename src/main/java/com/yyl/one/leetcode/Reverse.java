package com.yyl.one.leetcode;

/**
 * @author yyl
 * @date 2018/12/8 22:24
 */
public class Reverse {
    public static  int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    public static void main(String[] args) {
        int a=321;
        System.out.println(reverse(a));
    }
}
