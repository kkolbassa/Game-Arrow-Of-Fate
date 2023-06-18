package org.example.actions;

import org.example.storages.ItemsStorage;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.regions.Region;

public class BuildFire extends Action{
    public BuildFire() {
        name = "Разжечь костер";
        successfulTry = false;
        woodToAction = 1;
    }

    @Override
    public void complete(Region currentRegion, ObjectOfInterest objectOfInterest, ItemsStorage itemsStorage) throws Exception {
        itemsStorage.checkWood(woodToAction);

        double probabilityBurnObject = 0.01;
        if(Math.random()<probabilityBurnObject) removeObjectOfInterest(currentRegion, objectOfInterest);
        else buildFire(objectOfInterest, currentRegion, itemsStorage);

    }
    private void removeObjectOfInterest(Region currentRegion,ObjectOfInterest chooseObject) throws Exception {
        currentRegion.removeObjectOfInterest(currentRegion.getObjectsOfInterest().indexOf(chooseObject));
    }
    private void buildFire(ObjectOfInterest objectOfInterest, Region currentRegion, ItemsStorage itemsStorage) throws Exception {
        objectOfInterest.buildFire();
        itemsStorage.decreaseWood(woodToAction);
        notifyMission(currentRegion,name, itemsStorage);
        successfulTry = true;
    }
}
