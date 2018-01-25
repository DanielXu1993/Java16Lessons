package codes0552.AutoPromote;

public class AutoPromote
{
    public static void main(String[] args)
    {
        // byte bValue = 5;
        // bValue = bValue - 2;编译不通过,计算后的结果是int类型，需要类型转换
        
        byte sValue2 = 5;
        sValue2 -= 2;// 编译通过，sValue2仍然是byte类型
        
        sValue2 += 1000;// byte类型的值的范围是-128~127，发生“溢出”
        System.out.println(sValue2);// -21
    }
}
