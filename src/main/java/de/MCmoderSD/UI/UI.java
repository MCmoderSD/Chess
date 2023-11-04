package de.MCmoderSD.UI;

import de.MCmoderSD.main.Config;

import javax.swing.*;
import java.awt.*;

public class UI extends JPanel {

    // Associations
    private final Config config;
    private final InputHandler inputHandler;

    public UI(Config config) {
        super();
        setLayout(null);
        setPreferredSize(config.getDimension());
        setFocusable(true);
        requestFocus();

        this.config = config;
        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        Graphics2D g = (Graphics2D) graphics;
    }
}
