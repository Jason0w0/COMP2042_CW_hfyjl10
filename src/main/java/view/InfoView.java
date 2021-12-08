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
package view;

import javax.swing.*;


public class InfoView {

    public InfoView(){
        JOptionPane.showMessageDialog(null,getMessage(),"INFO",JOptionPane.PLAIN_MESSAGE);
    }

    private String getMessage(){
        return """
                WELCOME GAMER,
                This is a simple and fun brick destroying game.
                Here are the instruction to play this game.
                Press and hold A key to move left.
                Press and hold D key to move right.
                Press SPACE to start, pause and unpause.
                Clearing the stage will no ball lost will gain a reward.
                Clearing the stage will only 1 ball left will result in penalty.
                All right you are good to go.
                Have Fun!
                This game is modified by Lee Jason, 20184290, for coursework purpose :)
                """;
    }
}
