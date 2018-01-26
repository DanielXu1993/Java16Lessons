package codes0771.InstanceofTest;

public class InstanceofTest {
    public static void main(String[] args) {
        Object hello = "hello";
        System.out.println("字符串是否是Object类的实例:" + (hello instanceof Object));//true
        System.out.println("字符串是否是String类的实例:" + (hello instanceof String));//true
        System.out.println("字符串是否是Math类的实例:" + (hello instanceof Math));//false
        System.out.println("字符串是否是Comparable接口的实例:" + (hello instanceof Comparable));//true

        String str = "Hello";
        // 编译不通过java.lang.String cannot be converted to java.lang.Math
        // System.out.println("字符串str是否是Math类的实例:" + (str instanceof Math));

        String s = null;
        System.out.println("null是否是String类的实例:" + (s instanceof String));//false

    }
}
