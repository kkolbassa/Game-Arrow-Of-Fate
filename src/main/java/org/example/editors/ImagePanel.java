package org.example.editors;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image backgroundImage;

    public void setBackgroundImage(ImageIcon imageIcon) {
        this.backgroundImage = imageIcon.getImage();
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Рисуем фоновую картинку
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}