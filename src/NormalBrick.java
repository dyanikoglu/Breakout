public class NormalBrick extends Brick {

    public NormalBrick(int x, int y) {
        super(x,y);
        this.setHeight(24);
        this.setWidth(72);
        this.setIcon("image/brick_normal.png");
        this.setType(0);
    }
}
