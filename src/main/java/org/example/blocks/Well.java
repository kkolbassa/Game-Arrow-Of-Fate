package org.example.blocks;

public class Well extends CountableBlock{
    public Well(int count) {
        super(count);
        this.name = "Колодец";
    }

    @Override
    public boolean hasWell() {
        return true;
    }

    @Override
    public void buildWell() throws Exception {
        setCount(getCount()+1);
    }
}
