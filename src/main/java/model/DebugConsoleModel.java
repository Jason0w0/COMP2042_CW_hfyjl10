package model;

import controller.DebugPanelController;
import test.GameBoard;
import test.Stage;
import view.DebugPanelView;

import javax.swing.*;

public class DebugConsoleModel {

    private final JFrame owner;
    private final GameBoard gameBoard;
    private final Stage stage;

    private final DebugPanelView debugPanelView;
    private final DebugPanelController debugPanelController;

    public DebugConsoleModel(JFrame owner, Stage stage, GameBoard gameBoard){
        this.stage = stage;
        this.owner = owner;
        this.gameBoard = gameBoard;

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

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public DebugPanelController getDebugPanelController() {
        return debugPanelController;
    }
}
