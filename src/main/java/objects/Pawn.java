package objects;

import de.MCmoderSD.main.Config;

public class Pawn extends Piece {
    public Pawn(Config config, int x, int y, String type, boolean isWhite) {
        super(x, y, isWhite ? config.getPawn()[1] : config.getPawn()[0], type, isWhite);
    }

    @Override
    protected boolean canMove(int x, int y) {
        return false;
    }

    @Override
    public void move(int x, int y) {
        if (canMove(x, y)) setPosition(x, y);
        else System.out.println("Invalid move!");
    }
}
