package entities.courses;

public class Courses {
    private final int id;
    private final String name;
    private final double creditsCost;

    public Courses(int id, String name, double creditsCost) {
        this.id = id;
        this.name = name;
        this.creditsCost = creditsCost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCreditsCost() {
        return creditsCost;
    }
}
