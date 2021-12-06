package model;

import controller.GameBoardController;
import view.GameFrameView;
import view.GameBoardView;


public class GameFrameModel {
    private GameBoardView gameBoardView;
    private GameBoardController gameBoardController;
    private final GameFrameView owner;
    private boolean gaming;

    public GameFrameModel(GameFrameView owner){
        this.owner = owner;
        gaming = false;
        createGameBoard();
    }

    public GameBoardView getGameBoardView() {
        return gameBoardView;
    }

    public boolean isGaming() {
        return gaming;
    }

    public void setGaming(boolean gaming) {
        this.gaming = gaming;
    }

    private void createGameBoard(){
        GameBoardModel gameBoardModel = new GameBoardModel(owner);
        gameBoardView = new GameBoardView();
        gameBoardController = new GameBoardController(gameBoardModel,gameBoardView);
    }

    public GameBoardController getGameBoardController() {
        return gameBoardController;
    }
}
