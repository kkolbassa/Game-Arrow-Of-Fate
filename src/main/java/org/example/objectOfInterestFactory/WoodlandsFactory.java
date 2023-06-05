package org.example.objectOfInterestFactory;

import org.example.blocksFactory.GrassFactory;
import org.example.blocksFactory.StoneFactory;
import org.example.blocksFactory.TreeFactory;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.objectsOfInterest.Woodlands;

public class WoodlandsFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static WoodlandsFactory getInstance() {
        if (instance == null) {
            instance = new WoodlandsFactory();
        }
        return (WoodlandsFactory) instance;
    }

    public WoodlandsFactory() {
        factories.add(TreeFactory.getInstance());
        factories.add(GrassFactory.getInstance());
        factories.add(StoneFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new Woodlands();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
