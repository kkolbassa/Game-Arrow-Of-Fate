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
        for(int i = 0; i< factories.size(); i++){
            objectOfInterests.add(factories.get(i).create());
        }
        region.setObjectsOfInterest(objectOfInterests);
    }
}
