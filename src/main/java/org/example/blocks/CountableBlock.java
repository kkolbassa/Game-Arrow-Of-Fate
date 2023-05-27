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

    @Override
    public String getInfo2Table() {
        String info = getName();
        if(count>0) info+= " "+ count+" шт, ";
        else info = "";
        return info;
    }
}
