package org.example.editors;

import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.regions.Region;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ImagesEditor {
    private int countObjectOfInterest = 5;
    private ImagePanel panel;
    private ArrayList<JButton> buttonList = new ArrayList<>();
    private Region currentRegion;

    public ImagesEditor(ImagePanel panel) {
        this.panel = panel;
    }

    public void createImageRegion(Region currentRegion, JTable jTableCurrentRegion) {
        this.currentRegion = currentRegion;
        setBackgroundImage();
        addButtons(jTableCurrentRegion);
        setButtonsLocation();
    }

    private void setBackgroundImage(){
        String name = currentRegion.getName();
        panel.setBackgroundImage(new ImageIcon(getClass().getClassLoader().getResource("images/"+name+".png")));
    }
    private void addButtons(JTable jTableCurrentRegion){
        int countButton = currentRegion.getObjectsOfInterest().size();

        for (int i = 0; i < countObjectOfInterest; i++) {
            JButton button = new JButton();
            if (i< countButton) {
                button.setName(currentRegion.getObjectOfInterest(i).getName());
                fillButton(button, currentRegion.getObjectOfInterest(i), jTableCurrentRegion);
            }else{
                button.setName("Пустота");
                fillEmptyButton(button);
            }
            buttonList.add(button);
        }

    }

    private void fillEmptyButton(JButton button) {
        setButtonImage(button);
    }

    private void setButtonImage(JButton button) {
        button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/"+button.getName()+".png")));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
    }

    private void fillButton(JButton button, ObjectOfInterest objectOfInterest, JTable jTableCurrentRegion) {
        setButtonImage(button,objectOfInterest);
        setButtonAction(button,objectOfInterest, jTableCurrentRegion);
    }
    private void setButtonImage(JButton button, ObjectOfInterest objectOfInterest) {
        button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/"+currentRegion.getName()+objectOfInterest.getName()+".png")));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
    }
    private void setButtonsLocation() {
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        for (JButton button : buttonList) {
            hGroup.addComponent(button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
            if(buttonList.indexOf(button)!=(buttonList.size()-1)) hGroup.addGap(12); // Промежуток между кнопками

        }
        layout.setHorizontalGroup(hGroup);

        GroupLayout.ParallelGroup vGroup = layout.createParallelGroup();
        for (JButton button : buttonList) {
            vGroup.addComponent(button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        }
        layout.setVerticalGroup(vGroup);
    }

    private void setButtonAction(JButton button, ObjectOfInterest objectOfInterest, JTable jTableCurrentRegion){
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTableCurrentRegion.setRowSelectionInterval(currentRegion.getObjectsOfInterest().indexOf(objectOfInterest),currentRegion.getObjectsOfInterest().indexOf(objectOfInterest));
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBorderPainted(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBorderPainted(false);
            }
        });
    }
    public void updateImagesInfo(Region currentRegion,JTable jTableCurrentRegion) {
        clean();
        createImageRegion(currentRegion,jTableCurrentRegion);
    }

    public void clean() {
        panel.removeAll();
        buttonList.clear();
        currentRegion = null;
    }
}
