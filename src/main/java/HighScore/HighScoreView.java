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
package HighScore;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class generates the high score
 */
public class HighScoreView {
    private ArrayList<Integer> highScoreList;

    /**
     * This is the constructor of class HighScoreView
     */
    public HighScoreView () {

    }

    /**
     * This method creates the high score panel
     */
    public void displayContent () {
        JOptionPane.showMessageDialog(null,getMessage(),"HIGHSCORE",JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * This method generates the high score list
     * @return high score list
     */
    private String getMessage() {
        StringBuilder message = new StringBuilder();
        for (int i=0;i<highScoreList.size();i++){
            if (i == 5)
                break;
            message.append(String.format("%d. %d\n", i + 1, highScoreList.get(i)));
        }
        return message.toString();
    }

    /**
     * This method sets the high score list values
     * @param highScoreList High score list values
     */
    public void setHighScoreList(ArrayList<Integer> highScoreList) {this.highScoreList = highScoreList;}
}
