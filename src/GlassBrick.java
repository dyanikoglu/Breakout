public class GlassBrick extends Brick {

    public GlassBrick(int x, int y) {
        super(x,y);
        setHeight(24);
        setWidth(72);
        setImage("image/brick_glass.png");
        brickType=3;
    }
}
