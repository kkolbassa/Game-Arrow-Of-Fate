package org.example.blocks;

public class Stone extends CountableBlock{
    public Stone(int count) {
        super(count);
        this.name = "Камень";
    }
    public Stone(int count, String name) {
        super(count);
        this.name = name;
    }
    @Override
    public void getInfo() {


    }
}
