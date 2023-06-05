package org.example.objectOfInterestFactory;

import org.example.blocksFactory.*;
import org.example.objectsOfInterest.Geyser;
import org.example.objectsOfInterest.ObjectOfInterest;

public class GeyserFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static GeyserFactory getInstance() {
        if (instance == null) {
            instance = new GeyserFactory();
        }
        return (GeyserFactory) instance;
    }

    public GeyserFactory() {
            factories.add(StoneFactory.getInstance());
            factories.add(WaterFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new Geyser();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
