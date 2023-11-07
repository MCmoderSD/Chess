package objects;

import de.MCmoderSD.main.Config;

public class Pawn extends Piece {
    public Pawn(Config config, int x, int y, String type, boolean isWhite) {
        super(x, y, isWhite ? config.getPawn()[1] : config.getPawn()[0], type, isWhite);
    }

    @Override
    protected boolean canMove(int x, int y) {
        if (isWhite) {
            if (y == getY() - 1 && x == getX()) return true;
            return y == getY() - 2 && x == getX() && getY() == 6;
        } else {
            if (y == getY() + 1 && x == getX()) return true;
            return y == getY() + 2 && x == getX() && getY() == 1;
        }
    }

    @Override
    public boolean move(int x, int y) {
        if (canMove(x, y)) setPosition(x, y);
        else return false;
        return true;
    }
}
