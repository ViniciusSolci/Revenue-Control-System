package entities.commands;

import database.commands.ServicesDAO;
import entities.Services;
import org.jline.reader.LineReader;

import java.util.List;

public class ServicesCommands {
    private ServicesCommands() {
    }

    private static final String ENTER_SERVICE_ID = "Enter service id: ";
    private static LineReader reader;

    public static void insertOrUpdate(int command){
        int id = Integer.parseInt(reader.readLine(ENTER_SERVICE_ID));
        String description = reader.readLine("Enter service description: ");
        double totalHours = Double.parseDouble(reader.readLine("Enter hours of service: "));
        double hourCost = Double.parseDouble(reader.readLine("Enter hour cost: "));

        Services services = new Services(id, description, totalHours, hourCost);

        if (command == 1){
            ServicesDAO.insert(services);
        } else  ServicesDAO.update(services);
    }

    public static void delete(){
        int id = Integer.parseInt(reader.readLine(ENTER_SERVICE_ID));
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
        int id = Integer.parseInt(reader.readLine(ENTER_SERVICE_ID));
        Services services = ServicesDAO.getSingleServices(id);
        if (services != null){
            System.out.println(services);
        } else System.out.println("Service not found");
    }
}
