package org.example.regions;

import org.example.ComponentRegion;
import org.example.objectsOfInteerest.ObjectOfInterest;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class Region implements ComponentRegion {
    private ArrayList<ObjectOfInterest> objectsOfInterest;
    private String name;

    public ArrayList<ObjectOfInterest> getObjectsOfInterest() {
        return objectsOfInterest;
    }
    public ObjectOfInterest getObjectOfInterest(int index) {
        return objectsOfInterest.get(index);
    }

    public void setObjectsOfInterest(ArrayList<ObjectOfInterest> objectsOfInterest) {
        this.objectsOfInterest = objectsOfInterest;
    }
    public void addObjectsOfInterest(ObjectOfInterest objectsOfInterest) {
        this.objectsOfInterest.add(objectsOfInterest);
    }

    public LinkedHashMap<String, String> getInfo2Table() {
        LinkedHashMap<String, String> table = new LinkedHashMap<>();
        objectsOfInterest.forEach(objectOfInterest -> {
            table.put(objectOfInterest.getName(),objectOfInterest.getInfo2Table());
        });
        return table;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeObjectOfInterest(int chooseObject) throws Exception {
        objectsOfInterest.remove(chooseObject);
        throw new Exception("Упс! Выбранный объект сгорел!");
    }
}
