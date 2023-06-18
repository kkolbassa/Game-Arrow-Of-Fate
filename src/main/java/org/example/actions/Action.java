package org.example.actions;

import org.example.storages.ItemsStorage;
import org.example.items.Item;
import org.example.missions.Mission;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.regions.Region;

public abstract class Action {
    protected String name;
    protected boolean successfulTry;
    protected int woodToAction;

    public abstract void complete(Region currentRegion, ObjectOfInterest objectOfInterest, ItemsStorage itemsStorage) throws Exception;
    protected void notifyMission(Region currentRegion, String action, ItemsStorage itemsStorage) {
        Mission mission = currentRegion.getMission();
        if(!mission.isComplete()){
            mission.notifyMission(action);
            checkMissionComplete(mission, itemsStorage);
        }
    }
    private void checkMissionComplete(Mission mission, ItemsStorage itemsStorage) {
        if(mission.isComplete()) checkReward(mission.getReward(), itemsStorage);
    }
    private void checkReward(Item reward, ItemsStorage itemsStorage) {
        if(reward != null) itemsStorage.addItem(reward);
    }
}
