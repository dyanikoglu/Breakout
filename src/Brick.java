public class Brick extends GameObject {
    boolean destroyed;

    public Brick() {
        destroyed = false;
    }

    public Brick(int x, int y) {
        setX(x);
        setY(y);
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
