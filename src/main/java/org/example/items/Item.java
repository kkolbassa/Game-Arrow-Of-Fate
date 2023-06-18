package org.example.items;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getFullName(){
        return getName();
    }
    public boolean countable(){
        return false;
    }
}
