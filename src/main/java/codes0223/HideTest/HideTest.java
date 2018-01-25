package codes0223.HideTest;

class Parent
{
    public String tag = "hello";
}

class Derived extends Parent
{
    private String tag = "world";
}

public class HideTest
{
    public static void main(String[] args)
    {
        Derived d = new Derived();
        // System.out.println(d.tag);
        System.out.println(((Parent)d).tag);
    }
}
