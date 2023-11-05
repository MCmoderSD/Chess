package objects;

import de.MCmoderSD.main.Config;

import java.awt.image.BufferedImage;

public class King extends Piece {
    private final BufferedImage check;

    public King(Config config, int x, int y, String type, boolean isWhite) {
        super(x, y, isWhite ? config.getKing()[1] : config.getKing()[0], type, isWhite);
        check = isWhite ? config.getKing()[3] : config.getKnight()[2];
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

    // Getter
    public BufferedImage getCheck() {
        return check;
    }
}
