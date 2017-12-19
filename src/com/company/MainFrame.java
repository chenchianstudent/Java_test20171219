package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private Container cp;
    private JPanel jpdraw = new JPanel();
    private JPanel jpitem = new JPanel(new GridLayout(5, 1, 1, 1));
    private JButton bt1 = new JButton("drawREC");
    private JButton bt2 = new JButton("drawLIN");
    private JButton bt3 = new JButton("drawOVI");
    private JButton bt4 = new JButton("Exit");
    private JButton bt0 = new JButton("Draw");
    private int startx, starty, endx, endy, objw, objh, type = 1;

    public MainFrame() {
        init();
    }

    private void init() {
        this.setBounds(100, 100, 500, 500);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(5, 5));
        cp.add(jpitem, BorderLayout.WEST);
        cp.add(jpdraw, BorderLayout.CENTER);
        jpitem.add(bt0);
        jpitem.add(bt1);
        jpitem.add(bt2);
        jpitem.add(bt3);
        jpitem.add(bt4);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        bt0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = jpdraw.getGraphics();
                paint(g);
            }
        });
        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 1;
            }
        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 2;
            }
        });
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 3;
            }
        });
        jpdraw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                startx = e.getX();
                starty = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endx = e.getX();
                endy = e.getY();
                paint(jpdraw.getGraphics());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
    }

    public void paint(Graphics g1) {
        objw = endx - startx;
        objh = endx = starty;
        switch (type) {
            case 1:
                g1.drawRect(startx, starty, objw, objh);
                break;
            case 2:
                g1.drawLine(startx, starty, endx, endy);
                break;
            case 3:
                g1.drawOval(startx, starty, objw, objh);
                break;
        }
    }
}
