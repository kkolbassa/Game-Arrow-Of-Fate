package org.example;

import org.example.actions.Action;
import org.example.actions.CutTree;
import org.example.regions.Region;

import java.util.ArrayList;

public class GameWorld {
    private RegionsManipulation regionsManipulation = new RegionsManipulation();
    private Player player = new Player();
    private Region currentRegion;

    public Player getPlayer() {
        return player;
    }
    public Region getCurrentRegion() {
        return currentRegion;
    }
    public ArrayList<Region> getRegions() {
        return regionsManipulation.getRegions();
    }

    public RegionsManipulation getRegionsManipulation() {
        return regionsManipulation;
    }

    public void createWorld(int countTundra, int countMixedForest, int countDesert){
        regionsManipulation.createRegions(countTundra,countMixedForest,countDesert);
        setCurrentRegion();
    }
    private void setCurrentRegion(){
        currentRegion = regionsManipulation.getRandomRegion();
    }
    public void changeCurrentRegion(int chooseObject) throws Exception {
        currentRegion = regionsManipulation.changeRegion(currentRegion,chooseObject);
    }
    public void doAction(int chooseObject, Action action) throws Exception {
        player.doAction(currentRegion,chooseObject,action);
    }
}
