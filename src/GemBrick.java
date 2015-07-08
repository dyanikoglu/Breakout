public class GemBrick extends Brick{

    public GemBrick(int x, int y) {
        super(x,y);
        setHeight(24);
        setWidth(72);
        setImage("image/brick_gem.png");
        brickType=2;
    }
}
