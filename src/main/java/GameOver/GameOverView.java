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
package GameOver;

import GameBoard.GameBoardView;
import GameFrame.GameFrameView;
import HomeMenu.HomeMenuView;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class generates game over's view
 *
 * @author Jason
 */
public class GameOverView {
    private boolean isNewHighScore;
    private GameFrameView owner;
    private GameBoardView gameBoardView;
    private HomeMenuView homeMenuView;

    /**
     * This is the constructor of class GameOverView
     */
    public GameOverView(){}

    /**
     * This method sets hewHighScore variable
     * @param newHighScore Boolean newHighScore
     */
    public void setNewHighScore(boolean newHighScore) {
        isNewHighScore = newHighScore;
    }

    /**
     * This method sets the Owner variable
     * @param owner Game frame's view
     */
    public void setOwner(GameFrameView owner) {
        this.owner = owner;
    }

    /**
     * This method sets the game board's view
     * @param gameBoardView Game board's view
     */
    public void setGameBoardView(GameBoardView gameBoardView) {
        this.gameBoardView = gameBoardView;
    }

    /**
     * This method sets home menu's view
     * @param homeMenuView  Home menu's view
     */
    public void setHomeMenuView(HomeMenuView homeMenuView) {
        this.homeMenuView = homeMenuView;
    }

    /**
     * This method sets the message that will be displayed
     * @return String message that will be displayed
     */
    private String message() {
        String message = "Back to home menu?";
        if (isNewHighScore){
            message = "Congratulations! Your have created a new high score!\n" + message;
        }
        return message;
    }

    /**
     * This method will display the game over panel
     */
    public void displayPanel() {
        Object [] options = {"Back", "Exit"};
        int input = JOptionPane.showOptionDialog(null, message(), "GAME OVER", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        if (input == JOptionPane.YES_OPTION) {
            owner.dispose();
            owner.remove(gameBoardView);
            owner.add(homeMenuView, BorderLayout.CENTER);
            owner.setUndecorated(true);
            owner.setDefaultCloseOperation(EXIT_ON_CLOSE);
            owner.pack();
            owner.autoLocate();
            owner.setVisible(true);
            owner.setResizable(false);
        }
        else {
            System.out.println("Goodbye " + System.getProperty("user.name"));
            System.exit(0);
        }
    }
}
