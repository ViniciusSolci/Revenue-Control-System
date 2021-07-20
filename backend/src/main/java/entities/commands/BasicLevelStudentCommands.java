package entities.commands;

import database.commands.BasicLevelStudentDAO;
import entities.students.BasicLevelStudent;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

import java.util.List;

public class BasicLevelStudentCommands {
    private BasicLevelStudentCommands() {
    }

    private static final String ENTER_STUDENT_ID = "Enter student id: ";
    private static final LineReader READER = LineReaderBuilder.builder().terminal(null).completer(null).build();

    public static void insertOrUpdate(int command){
        int id = Integer.parseInt(READER.readLine(ENTER_STUDENT_ID));
        String name = READER.readLine("Enter student name: ");

        BasicLevelStudent basicLevelStudent = new BasicLevelStudent(id, name, BasicLevelStudentDAO.getMonthlyPayment());

        if (command == 1){
            BasicLevelStudentDAO.insert(basicLevelStudent);
        } else  BasicLevelStudentDAO.update(basicLevelStudent);
    }

    public static void delete(){
        int id = Integer.parseInt(READER.readLine(ENTER_STUDENT_ID));
        BasicLevelStudentDAO.delete(id);
    }

    public static void showAllBasicLevelStudents(){
        List<BasicLevelStudent> allBasicLevelStudents = BasicLevelStudentDAO.getAllBasicLevelStudents();
        for (BasicLevelStudent student : allBasicLevelStudents) {
            System.out.println(student);
            System.out.println("\n---------------\n");
        }
    }

    public static void showSpecificBasicLevelStudent(){
        int id = Integer.parseInt(READER.readLine(ENTER_STUDENT_ID));
        BasicLevelStudent student = BasicLevelStudentDAO.getSingleBasicLevelStudent(id);
        if (student != null){
            System.out.println(student);
        } else System.out.println("Student not found");
    }

    public static void updateMonthlyPayment(){
        double newMonthlyPayment = Double.parseDouble(READER.readLine(ENTER_STUDENT_ID));
        BasicLevelStudentDAO.updateMonthlyPayment(newMonthlyPayment);
    }
}
