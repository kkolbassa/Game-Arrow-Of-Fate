package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Ice;

public class IceFactory extends BlockFactory{
    private static BlockFactory instance;
    public static IceFactory getInstance() {
        if (instance == null) {
            instance = new IceFactory();
        }
        return (IceFactory) instance;
    }
    @Override
    public Block create() {
        return new Ice();
    }
}
