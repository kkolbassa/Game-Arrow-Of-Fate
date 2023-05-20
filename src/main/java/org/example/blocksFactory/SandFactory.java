package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Sand;

public class SandFactory extends BlockFactory{
    private static BlockFactory instance;
    public static SandFactory getInstance() {
        if (instance == null) {
            instance = new SandFactory();
        }
        return (SandFactory) instance;
    }
    @Override
    public Block create() {
        return new Sand();
    }
}
