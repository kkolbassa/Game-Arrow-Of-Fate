package org.example.blocks;

public class Water extends Block{
    public Water() {
        this.name ="Вода";
    }

    @Override
    public boolean hasWater() {
        return true;
    }
}
