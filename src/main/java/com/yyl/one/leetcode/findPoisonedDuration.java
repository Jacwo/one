package com.yyl.one.leetcode;

/**
 *
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 *
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 * 输入: [1,4], 2
 * 输出: 4
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
 * 所以最终输出 4 秒。
 *
 *
 * Created by yyl on 2017/5/3.
 */
public class findPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        if(timeSeries.length<=0)
            return sum;
        for(int i=1; i<timeSeries.length; i++){
            if(timeSeries[i] - timeSeries[i-1] >= duration)
                sum += duration;
            else{
                sum +=timeSeries[i] - timeSeries[i-1];
            }
        }
        return sum+duration;
    }
}
