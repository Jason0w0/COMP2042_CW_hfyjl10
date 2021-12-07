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

public class HomeMenuModel {

    private boolean startClicked;
    private boolean menuClicked;
    private boolean infoClicked;
    private boolean highScoreClicked;

    public HomeMenuModel() {}

    public boolean isStartClicked() {
        return startClicked;
    }

    public void setStartClicked(boolean startClicked) {
        this.startClicked = startClicked;
    }

    public boolean isMenuClicked() {
        return menuClicked;
    }

    public void setMenuClicked(boolean menuClicked) {
        this.menuClicked = menuClicked;
    }

    public boolean isInfoClicked() {
        return infoClicked;
    }

    public void setInfoClicked(boolean infoClicked) {
        this.infoClicked = infoClicked;
    }

    public boolean isHighScoreClicked() {
        return highScoreClicked;
    }

    public void setHighScoreClicked(boolean highScoreClicked) {
        this.highScoreClicked = highScoreClicked;
    }
}
