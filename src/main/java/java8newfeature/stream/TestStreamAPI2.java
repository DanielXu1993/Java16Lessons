package java8newfeature.stream;

import java8newfeature.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 中间操作: 不会执行任何操作，知道终止操作发生时一次性全部执行，即"惰性求值"
 * 1.筛选与切片
 * filter---接收Lambda表达式，从流中排除某些元素
 * limit---截断流，使其元素不超过给定的数量
 * skip---跳过元素，返回一个扔掉了前n个元素的流。若流中的元素不足n个，则返回一个空流。与limit(n)互补。
 * distinct---筛选，通过流所生成元素的hashCode()和equals()去除重复元素
 */
public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18),
            new Employee("李四", 58),
            new Employee("王五", 26),
            new Employee("赵六", 36),
            new Employee("田七", 12),
            new Employee("田七", 12),
            new Employee("田七", 12),
            new Employee("田七", 12)
    );


    // 内部迭代：迭代操作由Stream API完成
    @Test
    public void test1() {
        Stream<Employee> s = employees.stream()
                .filter(employee -> {
                    System.out.println("Stream API的中间操作");
                    return employee.getAge() > 35;
                });
        s.forEach(System.out::println);
    }

    @Test
    public void test3() {
        employees.stream()
                .filter(e -> e.getAge() > 20)
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        employees.stream()
                .filter(e -> e.getAge() > 10)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 映射
     * map---接收Lambda,将元素转换成其他形式或者提取信息。
     * 接受一个函数作为参数，该函数会被应用到每个元素上，并将其影射成一个新的元素。
     * flatMap---接收一个函数作为参数，将流中的每个元素都换成另一个流，然后把所有的流连接成一个流。
     */
    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);
        System.out.println("------------------------------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("------------------------------");
        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamAPI2::filterCharacter);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
