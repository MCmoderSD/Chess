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
    private final ArrayList<JButton> buttons = new ArrayList<>();
    private final JButton[][] fields;
    private final JPanel board;
    private final int boardSize;
    private final int fieldSize;

    // Constructor
    public UI(Config config, Game game) {
        super();
        setLayout(new BorderLayout());
        setPreferredSize(config.getDimension());
        setFocusable(true);
        requestFocus();

        this.config = config;
        this.game = game;
        inputHandler = new InputHandler();
        addKeyListener(inputHandler);

        boardSize = Math.min(config.getWidth(), config.getHeight());
        fieldSize = boardSize / 8;

        board = new JPanel();
        board.setLayout(new GridLayout(8, 8));
        board.setPreferredSize(new Dimension(boardSize, boardSize));
        add(board, BorderLayout.WEST);

        fields = new JButton[8][8];
        for (int y = 0; y < fields.length; y++) {
            for (int x = 0; x < fields[y].length; x++) {

                int finalX = x;
                int finalY = y;
                boolean isWhite = (x + y) % 2 == 0;

                fields[y][x] = new JButton();
                fields[y][x].setPreferredSize(new Dimension(boardSize / 8, boardSize / 8));
                fields[y][x].setFocusable(false);
                fields[y][x].setBorderPainted(false);
                fields[y][x].setBackground(isWhite ? Color.WHITE : Color.BLACK);
                fields[y][x].addActionListener(e -> game.buttonClicked(finalX, finalY));

                board.add(fields[y][x]);
            }
        }

        updateBoard();
    }

    // Setter
    public void updateBoard() {

        // Clear Board
        for (JButton[] field : fields) for (JButton jButton : field) jButton.setIcon(null);


        // Set Pieces
        for (Piece piece : pieces) {
            if (config.getImageReader() != null)
                fields[piece.getY()][piece.getX()].setIcon(config.getImageReader().createImageIcon(piece.getImage(), fieldSize));
            else
                fields[piece.getY()][piece.getX()].setIcon(config.getImageStreamer().createImageIcon(piece.getImage(), fieldSize));
        }
    }
}
