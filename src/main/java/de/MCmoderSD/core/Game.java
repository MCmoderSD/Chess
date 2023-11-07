package de.MCmoderSD.core;

import de.MCmoderSD.UI.Frame;
import de.MCmoderSD.UI.InputHandler;
import de.MCmoderSD.UI.UI;
import de.MCmoderSD.data.Board;
import de.MCmoderSD.main.Config;
import objects.Piece;

import java.util.ArrayList;

public class Game {

    // Associations
    private final Config config;
    private final Frame frame;
    private final UI ui;
    private final InputHandler inputHandler;
    private final Board board;

    // Attributes
    private final ArrayList<Piece> pieces = new ArrayList<>();
    private Piece selectedPiece;

    // Constructor
    public Game(Config config) {
        this.config = config;

        frame = new Frame(config, this);
        ui = frame.getUi();
        inputHandler = ui.getInputHandler();
        board = new Board(config, this);

        updateBoard();
    }

    // Methods
    public void updateBoard() {
        ui.setPieces(board.getPieces());
        ui.updateBoard();
    }

    // Getter
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void buttonClicked(int x, int y) {
        Piece clickedPiece = board.getPiece(x, y);
        if (clickedPiece != null && selectedPiece == null) {
            selectedPiece = clickedPiece;
            System.out.println("Selected " + selectedPiece.getType() + " at " + selectedPiece.getX() + ", " + selectedPiece.getY());
        } else if (clickedPiece == null && selectedPiece == null) System.out.println("No piece selected!");
        else if (clickedPiece == null) {
            if (selectedPiece.move(x, y)) {
                selectedPiece = null;
                board.updateBoard();
                updateBoard();
            } else System.out.println("Invalid move!");
        }
    }
}
