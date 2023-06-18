package org.example.items;

public abstract class CountableItem extends Item{
    private int count;
    public CountableItem(String name, int count) {
        super(name);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count = count+1;
    }
    public void decreaseCount(int count){
        this.count = this.count - count;
    }

    @Override
    public boolean countable() {
        return true;
    }
}
