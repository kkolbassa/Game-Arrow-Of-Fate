package org.example.objectOfInterestFactory;

import org.example.blocksFactory.*;
import org.example.objectsOfInteerest.Forest;
import org.example.objectsOfInteerest.ObjectOfInterest;

public class ForestFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static ForestFactory getInstance() {
        if (instance == null) {
            instance = new ForestFactory();
        }
        return (ForestFactory) instance;
    }

    public ForestFactory() {
        factories.add(TreeFactory.getInstance());
        factories.add(MushroomFactory.getInstance());
        factories.add(AnimalFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new Forest();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
