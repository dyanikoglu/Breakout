public class StoneBrick extends Brick {
    public StoneBrick(int x, int y) {
        super(x,y);
        this.setHeight(24);
        this.setWidth(72);
        this.setIcon("image/brick_stone_1.png");
        this.setType(1);
    }
}
