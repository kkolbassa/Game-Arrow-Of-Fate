package org.example.regionFactory;

import org.example.missionsFactory.MixedForestMissionFactory;
import org.example.objectOfInterestFactory.*;
import org.example.regions.MixedForest;
import org.example.regions.Region;

public class MixedForestFactory extends RegionFactory{
    private static RegionFactory instance;
    public static MixedForestFactory getInstance() {
        if (instance == null) {
            instance = new MixedForestFactory();
        }
        return (MixedForestFactory) instance;
    }
    public MixedForestFactory() {
        factories.add(MeadowFactory.getInstance());
        factories.add(ForestFactory.getInstance());
        factories.add(SwampFactory.getInstance());
        factories.add(VillageFactory.getInstance());
        factories.add(MountainFactory.getInstance());
        missionFactory = MixedForestMissionFactory.getInstance();
    }

    @Override
    public Region create(boolean significantMission) {
        Region region = new MixedForest();
        fillRegion(region);
        fillMission(region, significantMission);
        return region;
    }
}
