package org.example.items;

public class Wood extends CountableItem{

    public Wood(int count) {
        super("Бревно", count);
    }

    @Override
    public String getFullName() {
        return super.getName()+" "+ getCount()+" шт.";
    }
}
