package org.example;

import org.example.regions.Region;

public class GameWorld {
    private RegionsManipulation regionsManipulation = new RegionsManipulation();
    private Player player = new Player();
    private Region currentRegion;

    public void createWorld(int countTundra, int countMixedForest, int countDesert){
        regionsManipulation.createRegions(countTundra,countMixedForest,countDesert);
    }
    public void setCurrentRegion(){
        currentRegion = regionsManipulation.getRandomRegion();
    }
    public void changeCurrentRegion(){

    }

}
