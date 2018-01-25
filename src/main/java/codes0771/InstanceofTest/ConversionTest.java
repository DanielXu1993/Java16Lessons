package codes0771.InstanceofTest;

public class ConversionTest
{
    public static void main(String[] args)
    {
        // obj变量的编译类型为Object，是String类型的父类，可以类型强转
        Object obj = "Hello";
        String objStr = (String)obj;
        System.out.println(objStr);

        // objInt编译类型是Object，实际类型是Integer
        Object objInt = new Integer(5);
        // 编译时String是Object的子类，可以强制类型转换
        // 运行时Integer与String没有关系，无法进行强转
        // 抛出异常:java.lang.Integer cannot be cast to java.lang.String
        String strInt = (String)objInt;
        System.out.println(strInt);

        // Math不是String的子类，因此编译时异常
        // String s = "Hello";
        // Math m = (Math)s;

    }
}
