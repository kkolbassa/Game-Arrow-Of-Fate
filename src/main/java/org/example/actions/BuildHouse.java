package org.example.actions;

import org.example.storages.ItemsStorage;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.regions.Region;

public class BuildHouse extends Action{
    public BuildHouse() {
        name = "Построить дом";
        successfulTry = false;
        woodToAction = 10;
    }

    @Override
    public void complete(Region currentRegion, ObjectOfInterest objectOfInterest, ItemsStorage itemsStorage) throws Exception {
        itemsStorage.checkWood(woodToAction);
        objectOfInterest.buildHouse();
        itemsStorage.decreaseWood(woodToAction);
        notifyMission(currentRegion,name,itemsStorage);
        successfulTry = true;
    }
}
