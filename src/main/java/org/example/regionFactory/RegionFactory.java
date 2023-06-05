package org.example.regionFactory;

import org.example.missionsFactory.MissionFactory;
import org.example.objectOfInterestFactory.ObjectOfInterestFactory;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.regions.Region;

import java.util.ArrayList;

public abstract class RegionFactory {
    protected ArrayList<ObjectOfInterestFactory> factories = new ArrayList<>();
    protected MissionFactory missionFactory;
    public abstract Region create(boolean significantMission);
    public void fillRegion(Region region) {
        ArrayList<ObjectOfInterest> objectOfInterests = new ArrayList<>();
        for(int i = 0; i< factories.size(); i++){
            objectOfInterests.add(factories.get(i).create());
        }
        region.setObjectsOfInterest(objectOfInterests);
    }
    public void fillMission(Region region, boolean significantMission){
        region.setMission(missionFactory.create(significantMission));
    }
}
