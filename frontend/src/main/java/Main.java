import entities.commands.BasicLevelStudentCommands;
import entities.commands.ServicesCommands;
import entities.commands.SuperiorLevelStudentCommands;
import org.jline.reader.LineReader;


public class Main {
    private static final String COMMAND_NOT_FOUND = "Command not found";
    private static LineReader reader;

    public static void main(String[] args) {
        int command;

       do{
            Menu.basicMenu();
            command = Integer.parseInt(reader.readLine(""));
            switch (command) {
                case (0):
                    break;
                case (1):
                    Menu.separator();
                    Menu.advancedMenu();
                    int commandTarget = Integer.parseInt(reader.readLine(""));
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
                        default:
                            System.out.println(COMMAND_NOT_FOUND);
                            break;
                    }
                    break;
                case (2):
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
                    break;
                case (3):
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
                            ServicesCommands.showAllBasicLevelStudents();
                            break;
                        case (5):
                            ServicesCommands.showSpecificBasicLevelStudent();
                            break;
                        default:
                            System.out.println(COMMAND_NOT_FOUND);
                            break;
                    }
                    break;
                case (4):
                default:
                    System.out.println(COMMAND_NOT_FOUND);
                    break;
            }
        } while (command != 0);
    }
}
