package org.example.blocks;

public class Animal extends CountableBlock{

    public Animal(int count) {
        super(count);
        this.name = "Животоное";
    }
    public Animal(int count, String name) {
        super(count);
        this.name = name;
    }

}
