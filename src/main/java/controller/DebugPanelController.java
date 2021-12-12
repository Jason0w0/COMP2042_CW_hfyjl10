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

import model.DebugPanelModel;
import view.DebugPanelView;
import model.Stage;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class generates the debug panel's controller
 *
 * @author Jason
 */
public class DebugPanelController {
    private final DebugPanelModel debugPanelModel;
    private final DebugPanelView debugPanelView;

    /**
     * This is the constructor of class DebugPanelController
     * @param debugPanelModel Debug panel's model
     * @param debugPanelView Debug panel's view
     * @param stage Stage class
     */
    public DebugPanelController(DebugPanelModel debugPanelModel, DebugPanelView debugPanelView, Stage stage){
        this.debugPanelModel = debugPanelModel;
        this.debugPanelView = debugPanelView;
        this.debugPanelModel.setStage(stage);
        this.debugPanelView.addSkipLevelActionListener(new SkipLevelListener());
        this.debugPanelView.addResetBallActionListener(new ResetLevelListener());
        this.debugPanelView.addBallXSpeedChangeListener(new BallXSpeedChangeListener());
        this.debugPanelView.addBallYSpeedChangeListener(new BallYSpeedChangeListener());
    }

    /**
     * This class generates the action listener to skip class
     */
    class SkipLevelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            debugPanelModel.getStage().nextLevel();
        }
    }

    /**
     * This class generates the action listener to reset ball count
     */
    class ResetLevelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            debugPanelModel.getStage().resetBallCount();
        }
    }

    /**
     * This class generates the action listener to change ball's horizontal speed
     */
    class BallXSpeedChangeListener implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            debugPanelModel.getStage().setBallXSpeed(debugPanelView.getBallXSpeed().getValue());
        }
    }

    /**
     * This class generates the action listener to change ball's vertical speed
     */
    class BallYSpeedChangeListener implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            debugPanelModel.getStage().setBallYSpeed(debugPanelView.getBallYSpeed().getValue());
        }
    }
}
