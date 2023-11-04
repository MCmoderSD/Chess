package de.MCmoderSD.UI;

import de.MCmoderSD.main.Config;
import de.MCmoderSD.utilities.Calculate;

import javax.swing.*;

public class Frame extends JFrame {

    // Associations
    private final UI ui;

    public Frame(Config config) {
        super(config.getTitle());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(config.isResizable());
        setIconImage(config.getIcon());

        ui = new UI(config);
        add(ui);

        pack();
        setLocation(Calculate.centerFrame(this));
        setVisible(true);
    }
}
