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
package DebugPanel;

import Stage.Stage;

/**
 * This class generates the debug panel's model
 *
 * @author Jason
 */
public class DebugPanelModel {
    private Stage stage;

    /**
     * This is the constructor of DebugPanelModel class
     */
    public DebugPanelModel() {
    }

    /**
     * This method gets the stage variable
     * @return Stage class
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * This method sets the Stage variable
     * @param stage Stage class
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
