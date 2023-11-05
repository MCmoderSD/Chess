package de.MCmoderSD.data;

import de.MCmoderSD.core.Game;
import de.MCmoderSD.main.Config;
import objects.*;

public class Board {
    // Attributes
    private final Piece[][] board;

    // White pieces
    private final Pawn[] whitePawns;
    private final Rook[] whiteRooks;
    private final Bishop[] whiteBishops;
    private final Knight[] whiteKnights;
    private final Queen whiteQueen;
    private final King whiteKing;

    // Black pieces
    private final Pawn[] blackPawns;
    private final Rook[] blackRooks;
    private final Bishop[] blackBishops;
    private final Knight[] blackKnights;
    private final Queen blackQueen;
    private final King blackKing;

    public Board(Config config, Game game) {
        board = new Piece[8][8];

        // White pieces
        whitePawns = new Pawn[8];
        whiteRooks = new Rook[2];
        whiteBishops = new Bishop[2];
        whiteKnights = new Knight[2];
        whiteQueen = new Queen(config, 3, 0, "Queen", true);
        whiteKing = new King(config, 4, 0, "King", true);

        // Black pieces
        blackPawns = new Pawn[8];
        blackRooks = new Rook[2];
        blackBishops = new Bishop[2];
        blackKnights = new Knight[2];
        blackQueen = new Queen(config, 3, 7, "Queen", false);
        blackKing = new King(config, 4, 7, "King", false);

        // White pawns
        for (int i = 0; i < whitePawns.length; i++) whitePawns[i] = new Pawn(config, i, 1, "Pawn", true);

        // White rooks
        whiteRooks[0] = new Rook(config, 0, 0, "Rook", true);
        whiteRooks[1] = new Rook(config, 7, 0, "Rook", true);

        // White bishops
        whiteBishops[0] = new Bishop(config, 2, 0, "Bishop", true);
        whiteBishops[1] = new Bishop(config, 5, 0, "Bishop", true);

        // White knights
        whiteKnights[0] = new Knight(config, 1, 0, "Knight", true);
        whiteKnights[1] = new Knight(config, 6, 0, "Knight", true);

        // Black pawns
        for (int i = 0; i < blackPawns.length; i++) blackPawns[i] = new Pawn(config, i, 6, "Pawn", false);

        // Black rooks
        blackRooks[0] = new Rook(config, 0, 7, "Rook", false);
        blackRooks[1] = new Rook(config, 7, 7, "Rook", false);


        // Assign to Board
        for (Pawn pawn : whitePawns) board[pawn.getY()][pawn.getX()] = pawn;
        for (Rook rook : whiteRooks) board[rook.getY()][rook.getX()] = rook;
        for (Bishop bishop : whiteBishops) board[bishop.getY()][bishop.getX()] = bishop;
        for (Knight knight : whiteKnights) board[knight.getY()][knight.getX()] = knight;
        board[whiteQueen.getY()][whiteQueen.getX()] = whiteQueen;
        board[whiteKing.getY()][whiteKing.getX()] = whiteKing;

        for (Pawn pawn : blackPawns) board[pawn.getY()][pawn.getX()] = pawn;
        for (Rook rook : blackRooks) board[rook.getY()][rook.getX()] = rook;
        for (Bishop bishop : blackBishops) board[bishop.getY()][bishop.getX()] = bishop;
        for (Knight knight : blackKnights) board[knight.getY()][knight.getX()] = knight;
        board[blackQueen.getY()][blackQueen.getX()] = blackQueen;
        board[blackKing.getY()][blackKing.getX()] = blackKing;
    }

    public Piece[][] getBoard() {
        return board;
    }
}
