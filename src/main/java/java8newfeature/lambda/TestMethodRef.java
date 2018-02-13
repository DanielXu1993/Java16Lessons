package lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 一 ：
 * 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 * (可以把方法引用理解为是Lambda表达式的另一种表现形式)
 * 主要有三种语法格式:
 * 1.对象::实例方法名
 * 2.类::静态方法名
 * 3.类::实例方法名
 * 注意：
 * 1.Lambda体中调用的方法的参数与返回值类型要与
 * 函数式接口中抽象方法的参数与返回值保持一致
 * <p>
 * * 2.若Lambda参数列表中的第一个参数是实例方法的调用者，后面的参数是实例方法的参数时
 * 可以使用ClassName::method
 * <p>
 * 二：
 * 构造器引用：
 * 格式：
 * ClassName::new
 * 需要调用的构造器的参数列表要与要与函数式接口中抽象方法的参数列表保持一致
 * 三：
 * 数组引用：
 * Type::new;
 */
public class TestMethodRef {
    // 1.对象::实例方法名
    @Test
    public void test1() {
        PrintStream ps = System.out;
        Consumer<String> con = x -> ps.println(x);
        Consumer<String> con1 = ps::println;
        Consumer<String> con2 = System.out::println;
        con2.accept("abcdefg");
    }

    @Test
    public void test2() {
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = emp::getAge;
        Integer num = sup2.get();
        System.out.println(num);
    }

    // 2.类::静态方法名
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com1 = Integer::compare;
        int compare = com1.compare(10, 20);
        System.out.println(compare);
    }

    // 3.类::实例方法名
    @Test
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        // x是实例方法equals的调用者，y是实例方法的参数
        BiPredicate<String, String> bp2 = String::equals;
        boolean test = bp2.test("abc", "abc");
        System.out.println(test);
    }

    // 构造器引用：
    @Test
    public void test5() {
        Supplier<Employee> sup = () -> new Employee();
        Supplier<Employee> sup2 = Employee::new;
        Employee emp = sup2.get();
        System.out.println(emp.getAge());
    }

    @Test
    public void test6() {
        Function<Integer, Employee> fun = x -> new Employee(x);
        Function<Integer, Employee> fun2 = Employee::new;
        Employee emp = fun2.apply(10);
        System.out.println(emp.getAge());
        // 此时Employee中必须包含两个Integer类型的构造函数
        // R apply(T t, U u);
        // BiFunction<Integer, Integer, Employee> bf = Employee::new;
    }

    //数组引用：
    @Test
    public void test7() {
        Function<Integer, String[]> fun = x -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);
        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        System.out.println(strs2.length);
    }
}