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

    @Override
    public String toString(){
        return "Id: " + this.getId() +" | Name: " + this.getName() + " | Monthly payment: " + this.getMonthlyPayment();
    }
}
