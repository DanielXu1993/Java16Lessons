package codes0774.OverrideTest;

public class OverrideTest
{
    public void info(Object obj, double count)
    {
        System.out.println("参数为Object,Obj参数为：" + obj);
        System.out.println("参数为Object,count参数为：" + count);
    }

    public void info(Object[] objs, double count)
    {
        System.out.println("参数为Object[],objs参数为：" + objs);
        System.out.println("参数为Object[],count参数为：" + count);
    }

    public static void main(String[] args)
    {
        OverrideTest test = new OverrideTest();
        // null 能够匹配Object和Object[]
        // Object[]可以看成是Object的子类，参数Object[]能匹配的更加精确
        test.info(null, 5);//调用参数是Object[]的重载方法
        // 当参数是Object的重载方法改成如下形式是调用info方法会有编译时异常:reference to info is ambiguous
        // public void info(Object obj, int count)
        // 这是因为第一个参数与Object[]更匹配而第二个参数与int更匹配，而这两个更匹配的参数在两个不同的重载方法中
    }
}
