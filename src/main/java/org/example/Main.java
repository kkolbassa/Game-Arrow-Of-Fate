package org.example;

import org.example.objectOfInterestFactory.ForestFactory;
import org.example.objectOfInterestFactory.ObjectOfInterestFactory;
import org.example.objectOfInterestFactory.VillageFactory;
import org.example.objectsOfInteerest.ObjectOfInterest;
import org.example.regionFactory.DesertFactory;
import org.example.regionFactory.MixedForestFactory;
import org.example.regionFactory.RegionFactory;
import org.example.regionFactory.TundraFactory;
import org.example.regions.Region;

public class Main {
    public static void main(String[] args) {
        new Program().setVisible(true);
        /*RegionFactory factory = new DesertFactory();
        Region tundra = factory.create();
        tundra.getName();
        ObjectOfInterestFactory factory1= new VillageFactory();
        ObjectOfInterest forest = factory1.create();
        boolean a = forest.hasHouse();
        System.out.println(a);
        forest.buildHouse();
        System.out.println(a);*/
    }
}