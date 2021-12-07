/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2021 Lee Jason
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package model;

import view.GameBoardView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer {

    private final Timer gameTimer;
    private final GameBoardView gameBoardView;
    private final Stage stage;
    private HighScoreModel highScoreModel = new HighScoreModel();


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
            String score = String.format("Score %d HighScore %d", stage.getScore(), highScoreModel.getHighScore());
            setMessage(message);
            setScore(score);
            if (stage.isBallLost()) {
                if (stage.ballEnd()) {
                    stage.wallReset();
                    message = "Game over";
                    setMessage(message);
                    if (stage.getScore() >= highScoreModel.getHighScore()){
                        highScoreModel.newHighScore(stage.getScore());
                    }
                    stage.resetScore();
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
                    stage.playerReward();
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

    private void setScore(String score) { gameBoardView.setScoreBoard(score);}
}
