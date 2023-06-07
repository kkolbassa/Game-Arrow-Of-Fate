package org.example.editors;

import org.example.Player;
import org.example.missions.Mission;
import org.example.regions.Region;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TextEditorMission {
    private JTextArea description;
    private JLabel task;
    private JLabel progress;
    private JLabel complete;
    private JButton finishGame;
    private Player player;
    private ArrayList<Mission> significantMissions;

    public TextEditorMission(JTextArea description, JLabel task, JLabel progress, JLabel complete,Player player, JButton jButtonFinishGame) {
        this.description = description;
        this.task = task;
        this.progress = progress;
        this.complete = complete;
        this.player = player;
        this.finishGame = jButtonFinishGame;
        significantMissions = new ArrayList<>();
    }
    public void setSignificantMissions(ArrayList<Region> regions) {
        regions.stream().filter(region -> region.getMission().isSignificant())
                .forEach(region -> significantMissions.add(region.getMission()));
    }
    public void updateMission(Mission mission){
        description.setText(mission.getDescription());
        task.setText(mission.getTask());
        progress.setText(String.valueOf(mission.getProgress())+" / " + mission.getCountAction());
        checkMissionComplete(mission);
        checkAllMissionsComplete();
    }

    private void checkMissionComplete(Mission mission) {
        if(mission.isComplete()) updateCompleteMission(mission);
        else complete.setText("");
    }
    private void updateCompleteMission(Mission mission) {
        if(mission.isSignificant())setTextRewardGet();
        else setTextRewardLost();
    }
    private void setTextRewardGet() {
        complete.setText("Награда получена!");
        complete.setForeground(new java.awt.Color(51, 255, 51));
    }
    private void setTextRewardLost() {
        complete.setText("     Вас обманули!");
        complete.setForeground(new java.awt.Color(255, 0, 51));
    }
    private void checkAllMissionsComplete() {
        //if(player.isMissionsComplete()) createFinishButton();
        if(isMissionsComplete()) createFinishButton();
    }

    private boolean isMissionsComplete() {
        if(significantMissions!=null) {
            for (Mission mission : significantMissions) {
                if (!mission.isComplete()) return false;
            }
            return true;
        }
        return false;
    }

    private void createFinishButton() {
        finishGame.setVisible(true);
    }

}
