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

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * This class generates the controller for debug console
 *
 * @author Jason
 */
public class DebugConsoleController {
    private final DebugConsoleModel debugConsoleModel;
    private final DebugConsoleView debugConsoleView;

    /**
     * This is the constructor of class DebugConsoleController
     * @param debugConsoleModel Debug console model
     * @param debugConsoleView Debug console view
     */
    public DebugConsoleController(DebugConsoleModel debugConsoleModel, DebugConsoleView debugConsoleView){
        this.debugConsoleModel = debugConsoleModel;
        this.debugConsoleView = debugConsoleView;
        this.debugConsoleView.setOwner(this.debugConsoleModel.getOwner());
        this.debugConsoleView.setDebugPanelView(this.debugConsoleModel.getDebugPanelView());
        this.debugConsoleView.addConsoleWindowListener(new ConsoleWindowListener());
    }

    /**
     * This class generates WindowListener fucntion
     */
    class ConsoleWindowListener implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            debugConsoleModel.getGameBoard().repaint();
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {
            debugConsoleView.setLocation();
        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}
