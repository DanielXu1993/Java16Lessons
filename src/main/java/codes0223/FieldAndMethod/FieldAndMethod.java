package codes0223.FieldAndMethod;

class Base
{
    int count = 2;
    
    public void display()
    {
        System.out.println(this.count);
    }
}

class Derived extends Base
{
    int count = 20;
    
    @Override
    public void display()
    {
        System.out.println(this.count);
    }
}

public class FieldAndMethod
{
    public static void main(String[] args)
    {
        Base b = new Base();
        System.out.println(b.count);// 2
        b.display();// 2
        
        Derived d = new Derived();
        System.out.println(d.count);// 20
        d.display();// 20
        
        Base bd = new Derived();
        System.out.println(bd.count);// 2
        bd.display();// 20
        
        Base d2b = d;
        System.out.println(d2b.count);// 2
    }
}
