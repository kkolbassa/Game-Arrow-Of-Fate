package org.example.editors;

import org.example.storages.StoryData;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class TextEditorStory {
    private JTextArea beginStory;
    private JTextArea endStory;
    private StoryData storyData = StoryData.getInstance();
    public TextEditorStory(JTextArea beginStory, JTextArea endStory) {
        this.beginStory = beginStory;
        this.endStory = endStory;
        beginStory.setText("");
        endStory.setText("");
    }
    public void setText(){
        setStyle();
        setBeginning();
        setEnd();
    }

    private void setStyle() {

        beginStory.setLineWrap(true);
        beginStory.setWrapStyleWord(true);
        beginStory.setFont(new java.awt.Font("Segoe UI", 0, 18));
        beginStory.setOpaque(false);
        beginStory.setBackground(new java.awt.Color(0, 0, 0, 0));

        endStory.setLineWrap(true);
        endStory.setWrapStyleWord(true);
        endStory.setFont(new java.awt.Font("Segoe UI", 0, 18));
        endStory.setOpaque(false);
        endStory.setBackground(new java.awt.Color(0, 0, 0, 0));

        beginStory.setBorder(new LineBorder(new java.awt.Color(234, 114, 246), 4));
        endStory.setBorder(new LineBorder(new java.awt.Color(234, 114, 246), 4));
    }

    private void setBeginning() {
        for (String story: storyData.getBeginStory()) {
            beginStory.append("      "+story+"\n");
        }
    }

    private void setEnd() {
        for (String story: storyData.getEndStory()) {
            endStory.append("      "+story+"\n");
        }
    }
}
