package com.dyanikoglu.retrobreakout.GameObject.Brick;

public class BorderBrick extends Brick {
    public BorderBrick(int x,int y) {
        super(x,y);
        this.setIcon(loader.getResource("image/borderbrick.png"));
        this.setWidth(24);
        this.setHeight(24);
        this.setType(4);
    }
}
