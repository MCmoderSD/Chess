package objects;

import de.MCmoderSD.main.Config;

public class Knight extends Piece {
    public Knight(Config config, int x, int y, String type, boolean isWhite) {
        super(x, y, isWhite ? config.getKnight()[1] : config.getKnight()[0], type, isWhite);
    }

    @Override
    protected boolean canMove(int x, int y) {
    }

    @Override
    public void move(int x, int y) {
        if (canMove(x, y)) setPosition(x, y);
        else System.out.println("Invalid move!");
    }
}
