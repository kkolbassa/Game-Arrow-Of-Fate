package org.example.actions;

import org.example.storages.ItemsStorage;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.regions.Region;

public class CutTree extends Action{
    public CutTree() {
        name = "Срубить дерево";
        successfulTry = false;
        woodToAction = 0;
    }
    @Override
    public void complete(Region currentRegion, ObjectOfInterest objectOfInterest, ItemsStorage itemsStorage) throws Exception {
        cutTree(objectOfInterest);
        itemsStorage.addWood();
        notifyMission(currentRegion, name, itemsStorage);
        successfulTry = true;
    }
    private void cutTree(ObjectOfInterest objectOfInterest) throws Exception {
        if(objectOfInterest.hasTree()) objectOfInterest.cutTree();
        else throw new Exception("Деревьев в выбранном объекте нет");
    }
}
