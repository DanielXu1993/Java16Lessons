package codes0223.Sub;

class Base {
    final int count = 2;
}

class Mid extends Base {
    int count = 20;
}

public class Sub extends Mid {
    int count = 200;

    public static void main(String[] args) {
        Sub s = new Sub();
        Mid s2m = s;
        Base s2b = s;
        System.out.println(s.count);
        System.out.println(s2m.count);
        System.out.println(s2b.count);
    }
}
