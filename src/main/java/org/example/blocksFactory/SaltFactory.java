package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Salt;

public class SaltFactory extends CountableBlockFactory{
    private static BlockFactory instance;
    public static SaltFactory getInstance() {
        if (instance == null) {
            instance = new SaltFactory();
        }
        return (SaltFactory) instance;
    }
    @Override
    public Block create() {
        return new Salt(1);
    }

    @Override
    public Block create(int count) {
        return new Salt(count);
    }
}
