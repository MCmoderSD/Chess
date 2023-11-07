package objects;

import de.MCmoderSD.main.Config;

public class Knight extends Piece {
    public Knight(Config config, int x, int y, String type, boolean isWhite) {
        super(x, y, isWhite ? config.getKnight()[1] : config.getKnight()[0], type, isWhite);
    }

    @Override
    protected boolean canMove(int x, int y) {
        return false;
    }

    @Override
    public boolean move(int x, int y) {
        if (canMove(x, y)) setPosition(x, y);
        else return false;
        return true;
    }
}
