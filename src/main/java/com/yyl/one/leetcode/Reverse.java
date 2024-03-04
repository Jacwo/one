package com.yyl.one.leetcode;

/**
 * @author yyl
 * @date 2018/12/8 22:24
 */
public class Reverse {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static int find1From2(int[] a) {
        int len = a.length, res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = new int[3];
        a[0] = 30;
        a[1] = 30;
        a[2] = 31;
        int from2 = find1From2(a);
        System.out.println(from2);

        System.out.println(0%2);
    }

}
