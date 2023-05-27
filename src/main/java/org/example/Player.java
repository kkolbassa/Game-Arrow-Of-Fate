package org.example;

import org.example.objectsOfInteerest.ObjectOfInterest;
import org.example.regions.Region;

public class Player {
    public void tryCutTree(Region currentRegion, int chooseObject) throws Exception {
        checkChooseObject(chooseObject);
        cutTree(currentRegion.getObjectOfInterest(chooseObject));
    }

    private void checkChooseObject(int chooseObject) throws Exception {
        if(chooseObject<0) throw new Exception("Объект интереса не выбран");
    }

    private void cutTree(ObjectOfInterest objectOfInterest) throws Exception {
        if(objectOfInterest.hasTree()) objectOfInterest.cutTree();
        else throw new Exception("Деревьев в выбранном объекте нет");
    }

    public void buildHouse(Region currentRegion, int chooseObject) throws Exception {
        checkChooseObject(chooseObject);
        ObjectOfInterest objectOfInterest = currentRegion.getObjectOfInterest(chooseObject);
        objectOfInterest.buildHouse();
    }
    public void tryBuildFire(Region currentRegion, int chooseObject) throws Exception {
        checkChooseObject(chooseObject);
        ObjectOfInterest objectOfInterest = currentRegion.getObjectOfInterest(chooseObject);
        if(Math.random()<0.01) currentRegion.removeObjectOfInterest(chooseObject);
        else objectOfInterest.buildFire();
    }
}
