package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Stone;

public class StoneFactory extends CountableBlockFactory{
    private static BlockFactory instance;
    public static StoneFactory getInstance() {
        if (instance == null) {
            instance = new StoneFactory();
        }
        return (StoneFactory) instance;
    }
    @Override
    public Block create() {
        return new Stone(1);
    }

    @Override
    public Block create(int count) {
        return new Stone(count);
    }
}
