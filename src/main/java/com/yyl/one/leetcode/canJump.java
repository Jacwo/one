package com.yyl.one.leetcode;

/**
 * Created by yyl on 2020/12/07
 * 给定一个非负整数数组，你位于数组的第一个位置，
 * 数组的每个元素代表你在该位置可以跳跃的最大长度，判断是否可以
 * 达到最后一个位置
 * <p>
 * 输入: [2,1,1,0,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 解析
 * 循环数组，当前下标前面的元素的最大跳跃距离(下标值加上下标对应元素的值)大于当前下标即可
 */
public class canJump {
	public static boolean canJump(int[] nums) {
		int max_right = 0;
		//
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0 && max_right - i <= 0 && i != nums.length - 1)
				return false;
			// max(0,2) max_right=2
			// max(2,4) max_right=4
			max_right = Math.max(max_right, i + nums[i]);
		}
		return true;
	}

	public static void main(String[] args) {
		int num[] = {2, 1, 1, 0, 4};
		System.out.println(canJump(num));

	}

	public boolean canJump1(int[] nums) {
		if (nums.length < 2) return true;
		for (int curr = nums.length - 2; curr >= 0; curr--) {
			//从倒数第二个开始找，找元素等于0的位置
			if (nums[curr] == 0) {
				//记录需要跳跃距离1
				int neededJumps = 1;
				//当前元素无法补足需要跳转的距离
				while (neededJumps - nums[curr] > 0) {
					//记录需要跳跃距离加1
					neededJumps++;
					//数组往前移动一位
					curr--;
					//走到头还没有跳出循环，说明无法跳出
					if (curr < 0) return false;
				}
			}
		}
		return true;
	}
}
