package de.MCmoderSD.core;

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
    }

    // Getter

    public ArrayList<Piece> getPieces() {
        return pieces;
    }
}
