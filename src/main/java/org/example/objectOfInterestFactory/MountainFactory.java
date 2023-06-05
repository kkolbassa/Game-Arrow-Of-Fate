package org.example.objectOfInterestFactory;

import org.example.blocksFactory.*;
import org.example.objectsOfInterest.Mountain;
import org.example.objectsOfInterest.ObjectOfInterest;


public class MountainFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static MountainFactory getInstance() {
        if (instance == null) {
            instance = new MountainFactory();
        }
        return (MountainFactory) instance;
    }

    public MountainFactory() {
        factories.add(StoneFactory.getInstance());
        factories.add(IceFactory.getInstance());
        factories.add(FlowerFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new Mountain();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
