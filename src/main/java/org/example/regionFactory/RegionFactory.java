package org.example.regionFactory;

import org.example.objectOfInterestFactory.ObjectOfInterestFactory;
import org.example.objectsOfInteerest.ObjectOfInterest;
import org.example.regions.Region;

import java.util.ArrayList;

public abstract class RegionFactory {
    protected ArrayList<ObjectOfInterestFactory> factories = new ArrayList<>();
    public abstract Region create();
    public void fillRegion(Region region) {
        ArrayList<ObjectOfInterest> objectOfInterests = new ArrayList<>();
        int maxCountObject = 7;
        int count = 1 + (int) (Math.random()*maxCountObject);
        for(int i = 0; i<count; i++){
            int chosenFactory = (int) (Math.random()*factories.size());
            objectOfInterests.add(factories.get(chosenFactory).create());
        }
        region.setObjectsOfInterest(objectOfInterests);
    }
}
