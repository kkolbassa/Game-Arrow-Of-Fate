package org.example;

import org.example.regions.Region;

import javax.swing.*;
import java.util.ArrayList;

public class TextEditorMap {
    private JList jListMap;

    public TextEditorMap(JList jListMap) {
        this.jListMap = jListMap;
    }

    public void setModelMap(ArrayList<Region> regions) {
        DefaultListModel model = new DefaultListModel();

        regions.forEach(region -> {
            model.add(regions.indexOf(region), region.getName());
        });
        jListMap.setModel(model);
    }
}
