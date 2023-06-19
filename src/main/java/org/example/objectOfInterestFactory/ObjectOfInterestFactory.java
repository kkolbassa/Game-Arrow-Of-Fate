package org.example.objectOfInterestFactory;

import org.example.blocks.Block;
import org.example.blocksFactory.BlockFactory;
import org.example.blocksFactory.CountableBlockFactory;
import org.example.objectsOfInterest.ObjectOfInterest;

import java.util.ArrayList;

public abstract class ObjectOfInterestFactory {
    protected ArrayList<BlockFactory> factories = new ArrayList<>();
    public void fillObjectOfInterest(ObjectOfInterest objectOfInterest) {
        ArrayList<Block> blocks = new ArrayList<>();
        int countBlock = 20;

        factories.forEach(factory -> {
            if(factory instanceof CountableBlockFactory){
                int count = 1 + (int) (Math.random()*countBlock);
                CountableBlockFactory countableFactory = (CountableBlockFactory)factory;
                blocks.add(countableFactory.create(count));
            }else blocks.add(factory.create());
        });
        objectOfInterest.setBlocks(blocks);
    }
    public abstract ObjectOfInterest create();
}
