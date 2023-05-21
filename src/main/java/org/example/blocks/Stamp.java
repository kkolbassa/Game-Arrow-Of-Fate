package org.example.blocks;

public class Stamp extends CountableBlock{
    public Stamp(int count) {
        super(count);
        this.name = "Пень";
    }
    public Stamp(int count, String name) {
        super(count);
        this.name = name;
    }
}
