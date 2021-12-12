package Ball;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import static org.junit.jupiter.api.Assertions.*;

class RubberBallTest {

    RubberBall rubberBall = new RubberBall(new Point(10,10));

    @Test
    void moveTo() {
        rubberBall.moveTo(new Point(100,100));
        assertEquals(new Point(100,100),rubberBall.getPosition());
    }


    @Test
    void move() {
        rubberBall.move();
    }

    @Test
    void reverseX() {
        rubberBall.setXSpeed(5);
        rubberBall.reverseX();
        assertEquals(-5,rubberBall.getSpeedX());
    }

    @Test
    void reverseY() {
        rubberBall.setYSpeed(5);
        rubberBall.reverseY();
        assertEquals(-5,rubberBall.getSpeedY());
    }

}