package org.example.actions;

import org.example.storages.ItemsStorage;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.regions.Region;

public class BuildWell extends Action{
    public BuildWell() {
        name = "Построить колодец";
        successfulTry = false;
        woodToAction = 5;
    }
    @Override
    public void complete(Region currentRegion, ObjectOfInterest objectOfInterest, ItemsStorage itemsStorage) throws Exception {
        itemsStorage.checkWood(woodToAction);
        objectOfInterest.buildWell();
        itemsStorage.decreaseWood(woodToAction);
        notifyMission(currentRegion,name, itemsStorage);
        successfulTry = true;
    }
}
