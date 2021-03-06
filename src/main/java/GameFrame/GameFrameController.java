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

import HomeMenu.HomeMenuController;
import HomeMenu.HomeMenuModel;
import HomeMenu.HomeMenuView;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class generates the controller of game frame
 *
 * @author Jason
 */
public class GameFrameController {
    private final GameFrameModel gameFrameModel;
    private final GameFrameView gameFrameView;
    private final HomeMenuView homeMenuView;

    /**
     * This is class GameFrameController's constructor
     * This constructor initializes the game frame modal and view
     * @param gameFrameModel Game frame model
     * @param gameFrameView Game frame view
     */
    public GameFrameController(GameFrameModel gameFrameModel, GameFrameView gameFrameView){
        HomeMenuModel homeMenuModel = new HomeMenuModel();
        homeMenuView = new HomeMenuView();
        new HomeMenuController(homeMenuModel, homeMenuView, this);
        this.gameFrameModel = gameFrameModel;
        this.gameFrameView = gameFrameView;
        this.gameFrameModel.setOwner(this.gameFrameView);
        this.gameFrameModel.setHomeMenuView(homeMenuView);
        this.gameFrameView.addGameFrameWindowFocusListener(new addWindowFocusListener());
        this.gameFrameView.addHomeMenu(homeMenuView);
        this.gameFrameModel.createGameBoard();
    }

    /**
     * This class is generates the WindowFocusListener function
     */
    class addWindowFocusListener implements WindowFocusListener {
        @Override
        public void windowGainedFocus(WindowEvent e) {
            /*
            the first time the frame loses focus is because
            it has been disposed to install the GameBoard,
            so went it regains the focus it's ready to play.
            of course calling a method such as 'onLostFocus'
            is useful only if the GameBoard as been displayed
            at least once
            */
            gameFrameModel.setGaming(true);
        }

        @Override
        public void windowLostFocus(WindowEvent e) {
            if(gameFrameModel.isGaming())
                gameFrameModel.getGameBoardController().onLostFocus();
        }
    }

    /**
     * This method initializes the game frame view
     */
    public void initialize(){
        gameFrameView.setTitle(gameFrameModel.getDefTitle());
        gameFrameView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrameView.pack();
        gameFrameView.autoLocate();
        gameFrameView.setVisible(true);
        gameFrameView.setResizable(false);
    }

    /**
     * This method displays the game board
     */
    public void enableGameBoard(){
        gameFrameView.dispose();
        gameFrameView.remove(homeMenuView);
        gameFrameView.add(gameFrameModel.getGameBoardView(), BorderLayout.CENTER);
        gameFrameView.setUndecorated(false);
        initialize();
    }
}
