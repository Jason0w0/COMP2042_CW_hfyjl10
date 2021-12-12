package Bricks;

import Ball.RubberBall;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SteelBrickTest {

    SteelBrick steelBrick = new SteelBrick(new Point(10,10), new Dimension(30,10));
    RubberBall rubberBall = new RubberBall(new Point(10,10));

    @Test
    void impact() {
        steelBrick.setImpact(new Point(10,10), Brick.UP_IMPACT);
        steelBrick.setImpact(new Point(10,10), Brick.UP_IMPACT);
        steelBrick.setImpact(new Point(10,10), Brick.UP_IMPACT);
        assertTrue(steelBrick.isBroken());
    }

    @Test
    void setImpact() {
        assertFalse(steelBrick.setImpact(new Point(15,20),Brick.UP_IMPACT));
    }

    @Test
    void findImpact() {
        assertEquals(Brick.LEFT_IMPACT,steelBrick.findImpact(rubberBall));
    }

    @Test
    void repair() {
        steelBrick.repair();
        assertFalse(steelBrick.isBroken());
        assertEquals(steelBrick.getFullStrength(),steelBrick.getStrength());
    }
}