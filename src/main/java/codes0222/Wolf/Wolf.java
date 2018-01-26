package codes0222.Wolf;

class Animal {

    public String getDesc() {
        return "Animal";
    }

    public String toString() {
        return getDesc();
    }
}

public class Wolf extends Animal {
    private String name;

    private double weight;

    public Wolf(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getDesc() {
        return "Wolf [name=" + name + ", weight=" + weight + "]";
    }

    public static void main(String[] args) {
        System.out.println(new Wolf("灰太狼", 32.3));
    }
}