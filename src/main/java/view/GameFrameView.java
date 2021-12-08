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
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowFocusListener;


public class GameFrameView extends JFrame {

    public GameFrameView(){
        super();
        this.setLayout(new BorderLayout());
    }

    public void addHomeMenu(HomeMenuView homeMenuView){
        this.add(homeMenuView,BorderLayout.CENTER);
        this.setUndecorated(true);
    }

    public void autoLocate(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - this.getWidth()) / 2;
        int y = (size.height - this.getHeight()) / 2;
        this.setLocation(x,y);
    }

    public void addGameFrameWindowFocusListener(WindowFocusListener e){
        this.addWindowFocusListener(e);
    }
}
