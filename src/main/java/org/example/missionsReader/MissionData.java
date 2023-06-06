package org.example.missionsReader;

public class MissionData {
    private String region;
    private String description;
    private String task;

    public MissionData(String region, String description, String task) {
        this.region = region;
        this.description = description;
        this.task = task;
    }

    public String getRegion() {
        return region;
    }

    public String getDescription() {
        return description;
    }

    public String getTask() {
        return task;
    }
}
