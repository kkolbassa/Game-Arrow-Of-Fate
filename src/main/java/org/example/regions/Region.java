package org.example.regions;

import org.example.ComponentRegion;
import org.example.objectsOfInteerest.ObjectOfInterest;

import java.util.ArrayList;

public abstract class Region implements ComponentRegion {
    private ArrayList<ObjectOfInterest> objectsOfInterest;
    private String name;

    public ArrayList<ObjectOfInterest> getObjectsOfInterest() {
        return objectsOfInterest;
    }

    public void setObjectsOfInterest(ArrayList<ObjectOfInterest> objectsOfInterest) {
        this.objectsOfInterest = objectsOfInterest;
    }
    public void addObjectsOfInterest(ObjectOfInterest objectsOfInterest) {
        this.objectsOfInterest.add(objectsOfInterest);
    }
    @Override
    public boolean hasTree() {
        for (ComponentRegion objectOfInterest : objectsOfInterest) {
            if(objectOfInterest.hasTree()) return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
