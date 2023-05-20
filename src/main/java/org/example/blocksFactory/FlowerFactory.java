package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Flower;

public class FlowerFactory extends CountableBlockFactory{
    private static BlockFactory instance;
    public static FlowerFactory getInstance() {
        if (instance == null) {
            instance = new FlowerFactory();
        }
        return (FlowerFactory) instance;
    }
    @Override
    public Block create() {
        return new Flower(1);
    }

    @Override
    public Block create(int count) {
        return new Flower(count);
    }
}
