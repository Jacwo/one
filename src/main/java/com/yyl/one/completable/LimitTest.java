package com.yyl.one.completable;

import java.util.*;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/5/15 11:41
 */
public class LimitTest {
	Map<String,Long> lastRequireMap =new HashMap();
	int count= 0;
	public boolean fixedWindow(String key,long window,long threshold){
		long now= System.currentTimeMillis();
		Long lastRequire = lastRequireMap.get(key);
		if(now - lastRequire > window){
			count = 0;
			lastRequireMap.put(key,now);
		}
		if(count<threshold){
			count++;
			return true;
		}
		return false;
	}

	public boolean slidingWindow(String key,long window,long threshold){
		return false;
	}


	public int longStr(String s){
		Set<Character> set =new HashSet<>();
		int length = s.length();
		int left = 0;
		int maxLen = 0;
		for(int i = 0;i<length;i++){
			while(set.contains(s.charAt(i))){
				set.remove(s.charAt(left++));
			}
			set.add(s.charAt(i));

			maxLen = Math.max(maxLen, i - left + 1);

		}
		return maxLen;
	}


	public int[] maxSlidingWindow(int [] nums,int k){
		Deque<Integer> list = new LinkedList<>();
		int[] res=new int[nums.length-k+1];
		for(int i=0;i<nums.length;i++){
			while (!list.isEmpty() && nums[i]>= list.peekLast()){
				list.pollLast();
			}
			list.offerLast(i);
			if(i- list.peekFirst()>=k){
				list.pollFirst();
			}
			if(i>=k-1){
				res[i - k + 1] = nums[list.peekFirst()];
			}
		}
		return res;
	}
}
