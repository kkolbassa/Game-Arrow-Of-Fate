package org.example.objectOfInterestFactory;

import org.example.blocksFactory.*;
import org.example.objectsOfInteerest.ObjectOfInterest;
import org.example.objectsOfInteerest.Swamp;

public class SwampFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static SwampFactory getInstance() {
        if (instance == null) {
            instance = new SwampFactory();
        }
        return (SwampFactory) instance;
    }

    public SwampFactory() {
        factories.add(TreeFactory.getInstance());
        factories.add(FlowerFactory.getInstance());
        factories.add(WaterFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new Swamp();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
