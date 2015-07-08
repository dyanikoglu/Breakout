public class StoneBrick extends Brick {

    public StoneBrick(int x, int y) {
        super(x,y);
        setHeight(24);
        setWidth(72);
        setImage("image/brick_stone");
        brickType=1;
    }
}