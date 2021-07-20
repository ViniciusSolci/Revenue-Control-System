import database.connection.ConnectDatabase;
import database.connection.TablesCreation;

import database.utils.TestObjects;
import entities.commands.BasicLevelStudentCommands;
import entities.commands.RevenueCommands;
import entities.commands.ServicesCommands;
import entities.commands.SuperiorLevelStudentCommands;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

import java.sql.SQLException;

public class Main {
    private static final String COMMAND_NOT_FOUND = "Command not found";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TablesCreation.run();
        ///TestObjects.populateTablesForTests();
        LineReader reader = LineReaderBuilder.builder().terminal(null).completer(null).build();
        int command;

        do{
            Menu.basicMenu();
            command = Integer.parseInt(reader.readLine(""));
            switch (command) {
                case (0):
                    ConnectDatabase.stopDBServer();
                    break;
                case (1):
                    basicStudentMenu(reader);
                    break;
                case (2):
                    superiorLevelStudent(reader);
                    break;
                case (3):
                    servicesMenu(reader);
                    break;
                case (4):
                    int commandTarget;
                    Menu.separator();
                    Menu.specificRevenueMenu();
                    commandTarget = Integer.parseInt(reader.readLine(""));
                    RevenueCommands.getSpecificRevenue(commandTarget);
                    break;
                case (5):
                    RevenueCommands.getAllRevenue();
                    break;
                default:
                    System.out.println(COMMAND_NOT_FOUND);
                    break;
            }
        } while (command != 0);
    }

    private static void servicesMenu(LineReader reader) {
        int commandTarget;
        Menu.separator();
        Menu.advancedMenu();
        commandTarget = Integer.parseInt(reader.readLine(""));
        switch (commandTarget) {
            case (0):
                break;
            case (1):
            case (2):
                ServicesCommands.insertOrUpdate(commandTarget);
                break;
            case (3):
                ServicesCommands.delete();
                break;
            case (4):
                ServicesCommands.showAllServices();
                break;
            case (5):
                ServicesCommands.showSpecificService();
                break;
            default:
                System.out.println(COMMAND_NOT_FOUND);
                break;
        }
    }

    private static void superiorLevelStudent(LineReader reader) {
        int commandTarget;
        Menu.separator();
        Menu.advancedMenu();
        commandTarget = Integer.parseInt(reader.readLine(""));
        switch (commandTarget) {
            case (0):
                break;
            case (1):
            case (2):
                SuperiorLevelStudentCommands.insertOrUpdate(commandTarget);
                break;
            case (3):
                SuperiorLevelStudentCommands.delete();
                break;
            case (4):
                SuperiorLevelStudentCommands.showAllBasicLevelStudents();
                break;
            case (5):
                SuperiorLevelStudentCommands.showSpecificBasicLevelStudent();
                break;
            default:
                System.out.println(COMMAND_NOT_FOUND);
                break;
        }
    }

    private static void basicStudentMenu(LineReader reader) {
        int commandTarget;
        Menu.separator();
        Menu.advancedMenuForBasicStudents();
        commandTarget = Integer.parseInt(reader.readLine(""));
        switch (commandTarget) {
            case (0):
                break;
            case (1):
            case (2):
                BasicLevelStudentCommands.insertOrUpdate(commandTarget);
                break;
            case (3):
                BasicLevelStudentCommands.delete();
                break;
            case (4):
                BasicLevelStudentCommands.showAllBasicLevelStudents();
                break;
            case (5):
                BasicLevelStudentCommands.showSpecificBasicLevelStudent();
                break;
            case (6):
                BasicLevelStudentCommands.updateMonthlyPayment();
                break;
            default:
                System.out.println(COMMAND_NOT_FOUND);
                break;
        }
    }
}
