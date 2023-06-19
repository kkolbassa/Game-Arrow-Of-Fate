package org.example.regions;

import org.example.missions.Mission;
import org.example.objectsOfInterest.ObjectOfInterest;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class Region {
    private String name;
    private Mission mission;
    private boolean isObjectsChanged = false;
    private ArrayList<ObjectOfInterest> objectsOfInterest;

    public Mission getMission() {
        return mission;
    }
    public void setMission(Mission mission) {
        this.mission = mission;
    }
    public ArrayList<ObjectOfInterest> getObjectsOfInterest() {
        return objectsOfInterest;
    }
    public ObjectOfInterest getObjectOfInterest(int index) {
        return objectsOfInterest.get(index);
    }

    public boolean isObjectsChanged() {
        return isObjectsChanged;
    }

    public void setObjectsChanged(boolean objectsChanged) {
        isObjectsChanged = objectsChanged;
    }

    public void setObjectsOfInterest(ArrayList<ObjectOfInterest> objectsOfInterest) {
        this.objectsOfInterest = objectsOfInterest;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ObjectOfInterest getRandomObjectOfInterest(){
        return objectsOfInterest.get((int) (Math.random()*objectsOfInterest.size()));
    }

    public LinkedHashMap<String, String> getInfo2Table() {
        LinkedHashMap<String, String> table = new LinkedHashMap<>();
        objectsOfInterest.forEach(objectOfInterest -> {
            table.put(objectOfInterest.getName(),objectOfInterest.getInfo2Table());
        });
        return table;
    }

    public void removeObjectOfInterest(int chooseObject) throws Exception {
        objectsOfInterest.remove(chooseObject);
        setObjectsChanged(true);
        throw new Exception("Упс! Выбранный объект сгорел!");
    }

    public void addTree() {
        getRandomObjectOfInterest().addTree();
    }
}
