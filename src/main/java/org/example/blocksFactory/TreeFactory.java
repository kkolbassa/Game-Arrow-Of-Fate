package org.example.blocksFactory;

import org.example.blocks.Block;
import org.example.blocks.Tree;

public class TreeFactory extends CountableBlockFactory{
    private static BlockFactory instance;
    public static TreeFactory getInstance() {
        if (instance == null) {
            instance = new TreeFactory();
        }
        return (TreeFactory) instance;
    }
    @Override
    public Block create() {
        return new Tree(1);
    }

    @Override
    public Block create(int count) {
        return new Tree(count);
    }
}
