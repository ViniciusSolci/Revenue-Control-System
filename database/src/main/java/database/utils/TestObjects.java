package database.utils;

import database.commands.BasicLevelStudentDAO;
import database.commands.ServicesDAO;
import database.commands.SuperiorLevelStudentDAO;
import entities.Services;
import entities.students.BasicLevelStudent;
import entities.students.SuperiorLevelStudent;

public class TestObjects {
    private TestObjects() {
    }

    public static void populateTablesForTests(){
        BasicLevelStudent gabi = new BasicLevelStudent(1, "Gabriela Guimarães", 50);
        BasicLevelStudentDAO.insert(gabi);
        BasicLevelStudent vinicius = new BasicLevelStudent(2, "Vinicius Solci", 50);
        BasicLevelStudentDAO.insert(vinicius);

        SuperiorLevelStudent ygor = new SuperiorLevelStudent(1, "Ygor Dias", 10, 4);
        SuperiorLevelStudentDAO.insert(ygor);
        SuperiorLevelStudent valter = new SuperiorLevelStudent(2, "Valter Rogério Messias", 20, 5);
        SuperiorLevelStudentDAO.insert(valter);

        Services engineering = new Services(1, "Engineering services", 50, 100);
        ServicesDAO.insert(engineering);
        Services psychology = new Services(2, "Psychology services", 2, 140);
        ServicesDAO.insert(psychology);
    }
}
