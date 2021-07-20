package entities.commands;

import database.commands.ServicesDAO;
import entities.Services;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

import java.util.List;

public class ServicesCommands {
    private ServicesCommands() {
    }

    private static final String ENTER_SERVICE_ID = "Enter service id: ";
    private static final LineReader READER = LineReaderBuilder.builder().terminal(null).completer(null).build();

    public static void insertOrUpdate(int command){
        int id = Integer.parseInt(READER.readLine(ENTER_SERVICE_ID));
        String description = READER.readLine("Enter service description: ");
        double totalHours = Double.parseDouble(READER.readLine("Enter hours of service: "));
        double hourCost = Double.parseDouble(READER.readLine("Enter hour cost: "));

        Services services = new Services(id, description, totalHours, hourCost);

        if (command == 1){
            ServicesDAO.insert(services);
        } else  ServicesDAO.update(services);
    }

    public static void delete(){
        int id = Integer.parseInt(READER.readLine(ENTER_SERVICE_ID));
        ServicesDAO.delete(id);
    }

    public static void showAllServices(){
        List<Services> allServices = ServicesDAO.getAllServices();
        for (Services services : allServices) {
            System.out.println(services);
            System.out.println("\n---------------\n");
        }
    }

    public static void showSpecificService(){
        int id = Integer.parseInt(READER.readLine(ENTER_SERVICE_ID));
        Services services = ServicesDAO.getSingleServices(id);
        if (services != null){
            System.out.println(services);
        } else System.out.println("Service not found");
    }
}
