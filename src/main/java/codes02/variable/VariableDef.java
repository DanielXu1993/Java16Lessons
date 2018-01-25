package codes02.variable;

class ErrorDef
{
    // Cannot reference a field before it is defined
    // static int num1 = num2 + 2;
    static int num2 = 20;
}

class RightDef
{
    int num1 = num2 + 2;
    
    static int num2 = 20;
}

public class VariableDef
{
    public static void main(String[] args)
    {
        
    }
}