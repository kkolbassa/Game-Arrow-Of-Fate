package org.example.blocks;

public class Mushroom extends CountableBlock{
    public Mushroom(int count) {
        super(count);
        this.name = "Гриб";
    }
    public Mushroom(int count, String name) {
        super(count);
        this.name = name;
    }
    @Override
    public void getInfo() {

    }
}
