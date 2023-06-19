package org.example;

import org.example.actions.*;
import org.example.items.Item;
import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.regions.Region;
import org.example.storages.ItemsStorage;

import java.util.ArrayList;

public class Player {
    private ItemsStorage itemsStorage = new ItemsStorage();
    private ArrayList<Action> actions = new ArrayList<>();
    public ArrayList<Item> getItems(){
        return itemsStorage.getItems();
    }

    public ItemsStorage getItemsStorage() {
        return itemsStorage;
    }
    public void doAction(Region currentRegion, int chooseObject, Action action) throws Exception {
        checkChooseObject(chooseObject);
        ObjectOfInterest objectOfInterest = currentRegion.getObjectOfInterest(chooseObject);
        actions.add(action);
        action.complete(currentRegion,objectOfInterest,getItemsStorage());
    }
    private void checkChooseObject(int chooseObject) throws Exception {
        if(chooseObject<0) throw new Exception("Объект интереса не выбран");
    }
}
