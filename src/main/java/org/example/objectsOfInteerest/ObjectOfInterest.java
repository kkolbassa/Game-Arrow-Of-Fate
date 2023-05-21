package org.example.objectsOfInteerest;

import org.example.ComponentObjectOfInterest;
import org.example.ComponentRegion;
import org.example.blocks.Block;
import org.example.blocks.Fire;
import org.example.blocks.House;
import org.example.blocks.Tree;

import java.util.ArrayList;

public abstract class ObjectOfInterest implements ComponentRegion, ComponentObjectOfInterest {
    private ArrayList<Block> blocks;
    protected String name;

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }
    @Override
    public boolean hasTree() {

        for (ComponentRegion block : blocks) {
            if(block.hasTree()) return true;
        }
        return false;
    }

    public void cutTree() {
        for (ComponentObjectOfInterest block : blocks) {
            block.cutTree();
        }
    }

    @Override
    public void buildHouse() {
        if(hasHouse()) {
            for (ComponentObjectOfInterest block : blocks) {
                block.buildHouse();
            }
        }else blocks.add(new House(1));
    }

    @Override
    public boolean hasHouse() {
        for (ComponentObjectOfInterest block : blocks) {
            if(block.hasHouse()) return true;
        }
        return false;
    }

    @Override
    public boolean isSettlement() {
        for (ComponentObjectOfInterest block : blocks) {
            if(block.isSettlement()) return true;
        }
        return false;
    }

    @Override
    public void buildFire() {
        if(!isSettlement()) addFire();
    }

    private void addFire() {
        if(Math.random()>0.01) {
            if (hasFire()) createFire();
            else blocks.add(new Fire(1));
        } else blocks = null;
    }

    private void createFire() {
        for (ComponentObjectOfInterest block : blocks) {
            block.buildFire();
        }
    }

    @Override
    public boolean hasFire() {
        for (ComponentObjectOfInterest block : blocks) {
            if(block.hasFire()) return true;
        }
        return false;
    }
}
