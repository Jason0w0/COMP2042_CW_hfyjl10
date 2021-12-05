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
import java.awt.event.WindowListener;

public class DebugConsoleView extends JDialog {

    private static final String TITLE = "Debug Console";

    private JFrame owner;

    public DebugConsoleView(){
        initialize();
    }

    private void initialize(){
        this.setModal(true);
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setFocusable(true);
    }

    public void addConsoleWindowListener(WindowListener e){
        this.addWindowListener(e);
    }

    public void setOwner(JFrame owner) {
        this.owner = owner;
    }

    public void setDebugPanelView(DebugPanelView debugPanelView) {
        this.add(debugPanelView,BorderLayout.CENTER);
        this.pack();
    }

    public void setLocation(){
        int x = ((owner.getWidth() - this.getWidth()) / 2) + owner.getX();
        int y = ((owner.getHeight() - this.getHeight()) / 2) + owner.getY();
        this.setLocation(x,y);
    }

}
