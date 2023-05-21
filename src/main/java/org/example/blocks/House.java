package org.example.blocks;

public class House extends CountableBlock{
    public House(int count) {
        super(count);
        this.name = "Дом";
    }
    public House(int count, String name) {
        super(count);
        this.name = name;
    }

    @Override
    public void buildHouse() {
        setCount(getCount()+1);
    }

    @Override
    public boolean hasHouse() {
        return true;
    }
}
