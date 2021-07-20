package entities.students;

import entities.courses.Courses;

public class SuperiorLevelStudent extends GeneralStudent {
    private final double totalCredits;
    private final Courses course;

    public SuperiorLevelStudent(int id, String name, double totalCredits, Courses course) {
        super(id, name);
        this.totalCredits = totalCredits;
        this.course = course;
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public Courses getCourse() {
        return course;
    }

}
