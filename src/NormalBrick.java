public class NormalBrick extends Brick {

    public NormalBrick(int x, int y) {
        super(x,y);
        setHeight(24);
        setWidth(72);
        setImage("image/brick_normal");
        brickType=0;
    }
}
