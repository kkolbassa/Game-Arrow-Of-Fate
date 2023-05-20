package org.example.regionFactory;

import org.example.objectOfInterestFactory.*;
import org.example.regions.MixedForest;
import org.example.regions.Region;

public class MixedForestFactory extends RegionFactory{
    public MixedForestFactory() {
        factories.add(MeadowFactory.getInstance());
        factories.add(ForestFactory.getInstance());
        factories.add(MountainFactory.getInstance());
        factories.add(SwampFactory.getInstance());
        factories.add(VillageFactory.getInstance());
    }

    @Override
    public Region create() {
        Region region = new MixedForest();
        fillRegion(region);
        return region;
    }
}
