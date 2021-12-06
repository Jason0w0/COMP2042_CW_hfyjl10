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

import controller.DebugConsoleController;
import view.GameBoardView;
import view.DebugConsoleView;

import javax.swing.*;
import java.awt.*;

public class GameBoardModel {

    private Stage stage;
    private DebugConsoleView debugConsoleView;
    private GameTimer gameTimer;
    private final JFrame owner;

    private boolean showPauseMenu;


    public GameBoardModel(JFrame owner) {
        this.owner = owner;
        showPauseMenu = false;
    }

    public Stage getStage() {
        return stage;
    }

    public Timer getGameTimer() {
        return gameTimer.getGameTimer();
    }

    public DebugConsoleView getDebugConsoleView() {
        return debugConsoleView;
    }

    public boolean isShowPauseMenu() {
        return showPauseMenu;
    }

    public void setShowPauseMenu(boolean showPauseMenu) {
        this.showPauseMenu = showPauseMenu;
    }

    public void createStage(){
        stage = new Stage(new Rectangle(0,0, 600, 450),new Point(300,430));
        //initialize the first level
        stage.nextLevel();
    }

    public void createDebugConsole(GameBoardView gameBoardView){
        DebugConsoleModel debugConsoleModel = new DebugConsoleModel(owner, stage, gameBoardView);
        debugConsoleView = new DebugConsoleView();
        new DebugConsoleController(debugConsoleModel, debugConsoleView);
    }

    public void gameLoop(GameBoardView gameBoardView){
        gameTimer = new GameTimer(gameBoardView, stage);
    }
}
