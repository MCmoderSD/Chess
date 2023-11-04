package objects;

import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public abstract class Piece {

    // Constants
    protected final String type;
    protected final BufferedImage image;
    protected final boolean isWhite;

    // Attributes
    protected int x;
    protected int y;

    // Constructor
    public Piece(int x, int y, BufferedImage image, String type, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.image = image;
        this.isWhite = isWhite;
    }

    // Methods
    protected abstract boolean canMove(int x, int y);

    public abstract void move(int x, int y);


    // Getters
    public BufferedImage getImage() {
        return image;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public String getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    // Setter
    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    public Point getPosition() {
        return new Point(x, y);
    }

    protected void setPosition(Point position) {
        this.x = position.x;
        this.y = position.y;
    }

    protected void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
