package codes0777.NullInvocation;
class Animal
{
    public static void info()
    {
        System.out.println("Animal的info方法");
    }
}
class Wolf extends Animal
{
    public static void info()
    {
        System.out.println("Wolf的info方法");
    }
}
public class NullInvocation
{
    public static void main(String[] args)
    {
        // 该静态方法属于Animal类而不是Animal对象
        // 即使变量a1是null，依然可以调用它的静态方法
        Animal a1 = null;
        Animal.info();
        // 静态方法属于类，不会产生多态
        Animal a2 = new Wolf();
        Animal.info();
    }
}
