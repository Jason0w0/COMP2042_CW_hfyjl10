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
package HomeMenu;

/**
 * This class generates home menu's model
 *
 * @author Jason
 */
public class HomeMenuModel {
    private boolean startClicked;
    private boolean menuClicked;
    private boolean infoClicked;
    private boolean highScoreClicked;

    /**
     * This is the constructor of HomeMenuModel class
     */
    public HomeMenuModel() {}

    /**
     * This method gets startClicked variable
     * @return StartClicked variable
     */
    public boolean isStartClicked() {
        return startClicked;
    }

    /**
     * This method sets startClicked variable
     * @param startClicked Boolean StartClicked
     */
    public void setStartClicked(boolean startClicked) {
        this.startClicked = startClicked;
    }

    /**
     * This method gets menuClicked variable
     * @return MenuClicked variable
     */
    public boolean isMenuClicked() {
        return menuClicked;
    }

    /**
     * This method sets menuClicked variable
     * @param menuClicked MenuClicked variable
     */
    public void setMenuClicked(boolean menuClicked) {
        this.menuClicked = menuClicked;
    }

    /**
     * This method gets infoClicked variable
     * @return InfoClicked variable
     */
    public boolean isInfoClicked() {
        return infoClicked;
    }

    /**
     * This method sets infoClicked variable
     * @param infoClicked Boolean Info Clicked
     */
    public void setInfoClicked(boolean infoClicked) {
        this.infoClicked = infoClicked;
    }

    /**
     * This method gets highScoreClicked variable
     * @return HighScoreClicked variable
     */
    public boolean isHighScoreClicked() {
        return highScoreClicked;
    }

    /**
     * This method sets highScoreClicked variable
     * @param highScoreClicked Boolean HighScoreClicked
     */
    public void setHighScoreClicked(boolean highScoreClicked) {
        this.highScoreClicked = highScoreClicked;
    }
}
