package controller;

import model.DebugPanelModel;
import view.DebugPanelView;
import test.Wall;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DebugPanelController {

    private final DebugPanelModel debugPanelModel;
    private final DebugPanelView debugPanelView;

    public DebugPanelController(DebugPanelModel debugPanelModel, DebugPanelView debugPanelView, Wall wall){
        this.debugPanelModel = debugPanelModel;
        this.debugPanelView = debugPanelView;
        this.debugPanelModel.setWall(wall);
        this.debugPanelView.addSkipLevelActionListener(new SkipLevelListener());
        this.debugPanelView.addResetBallActionListener(new ResetLevelListener());
        this.debugPanelView.addBallXSpeedChangeListener(new BallXSpeedChangeListener());
        this.debugPanelView.addBallYSpeedChangeListener(new BallYSpeedChangeListener());
    }

    public void setValues(int x,int y){
        debugPanelView.getBallXSpeed().setValue(x);
        debugPanelView.getBallYSpeed().setValue(y);
    }

    class SkipLevelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            debugPanelModel.getWall().nextLevel();
        }
    }

    class ResetLevelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            debugPanelModel.getWall().resetBallCount();
        }
    }

    class BallXSpeedChangeListener implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            debugPanelModel.getWall().setBallXSpeed(debugPanelView.getBallXSpeed().getValue());
        }
    }

    class BallYSpeedChangeListener implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            debugPanelModel.getWall().setBallYSpeed(debugPanelView.getBallYSpeed().getValue());
        }
    }
}
