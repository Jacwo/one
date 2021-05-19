package com.yyl.one.leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/123-mai-mai-gu-piao-de-zui-jia-shi-ji-ii-zfh9/
 * 示例 1:
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *

 * Created by yyl on 2021/6/14.
 */
public class maxProfit3 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2)
            return 0;
        int [] maxBefore = new int[len];
        int min = prices[0];
        for(int i=1; i<len; i++){
            maxBefore[i] = Math.max(maxBefore[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int max = prices[len - 1];
        int ret = 0;
        for(int i=len-2; i>=0; i--){
            //找到后面最大的价格
            max = Math.max(prices[i], max);
            //利润 = 最大价格 - 当前价格 + 此时交易时第一次的利润
            //取最大值
            ret = Math.max(ret, max - prices[i] + maxBefore[i]);
        }
        return ret;
    }

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        int a, b, c, d;
        d = Math.max(prices[len-1], prices[len-2]);
        c = Math.max(prices[len-1] - prices[len-2], 0);
        b = d;
        a = c;
        for(int i=len-3; i>=0; i--) {
            a = Math.max(b - prices[i], a);
            b = Math.max(prices[i] + c, b);
            c = Math.max(d - prices[i], c);
            d = Math.max(prices[i], d);
        }
        return a;
    }

    public int maxProfit2(int[] prices) {
        // these four variables represent your profit after executing corresponding transaction
        // in the beginning, your profit is 0.
        // when you buy a stock ,the profit will be deducted of the price of stock.
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            if (firstBuy < -curPrice) firstBuy = -curPrice; // the max profit after you buy first stock
            if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice; // the max profit after you sell it
            if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice; // the max profit after you buy the second stock
            if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice; // the max profit after you sell the second stock
        }

        return secondSell; // secondSell will be the max profit after passing the prices
    }


    public static  int maxProfit3(int[] prices) {
        int res[]=new int[2];
        int max=0;
        int freContinue=0;
        int count=0;
        int current =0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                max =Math.max(max,prices[i+1]-prices[i]+max);
                min = Math.min(min,prices[i]);
                count++;
                current=i+1;
                if(i!= prices.length-2){
                    continue;
                }
            }
            freContinue=current-count;
            if(prices[current]>prices[freContinue] && (prices[current]-prices[freContinue]+res[0]+res[1])> (prices[current]-min )&&  (res[0]+res[1])<(prices[current]-min)){

                max =Math.max(max,prices[current]-min);
            }else{
                min=Integer.MAX_VALUE;
            }
            count=0;
            if(max>res[0] && max>res[1]){
                if(res[1]!=0 && res[1]>res[0] ){
                    res[0]=res[1];
                }
                res[1]=max;
            }else if(max>res[0]){
                res[0]=max;
            }
            max =0;
        }

        return res[0]+res[1];
    }

    public static void main(String[] args) {
        int a[]={6,1,3,2,4,7};
        System.out.println(maxProfit3(a));
    }
}
