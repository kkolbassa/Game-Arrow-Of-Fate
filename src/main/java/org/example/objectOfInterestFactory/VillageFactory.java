package org.example.objectOfInterestFactory;

import org.example.blocksFactory.*;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.objectsOfInterest.Village;

public class VillageFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static VillageFactory getInstance() {
        if (instance == null) {
            instance = new VillageFactory();
        }
        return (VillageFactory) instance;
    }

    public VillageFactory() {
        factories.add(TreeFactory.getInstance());
        factories.add(ResidentFactory.getInstance());
        factories.add(AnimalFactory.getInstance());
        factories.add(HouseFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new Village();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
