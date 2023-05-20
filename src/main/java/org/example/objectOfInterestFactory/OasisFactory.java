package org.example.objectOfInterestFactory;

import org.example.blocksFactory.*;
import org.example.objectsOfInteerest.Oasis;
import org.example.objectsOfInteerest.ObjectOfInterest;

public class OasisFactory extends ObjectOfInterestFactory{
    private static ObjectOfInterestFactory instance;
    public static OasisFactory getInstance() {
        if (instance == null) {
            instance = new OasisFactory();
        }
        return (OasisFactory) instance;
    }

    public OasisFactory() {
        factories.add(TreeFactory.getInstance());
        factories.add(WaterFactory.getInstance());
        factories.add(GrassFactory.getInstance());
    }

    @Override
    public ObjectOfInterest create() {
        ObjectOfInterest objectOfInterest = new Oasis();
        fillObjectOfInterest(objectOfInterest);
        return objectOfInterest;
    }
}
