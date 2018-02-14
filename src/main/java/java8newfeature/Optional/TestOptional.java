package java8newfeature.Optional;

import java8newfeature.lambda.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * Optional<T>类是一个容器类，代表一个值存不存在。
 * 以前用null来表示一个值不存在，现在可以用Optional更好的表达这个概念。
 * 并且可以避免空指针异常。
 * 常用方法：
 * T            get():如果 Optional中有一个值，返回值，否则抛出 NoSuchElementException
 * Optional<T>  Optional.of(T t):创建一个Optional实例
 * Optional<T>  Optional.empty():创建一个空的Optional实例
 * Optional<T>  Optional.ofNullable(T t):若t不为null,创建Optional实例，否则创建空实例
 * boolean      ifPresent():判断是否包含值
 * T            orElse(T t):如果调用的对象包含值，返回该值，否则返回t
 * T            orElseGet(Supplier<? extends T> s):如果调用的对象包含值，返回该值，否则返回s获取的值
 * Optional     map(Function f):如果有值，对其处理并返回处理后的Optional，否则返回Optional.empty()
 * Optional     flatMap(Function mapper):与map类似，要求返回值必须是Optional
 */
public class TestOptional {
    @Test
    public void test1() {
        Optional<Employee> op = Optional.of(new Employee());
        // Optional<Employee> op = Optional.of(null);空指针异常
        Employee emp = op.get();
        System.out.println(emp);// Employee{name='null', age=0}
    }

    @Test
    public void test2() {
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get()); // 空指针异常
    }

    @Test
    public void test3() {
        Optional<Employee> op = Optional.ofNullable(new Employee());
        System.out.println(op.get());// Employee{name='null', age=0}
        Optional<Employee> op2 = Optional.ofNullable(null);
        // System.out.println(op2.get());// NoSuchElementException
        if (op2.isPresent()) {
            System.out.println(op2.get());// 没有执行
        }
        Employee emp = op2.orElse(new Employee("张三", 18));
        System.out.println(emp);// Employee{name='张三', age=18}
        Employee emp2 = op2.orElseGet(() -> new Employee());
        System.out.println(emp2);// Employee{name='null', age=0}
    }

    @Test
    public void test4() {
        Optional<Employee> op = Optional.ofNullable(new Employee("张三", 18));
        Optional<String> str = op.map(e -> e.getName());
        System.out.println(str.get());// 张三

        Optional<String> str2 = op.flatMap(e -> Optional.of(e.getName()));
        System.out.println(str2.get());// 张三

    }

    // 举例
    @Test
    public void test5() {
        Man man = new Man();
        String name = getGoddessName(man);
        System.out.println(name);// 王祖贤
    }

    // 需求：获取一个男人心中女神的名字
    public String getGoddessName(Man man) {
        if (man == null)
            return "王祖贤";
        if (man.getGoddess() == null)
            return "王祖贤";
        return man.getGoddess().getName();
    }

    @Test
    public void test6() {
        Optional<NewMan> op = Optional.ofNullable(null);
        String name = getGoddessName2(op);
        System.out.println(name);// 王祖贤

        Optional<Goddess> gn = Optional.ofNullable(null);
        Optional<NewMan> op1 = Optional.ofNullable(new NewMan(gn));
        String name2 = getGoddessName2(op1);
        System.out.println(name2);// 王祖贤

        Optional<Goddess> gn2 = Optional.ofNullable(new Goddess("林青霞"));
        Optional<NewMan> op2 = Optional.ofNullable(new NewMan(gn2));
        String name3 = getGoddessName2(op2);
        System.out.println(name3);// 林青霞

    }

    public String getGoddessName2(Optional<NewMan> man) {
        return man.orElse(new NewMan())
                .getGoddess()
                .orElse(new Goddess("王祖贤"))
                .getName();
    }
}
