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

    public void woodToFire() throws Exception {
        if(getWood()== null||getWood().getCount()<1) throw new Exception("Недостаточно бревен для розжига (надо 1 шт.)");
        else getWood().decreaseCount(1);
    }

    public void woodToHouse() throws Exception {
        if(getWood()== null||getWood().getCount()<10) throw new Exception("Недостаточно бревен для дома (надо 10 шт.)");
        else getWood().decreaseCount(10);
    }
    public void woodToWell() throws Exception {
        if(getWood()== null||getWood().getCount()<5) throw new Exception("Недостаточно бревен для колодца (надо 5 шт.)");
        else getWood().decreaseCount(5);
    }

    public void checkWood(int woodToAction) throws Exception {
        if(getWood()== null||getWood().getCount()<woodToAction) throw new Exception("Недостаточно бревен для действия (надо "+woodToAction+ " шт.)");
    }

    public void decreaseWood(int woodToAction) {
        getWood().decreaseCount(woodToAction);
    }
}
