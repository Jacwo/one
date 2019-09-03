package com.yyl.one.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * author:yangyuanliang Date:2019-09-03 Time:19:19
 **/
public class ZConvert {
    public static  String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {
        String s="LEETCODEISHIRING";
        int number=3;
        System.out.println(convert(s,number));
    }

}
