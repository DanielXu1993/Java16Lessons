package codes02.staticInitTest;

class Count
{
    static int count = 2;
    static
    {
        count = 3;
    }
}

public class StaticInitTest
{
    public static void main(String[] args)
    {
        System.out.println(Count.count);
    }
}