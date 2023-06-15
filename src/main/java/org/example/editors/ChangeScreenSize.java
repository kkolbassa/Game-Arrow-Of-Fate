package org.example.editors;

import javax.swing.*;
import java.awt.*;

public class ChangeScreenSize {

    public static void setLocation(JFrame frame){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int x = (screenWidth - frame.getWidth()) / 2;
        int y = (screenHeight - frame.getHeight()) / 2;

        frame.setLocation(x, y);
    }
    public static void setLocation(JDialog dialog){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int x = (screenWidth - dialog.getWidth()) / 2;
        int y = (screenHeight - dialog.getHeight()) / 2;

        dialog.setLocation(x, y);
    }
}
