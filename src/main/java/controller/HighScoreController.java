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
package controller;

import model.HighScoreModel;
import view.HighScoreView;


public class HighScoreController {

    public HighScoreController() {
        HighScoreModel highScoreModel = new HighScoreModel();
        HighScoreView highScoreView = new HighScoreView();
        highScoreView.setHighScoreList(highScoreModel.getHighScoreList());
        highScoreView.displayContent();
    }
}
