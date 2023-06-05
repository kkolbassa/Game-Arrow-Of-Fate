package org.example.missions;

public abstract class Mission {
    private String description;
    private String task;
    private int countAction;
    private int progress;
    private boolean complete;
    private boolean significant;
    public Mission(String description, String task, int countAction, boolean significant) {
        this.description = description;
        this.task = task;
        this.countAction = countAction;
        this.significant = significant;
        progress = 0;
        complete = false;
    }
    public void incrementProgress() {
        progress++;
        if (progress >= countAction) {
            completeMission();
            complete = true;
        }
    }
    public abstract void completeMission();

    public String getDescription() {
        return description;
    }
    public String getTask() {
        return task;
    }
    public int getCountAction() {
        return countAction;
    }
    public int getProgress() {
        return progress;
    }

}
