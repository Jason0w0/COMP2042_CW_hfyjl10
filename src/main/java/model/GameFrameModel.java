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
    private GameBoardView gameBoardView;
    private GameBoardController gameBoardController;
    private final GameFrameView owner;
    private HomeMenuView homeMenuView;
    private boolean gaming;

    public GameFrameModel(GameFrameView owner){
        this.owner = owner;
        gaming = false;
    }

    public GameBoardView getGameBoardView() {
        return gameBoardView;
    }

//    public HomeMenuView getHomeMenuView() {
//        return homeMenuView;
//    }

    public void setHomeMenuView(HomeMenuView homeMenuView) {
        this.homeMenuView = homeMenuView;
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
