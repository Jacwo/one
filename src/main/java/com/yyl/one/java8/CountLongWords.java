package com.yyl.one.java8;

import net.sf.cglib.core.Local;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yyl
 * @date 2018/11/24 下午5:12
 */
public class CountLongWords {

    public static<T> void show(String title, Stream<T> stream){
        final int SIZE=3;
        List<T> firstElements=stream.limit(SIZE+1)
                .collect(Collectors.toList());
        System.out.println(title+":");
        for (int i = 0; i <firstElements.size() ; i++) {
            if(i>0){
                System.out.println(",");
            }
            if(i<SIZE)
                System.out.println(firstElements.get(i));
            else
                System.out.println("....");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String contents = "hello,java,word,test,world,gx,yyl";
        List<String> words = Arrays.asList(contents.split(","));
        Optional<String> first = words.stream().filter(s -> s.contains("h3e"))
                .findFirst();
        System.out.println(first.orElse("no"));
        Optional<String> empty = Optional.empty();
        String result=empty.orElse("N/A");
        System.out.println(result);
        String s = empty.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println(s);
        //String s1 = empty.orElseThrow(IllegalAccessError::new);
        //System.out.println(s1);
        Optional<String> red = words.stream().filter(s2 -> s2.contains("red")).findFirst();
        red.ifPresent(s3-> System.out.println(s3
                +"contains red"));
        List<String[]> collect = words.stream().map(s5 -> s5.split(","))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);

        List<String> collect1 = words.stream().map(s6 -> s6.split(","))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect1);

        //List<String> newwords=words.stream().map(String::toUpperCase).collect(Collectors.toList());
        //words.stream().map(String::length);

        //System.out.println(newwords);

      //  show("words",Stream.of(words));
//        long count = 0;
//        for (String w : words) {
//            if (w.length() > 2) {
//
//                    count++;
//            }
//        }
//
//        count=words.stream().filter(w->w.length()>2).count();
//        System.out.println("CountLongWords.main"+count);
//        count=words.parallelStream().filter(w->w.length()>2).count();
//        System.out.println(count);
    }
}
