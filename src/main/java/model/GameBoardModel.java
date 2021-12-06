package model;

import controller.DebugConsoleController;
import view.GameBoardView;
import test.Stage;
import view.DebugConsoleView;

import javax.swing.*;
import java.awt.*;

public class GameBoardModel {

    private Stage stage;
    private DebugConsoleView debugConsoleView;
    private GameTimer gameTimer;
    private final JFrame owner;

    private boolean showPauseMenu;


    public GameBoardModel(JFrame owner) {
        this.owner = owner;
        showPauseMenu = false;
    }

    public Stage getStage() {
        return stage;
    }

    public Timer getGameTimer() {
        return gameTimer.getGameTimer();
    }

    public DebugConsoleView getDebugConsoleView() {
        return debugConsoleView;
    }

    public boolean isShowPauseMenu() {
        return showPauseMenu;
    }

    public void setShowPauseMenu(boolean showPauseMenu) {
        this.showPauseMenu = showPauseMenu;
    }

    public void createStage(){
        stage = new Stage(new Rectangle(0,0, 600, 450),30,3,3,new Point(300,430));
        //initialize the first level
        stage.nextLevel();
    }

    public void createDebugConsole(GameBoardView gameBoardView){
        DebugConsoleModel debugConsoleModel = new DebugConsoleModel(owner, stage, gameBoardView);
        debugConsoleView = new DebugConsoleView();
        new DebugConsoleController(debugConsoleModel, debugConsoleView);
    }

    public void gameLoop(GameBoardView gameBoardView){
        gameTimer = new GameTimer(gameBoardView, stage);
    }
}
