package org.example.editors;

import org.example.regions.Region;

import javax.swing.*;
import java.util.ArrayList;

public class TextEditorMap {
    private JList jListMap;

    public TextEditorMap(JList jListMap) {
        this.jListMap = jListMap;
        jListMap.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jListMap.setCellRenderer(new BoldListRenderer());
    }

    public void setModelMap(ArrayList<Region> regions, Region currentRegion) {
        DefaultListModel model = new DefaultListModel();

        for(int i = 0; i< regions.size();i++){
            if(currentRegion.equals(regions.get(i))) {
                jListMap.setSelectionInterval(i,i);
                model.addElement("<html><b>" +(i+1)+". "+regions.get(i).getName() + "</b></html>");
            }else model.add(regions.indexOf(regions.get(i)), (i+1)+". "+regions.get(i).getName());
        }
        jListMap.setModel(model);
    }
}
