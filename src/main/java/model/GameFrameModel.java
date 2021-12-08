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

import controller.GameBoardController;
import view.GameFrameView;
import view.GameBoardView;
import view.HomeMenuView;


public class GameFrameModel {
    private static final String DEF_TITLE = "Brick Destroy";

    private GameBoardView gameBoardView;
    private GameBoardController gameBoardController;
    private  GameFrameView owner;
    private HomeMenuView homeMenuView;

    private boolean gaming;

    public GameFrameModel(){
        new HighScoreModel();
        setGaming(false);
    }

    public void setOwner(GameFrameView owner) {
        this.owner = owner;
    }

    public GameBoardView getGameBoardView() {
        return gameBoardView;
    }

    public void setHomeMenuView(HomeMenuView homeMenuView) {
        this.homeMenuView = homeMenuView;
    }

    public String getDefTitle() {
        return DEF_TITLE;
    }

    public boolean isGaming() {
        return gaming;
    }

    public void setGaming(boolean gaming) {
        this.gaming = gaming;
    }

    public void createGameBoard(){
        GameBoardModel gameBoardModel = new GameBoardModel(owner, homeMenuView);
        gameBoardView = new GameBoardView();
        gameBoardController = new GameBoardController(gameBoardModel,gameBoardView);
    }

    public GameBoardController getGameBoardController() {
        return gameBoardController;
    }
}
