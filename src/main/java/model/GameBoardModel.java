package model;

import controller.DebugConsoleController;
import test.GameBoard;
import test.Stage;
import view.DebugConsoleView;

import javax.swing.*;
import java.awt.*;

public class GameBoardModel {

    private static  int DEF_WIDTH = 600;
    private static  int DEF_HEIGHT = 450;

    private Stage stage;
    private boolean showPauseMenu;
//    private String message;

    private DebugConsoleView debugConsoleView;
    private DebugConsoleController debugConsoleController;
    private DebugConsoleModel debugConsoleModel;

    private GameTimer gameTimer;
    private JFrame owner;


    public GameBoardModel(JFrame owner) {
        this.owner = owner;
        showPauseMenu = false;
//        message = "";
    }

    public Stage getStage() {
        return stage;
    }

//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

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
        stage = new Stage(new Rectangle(0,0,DEF_WIDTH,DEF_HEIGHT),30,3,6/2,new Point(300,430));
        //initialize the first level
        stage.nextLevel();
    }

    public void createDebugConsole(GameBoard gameBoardView){
        debugConsoleModel = new DebugConsoleModel(owner, stage,gameBoardView);
        debugConsoleView = new DebugConsoleView();
        debugConsoleController = new DebugConsoleController(debugConsoleModel, debugConsoleView);
    }

    public void gameLoop(GameBoard gameBoardView){
        gameTimer = new GameTimer(gameBoardView, stage);
//        gameTimer = new Timer(10,e ->{
//            stage.move();
//            stage.findImpacts();
//            message = String.format("Bricks: %d Balls %d", stage.getBrickCount(), stage.getBallCount());
//            if(stage.isBallLost()){
//                if(stage.ballEnd()){
//                    stage.wallReset();
//                    message = "Game over";
//                }
//                stage.ballReset();
//                stage.playerReset();
//                gameTimer.stop();
//            }
//            else if(stage.isDone()){
//                if(stage.hasLevel()){
//                    message = "Go to Next Level";
//                    gameTimer.stop();
//                    stage.ballReset();
//                    stage.playerReset();
//                    stage.wallReset();
//                    stage.nextLevel();
//                }
//                else{
//                    message = "ALL WALLS DESTROYED";
//                    gameTimer.stop();
//                }
//            }
//
//            gameBoardView.repaint();
//        });
    }
}
