package org.example;

import org.example.editors.TextEditorGameWorld;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    private Timer gameTimer;

    public void startGame(RegionsManipulation regionsManipulation, TextEditorGameWorld textEditorGameWorld)throws Exception {
        gameTimer = new Timer();
        TimerTask gameTask = new TimerTask() {
            public void run() {
                regionsManipulation.addTree();
                textEditorGameWorld.updateCurrentRegion();
            }
        };
        gameTimer.schedule(gameTask, 0, 120000);
    }

    public void stopGame() {
        gameTimer.cancel();
    }
}
