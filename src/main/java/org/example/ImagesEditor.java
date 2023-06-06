package org.example;

import org.example.objectsOfInterest.ObjectOfInterest;
import org.example.regions.Region;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ImagesEditor {
    private ImagePanel panel;
    private ArrayList<JButton> buttonList = new ArrayList<>();
    private Region currentRegion;

    public ImagesEditor() {
    }

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

        for (int i = 0; i < countButton; i++) {
            JButton button = new JButton();
            button.setName(currentRegion.getObjectOfInterest(i).getName());
            fillButton(button,currentRegion.getObjectOfInterest(i),jTableCurrentRegion);
            buttonList.add(button);
        }

    }
    private void fillButton(JButton button, ObjectOfInterest objectOfInterest, JTable jTableCurrentRegion) {
        setButtonImage(button,objectOfInterest);
        setButtonAction(button,objectOfInterest, jTableCurrentRegion);
    }
    private void setButtonImage(JButton button, ObjectOfInterest objectOfInterest) {
        button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/"+objectOfInterest.getName()+".png")));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
    }
    private void setButtonsLocation() {
        // Создаем GroupLayout для панели
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        // Создаем горизонтальную группу
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        for (JButton button : buttonList) {
            hGroup.addComponent(button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
            hGroup.addGap(10); // Промежуток между кнопками

        }
        layout.setHorizontalGroup(hGroup);

        // Создаем вертикальную группу
        GroupLayout.ParallelGroup vGroup = layout.createParallelGroup();
        for (JButton button : buttonList) {
            vGroup.addComponent(button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        }
        layout.setVerticalGroup(vGroup);
    }

    private void setButtonAction(JButton button, ObjectOfInterest objectOfInterest, JTable jTableCurrentRegion){
        /*button.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Получаем размеры изображения
                ImageIcon icon = (ImageIcon) button.getIcon();
                Image image = icon.getImage();
                int imageWidth = image.getWidth(null);
                int imageHeight = image.getHeight(null);

                // Масштабируем кнопку, чтобы соответствовать размерам изображения с сохранением пропорций
                int buttonWidth = button.getWidth();
                int buttonHeight = (int) (buttonWidth * ((double) imageHeight / imageWidth));
                button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
            }
        });*/

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
                // Изменение внешнего вида кнопки при выходе курсора мыши
                button.setBorderPainted(false);
            }
        });
    }
    public void updateImagesInfo(Region currentRegion,JTable jTableCurrentRegion) {
        ObjectOfInterest changedObject = currentRegion.getRemovedObject();
        updateButtonsList(changedObject);
        this.currentRegion = currentRegion;
        updateButtonsAction(jTableCurrentRegion);
        panel.revalidate();
        panel.repaint();
        currentRegion.setObjectsChanged(false);

    }

    private void updateButtonsAction(JTable jTableCurrentRegion) {
        int countButton = currentRegion.getObjectsOfInterest().size();

        for (int i = 0; i < countButton; i++) {
            setButtonAction(buttonList.get(i),currentRegion.getObjectOfInterest(i),jTableCurrentRegion);
        }
    }

    private void updateButtonsList(ObjectOfInterest changedObject) {
        panel.remove(getButton(changedObject));  // Удаляем кнопку из панели
        buttonList.remove(getButton(changedObject));

    }

    private int getButton(ObjectOfInterest countObject) {
        int countButton = buttonList.size();

        for (int i = 0; i < countButton; i++) {
            if(buttonList.get(i).getName().equals(countObject.getName())) return i;
        }
        return -1;
    }

    public void clean() {
        panel.removeAll();
        buttonList.clear();
        currentRegion = null;
    }
}
