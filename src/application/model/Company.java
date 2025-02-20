package application.model;

public class Company {
    private String name;
    private int hours; // weekly work hours
    private int id;
    public Company(int id, String name, int hours) {
        this.id = id;
        this.name = name;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " (" + hours + " hours)";
    }

}
