package org.example.editors;

import javax.swing.*;
import java.awt.*;

public class BoldListRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value != null && value.toString().startsWith("<html><b>") && value.toString().endsWith("</b></html>")) {
            Font font = label.getFont();
            label.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        }

        return label;
    }
}
