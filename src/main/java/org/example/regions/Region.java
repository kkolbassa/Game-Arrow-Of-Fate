package org.example.regions;

import org.example.Component;
import org.example.objectsOfInteerest.ObjectOfInterest;

import java.util.ArrayList;

public abstract class Region implements Component {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
