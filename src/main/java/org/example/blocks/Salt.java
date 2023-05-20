package org.example.blocks;

public class Salt extends CountableBlock{
    public Salt(int count) {
        super(count);
        this.name = "Соль";
    }
    public Salt(int count, String name) {
        super(count);
        this.name = name;
    }

    @Override
    public void getInfo() {

    }
}
