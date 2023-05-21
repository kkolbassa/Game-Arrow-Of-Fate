package org.example.blocks;

public class Flower extends CountableBlock{
    public Flower(int count) {
        super(count);
        this.name = "Цветок";
    }
    public Flower(int count, String name) {
        super(count);
        this.name = name;
    }

}
