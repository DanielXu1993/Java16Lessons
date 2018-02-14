package java8newfeature.lambda;

@FunctionalInterface
interface LambdaReturn {
    int test();
}

@FunctionalInterface
interface LambdaReturn2 {
    int test(int x, int y);
}

class TestLambdaReturn {
    void returnValue(LambdaReturn lambdaReturn) {
        int i = lambdaReturn.test();
        System.out.println("Lambda表达式的返回值: " + i);
    }

    void returnValue2(int x, int y, LambdaReturn2 lambdaReturn) {
        int i = lambdaReturn.test(x, y);
        System.out.println("Lambda表达式的返回值: " + i);
    }

    public static void main(String[] args) {

        TestLambdaReturn tlr = new TestLambdaReturn();

        // 带返回值的Lambda表达式，{}不可省
        tlr.returnValue(() -> {
            return 14;
        });

        // 和匿名内部类一样，
        // 如果访问局部变量，局部变量默认是final修饰的
        int i = 1234;
        tlr.returnValue(() -> {
            return i;
        });

        // 带返回值的Lambda表达式，只有一行return语句，当省略return时可以省略{}
        tlr.returnValue2(5, 6, (x, y) -> x * y);
    }
}
