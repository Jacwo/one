package cn.yyl.interview.arg;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/11/12 00:25
 */
public class LongestTest {
	public static int longestStr(String s){
		//String s = "abcabcd"
		char[] chars = s.toCharArray();
		Set<Character> set =new HashSet<>();
		int left = 0;
		int maxLen=0;
		for (int i = 0; i < chars.length; i++) {

			while(set.contains(chars[i])){
				set.remove(chars[left++]);
			}
			set.add(chars[i]);

			maxLen =Math.max(maxLen,i-left+1);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String s = "abcabcd";
		System.out.println(longestStr(s));
	}
}
