package org.example.blocksFactory;

import org.example.blocks.Block;

public abstract class CountableBlockFactory extends BlockFactory{
    public abstract Block create(int count);
}
