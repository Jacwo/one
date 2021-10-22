package com.yyl.one.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by liuchong on 2017/4/13.
 */
public class thirdMax {
    public int thirdMax(int[] nums) {
        int res=Integer.MIN_VALUE, count=0;
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=0; i--){
            if(res != nums[i]){
                res = nums[i];
                count++;
                if(count == 3)
                    break;
            }
        }
        if(count<3)
            return nums[nums.length-1];
        return res;
    }

    public int thirdMax1(int[] nums){
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    public int thirdMax2(int [] nums){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.contains(num)){
                pq.offer(num);
                set.add(num);
                if(pq.size() > 3)
                    set.remove(pq.poll());
            }
        }
        if(pq.size()<3)
            while(pq.size()>1)
                pq.poll();
        return pq.peek();
    }
}
