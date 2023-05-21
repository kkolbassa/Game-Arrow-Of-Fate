package org.example.blocks;


public class Resident extends CountableBlock{
    public Resident(int count) {
        super(count);
        this.name = "Житель";
    }
    public Resident(int count, String name) {
        super(count);
        this.name = name;
    }

    @Override
    public boolean isSettlement() {
        if(getCount()>0)return true;
        else return false;
    }
}
