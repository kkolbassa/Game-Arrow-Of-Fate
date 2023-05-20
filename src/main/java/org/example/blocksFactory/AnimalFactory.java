package org.example.blocksFactory;

import org.example.blocks.Animal;
import org.example.blocks.Block;
import org.example.objectOfInterestFactory.DeerCampFactory;

public class AnimalFactory extends CountableBlockFactory{
    private static BlockFactory instance;
    public static AnimalFactory getInstance() {
        if (instance == null) {
            instance = new AnimalFactory();
        }
        return (AnimalFactory) instance;
    }
    @Override
    public Block create() {
        return new Animal(1);
    }

    @Override
    public Block create(int count) {
        return new Animal(count);
    }
}
