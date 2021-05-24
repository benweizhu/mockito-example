package model;

public class DeleteJobCommand {

    private String id;

    public DeleteJobCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
