package entities.students;

public class GeneralStudent {
    private final int id;
    private final String name;

    public GeneralStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
