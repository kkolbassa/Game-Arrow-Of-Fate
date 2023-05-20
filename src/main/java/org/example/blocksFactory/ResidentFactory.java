package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Resident;

public class ResidentFactory extends CountableBlockFactory{
    private static BlockFactory instance;
    public static ResidentFactory getInstance() {
        if (instance == null) {
            instance = new ResidentFactory();
        }
        return (ResidentFactory) instance;
    }
    @Override
    public Block create() {
        return new Resident(1);
    }

    @Override
    public Block create(int count) {
        return new Resident(count);
    }
}
