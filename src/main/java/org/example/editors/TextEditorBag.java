package org.example.editors;

import org.example.Player;
import org.example.items.CountableItem;
import org.example.items.Item;

import javax.swing.*;
import java.util.ArrayList;

public class TextEditorBag {
    private JList bag;

    public TextEditorBag(JList bag) {
        this.bag = bag;
        bag.setFont(new java.awt.Font("Segoe UI", 0, 18));
    }

    public void setModelMap(Player player) {
        DefaultListModel model = new DefaultListModel();
        ArrayList<Item> items = player.getItems();

        for(int i = 0; i< items.size();i++){
            if(!items.get(i).countable()) model.addElement(items.get(i).getFullName());
            else if(countPositive(items.get(i))) model.addElement(items.get(i).getFullName());
        }

        bag.setModel(model);
    }

    private boolean countPositive (Item item) {
        CountableItem countableItem = (CountableItem) item;
        return  countableItem.getCount()>0;
    }
}
