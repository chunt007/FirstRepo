package com.example.project;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreePanelThree {

    private JPanel jpanel = new JPanel();
    private JTree treeone;

    final String[]   categories = {"Featured Rooms"};
    final String[]   categories2 = {"Business & Finance"};
    final String[]   categories3 = {"Computers & Internet"};
    final String[][] categories4 = {{"Cultures & Community"}};
    final String[][] categories5 = {{"Entertainment & Arts"}};
    final String[]   categories6 = {"Family & Home"};
    final String[][] Categories3 = {{"Games"},{"Game Room: 1", "Game Room: 2", "Television"},{"International"}};
    final String[]   Categories4 = {"Computers & Internet"};
    final String[][] Categories5 = {{"Computers & Internet"}};
    final String[] Categories6 = {"Schools & Education"};
    final String[] Categories7 = {"Science"};
    final String[] Categories8 = {"Voice Chat"};


    public JTreePanelThree() {
        super();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");

        DefaultMutableTreeNode sub1 = new DefaultMutableTreeNode(new DefaultMutableTreeNode(Categories3[0][0]));

        DefaultMutableTreeNode sub2 = new DefaultMutableTreeNode(new DefaultMutableTreeNode(Categories3[2][0]));






        sub1.add(new DefaultMutableTreeNode(Categories3[1][0]));
        sub1.add(new DefaultMutableTreeNode(Categories3[1][1]));
        sub1.add(new DefaultMutableTreeNode(Categories3[1][2]));
        //sub3.add(new DefaultMutableTreeNode(Categories4[0])); we commented this out because not all categories are expandable

        //sub2.add(new DefaultMutableTreeNode(Categories3[3][0]));
        //sub2.add(new DefaultMutableTreeNode(Categories3[3][1]));

        root.add(sub1);

        root.add(sub2);

        treeone = new JTree(root);
        treeone.setRootVisible(false);
        treeone.setShowsRootHandles(true);
        jpanel.add(treeone);



    }
public JPanel getJPanel() {
        return jpanel;
}




}
