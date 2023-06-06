package org.example;

import org.example.items.Item;
import org.example.missions.Mission;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.regions.Region;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void tryCutTree(Region currentRegion, int chooseObject) throws Exception {
        checkChooseObject(chooseObject);
        cutTree(currentRegion.getObjectOfInterest(chooseObject));
        notifyMission(currentRegion, "Срубить дерево");
    }

    private void checkChooseObject(int chooseObject) throws Exception {
        if(chooseObject<0) throw new Exception("Объект интереса не выбран");
    }

    private void cutTree(ObjectOfInterest objectOfInterest) throws Exception {
        if(objectOfInterest.hasTree()) objectOfInterest.cutTree();
        else throw new Exception("Деревьев в выбранном объекте нет");
    }
    private void notifyMission(Region currentRegion, String action) {
        Mission mission = currentRegion.getMission();
        if(!mission.isComplete()){
            mission.notifyMission(action);
            checkMissionComplete(mission);
        }
    }
    private void checkMissionComplete(Mission mission) {
        if(mission.isComplete()) items.add(mission.getReward());
    }
    public void buildHouse(Region currentRegion, int chooseObject) throws Exception {
        checkChooseObject(chooseObject);
        ObjectOfInterest objectOfInterest = currentRegion.getObjectOfInterest(chooseObject);
        objectOfInterest.buildHouse();
        notifyMission(currentRegion,"Построить дом");
    }
    public void tryBuildFire(Region currentRegion, int chooseObject) throws Exception {
        checkChooseObject(chooseObject);
        ObjectOfInterest objectOfInterest = currentRegion.getObjectOfInterest(chooseObject);
        double probabilityBurnObject = 0.01;
        if(Math.random()<probabilityBurnObject) removeObjectOfInterest(currentRegion, chooseObject);
        else buildFire(objectOfInterest, currentRegion);
    }

    private void buildFire(ObjectOfInterest objectOfInterest, Region currentRegion) throws Exception {
        objectOfInterest.buildFire();
        notifyMission(currentRegion,"Разжечь костер");
    }

    private void removeObjectOfInterest(Region currentRegion,int chooseObject) throws Exception {
        currentRegion.removeObjectOfInterest(chooseObject);
    }
    public void buildWell(Region currentRegion, int chooseObject) throws Exception {
        checkChooseObject(chooseObject);
        ObjectOfInterest objectOfInterest = currentRegion.getObjectOfInterest(chooseObject);
        objectOfInterest.buildWell();
        notifyMission(currentRegion,"Построить колодец");
    }
}
