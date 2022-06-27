package com.example.project;

import javax.swing.*;

public class TreeSecond {

    private JPanel jpanel = new JPanel();
    private JTree tree;
    private String[][] options;

    public TreeSecond(String vals[][]) {
        super();
        options = vals;
        tree = new JTree(options);
        jpanel.add(tree);

    }

    public JPanel getJPanel() {
        return jpanel;
    }

}
