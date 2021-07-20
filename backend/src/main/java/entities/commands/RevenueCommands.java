package entities.commands;

import database.commands.BasicLevelStudentDAO;
import database.commands.ServicesDAO;
import database.commands.SuperiorLevelStudentDAO;
import entities.Services;
import entities.students.BasicLevelStudent;
import entities.students.SuperiorLevelStudent;

import java.util.List;

public class RevenueCommands {
    private RevenueCommands() {
    }

    public static void getAllRevenue(){
        double revenue = 0;
        List<BasicLevelStudent> basicLevelStudentList = BasicLevelStudentDAO.getAllBasicLevelStudents();
        for (BasicLevelStudent basicLevelStudent : basicLevelStudentList) {
            revenue += basicLevelStudent.getMonthlyPayment();
        }
        List<Services> servicesList = ServicesDAO.getAllServices();
        for (Services service : servicesList) {
            double servicesRevenue = service.getTotalHours()*service.getHourCost();
            revenue += servicesRevenue;
        }
        List<SuperiorLevelStudent> superiorLevelStudentList = SuperiorLevelStudentDAO.getAllSuperiorLevelStudents();
        for (SuperiorLevelStudent superiorLevelStudent : superiorLevelStudentList) {
            double superiorLevelStudentRevenue = superiorLevelStudent.getTotalCredits()*superiorLevelStudent.getCreditsCost();
            revenue += superiorLevelStudentRevenue;
        }
        System.out.println("All revenue: " + revenue);
    }

    public static void getSpecificRevenue(int option){
        double revenue = 0;
        switch (option){
            case (1):
                List<BasicLevelStudent> basicLevelStudentList = BasicLevelStudentDAO.getAllBasicLevelStudents();
                for (BasicLevelStudent basicLevelStudent : basicLevelStudentList) {
                    revenue += basicLevelStudent.getMonthlyPayment();
                }
                System.out.println("Basic Level Students Revenue = " + revenue);
                break;
            case (2):
                List<Services> servicesList = ServicesDAO.getAllServices();
                for (Services service : servicesList) {
                    double servicesRevenue = service.getTotalHours()*service.getHourCost();
                    revenue += servicesRevenue;
                }
                System.out.println("Services Revenue = " + revenue);
                break;
            case (3):
                List<SuperiorLevelStudent> superiorLevelStudentList = SuperiorLevelStudentDAO.getAllSuperiorLevelStudents();
                for (SuperiorLevelStudent superiorLevelStudent : superiorLevelStudentList) {
                    double superiorLevelStudentRevenue = superiorLevelStudent.getTotalCredits()*superiorLevelStudent.getCreditsCost();
                    revenue += superiorLevelStudentRevenue;
                }
                System.out.println("Superior Level Students Revenue = " + revenue);
                break;
            default:
                System.out.println("Option not found");
        }
    }
}
