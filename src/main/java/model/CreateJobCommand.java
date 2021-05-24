package model;

public class CreateJobCommand {

    private String name;

    public CreateJobCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
