package org.example.storages;

import org.example.items.CountableItem;
import org.example.items.Item;
import org.example.items.Wood;

import java.util.ArrayList;

public class ItemsStorage {
    private ArrayList<Item> items = new ArrayList<>();
    public ArrayList<Item> getItems() {
        return items;
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void addWood() {
        CountableItem wood  = getWood();
        if(wood == null) items.add(new Wood(1));
        else wood.addCount();
    }
    private CountableItem getWood(){
        CountableItem wood  = (CountableItem) items.stream().filter(item -> item.getName() == "Бревно")
                .findFirst()
                .orElse(null);
        return wood;
    }

    public void checkWood(int woodToAction) throws Exception {
        if(getWood()== null||getWood().getCount()<woodToAction) throw new Exception("Недостаточно бревен для действия (надо "+woodToAction+ " шт.)");
    }

    public void decreaseWood(int woodToAction) {
        getWood().decreaseCount(woodToAction);
    }
}
