package model;

import java.util.UUID;

public class Job {

    private String id;
    private String name;

    public Job(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
