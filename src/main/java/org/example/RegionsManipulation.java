package org.example;

import org.example.regionFactory.DesertFactory;
import org.example.regionFactory.MixedForestFactory;
import org.example.regionFactory.RegionFactory;
import org.example.regionFactory.TundraFactory;
import org.example.regions.Region;

import java.util.ArrayList;

public class RegionsManipulation {
    private ArrayList<Region> regions = new ArrayList<>();
    private RegionFactory factory;

    public void createRegions(int countTundra, int countMixedForest, int countDesert ){
        createTundra(countTundra);
        createMixedForest(countMixedForest);
        createDesert(countDesert);
    }

    private void createDesert(int countDesert) {
        factory = DesertFactory.getInstance();
        createRegion(countDesert);
    }

    private void createMixedForest(int countMixedForest) {
        factory = MixedForestFactory.getInstance();
        createRegion(countMixedForest);
    }

    private void createTundra(int countTundra) {
        factory = TundraFactory.getInstance();
        createRegion(countTundra);
    }
    private void createRegion(int count) {
        for(int i=0;i<count;i++){
            regions.add(factory.create());
        }
    }
    public Region getRandomRegion(){
        return regions.get((int) (Math.random()*regions.size()));
    }
}