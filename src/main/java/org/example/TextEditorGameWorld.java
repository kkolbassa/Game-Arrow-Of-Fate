package org.example;

import org.example.regions.Region;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedHashMap;

public class TextEditorGameWorld {
    private JLabel jLabelCurrentRegion;
    private JLabel jLabelImageCurrentRegion;
    private JTable jTableCurrentRegion;
    public TextEditorGameWorld(JLabel jLabelCurrentRegion, JLabel jLabelImageCurrentRegion, JTable jTableCurrentRegion) {
        this.jLabelCurrentRegion = jLabelCurrentRegion;
        this.jLabelImageCurrentRegion = jLabelImageCurrentRegion;
        this.jTableCurrentRegion = jTableCurrentRegion;
    }

    public void updateCurrentRegion(Region currentRegion) {
        updateRegionName(currentRegion.getName());
        updateTableObjects(currentRegion.getInfo2Table());
    }

    private void updateRegionName(String name) {
        jLabelCurrentRegion.setText(name);
    }

    private void updateTableObjects(LinkedHashMap<String, String> currentRegion) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Объкт интереса");
        model.addColumn("Параметры");

        currentRegion.forEach((key, value) -> {
            model.addRow(new Object[]{key, value});
        });
        jTableCurrentRegion.setModel(model);
    }
}
