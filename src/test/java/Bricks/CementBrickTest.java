package Bricks;

import Ball.RubberBall;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CementBrickTest {

    CementBrick cementBrick = new CementBrick(new Point(10,10),new Dimension(10,20));
    RubberBall rubberBall = new RubberBall(new Point(10,10));

    @Test
    void setImpact() {
        assertFalse(cementBrick.setImpact(new Point(15,20),Brick.UP_IMPACT));
    }

    @Test
    void findImpact() {
        assertEquals(Brick.LEFT_IMPACT,cementBrick.findImpact(rubberBall));
    }

    @Test
    void repair() {
        cementBrick.repair();
        assertFalse(cementBrick.isBroken());
        assertEquals(cementBrick.getFullStrength(),cementBrick.getStrength());
    }

    @Test
    void impact() {
        cementBrick.impact();
        assertFalse(cementBrick.isBroken());
        assertEquals(cementBrick.getFullStrength()-1,cementBrick.getStrength());
    }
}