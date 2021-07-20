package entities.students;

import entities.courses.Courses;

public class SuperiorLevelStudent extends GeneralStudent {
    private final double totalCredits;
    private final double payment;
    private final Courses course;

    public SuperiorLevelStudent(int id, String name, double totalCredits, double payment, Courses course) {
        super(id, name);
        this.totalCredits = totalCredits;
        this.course = course;
        this.payment = totalCredits*course.getCreditsCost();
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public double getPayment() {
        return payment;
    }

    public Courses getCourse() {
        return course;
    }

}
