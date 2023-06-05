package org.example.objectOfInterestFactory;

import org.example.blocksFactory.*;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.objectsOfInterest.PyramidRuin;

public class PyramidRuinFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static PyramidRuinFactory getInstance() {
        if (instance == null) {
            instance = new PyramidRuinFactory();
        }
        return (PyramidRuinFactory) instance;
    }

    public PyramidRuinFactory() {
        factories.add(SandFactory.getInstance());
        factories.add(StoneFactory.getInstance());
        factories.add(TreasureFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new PyramidRuin();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
