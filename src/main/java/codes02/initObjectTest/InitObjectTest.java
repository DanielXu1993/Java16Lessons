package codes02.initObjectTest;

class Creature {
    static {
        System.out.println("Creature 静态代码块");
    }

    {
        System.out.println("Creature 非静态代码块");
    }

    public Creature() {
    }

    public Creature(String name) {
        this();
        System.out.println("Creature 带有name参数的构造器, name = " + name);
    }
}

class Animal extends Creature {
    static {
        System.out.println("Animal 静态代码块");
    }

    {
        System.out.println("Animal 非静态代码块");
    }

    public Animal(String name) {
        super(name);
        System.out.println("Creature 带有name参数的构造器, name = " + name);
    }

    public Animal(String name, int age) {
        this(name);
        System.out.println("Animal带两个参数的构造器, age = " + age);
    }
}

class Wolf extends Animal {
    static {
        System.out.println("Wolf 静态代码块");
    }

    {
        System.out.println("Wolf 非静态代码块");
    }

    public Wolf() {
        super("灰太狼");
        System.out.println("Wolf 无参数的构造器");
    }

    public Wolf(double weight) {
        this();
        System.out.println("Wolf带weight参数的构造器,weight = " + weight);
    }
}

public class InitObjectTest {
    public static void main(String[] args) {
        new Wolf(5.6);
    }
}