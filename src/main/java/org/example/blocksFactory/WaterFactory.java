package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Water;

public class WaterFactory extends BlockFactory{
    private static BlockFactory instance;
    public static WaterFactory getInstance() {
        if (instance == null) {
            instance = new WaterFactory();
        }
        return (WaterFactory) instance;
    }
    @Override
    public Block create() {
        return new Water();
    }
}
