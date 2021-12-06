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

import model.HomeMenuModel;
import view.HomeMenuView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class HomeMenuController implements MouseListener, MouseMotionListener {

    private final HomeMenuModel homeMenuModel;
    private final HomeMenuView homeMenuView;
    private final Rectangle startButton;
    private final Rectangle menuButton;
    private final Rectangle infoButton;

    public HomeMenuController(HomeMenuModel homeMenuModel, HomeMenuView homeMenuView, GameFrameController owner){
        this.homeMenuModel = homeMenuModel;
        this.homeMenuView = homeMenuView;
        this.homeMenuView.addMouseListener(this);
        this.homeMenuView.addMouseMotionListener(this);
        startButton = this.homeMenuView.getStartButton();
        menuButton = this.homeMenuView.getMenuButton();
        infoButton = this.homeMenuView.getInfoButton();
        homeMenuView.setOwner(owner);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();

        if(homeMenuView.getStartButton().contains(p)){
            homeMenuView.getOwner().enableGameBoard();

        }
        else if(homeMenuView.getMenuButton().contains(p)){
            System.out.println("Goodbye " + System.getProperty("user.name"));
            System.exit(0);
        }
        else if(homeMenuView.getInfoButton().contains(p)){

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        if(homeMenuView.getStartButton().contains(p)){
            homeMenuModel.setStartClicked(true);
            homeMenuView.setStartClicked(homeMenuModel.isStartClicked());
            homeMenuView.repaint(startButton.x,startButton.y,startButton.width+1,startButton.height+1);

        }
        else if(homeMenuView.getMenuButton().contains(p)){
            homeMenuModel.setMenuClicked(true);
            homeMenuView.setMenuClicked(homeMenuModel.isMenuClicked());
            homeMenuView.repaint(menuButton.x,menuButton.y,menuButton.width+1,menuButton.height+1);
        }
        else if(homeMenuView.getInfoButton().contains(p)){
            homeMenuModel.setInfoClicked(true);
            homeMenuView.setInfoClicked(homeMenuModel.isInfoClicked());
            homeMenuView.repaint(infoButton.x,infoButton.y,infoButton.width+1,infoButton.height+1);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(homeMenuModel.isStartClicked()){
            homeMenuModel.setStartClicked(false);
            homeMenuView.setStartClicked(homeMenuModel.isStartClicked());
            homeMenuView.repaint(startButton.x,startButton.y,startButton.width+1,startButton.height+1);
        }
        else if(homeMenuModel.isMenuClicked()){
            homeMenuModel.setMenuClicked(false);
            homeMenuView.setMenuClicked(homeMenuModel.isMenuClicked());
            homeMenuView.repaint(menuButton.x,menuButton.y,menuButton.width+1,menuButton.height+1);
        }
        else if(homeMenuModel.isInfoClicked()){
            homeMenuModel.setInfoClicked(false);
            homeMenuView.setInfoClicked(homeMenuModel.isInfoClicked());
            homeMenuView.repaint(infoButton.x,infoButton.y,infoButton.width+1,infoButton.height+1);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        if(homeMenuView.getStartButton().contains(p) || homeMenuView.getMenuButton().contains(p) || homeMenuView.getInfoButton().contains(p))
            homeMenuView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        else
            homeMenuView.setCursor(Cursor.getDefaultCursor());
    }
}
