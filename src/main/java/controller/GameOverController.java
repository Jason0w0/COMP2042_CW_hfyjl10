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
package controller;

import model.GameOverModel;
import view.GameOverView;

/**
 * This class generates the game over's controller
 *
 * @author Jason
 */
public class GameOverController {
    private final GameOverModel gameOverModel;
    private final GameOverView gameOverView;

    /**
     * Ths is the constructor of GameOverController class
     * @param gameOverModel Game over's model
     * @param gameOverView Game over's view
     */
    public GameOverController(GameOverModel gameOverModel, GameOverView gameOverView) {
        this.gameOverModel = gameOverModel;
        this.gameOverView = gameOverView;
        this.gameOverView.setOwner(this.gameOverModel.getOwner());
        this.gameOverView.setGameBoardView(this.gameOverModel.getGameBoardView());
        this.gameOverView.setHomeMenuView(this.gameOverModel.getHomeMenuView());
        this.gameOverView.setNewHighScore(this.gameOverModel.isNewHighScore());
    }

    /**
     * This method will determine if new high score message will be display
     */
    public void addHighScoreMessage() {
        gameOverView.setNewHighScore(gameOverModel.isNewHighScore());
    }
}
