package Bricks;

import Ball.RubberBall;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ClayBrickTest {
    ClayBrick clayBrick = new ClayBrick(new Point(10,10),new Dimension(20,60));
    RubberBall rubberBall = new RubberBall(new Point(10,10));

    @Test
    void setImpact() {
        assertTrue(clayBrick.setImpact(new Point(10, 10), Brick.Crack.getUP()));
    }


    @Test
    void findImpact() {
        assertEquals(Brick.LEFT_IMPACT,clayBrick.findImpact(rubberBall));
    }

    @Test
    void repair() {
        clayBrick.repair();
        assertFalse(clayBrick.isBroken());
        assertEquals(clayBrick.getFullStrength(),clayBrick.getStrength());
    }

    @Test
    void impact() {
        clayBrick.impact();
        assertTrue(clayBrick.isBroken());
        assertEquals(clayBrick.getFullStrength()-1,clayBrick.getStrength());
    }

}