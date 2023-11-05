package de.MCmoderSD.core;

import de.MCmoderSD.UI.Frame;
import de.MCmoderSD.main.Config;
import objects.Piece;

import java.util.ArrayList;

public class Game {

    // Associations
    private final Config config;

    // Attributes
    private final ArrayList<Piece> pieces = new ArrayList<>();

    // Constructor
    public Game(Config config) {
        this.config = config;

        Frame frame = new Frame(config, this);
    }

    // Getter

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void buttonClicked(int x, int y) {
    }
}
