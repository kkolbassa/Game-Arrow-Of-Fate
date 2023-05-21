package org.example;

import org.example.objectsOfInteerest.ObjectOfInterest;

public class Player {
    public void cutTree(ObjectOfInterest objectOfInterest){
        if(objectOfInterest.hasTree()) objectOfInterest.cutTree();
    }
    public void buildHouse(ObjectOfInterest objectOfInterest){
        objectOfInterest.buildHouse();
    }
    public void buildFire(ObjectOfInterest objectOfInterest){
        objectOfInterest.buildFire();
    }
}
