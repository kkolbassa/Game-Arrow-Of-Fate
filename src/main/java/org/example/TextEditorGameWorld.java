package org.example;

import org.example.regions.Region;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.LinkedHashMap;

public class TextEditorGameWorld {
    private JLabel jLabelCurrentRegion;
    private JTable jTableCurrentRegion;
    private ImagesEditor imagesEditor;
    private TextEditorMission textEditorMission;
    private Region currentRegion = new Region() {};
    public TextEditorGameWorld(JLabel jLabelCurrentRegion, JTable jTableCurrentRegion, ImagePanel imagePanel) {
        this.jLabelCurrentRegion = jLabelCurrentRegion;
        this.jTableCurrentRegion = jTableCurrentRegion;
        imagesEditor = new ImagesEditor(imagePanel);
    }
    public void createTextEditorMission(JTextArea description, JLabel task, JLabel progress, JLabel jLabelMissionComplete){
        textEditorMission = new TextEditorMission(description,task,progress,jLabelMissionComplete);
    }
    public void updateCurrentRegion() {
        textEditorMission.updateMission(currentRegion.getMission());
        updatePartInfo();
    }
    public void updateCurrentRegion(Region currentRegion) {
        clean();
        updateFullInfo(currentRegion);
        textEditorMission.updateMission(currentRegion.getMission());
    }

    private void updateFullInfo(Region currentRegion) {
        this.currentRegion =currentRegion;
        updateRegionName(currentRegion.getName());
        updateTableObjects(currentRegion.getInfo2Table());
        createImagesInfo();
    }

    private void updatePartInfo() {
        updateTableObjects(currentRegion.getInfo2Table());
        if(currentRegion.isObjectsChanged()) updateImagesInfo();
    }

    private void createImagesInfo() {
        imagesEditor.createImageRegion(currentRegion, jTableCurrentRegion);
    }
    private void updateImagesInfo() {
        imagesEditor.updateImagesInfo(currentRegion,jTableCurrentRegion);
    }

    private void updateRegionName(String name) {
        jLabelCurrentRegion.setText(name);
    }

    private void updateTableObjects(LinkedHashMap<String, String> currentRegion) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Запрещаем редактирование всех ячеек
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
        column.setPreferredWidth(500);  // Устанавливаем ширину колонки

    }

    public void clean() {
        this.currentRegion = new Region() {};
        imagesEditor.clean();
    }
}
