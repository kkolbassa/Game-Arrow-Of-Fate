package org.example.objectOfInterestFactory;

import org.example.blocksFactory.*;
import org.example.objectsOfInterest.Glacier;
import org.example.objectsOfInterest.ObjectOfInterest;

public class GlacierFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static GlacierFactory getInstance() {
        if (instance == null) {
            instance = new GlacierFactory();
        }
        return (GlacierFactory) instance;
    }

    public GlacierFactory() {
        factories.add(IceFactory.getInstance());
        factories.add(WaterFactory.getInstance());
        factories.add(AnimalFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new Glacier();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
