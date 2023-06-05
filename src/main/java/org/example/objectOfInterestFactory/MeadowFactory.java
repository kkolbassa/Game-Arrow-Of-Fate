package org.example.objectOfInterestFactory;

import org.example.blocksFactory.AnimalFactory;
import org.example.blocksFactory.GrassFactory;
import org.example.blocksFactory.TreeFactory;
import org.example.objectsOfInterest.Meadow;
import org.example.objectsOfInterest.ObjectOfInterest;

public class MeadowFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static MeadowFactory getInstance() {
        if (instance == null) {
            instance = new MeadowFactory();
        }
        return (MeadowFactory) instance;
    }

    public MeadowFactory() {
        factories.add(TreeFactory.getInstance());
        factories.add(GrassFactory.getInstance());
        factories.add(AnimalFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new Meadow();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
