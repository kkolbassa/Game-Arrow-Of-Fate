package org.example.storages;

import java.util.ArrayList;

public class StoryData {
    private ArrayList<String> beginStory;
    private ArrayList<String> endStory;
    private static StoryData instance;
    public static StoryData getInstance() {

        if (instance == null) {
            instance = new StoryData();
        }
        return instance;
    }

    public ArrayList<String> getBeginStory() {
        return beginStory;
    }

    public void setBeginStory(ArrayList<String> beginStory) {
        this.beginStory = beginStory;
    }

    public ArrayList<String> getEndStory() {
        return endStory;
    }

    public void setEndStory(ArrayList<String> endStory) {
        this.endStory = endStory;
    }
}
