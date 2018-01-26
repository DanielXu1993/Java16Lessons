package codes02.initTest;

class Cat {
    String name;
    int age;

    public Cat(String name, int age) {
        //构造器总是在非静态代码块和实例变量赋值语句后面执行
        //因此如果在构造器中给weight赋值，所创建的对象的weight值就是
        //构造器中的值
        this.name = name;
        this.age = age;
    }

    // 当非静态代码块在实例变量声明之前时
    // 非静态代码块中的实例变量的值会被后面的值覆盖
    // 此时当创建Cat对象时该对象的weight属性值为2.3
    {
        weight = 2.0;
    }

    // 如果此语句在非静态代码块之前，Cat对象的weight属性值会被后面的代码块覆盖，为2.0
    // 当非静态代码块在实例变量声明之前而实例变量仅有一个声明而没有赋值时
    // Cat对象的weight属性值为代码块中的值2.0而不是0
    double weight = 2.3;
}

public class InitTest {
    public static void main(String[] args) {
        Cat cat = new Cat("fsfs", 5);
        System.out.println(cat.weight);
    }
}