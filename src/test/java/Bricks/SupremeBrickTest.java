package Bricks;

import Ball.RubberBall;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SupremeBrickTest {

    SupremeBrick supremeBrick = new SupremeBrick(new Point(10,10), new Dimension(30,10));
    RubberBall rubberBall = new RubberBall(new Point(10,10));

    @Test
    void impact() {
        supremeBrick.setImpact(new Point(20,20), Brick.DOWN_IMPACT);
        supremeBrick.setImpact(new Point(20,20), Brick.DOWN_IMPACT);
        supremeBrick.setImpact(new Point(20,20), Brick.DOWN_IMPACT);
        assertFalse(supremeBrick.isBroken());
    }

    @Test
    void setImpact() {
        assertFalse(supremeBrick.setImpact(new Point(15,20),Brick.UP_IMPACT));
    }

    @Test
    void findImpact() {
        assertEquals(Brick.LEFT_IMPACT,supremeBrick.findImpact(rubberBall));
    }

    @Test
    void repair() {
        supremeBrick.repair();
        assertFalse(supremeBrick.isBroken());
        assertEquals(supremeBrick.getFullStrength(),supremeBrick.getStrength());
    }
}