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
package GameFrame;

import HomeMenu.HomeMenuView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowFocusListener;
import java.io.File;
import java.io.IOException;

/**
 * This class generates the game frame's view
 *
 * @author Jason
 */
public class GameFrameView extends JFrame {
    /**
     * This is the constructor of GameFrameViewClass
     */
    public GameFrameView(){
        super();
        this.setLayout(new BorderLayout());
        addIconImage();
    }

    /**
     * This method adds an icon image
     */
    private void addIconImage() {
        try {
            this.setIconImage(ImageIO.read(new File("src/main/resources/brick-destroyer-img-resized.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method adds a home menu to the screen
     * @param homeMenuView home menu
     */
    public void addHomeMenu(HomeMenuView homeMenuView){
        this.add(homeMenuView,BorderLayout.CENTER);
        this.setUndecorated(true);
    }

    /**
     * This method sets the location of the screen
     */
    public void autoLocate(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - this.getWidth()) / 2;
        int y = (size.height - this.getHeight()) / 2;
        this.setLocation(x,y);
    }

    /**
     * This method adds WindowFocusListener to current screen
     * @param e WindowFocusListener
     */
    public void addGameFrameWindowFocusListener(WindowFocusListener e){
        this.addWindowFocusListener(e);
    }
}
