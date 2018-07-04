package com.dyanikoglu.retrobreakout;

import com.dyanikoglu.retrobreakout.GameObject.Ball;

public interface ICollidable {
    boolean colDetect(Ball ball);
    void colResponse(Ball ball);
}
