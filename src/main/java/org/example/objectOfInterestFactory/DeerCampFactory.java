package org.example.objectOfInterestFactory;

import org.example.blocksFactory.AnimalFactory;
import org.example.blocksFactory.HouseFactory;
import org.example.blocksFactory.ResidentFactory;
import org.example.objectsOfInterest.DeerCamp;
import org.example.objectsOfInterest.ObjectOfInterest;

public class DeerCampFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static DeerCampFactory getInstance() {
        if (instance == null) {
            instance = new DeerCampFactory();
        }
        return (DeerCampFactory) instance;
    }
    public DeerCampFactory() {
        factories.add(AnimalFactory.getInstance());
        factories.add(HouseFactory.getInstance());
        factories.add(ResidentFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new DeerCamp();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
