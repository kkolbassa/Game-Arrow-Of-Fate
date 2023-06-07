package org.example.editors;

import org.example.Player;
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
            model.add(items.indexOf(items.get(i)), (i+1)+". "+items.get(i).getName());
        }

        bag.setModel(model);
    }
}
