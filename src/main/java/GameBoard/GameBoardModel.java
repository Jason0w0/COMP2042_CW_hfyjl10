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
package GameBoard;

import DebugConsole.DebugConsoleController;
import DebugConsole.DebugConsoleModel;
import DebugConsole.DebugConsoleView;
import GameTimer.GameTimer;
import Stage.Stage;
import GameFrame.GameFrameView;
import HomeMenu.HomeMenuView;

import javax.swing.*;
import java.awt.*;

/**
 * This class generates the game board's model
 *
 * @author Jason
 */
public class GameBoardModel {
    private Stage stage;
    private DebugConsoleView debugConsoleView;
    private GameTimer gameTimer;
    private final GameFrameView owner;
    private final HomeMenuView homeMenuView;

    private boolean showPauseMenu;

    /**
     * This is class GameBoardModel's constructor.
     * @param owner JFrame
     * @param homeMenuView Home menu View
     */
    public GameBoardModel(GameFrameView owner, HomeMenuView homeMenuView) {
        this.owner = owner;
        this.homeMenuView = homeMenuView;
        setShowPauseMenu(false);
    }

    /**
     * This method gets the current level
     * @return Current level
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * This method gets the game loop
     * @return Game loop
     */
    public Timer getGameTimer() {
        return gameTimer.getGameTimer();
    }

    /**
     * This method gets the debug console's view
     * @return Debug console's view
     */
    public DebugConsoleView getDebugConsoleView() {
        return debugConsoleView;
    }

    /**
     * This method gets the showPauseMenu variable
     * @return showPauseMenu variable
     */
    public boolean isShowPauseMenu() {
        return showPauseMenu;
    }

    /**
     * This method sets the showPauseMenu variable
     * @param showPauseMenu Boolean either Pause menu is displayed
     */
    public void setShowPauseMenu(boolean showPauseMenu) {
        this.showPauseMenu = showPauseMenu;
    }

    /**
     * This method creates the game level
     */
    public void createStage(){
        stage = new Stage(new Rectangle(0,0, 600, 450),new Point(300,430));
        stage.nextLevel();
    }

    /**
     * This method creates the debug console
     * @param gameBoardView Game board's view
     */
    public void createDebugConsole(GameBoardView gameBoardView){
        DebugConsoleModel debugConsoleModel = new DebugConsoleModel(owner, stage, gameBoardView);
        debugConsoleView = new DebugConsoleView();
        new DebugConsoleController(debugConsoleModel, debugConsoleView);
    }

    /**
     * This method creates the game loop
     * @param gameBoardView Game Board's view
     */
    public void CreateGameLoop(GameBoardView gameBoardView){
        gameTimer = new GameTimer(owner, homeMenuView, gameBoardView, stage, getStage().getPlayer());
    }
}
