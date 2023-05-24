package org.example;

import org.example.regions.Region;

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
    public void setCurrentRegion(){
        currentRegion = regionsManipulation.getRandomRegion();
    }
    public void changeCurrentRegion(){

    }

}
