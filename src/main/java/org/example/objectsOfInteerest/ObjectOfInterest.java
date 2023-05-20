package org.example.objectsOfInteerest;

import org.example.Component;
import org.example.blocks.Block;

import java.util.ArrayList;

public abstract class ObjectOfInterest implements Component {
    private ArrayList<Block> blocks;
    protected String name;

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public void getInfo() {

        for (Component block : blocks) {
            block.getInfo();
        }
    }
}
