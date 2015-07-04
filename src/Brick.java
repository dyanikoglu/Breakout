public class Brick extends GameObject {
    boolean destroyed;

    public Brick() {
    }

    public Brick(int x, int y) {
        setX(x);
        setY(y);
        destroyed = false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
