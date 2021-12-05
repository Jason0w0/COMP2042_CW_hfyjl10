package controller;

import model.HomeMenuModel;
import view.HomeMenuView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class HomeMenuController implements MouseListener, MouseMotionListener {

    private HomeMenuModel homeMenuModel;
    private HomeMenuView homeMenuView;
    private Rectangle startButton;
    private Rectangle menuButton;

    public HomeMenuController(HomeMenuModel homeMenuModel, HomeMenuView homeMenuView){
        this.homeMenuModel = homeMenuModel;
        this.homeMenuView = homeMenuView;
        this.homeMenuView.addMouseListener(this);
        this.homeMenuView.addMouseMotionListener(this);
        startButton = this.homeMenuView.getStartButton();
        menuButton = this.homeMenuView.getMenuButton();
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
        if(homeMenuView.getStartButton().contains(p) || homeMenuView.getMenuButton().contains(p))
            homeMenuView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        else
            homeMenuView.setCursor(Cursor.getDefaultCursor());
    }
}