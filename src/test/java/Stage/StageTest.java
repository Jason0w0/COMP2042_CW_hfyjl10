package Stage;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class StageTest {

    Stage stage = new Stage(new Rectangle(0,0, 600, 450),new Point(300,430));

    @Test
    void findImpacts() {
        stage.findImpacts();
        assertEquals(5,stage.getBall().getSpeedY());
    }

    @Test
    void ballReset() {
        stage.ballReset();
        assertEquals(new Point(300,430),stage.getBall().getPosition());
    }

    @Test
    void playerReset() {
        stage.playerReset();
        assertTrue(stage.getPlayer().getPlayerFace().contains(300,430));
    }

    @Test
    void ballEnd() {
        assertFalse(stage.ballEnd());
    }

    @Test
    void nextLevel() {
        stage.nextLevel();
        assertEquals(31,stage.getBrickCount());
    }

    @Test
    void hasLevel() {
        assertTrue(stage.hasLevel());
    }

}