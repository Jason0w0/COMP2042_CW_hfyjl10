package controller;

import model.GameFrameModel;
import model.HomeMenuModel;
import view.GameFrameView;
import view.HomeMenuView;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GameFrameController {
    private final GameFrameModel gameFrameModel;
    private final GameFrameView gameFrameView;

    private final HomeMenuView homeMenuView;

    public GameFrameController(GameFrameModel gameFrameModel, GameFrameView gameFrameView){
        homeMenuView = new HomeMenuView();
        HomeMenuModel homeMenuModel = new HomeMenuModel();
        new HomeMenuController(homeMenuModel, homeMenuView, this);
        this.gameFrameModel = gameFrameModel;
        this.gameFrameView = gameFrameView;
        this.gameFrameView.addGameFrameWindowFocusListener(new addWindowFocusListener());
        this.gameFrameView.addHomeMenu(homeMenuView);

    }

    class addWindowFocusListener implements WindowFocusListener {
        @Override
        public void windowGainedFocus(WindowEvent e) {
            /*
            the first time the frame loses focus is because
            it has been disposed to install the GameBoard,
            so went it regains the focus it's ready to play.
            of course calling a method such as 'onLostFocus'
            is useful only if the GameBoard as been displayed
            at least once
            */
            gameFrameModel.setGaming(true);
        }

        @Override
        public void windowLostFocus(WindowEvent e) {
            if(gameFrameModel.isGaming())
                gameFrameModel.getGameBoardController().onLostFocus();
        }
    }

    public void initialize(){
        gameFrameView.setTitle(gameFrameView.getDefTitle());
        gameFrameView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrameView.pack();
        gameFrameView.autoLocate();
        gameFrameView.setVisible(true);
        gameFrameView.setResizable(false);
    }

    public void enableGameBoard(){
        gameFrameView.dispose();
        gameFrameView.remove(homeMenuView);
        gameFrameView.add(gameFrameModel.getGameBoardView(), BorderLayout.CENTER);
        gameFrameView.setUndecorated(false);
        initialize();
    }
}
