package com.dyanikoglu.retrobreakout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener {
    private JButton playButton;
    public static JTextField nameTextField;
    public static boolean flag=true;

    public MainMenu() {
        this.setFocusable(false);
        drawPanel();
        playButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(!nameTextField.getText().isEmpty())
            flag=false;
    }

    private void drawPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gBagC;
        playButton = new JButton("PLAY");
        gBagC = new GridBagConstraints();
        setGridBagConstraints(gBagC, 1, 6, 3, 5, 1, 1, 0, 0, "north");
        playButton.setAlignmentY(10);
        add(playButton, gBagC);

        JLabel label1;
        label1 = new JLabel("Player Name:");
        label1.setForeground(Color.BLACK);
        gBagC = new GridBagConstraints();
        setGridBagConstraints(gBagC, 1, 1, 0, 0, 1, 0, 0, 0, "north");
        add(label1, gBagC);

        nameTextField = new JTextField();
        gBagC = new GridBagConstraints();
        setGridBagConstraints(gBagC, 2, 1, 0, 0, 1, 0, 100, 0, "north");
        add(nameTextField, gBagC);

        final JPanel divider1 = new JPanel();
        gBagC = new GridBagConstraints();
        setGridBagConstraints(gBagC, 3, 2, 0, 0, 0, 0, 0, 0, "");
        gBagC.fill = GridBagConstraints.HORIZONTAL;
        add(divider1, gBagC);
    }

    private void setGridBagConstraints(GridBagConstraints gBagC, int gridx, int gridy, int gridwidth, int gridheight, int weightx, int weighty, int ipadx, int ipady, String anchor) {
        gBagC.gridx=gridx;
        gBagC.gridy=gridy;

        if(gridwidth!=0)
            gBagC.gridwidth=gridwidth;
        if(gridheight!=0)
            gBagC.gridheight=gridheight;
        if(weightx!=0)
            gBagC.weightx=weightx;
        if(weighty!=0)
            gBagC.weighty=weighty;
        if(ipadx!=0)
            gBagC.ipadx=ipadx;
        if(ipady!=0)
            gBagC.ipady=ipady;

        if(anchor.equalsIgnoreCase("south"))
            gBagC.anchor=GridBagConstraints.SOUTH;
        else if(anchor.equalsIgnoreCase("southeast"))
            gBagC.anchor=GridBagConstraints.SOUTHEAST;
        else if((anchor.equalsIgnoreCase("north")))
            gBagC.anchor=GridBagConstraints.NORTH;
    }

}
