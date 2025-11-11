package cn.yyl.interview.arg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/4/4 17:48
 */
public class PermutationTest {
	static List<List<Character>> res=new ArrayList<>();

	public static void main(String[] args) {
		String ss = "abc";
		permutation(ss.toCharArray(),0);
		LinkedList<Character> list=new LinkedList<>();
		backtrace(list,ss.toCharArray());
		System.out.println(res);
	}
	public static void permutation(char[] chars, int begin) {
		// 如果是最后一个元素了，就输出排列结果
		if (chars.length - 1 == begin) {
			System.out.print(new String(chars) + " ");
		} else {
			char tmp;
			// 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
			for (int i = begin; i < chars.length; i++) {
				tmp = chars[begin];
				chars[begin] = chars[i];
				chars[i] = tmp;
				// 处理下一个位置
				permutation(chars, begin + 1);
				tmp = chars[begin];
				chars[begin] = chars[i];
				chars[i] = tmp;
			}
		}
	}




	private static void backtrace(LinkedList<Character> list, char[] chars) {
		if(list.size()==chars.length){
			res.add(new LinkedList(list));
			return;
		}
		for(int i=0;i<chars.length;i++){
			if(list.contains(chars[i])){
				continue;
			}
			list.addLast(chars[i]);
			backtrace(list,chars);
			list.removeFirst();
		}
	}
}
