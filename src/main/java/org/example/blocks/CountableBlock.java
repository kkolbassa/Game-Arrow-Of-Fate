package org.example.blocks;

public abstract class CountableBlock extends Block{
    private int count;

    public CountableBlock(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
