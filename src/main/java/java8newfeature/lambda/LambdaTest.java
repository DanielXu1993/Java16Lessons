package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大内置核心函数式接口
 * Consumer<T>: 消费型接口===>void accept(T t);
 * Supplier<T>: 供给型接口===>T get();
 * Function<T,R>:函数型接口===> R apply(T t);
 * Predicate<T>:断言型接口===>boolean test(T t);
 */
public class LambdaTest {
    //Consumer<T>消费型接口
    @Test
    public void test1() {
        happy(10000, m -> System.out.println("消费" + m + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    // Supplier<T>供给型接口
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    // 需求：产生包含指定个数的整数集合
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }


    // Function<T,R> 函数型接口

    //需求：用于处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    @Test
    public void test3() {
        String newString = strHandler("\t\t\t分萨芬是否  ", (str) -> str.trim());
        System.out.println(newString);
        String newString2 = strHandler("分萨芬是否分否分萨芬是否", (str) -> str.substring(2, 6));
        System.out.println(newString2);
    }

    // Predicate<T> 断言型接口
    // 需求：过滤集合中的字符串
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> stringList = new ArrayList<String>();
        for (String s : list) {
            if (pre.test(s)) {
                stringList.add(s);
            }
        }
        return stringList;
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("hello", "ok", "yes", "glasgow");
        List<String> newList = filterStr(list, s -> s.length() > 3);
        for (String str : newList) {
            System.out.println(str);
        }
    }
}
