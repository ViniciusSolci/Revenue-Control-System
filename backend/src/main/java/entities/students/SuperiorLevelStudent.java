package entities.students;

public class SuperiorLevelStudent extends GeneralStudent {
    private final double totalCredits;
    private final double creditsCost;

    public SuperiorLevelStudent(int id, String name, double totalCredits, double creditsCost) {
        super(id, name);
        this.totalCredits = totalCredits;
        this.creditsCost = creditsCost;
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public double getCreditsCost() {
        return creditsCost;
    }
}
