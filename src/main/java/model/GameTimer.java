package model;

import test.GameBoard;
import test.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer {
    public Timer getGameTimer() {
        return gameTimer;
    }

    private Timer gameTimer;
    private GameBoard gameBoardView;
    private Stage stage;
    private String message;


    public GameTimer(GameBoard gameBoardView, Stage stage) {
        this.gameBoardView = gameBoardView;
        this.stage = stage;
        gameTimer = new Timer(10, new addActionListener());
    }

    class addActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            stage.move();
            stage.findImpacts();
            message = String.format("Bricks: %d Balls %d", stage.getBrickCount(), stage.getBallCount());
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

    private void setMessage(String Message){
        gameBoardView.setMessage(Message);
    }
}
