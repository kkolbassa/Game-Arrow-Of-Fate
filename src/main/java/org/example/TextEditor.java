package org.example;

import org.example.regions.Region;

import javax.swing.*;

public class TextEditor {
    private JLabel jLabelCurrentRegion;
    private JLabel jLabelImageCurrentRegion;
    private JTable jTableCurrentRegion;
    private JList<String> jListMap;
    public TextEditor(JLabel jLabelCurrentRegion, JLabel jLabelImageCurrentRegion, JTable jTableCurrentRegion, JList<String> jListMap) {
        this.jLabelCurrentRegion = jLabelCurrentRegion;
        this.jLabelImageCurrentRegion = jLabelImageCurrentRegion;
        this.jTableCurrentRegion = jTableCurrentRegion;
        this.jListMap = jListMap;
    }

    public void updateCurrentRegion(Region currentRegion) {
        jLabelCurrentRegion.setText(currentRegion.getName());
    }
}
