package de.MCmoderSD.UI;

import de.MCmoderSD.core.Game;
import de.MCmoderSD.main.Config;
import objects.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI extends JPanel {

    // Associations
    private final Config config;
    private final Game game;
    private final InputHandler inputHandler;

    // Attributes
    private final ArrayList<Piece> pieces = new ArrayList<>();

    // Constructor
    public UI(Config config, Game game) {
        super();
        setLayout(null);
        setPreferredSize(config.getDimension());
        setFocusable(true);
        requestFocus();

        this.config = config;
        this.game = game;
        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        Graphics2D g = (Graphics2D) graphics;

    }
}
