package entities.commands;

import database.commands.SuperiorLevelStudentDAO;
import entities.students.SuperiorLevelStudent;
import org.jline.reader.LineReader;

import java.util.List;

public class SuperiorLevelStudentCommands {
    private SuperiorLevelStudentCommands() {
    }

    private static final String ENTER_STUDENT_ID = "Enter student id: ";
    private static LineReader reader;

    public static void insertOrUpdate(int command){
        int id = Integer.parseInt(reader.readLine(ENTER_STUDENT_ID));
        String name = reader.readLine("Enter student name: ");
        double totalCredits = Double.parseDouble(reader.readLine("Enter student total credits: "));
        double creditsCost = Double.parseDouble(reader.readLine("Enter the credits cost: "));

        SuperiorLevelStudent superiorLevelStudent = new SuperiorLevelStudent(id, name, totalCredits, creditsCost);

        if (command == 1){
            SuperiorLevelStudentDAO.insert(superiorLevelStudent);
        } else  SuperiorLevelStudentDAO.update(superiorLevelStudent);
    }

    public static void delete(){
        int id = Integer.parseInt(reader.readLine(ENTER_STUDENT_ID));
        SuperiorLevelStudentDAO.delete(id);
    }

    public static void showAllBasicLevelStudents(){
        List<SuperiorLevelStudent> allSuperiorLevelStudents = SuperiorLevelStudentDAO.getAllSuperiorLevelStudents();
        for (SuperiorLevelStudent student : allSuperiorLevelStudents) {
            System.out.println(student.toString());
            System.out.println("\n---------------\n");
        }
    }

    public static void showSpecificBasicLevelStudent(){
        int id = Integer.parseInt(reader.readLine(ENTER_STUDENT_ID));
        SuperiorLevelStudent student = SuperiorLevelStudentDAO.getSingleSuperiorLevelStudent(id);
        if (student != null){
            System.out.println(student);
        } else System.out.println("Student not found");
    }
}
