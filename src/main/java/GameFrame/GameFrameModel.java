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
package GameFrame;

import GameBoard.GameBoardController;
import GameBoard.GameBoardModel;
import HighScore.HighScoreModel;
import GameBoard.GameBoardView;
import HomeMenu.HomeMenuView;


/**
 * This class generates the game frame's model
 * This class stores the game frame's data
 *
 * @author Jason
 */
public class GameFrameModel {
    private static final String DEF_TITLE = "Brick Destroy";

    private GameBoardView gameBoardView;
    private GameBoardController gameBoardController;
    private  GameFrameView owner;
    private HomeMenuView homeMenuView;

    private boolean gaming;

    /**
     * This is class GameFrameModel's constructor
     */
    public GameFrameModel(){
        new HighScoreModel();
        setGaming(false);
    }

    /**
     * This method initializes owner variable
     * @param owner JFrame
     */
    public void setOwner(GameFrameView owner) {
        this.owner = owner;
    }

    /**
     * This method gets the game board view
     * @return Game board view
     */
    public GameBoardView getGameBoardView() {
        return gameBoardView;
    }

    /**
     * This method initializes the homeMenuView variable
     * @param homeMenuView Home menu view
     */
    public void setHomeMenuView(HomeMenuView homeMenuView) {
        this.homeMenuView = homeMenuView;
    }

    /**
     * This method gets the Defined title
     * @return Defined title
     */
    public String getDefTitle() {
        return DEF_TITLE;
    }

    /**
     * This method returns the gaming variable
     * @return Boolean gaming variable
     */
    public boolean isGaming() {
        return gaming;
    }

    /**
     * This method sets the gaming variable
     * @param gaming Boolean gaming variable
     */
    public void setGaming(boolean gaming) {
        this.gaming = gaming;
    }

    /**
     * This method creates the game board
     */
    public void createGameBoard(){
        GameBoardModel gameBoardModel = new GameBoardModel(owner, homeMenuView);
        gameBoardView = new GameBoardView();
        gameBoardController = new GameBoardController(gameBoardModel,gameBoardView);
    }

    /**
     * This method gets the game board's controller
     * @return Game board's controller
     */
    public GameBoardController getGameBoardController() {
        return gameBoardController;
    }
}
