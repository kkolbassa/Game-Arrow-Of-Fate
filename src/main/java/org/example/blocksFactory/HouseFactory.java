package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.House;

public class HouseFactory extends CountableBlockFactory{
    private static BlockFactory instance;
    public static HouseFactory getInstance() {
        if (instance == null) {
            instance = new HouseFactory();
        }
        return (HouseFactory) instance;
    }
    @Override
    public Block create() {
        return new House(1);
    }

    @Override
    public Block create(int count) {
        return new House(count);
    }
}
