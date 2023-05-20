package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Mushroom;

public class MushroomFactory extends CountableBlockFactory{
    private static BlockFactory instance;
    public static MushroomFactory getInstance() {
        if (instance == null) {
            instance = new MushroomFactory();
        }
        return (MushroomFactory) instance;
    }
    @Override
    public Block create() {
        return new Mushroom(1);
    }

    @Override
    public Block create(int count) {
        return new Mushroom(count);
    }
}
