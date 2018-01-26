package codes0331.ListTest;

import java.util.ArrayList;
import java.util.List;

class Apple {
    double weight;

    public Apple(double weight) {
        this.weight = weight;
    }

}

public class ListTest {
    public static void main(String[] args) {
        Apple t1 = new Apple(2.2);
        Apple t2 = new Apple(1.8);
        List<Apple> list = new ArrayList<Apple>();
        list.add(t1);
        list.add(t2);
        System.out.println(list.get(0) == t1);
        System.out.println(list.get(1) == t2);

    }
}
