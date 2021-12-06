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

import model.GameBoardModel;
import view.GameBoardView;

import java.awt.*;
import java.awt.event.*;

public class GameBoardController {
    private final GameBoardModel gameBoardModel;
    private final GameBoardView gameBoardView;

    public GameBoardController(GameBoardModel gameBoardModel, GameBoardView gameBoardView){
        this.gameBoardModel = gameBoardModel;
        this.gameBoardView = gameBoardView;
        this.gameBoardView.addGameBoardKeyListener(new addKeyListener());
        this.gameBoardView.addGameBoardMouseListener(new addMouseListener());
        this.gameBoardView.addGameBoardMouseMotionListener(new addMouseMotionListener());
        this.gameBoardModel.createStage();
        this.gameBoardModel.createDebugConsole(gameBoardView);
        this.gameBoardModel.gameLoop(gameBoardView);
        this.gameBoardView.setStage(gameBoardModel.getStage());
        this.gameBoardView.getShowPauseMenu(gameBoardModel.isShowPauseMenu());
    }

    public void onLostFocus(){
        gameBoardModel.getGameTimer().stop();
        gameBoardView.setMessage("Focus Lost");
        gameBoardView.repaint();
    }

    class addKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_A:
                    gameBoardModel.getStage().getPlayer().moveLeft();
                    break;
                case KeyEvent.VK_D:
                    gameBoardModel.getStage().getPlayer().movRight();
                    break;
                case KeyEvent.VK_ESCAPE:
                    gameBoardModel.setShowPauseMenu(!gameBoardModel.isShowPauseMenu());
                    gameBoardView.repaint();
                    gameBoardModel.getGameTimer().stop();
                    break;
                case KeyEvent.VK_SPACE:
                    if(!gameBoardModel.isShowPauseMenu())
                        if(gameBoardModel.getGameTimer().isRunning())
                            gameBoardModel.getGameTimer().stop();
                        else
                            gameBoardModel.getGameTimer().start();
                    break;
                case KeyEvent.VK_F1:
                    if(e.isAltDown() && e.isShiftDown())
                        gameBoardModel.getDebugConsoleView().setVisible(true);
                default:
                    gameBoardModel.getStage().getPlayer().stop();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            gameBoardModel.getStage().getPlayer().stop();
        }
    }

    class addMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint();
            if(!gameBoardModel.isShowPauseMenu())
                return;
            if(gameBoardView.getContinueButtonRect().contains(p)){
                gameBoardModel.setShowPauseMenu(false);
                gameBoardView.repaint();
            }
            else if(gameBoardView.getRestartButtonRect().contains(p)){
                gameBoardView.setMessage("Restarting Game...");
                gameBoardModel.getStage().ballReset();
                gameBoardModel.getStage().wallReset();
                gameBoardModel.setShowPauseMenu(false);
                gameBoardView.repaint();
            }
            else if(gameBoardView.getExitButtonRect().contains(p)){
                System.exit(0);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class addMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            Point p = e.getPoint();
            if(gameBoardView.getExitButtonRect() != null && gameBoardModel.isShowPauseMenu()) {
                if (gameBoardView.getExitButtonRect().contains(p) || gameBoardView.getContinueButtonRect().contains(p) || gameBoardView.getRestartButtonRect().contains(p))
                    gameBoardView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                else
                    gameBoardView.setCursor(Cursor.getDefaultCursor());
            }
            else{
                gameBoardView.setCursor(Cursor.getDefaultCursor());
            }
        }
    }
}
