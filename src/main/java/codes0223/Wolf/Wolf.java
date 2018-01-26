package codes0223.Wolf;

class Animal {
    public String name;

    public void info() {
        System.out.println(name);
    }
}

public class Wolf extends Animal {
    private double weight;
}