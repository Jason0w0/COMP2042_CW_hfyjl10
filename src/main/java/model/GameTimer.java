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

import controller.GameOverController;
import view.GameBoardView;
import view.GameFrameView;
import view.GameOverView;
import view.HomeMenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used to generate the game loop
 *
 * @author Jason
 */
public class GameTimer {

    private final Timer gameTimer;
    private final GameBoardView gameBoardView;
    private final Stage stage;
    private final HighScoreModel highScoreModel;
    private final GameOverView gameOverView;
    private final GameOverModel gameOverModel;
    private final GameOverController gameOverController;
    private final Player player;

    /**
     * This is class GameTimer's constructor
     * This constructor generates the game loop
     * @param owner GameFrameView class
     * @param homeMenuView HomeMenu class
     * @param gameBoardView GameBoardView class
     * @param stage Stage class
     * @param player Player class
     */
    public GameTimer(GameFrameView owner, HomeMenuView homeMenuView, GameBoardView gameBoardView, Stage stage, Player player) {
        this.gameBoardView = gameBoardView;
        this.stage = stage;
        this.player = player;
        highScoreModel = new HighScoreModel();
        gameOverModel = new GameOverModel(owner,this.gameBoardView, homeMenuView);
        gameOverView = new GameOverView();
        gameOverController = new GameOverController(gameOverModel,gameOverView);
        gameTimer = new Timer(10, new addActionListener());
    }

    /**
     * This class is the game loop
     */
    class addActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            stage.move();
            stage.findImpacts();
            String message = String.format("Bricks: %d Balls %d", stage.getBrickCount(), stage.getBallCount());
            String score = String.format("Score %d HighScore %d", stage.getScore(), highScoreModel.getHighScore());
            setMessage(message);
            setScore(score);
            if (stage.ballLost()) {
                if (stage.ballEnd()) {
                    stage.wallReset();
                    message = "Game over";
                    setMessage(message);
                    if (highScoreModel.isInHighScoreList(stage.getScore())){
                        highScoreModel.writeNewHighScore(stage.getScore());
                        gameOverModel.setNewHighScore(true);
                    }
                    stage.resetScore();
                    setScore("");
                    gameOverController.addHighScoreMessage();
                    gameOverView.displayPanel();
                    gameOverModel.setNewHighScore(false);
                    player.removeReward();
                    player.removePenalty();
                }
                stage.ballReset();
                stage.playerReset();
                gameTimer.stop();
            } else if (stage.isDone()) {
                if (stage.hasLevel()) {
                    message = "Go to Next Level";
                    setMessage(message);
                    gameTimer.stop();
                    stage.playerBonus(stage.getBallCount());
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

    /**
     * This class gets the game loop
     * @return Game loop
     */
    public Timer getGameTimer() {
        return gameTimer;
    }

    /**
     * This class sets the string message that will be displayed
     * @param Message String that will be displayed
     */
    private void setMessage(String Message){
        gameBoardView.setMessage(Message);
    }

    /**
     * This class sets the string score that will be displayed
     * @param score String that will be displayed
     */
    private void setScore(String score) {
        gameBoardView.setScoreBoard(score);
    }
}
