package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUII {
    private JButton draw0Button;
    private JPanel panel1;
    private JComboBox objectSelector;
    private JComboBox styleSelector;
    private JPanel image;

    private Graphics2D canvas;

    private int[] commandToDraw;
    private MStiley drawing;

    private GUII() {
        commandToDraw = new int[2];
        commandToDraw[0]=0;
        commandToDraw[1]=0;

        canvas = (Graphics2D) image.getGraphics();

        draw0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (commandToDraw[0] == 0) {
                    drawing = new Minimalism();
                } else if (commandToDraw[0] == 1) {
                    drawing = new Cubism();
                }
                if (commandToDraw[1] == 0) {
                    canvas.draw(drawing.drawSpruce());
                } else if (commandToDraw[1] == 1) {
                    drawing.drawBuilding();
                }
                canvas.draw(drawing.figure);
            }
        });
        objectSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandToDraw[1] = objectSelector.getSelectedIndex();
            }
        });
        styleSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandToDraw[0] = styleSelector.getSelectedIndex();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUII");
        frame.setContentPane(new GUII().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
