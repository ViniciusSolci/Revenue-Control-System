package entities;

public class Services {
    private final int id;
    private final String description;
    private final double totalHours;
    private final double hourCost;

    public Services(int id, String description, double totalHours, double hourCost) {
        this.id = id;
        this.description = description;
        this.totalHours = totalHours;
        this.hourCost = hourCost;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public double getHourCost() {
        return hourCost;
    }
}
