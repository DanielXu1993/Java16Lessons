package java8newfeature.Optional;

public class Man {
    private Goddess goddess;

    public Man() {
    }

    public Man(Goddess goddess) {
        this.goddess = goddess;
    }

    public Goddess getGoddess() {
        return goddess;
    }

    public void setGoddess(Goddess goddess) {
        this.goddess = goddess;
    }

    @Override
    public String toString() {
        return "Man{" +
                "goddess=" + goddess +
                '}';
    }
}
