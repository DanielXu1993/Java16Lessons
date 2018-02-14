package java8newfeature.lambda;

/**
 * 如果一个接口只有一个抽象方法（包括从父接口中继承来的），该接口是一个函数式接口，可以使用Lambda表达式来实现
 * 函数式接口可以通过注解@FunctionalInterface来限定。
 * Lambda表达式可以认为是一种特殊的匿名内部类
 */
//  Lambda表达式的语法：
//      ([形参列表，如果根据上下文能够推断出参数类型，类型可省]) -> {
//          执行语句
//          return ...
//      }

/**
 * 1.如果参数列表是空的，只需要保留()即可
 * 2.如果没有返回值，只需要在{}中写执行语句即可
 * 3.如果接口中的抽象方法只有一个形参，()可以省略，只需要参数的名称即可
 * 4.如果执行语句只有一行，可以省略{},但是有返回值时{}不能省略
 */

public interface TestLambdaInterface {
    void test();
}

interface TestLambdaInterface1 {
    void test(String str);
}

interface TestLambdaInterface2 {
    void test(String str, int o);
}

class TestLambda {
    public static void main(String[] args) {

        // 使用匿名内部类实现的抽象方法
        TestLambdaInterface t1 = new TestLambdaInterface() {
            @Override
            public void test() {
                System.out.println("使用匿名内部类实现的抽象方法");
            }
        };
        t1.test();

        // 右边()中的参数类型会根据左边的类型自动推断
        TestLambdaInterface t2 = () -> {
            System.out.println("使用Lambda表达式实现的抽象方法");
        };
        t2.test();

        // 执行语句只有一行，省略{}
        TestLambdaInterface t3 = () ->
                System.out.println("使用Lambda表达式实现的抽象方法,执行语句只有一行，省略{}");
        t3.test();

        // 接口中的抽象方法只有一个参数，()可省,只需要参数的名称即可
        TestLambdaInterface1 i4 = s -> System.out.println("参数:" + s);
        i4.test("只有参数名称，省略了()");

        // 如果接口中的参数列表超过一个参数时，不能省略()
        TestLambdaInterface2 i5 = (s, i) -> System.out.println("参数: s = " + s + " , i = " + i);
        i5.test("两个参数的方法", 50);
    }
}