package model;

import controller.DebugPanelController;
import view.GameBoardView;
import test.Stage;
import view.DebugPanelView;

import javax.swing.*;

public class DebugConsoleModel {

    private final JFrame owner;
    private final GameBoardView gameBoardView;
    private final Stage stage;

    private final DebugPanelView debugPanelView;
    private final DebugPanelController debugPanelController;

    public DebugConsoleModel(JFrame owner, Stage stage, GameBoardView gameBoardView){
        this.stage = stage;
        this.owner = owner;
        this.gameBoardView = gameBoardView;

        debugPanelView = new DebugPanelView();
        DebugPanelModel debugPanelModel = new DebugPanelModel();
        debugPanelController = new DebugPanelController(debugPanelModel, debugPanelView, stage);

    }

    public JFrame getOwner() {
        return owner;
    }

    public Stage getStage() {
        return stage;
    }

    public DebugPanelView getDebugPanelView() {
        return debugPanelView;
    }

    public GameBoardView getGameBoard() {
        return gameBoardView;
    }

    public DebugPanelController getDebugPanelController() {
        return debugPanelController;
    }
}
