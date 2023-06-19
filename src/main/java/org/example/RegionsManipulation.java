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

    public void createRegions(int countTundra, int countMixedForest, int countDesert ) {
        createTundra(countTundra);
        createMixedForest(countMixedForest);
        createDesert(countDesert);
        Collections.shuffle(regions);
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

    public Region changeRegion(Region currentRegion, int chooseObject) throws Exception {
        Region newRegion = getRegion(chooseObject);
        if(currentRegion.equals(newRegion)) throw new Exception("Вы уже находитесь в этом регионе!");
        if(Math.abs(regions.indexOf(currentRegion) - chooseObject)>1) throw new Exception("Перемещаться можно только в соседний регион!");
        else return newRegion;
    }

    public void addTree() {
        getRandomRegion().addTree();
    }
}
