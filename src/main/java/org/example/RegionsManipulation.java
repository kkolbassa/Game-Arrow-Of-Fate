package org.example;

import org.example.regionFactory.DesertFactory;
import org.example.regionFactory.MixedForestFactory;
import org.example.regionFactory.RegionFactory;
import org.example.regionFactory.TundraFactory;
import org.example.regions.Region;

import java.util.ArrayList;
import java.util.Collections;

public class RegionsManipulation {
    private ArrayList<Region> regions = new ArrayList<>();
    private RegionFactory factory;

    public void createRegions(int countTundra, int countMixedForest, int countDesert ) throws Exception{
        checkCountData(countTundra, countMixedForest,countDesert);
        createTundra(countTundra);
        createMixedForest(countMixedForest);
        createDesert(countDesert);
        Collections.shuffle(regions);
    }

    private void checkCountData(int countTundra, int countMixedForest, int countDesert) throws Exception {
        if(countTundra==0&&countMixedForest==0&&countDesert==0)
            throw new Exception("Неверно введено кол-во регионов");
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
        int winMission = (int) (Math.random()*count);
        for(int i=0;i<count;i++){
            if(i==winMission) regions.add(factory.create(true));
            else regions.add(factory.create(false));
        }
    }
    public Region getRandomRegion(){
        return regions.get((int) (Math.random()*regions.size()));
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public Region getRegion(int chooseObject) throws Exception {
        if(chooseObject<0) throw new Exception("Регион не выбран!");
        else return regions.get(chooseObject);
    }
}
