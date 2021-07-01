package com.yyl.one.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author:yangyuanliang Date:2019-11-08 Time:17:25
 **/
public class TestCase {
    public static void main(String[] args) {
        List<Student> studentList=new ArrayList<>(3);
        studentList.add(new Student("路飞",12,222));
        studentList.add(new Student("路飞2",22,222));
        studentList.add(new Student("路飞3",22,222));
        //map转换
        List<String> name=studentList.stream()
                .map(student -> student.getName()).collect(Collectors.toList());
        System.out.println(name);
        //filter筛选
        List<Student> collect = studentList.stream().filter(student -> student.getAge() < 20).collect(Collectors.toList());
        System.out.println(collect);
        //flatMap 合并流
        List<Student> list = Stream.of(studentList, Arrays.asList(new Student("艾斯", 25, 183),
                        new Student("雷利", 48, 176)))
                .flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        System.out.println("list----"+list);
        //max和min求最大最小值
        Optional<Student> max = list.stream()
                .max(Comparator.comparing(stu -> stu.getAge()));
        Optional<Student> min = list.stream()
                .min(Comparator.comparing(stu -> stu.getAge()));
        //判断是否有值
        if (max.isPresent()) {
            System.out.println(max.get());
        }
        if (min.isPresent()) {
            System.out.println(min.get());
        }
        //count统计用一般结合filter
        long count = list.stream().filter(student -> student.getAge() < 45).count();
        System.out.println(count);
        // reduce
       // list.stream().flatMap()
        //list.parallelStream()

        String names=list.stream().map(Student::getName).collect(Collectors.joining(",","[","]"));
        System.out.println(names);

    }
}
