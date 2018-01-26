package codes01.referenceArray;

class Person {
    public int age;

    public double height;
}

public class ReferenceArray {

    public static void main(String[] args) {
        Person[] students = new Person[2];
        Person zhangsan = new Person();
        zhangsan.age = 15;
        zhangsan.height = 158;
        Person lee = new Person();
        lee.age = 16;
        lee.height = 161;
        students[0] = zhangsan;
        students[1] = zhangsan;

    }

}
