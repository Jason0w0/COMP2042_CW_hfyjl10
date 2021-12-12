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
package Start;

import GameFrame.GameFrameController;
import GameFrame.GameFrameModel;
import GameFrame.GameFrameView;

import java.awt.*;

/**
 * This is the main class where the program starts
 *
 * @author Jason
 */
public class GraphicsMain {
    /**
     * This is the main method
     * This method initializes the game frame and view.
     */
    public static void main(String[] args){
        GameFrameView gameFrameView = new GameFrameView();
        GameFrameModel gameFrameModel = new GameFrameModel();
        GameFrameController gameFrameController = new GameFrameController(gameFrameModel, gameFrameView);
        EventQueue.invokeLater(gameFrameController::initialize);
    }
}
