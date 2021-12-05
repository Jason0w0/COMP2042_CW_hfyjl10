package controller;

import model.DebugConsoleModel;
import test.Ball;
import view.DebugConsoleView;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DebugConsoleController {
    private final DebugConsoleModel debugConsoleModel;
    private final DebugConsoleView debugConsoleView;

    public DebugConsoleController(DebugConsoleModel debugConsoleModel, DebugConsoleView debugConsoleView){
        this.debugConsoleModel = debugConsoleModel;
        this.debugConsoleView = debugConsoleView;
        this.debugConsoleView.setOwner(this.debugConsoleModel.getOwner());
        this.debugConsoleView.setDebugPanelView(this.debugConsoleModel.getDebugPanelView());
        this.debugConsoleView.addConsoleWindowListener(new ConsoleWindowListener());
    }


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
            Ball b = debugConsoleModel.getStage().getBall();
            debugConsoleModel.getDebugPanelController().setValues(b.getSpeedX(),b.getSpeedY());
        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}
