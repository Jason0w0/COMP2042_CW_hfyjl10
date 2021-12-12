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
package DebugConsole;

import DebugPanel.DebugPanelController;
import DebugPanel.DebugPanelModel;
import Stage.Stage;
import GameBoard.GameBoardView;
import DebugPanel.DebugPanelView;

import javax.swing.*;

/**
 * This class generates the debug console's model
 *
 * @author Jason
 */
public class DebugConsoleModel {
    private final JFrame owner;
    private final GameBoardView gameBoardView;
    private final DebugPanelView debugPanelView;

    /**
     * This is the constructor of class DebugConsoleModel
     * @param owner JFrame
     * @param stage Stag class
     * @param gameBoardView Game board's view
     */
    public DebugConsoleModel(JFrame owner, Stage stage, GameBoardView gameBoardView){
        this.owner = owner;
        this.gameBoardView = gameBoardView;

        debugPanelView = new DebugPanelView();
        DebugPanelModel debugPanelModel = new DebugPanelModel();
        new DebugPanelController(debugPanelModel, debugPanelView, stage);

    }

    /**
     * This method gets the owner variable
     * @return Owner variable
     */
    public JFrame getOwner() {
        return owner;
    }

    /**
     * This method gets the debug Panel's view
     * @return Debug Panel's view
     */
    public DebugPanelView getDebugPanelView() {
        return debugPanelView;
    }

    /**
     * This method gets the game board's view
     * @return Game board's view
     */
    public GameBoardView getGameBoard() {
        return gameBoardView;
    }
}
