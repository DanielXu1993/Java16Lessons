package java8newfeature.stream;

import java8newfeature.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream操作的三个步骤：
 * 1. 创建Stream
 * 2. 中间操作
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI1 {
    // 创建Stream
    @Test
    public void test1() {
        // 1.通过Collection系列的集合提供的stream()或parallelStream()方法获取
        List<String> list = new ArrayList<String>();
        Stream<String> stream1 = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        // 2.通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        // 3.通过Stream接口中的静态方法of(T t)获取流
        Stream<String> stream3 = Stream.of("aaa", "bbb", "ccc");

        // 4.创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        // 生成
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
    }
}
