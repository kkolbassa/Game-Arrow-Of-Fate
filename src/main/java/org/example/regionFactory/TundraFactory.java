package org.example.regionFactory;

import org.example.objectOfInterestFactory.*;
import org.example.regions.Region;
import org.example.regions.Tundra;


public class TundraFactory extends RegionFactory{
    private static RegionFactory instance;
    public static TundraFactory getInstance() {
        if (instance == null) {
            instance = new TundraFactory();
        }
        return (TundraFactory) instance;
    }
    public TundraFactory() {
        factories.add(GlacierFactory.getInstance());
        factories.add(WoodlandsFactory.getInstance());
        factories.add(DeerCampFactory.getInstance());
        factories.add(SwampFactory.getInstance());
        factories.add(GeyserFactory.getInstance());
    }

    @Override
    public Region create() {
        Region region = new Tundra();
        fillRegion(region);
        return region;
    }

}
