package org.example.objectOfInterestFactory;

import org.example.blocksFactory.*;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.objectsOfInterest.SaltMarsh;

public class SaltMarshFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static SaltMarshFactory getInstance() {
        if (instance == null) {
            instance = new SaltMarshFactory();
        }
        return (SaltMarshFactory) instance;
    }

    public SaltMarshFactory() {
        factories.add(WaterFactory.getInstance());
        factories.add(SaltFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new SaltMarsh();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
