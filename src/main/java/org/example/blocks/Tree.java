package org.example.blocks;

public class Tree extends CountableBlock{
    public Tree(int count) {
        super(count);
        this.name = "Дерево";
    }
    public Tree(int count, String name) {
        super(count);
        this.name = name;
    }
    @Override
    public boolean hasTree() {
        if(getCount()!=0) return true;
        else return false;
    }

    @Override
    public void cutTree() {
        setCount(getCount()-1);
    }

}
