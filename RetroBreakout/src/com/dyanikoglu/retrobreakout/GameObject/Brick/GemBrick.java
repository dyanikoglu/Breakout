package com.dyanikoglu.retrobreakout.GameObject.Brick;

public class GemBrick extends Brick{
    public GemBrick(int x, int y) {
        super(x,y);
        this.setHeight(24);
        this.setWidth(72);
        this.setIcon(loader.getResource("image/brick_gem.png"));
        this.setType(2);
    }
}
