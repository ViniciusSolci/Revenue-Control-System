package entities.students;

public class BasicLevelStudent extends GeneralStudent {
    private final double monthlyPayment;

    public BasicLevelStudent(int id, String name, double monthlyPayment) {
        super(id, name);
        this.monthlyPayment = monthlyPayment;
    }


    public double getMonthlyPayment() {
        return monthlyPayment;
    }
}
