package de.MCmoderSD.UI;

import de.MCmoderSD.core.Game;
import de.MCmoderSD.main.Config;
import de.MCmoderSD.utilities.Calculate;

import javax.swing.*;

public class Frame extends JFrame {

    // Associations
    private final Config config;
    private final Game game;
    private final UI ui;

    public Frame(Config config, Game game) {
        super(config.getTitle());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(config.isResizable());
        setIconImage(config.getIcon());

        this.config = config;
        this.game = game;

        ui = new UI(config, game);
        add(ui);

        pack();
        setLocation(Calculate.centerFrame(this));
        setVisible(true);
    }
}
