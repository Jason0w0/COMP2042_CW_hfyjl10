package model;

import view.GameBoardView;
import test.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer {

    private final Timer gameTimer;
    private final GameBoardView gameBoardView;
    private final Stage stage;


    public GameTimer(GameBoardView gameBoardView, Stage stage) {
        this.gameBoardView = gameBoardView;
        this.stage = stage;
        gameTimer = new Timer(10, new addActionListener());
    }

    class addActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            stage.move();
            stage.findImpacts();
            String message = String.format("Bricks: %d Balls %d", stage.getBrickCount(), stage.getBallCount());
            setMessage(message);
            if (stage.isBallLost()) {
                if (stage.ballEnd()) {
                    stage.wallReset();
                    message = "Game over";
                    setMessage(message);
                }
                stage.ballReset();
                stage.playerReset();
                gameTimer.stop();
            } else if (stage.isDone()) {
                if (stage.hasLevel()) {
                    message = "Go to Next Level";
                    setMessage(message);
                    gameTimer.stop();
                    stage.ballReset();
                    stage.playerReset();
                    stage.wallReset();
                    stage.nextLevel();
                } else {
                    message = "ALL WALLS DESTROYED";
                    setMessage(message);
                    gameTimer.stop();
                }
            }

            gameBoardView.repaint();
        }
    }

    public Timer getGameTimer() {
        return gameTimer;
    }

    private void setMessage(String Message){
        gameBoardView.setMessage(Message);
    }
}
