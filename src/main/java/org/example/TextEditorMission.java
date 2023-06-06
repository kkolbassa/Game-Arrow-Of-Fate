package org.example;

import org.example.missions.Mission;

import javax.swing.*;

public class TextEditorMission {
    private JTextArea description;
    private JLabel task;
    private JLabel progress;
    private JLabel complete;

    public TextEditorMission(JTextArea description, JLabel task, JLabel progress, JLabel complete) {
        this.description = description;
        this.task = task;
        this.progress = progress;
        this.complete = complete;
    }
    public void updateMission(Mission mission){
        description.setText(mission.getDescription());
        task.setText(mission.getTask());
        progress.setText(String.valueOf(mission.getProgress())+" / " + mission.getCountAction());
        if(mission.isComplete()) updateCompleteMission(mission);
    }

    private void updateCompleteMission(Mission mission) {
        if(mission.isSignificant())complete.setText("Награда получена!");
        else complete.setText("Вас обманули!");
    }
}
