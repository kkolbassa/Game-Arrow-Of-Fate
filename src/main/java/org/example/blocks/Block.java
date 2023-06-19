package org.example.blocks;

import org.example.ComponentObjectOfInterest;

public abstract class Block implements ComponentObjectOfInterest {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getInfo2Table() {
        return getName()+", ";
    }

    @Override
    public boolean hasTree() {
        return false;
    }

    @Override
    public void cutTree() {
    }

    @Override
    public boolean hasHouse() {
        return false;
    }
    @Override
    public void buildHouse() {
    }

    @Override
    public boolean isSettlement() {
        return false;
    }

    @Override
    public boolean hasFire() {
        return false;
    }

    @Override
    public void buildFire() {
    }

    @Override
    public boolean stampExist() {
        return false;
    }

    @Override
    public void createStamp() {
    }

    @Override
    public boolean hasWater() {
        return false;
    }

    @Override
    public boolean hasWell() {
        return false;
    }

    @Override
    public void buildWell() throws Exception {
    }

    @Override
    public void createTree() {

    }
}
