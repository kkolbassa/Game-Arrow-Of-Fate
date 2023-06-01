package org.example;

import org.example.regions.Region;

import java.util.ArrayList;

public class GameWorld {
    private RegionsManipulation regionsManipulation = new RegionsManipulation();
    private Player player = new Player();
    private Region currentRegion;

    public Region getCurrentRegion() {
        return currentRegion;
    }

    public void createWorld(int countTundra, int countMixedForest, int countDesert) throws Exception{
        regionsManipulation.createRegions(countTundra,countMixedForest,countDesert);
        setCurrentRegion();
    }
    private void setCurrentRegion(){
        currentRegion = regionsManipulation.getRandomRegion();
    }
    public void changeCurrentRegion(int chooseObject) throws Exception {
        currentRegion = regionsManipulation.getRegion(chooseObject);
    }
    public void cutTree(int chooseObject) throws Exception {
        player.tryCutTree(currentRegion, chooseObject);
    }

    public void buildHouse(int chooseObject) throws Exception {
        player.buildHouse(currentRegion, chooseObject);
    }

    public void buildFire(int chooseObject) throws Exception {
        player.tryBuildFire(currentRegion, chooseObject);
    }

    public ArrayList<Region> getRegions() {
        return regionsManipulation.getRegions();
    }
}
