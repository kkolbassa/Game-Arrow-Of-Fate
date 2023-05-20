package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Treasure;

public class TreasureFactory extends BlockFactory{
    private static BlockFactory instance;
    public static TreasureFactory getInstance() {
        if (instance == null) {
            instance = new TreasureFactory();
        }
        return (TreasureFactory) instance;
    }
    @Override
    public Block create() {
        return new Treasure();
    }
}
