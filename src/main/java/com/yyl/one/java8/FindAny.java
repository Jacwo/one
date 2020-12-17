package com.yyl.one.java8;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Author:yangyuanliang
 * @Date:2020/12/11 18:35
 * @Description:
 */
public class FindAny {

	public static void main(String[] args) {
		List<String> list= Arrays.asList("1","2");
		for(int i=0;i<100;i++){
			Collections.shuffle(list);
			Optional<String> any = list.stream().parallel().findAny();
			System.out.println(any.get());
		}
	}
}
