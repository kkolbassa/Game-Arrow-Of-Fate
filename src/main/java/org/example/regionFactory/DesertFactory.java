package org.example.regionFactory;

import org.example.objectOfInterestFactory.*;
import org.example.regions.Desert;
import org.example.regions.Region;

public class DesertFactory extends RegionFactory{
    public DesertFactory() {
        factories.add(OasisFactory.getInstance());
        factories.add(PyramidRuinFactory.getInstance());
        factories.add(GorgeFactory.getInstance());
        factories.add(SaltMarshFactory.getInstance());
        factories.add(MountainFactory.getInstance());
    }

    @Override
    public Region create() {
        Region region = new Desert();
        fillRegion(region);
        return region;
    }
}
