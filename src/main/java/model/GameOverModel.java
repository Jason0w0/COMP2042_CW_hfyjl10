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
import view.GameFrameView;
import view.HomeMenuView;

/**
 * This class will generate the game over's model
 *
 * @author Jason
 */
public class GameOverModel {
    private boolean isNewHighScore;
    private final GameFrameView owner;
    private final GameBoardView gameBoardView;
    private final HomeMenuView homeMenuView;

    /**
     * This is the constructor of GameOverModel
     * @param owner JFrame
     * @param gameBoardView Game board's view
     * @param homeMenuView Home menu's view
     */
    public GameOverModel(GameFrameView owner, GameBoardView gameBoardView, HomeMenuView homeMenuView) {
        this.owner = owner;
        this.gameBoardView = gameBoardView;
        this.homeMenuView = homeMenuView;
        setNewHighScore(false);
    }

    /**
     * This method gets isNewHighScore variable
     * @return isNewHighScore variable
     */
    public boolean isNewHighScore() {
        return isNewHighScore;
    }

    /**
     * This method sets isNewHighScore variable
     * @param newHighScore Boolean newHighScore
     */
    public void setNewHighScore(boolean newHighScore) {
        isNewHighScore = newHighScore;
    }

    /**
     * This method gets the owner variable
     * @return Owner variable
     */
    public GameFrameView getOwner() {
        return owner;
    }

    /**
     * This method gets the game board's view
     * @return GameBoardView variable
     */
    public GameBoardView getGameBoardView() {
        return gameBoardView;
    }

    /**
     * This method gets the home menu's view
     * @return HomeMenuView variable
     */
    public HomeMenuView getHomeMenuView() {
        return homeMenuView;
    }
}
