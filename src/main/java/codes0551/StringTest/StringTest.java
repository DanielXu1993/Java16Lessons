package codes0551.StringTest;

public class StringTest {
    public static void main(String[] args) {
        // 使用new创建字符串，不放入字符串池中
        String str = new String("Hello Java");
        // 使用直接值创建字符串
        String str1 = "Hello Java";
        System.out.println(str == str1);// false

        // 使用表达式创建字符串，编译时 str2 = "Hello Java"
        String str2 = "Hello" + " Java";
        System.out.println(str1 == str2);// true

        String s1 = "Hello";
        // 编译时无法计算 str3的值
        String str3 = s1 + " Java";
        System.out.println(str2 == str3);// false

        // 宏变量，编译时将 s2 直接换成 "Hello"
        final String s2 = "Hello";
        String str4 = s2 + " Java";
        System.out.println(str2 == str4);// true
    }
}
