package org.example.blocks;

import org.example.ComponentObjectOfInterest;
import org.example.ComponentRegion;

public abstract class Block implements ComponentRegion, ComponentObjectOfInterest {
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
}
