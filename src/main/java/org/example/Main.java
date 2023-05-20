package org.example;

import org.example.regionFactory.DesertFactory;
import org.example.regionFactory.MixedForestFactory;
import org.example.regionFactory.RegionFactory;
import org.example.regionFactory.TundraFactory;
import org.example.regions.Region;

public class Main {
    public static void main(String[] args) {
        RegionFactory factory = new DesertFactory();
        Region tundra = factory.create();
        tundra.getName();

    }
}