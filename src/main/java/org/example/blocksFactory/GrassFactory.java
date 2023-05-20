package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Grass;

public class GrassFactory extends BlockFactory {
    private static BlockFactory instance;
    public static GrassFactory getInstance() {
        if (instance == null) {
            instance = new GrassFactory();
        }
        return (GrassFactory) instance;
    }
    @Override
    public Block create() {
        return new Grass();
    }
}
