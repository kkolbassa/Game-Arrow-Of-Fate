package org.example.objectOfInterestFactory;

import org.example.blocksFactory.*;
import org.example.objectsOfInterest.Gorge;
import org.example.objectsOfInterest.ObjectOfInterest;

public class GorgeFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static GorgeFactory getInstance() {
        if (instance == null) {
            instance = new GorgeFactory();
        }
        return (GorgeFactory) instance;
    }

    public GorgeFactory() {
        factories.add(TreeFactory.getInstance());
        factories.add(StoneFactory.getInstance());
        factories.add(SandFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new Gorge();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
