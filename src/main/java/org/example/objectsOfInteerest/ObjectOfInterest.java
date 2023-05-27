package org.example.objectsOfInteerest;

import org.apache.commons.lang3.StringUtils;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean hasTree() {

        for (ComponentObjectOfInterest block : blocks) {
            if(block.hasTree()) return true;
        }
        return false;
    }

    public void cutTree(){
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
    public void buildFire() throws Exception {
        if(!isSettlement()) addFire();
        else throw new Exception("В населенных пунктах костер разводить нельзя!");
    }
    @Override
    public boolean isSettlement() {
        for (ComponentObjectOfInterest block : blocks) {
            if(block.isSettlement()) return true;
        }
        return false;
    }
    private void addFire() throws Exception {
        if (hasFire()) createFire();
        else blocks.add(new Fire(1));
    }
    @Override
    public boolean hasFire() {
        for (ComponentObjectOfInterest block : blocks) {
            if(block.hasFire()) return true;
        }
        return false;
    }
    private void createFire() throws Exception {
        for (ComponentObjectOfInterest block : blocks) {
            block.buildFire();
        }
    }

    @Override
    public String getInfo2Table() {
        String info = "";
        for (Block block : blocks) {
            info+= block.getInfo2Table();
        }
        info = StringUtils.removeEnd(info, ", ");
        return info;
    }
}
