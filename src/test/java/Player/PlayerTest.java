package Player;

import Ball.RubberBall;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player(new Point(150,50),new Rectangle(0,0, 600, 450));
    RubberBall rubberBall = new RubberBall(new Point(150,50));

    @Test
    void impact() {
        assertTrue(player.impact(rubberBall));
    }

    @Test
    void move() {
        player.moveLeft();
        player.move();
        assertTrue(player.getPlayerFace().contains(145,50));
    }

    @Test
    void moveTo() {
        player.moveTo(new Point(200,200));
        assertTrue(player.getPlayerFace().contains(200,200));
    }

    @Test
    void playerReward() {
        player.playerReward();
        assertFalse(player.getPlayerFace().contains(250,50));
    }

    @Test
    void playerPenalty() {
        player.playerPenalty();
        assertTrue(player.getPlayerFace().contains(200,50));
    }

    @Test
    void removeReward() {
        player.playerReward();
        player.removeReward();
        assertFalse(player.getPlayerFace().contains(250,50));
    }

    @Test
    void removePenalty() {
        player.playerReward();
        player.removeReward();
        assertFalse(player.getPlayerFace().contains(250,50));
    }
}