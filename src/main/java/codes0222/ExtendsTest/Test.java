package codes0222.ExtendsTest;

class Base {
    private int i = 2;

    public Base() {
        this.display();
        System.out.println(this.getClass());
    }

    public void display() {
        System.out.println(i);
    }
}

class Dervied extends Base {
    private int i = 22;

    public Dervied() {
        i = 222;
    }

    public void display() {
        System.out.println(i);
    }
}

public class Test {
    public static void main(String[] args) {
        new Dervied();// 0
    }
}