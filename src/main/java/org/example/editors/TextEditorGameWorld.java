package org.example.editors;

import org.example.Player;
import org.example.regions.Region;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TextEditorGameWorld {
    private JLabel jLabelCurrentRegion;
    private JTable jTableCurrentRegion;
    private ImagesEditor imagesEditor;
    private TextEditorMission textEditorMission;
    private TextEditorMap textEditorMap;
    private TextEditorBag textEditorBag;
    private TextEditorStory textEditorStory;
    private Region currentRegion = new Region() {};
    public TextEditorGameWorld(JLabel jLabelCurrentRegion, JTable jTableCurrentRegion, ImagePanel imagePanel) {
        this.jLabelCurrentRegion = jLabelCurrentRegion;
        this.jTableCurrentRegion = jTableCurrentRegion;
        jTableCurrentRegion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        imagesEditor = new ImagesEditor(imagePanel);
    }
    public void createTextEditorMission(JTextArea description, JLabel task, JLabel progress, JLabel jLabelMissionComplete, JButton jButtonFinishGame){
        textEditorMission = new TextEditorMission(description,task,progress,jLabelMissionComplete, jButtonFinishGame);
    }
    public void createTextEditorMap(JList jListMap){
        textEditorMap = new TextEditorMap(jListMap);
    }
    public void createTextEditorBag(JList jListItems) {
        textEditorBag = new TextEditorBag(jListItems);
    }
    public void createTextEditorStory(JTextArea jTextAreaBeginStory, JTextArea jTextAreaEndStory) {
        textEditorStory = new TextEditorStory(jTextAreaBeginStory,jTextAreaEndStory);
    }
    public void updateCurrentRegion() {
        textEditorMission.updateMission(currentRegion.getMission());
        updatePartInfo();
    }
    private void updatePartInfo() {
        updateTableObjects(currentRegion.getInfo2Table());
        if(currentRegion.isObjectsChanged()) updateImagesInfo();
    }
    private void updateTableObjects(LinkedHashMap<String, String> currentRegion) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTableCurrentRegion.setRowHeight(31);

        model.addColumn("Объкт интереса");
        model.addColumn("Параметры");

        currentRegion.forEach((key, value) -> {
            model.addRow(new Object[]{key, value});
        });
        jTableCurrentRegion.setModel(model);

        TableColumn column = jTableCurrentRegion.getColumnModel().getColumn(1);
        column.setPreferredWidth(500);

    }
    private void updateImagesInfo() {
        imagesEditor.updateImagesInfo(currentRegion,jTableCurrentRegion);
    }

    public void updateCurrentRegion(Region currentRegion) {
        clean();
        updateFullInfo(currentRegion);
        textEditorMission.updateMission(currentRegion.getMission());
    }
    public void clean() {
        this.currentRegion = new Region() {};
        imagesEditor.clean();
    }
    private void updateFullInfo(Region currentRegion) {
        this.currentRegion =currentRegion;
        updateRegionName(currentRegion.getName());
        updateTableObjects(currentRegion.getInfo2Table());
        createImagesInfo();
    }
    public void updateCurrentRegion(Region currentRegion, ArrayList<Region> regions) {
        textEditorMission.setSignificantMissions(regions);
        updateCurrentRegion(currentRegion);
    }

    private void createImagesInfo() {
        imagesEditor.createImageRegion(currentRegion, jTableCurrentRegion);
    }
    private void updateRegionName(String name) {
        jLabelCurrentRegion.setText(name);
    }

    public void setModeMap(ArrayList<Region> regions, Region currentRegion) {
        textEditorMap.setModelMap(regions,currentRegion);
    }

    public void setModeBag(Player player) {
        textEditorBag.setModelMap(player);
    }

    public void setStoryText() {
        textEditorStory.setText();
    }
}
