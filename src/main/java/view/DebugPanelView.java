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
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;


public class DebugPanelView extends JPanel {

    private static final Color DEF_BKG = Color.WHITE;

    private final JButton skipLevel;
    private final JButton resetBalls;

    private final JSlider ballXSpeed;
    private final JSlider ballYSpeed;

    public DebugPanelView(){

        initialize();

        skipLevel = new JButton("Skip Level");
        resetBalls = new JButton("Reset Balls");

        ballXSpeed = makeSlider();
        ballYSpeed = makeSlider();

        this.add(skipLevel);
        this.add(resetBalls);

        this.add(ballXSpeed);
        this.add(ballYSpeed);

    }

    private void initialize(){
        this.setBackground(DEF_BKG);
        this.setLayout(new GridLayout(2,2));
    }

    private JSlider makeSlider(){
        JSlider out = new JSlider(-10, 10);
        out.setMajorTickSpacing(1);
        out.setSnapToTicks(true);
        out.setPaintTicks(true);
        return out;
    }

    public JSlider getBallXSpeed() {
        return ballXSpeed;
    }

    public JSlider getBallYSpeed() {
        return ballYSpeed;
    }

    public void addSkipLevelActionListener(ActionListener e){
        skipLevel.addActionListener(e);
    }

    public void addResetBallActionListener(ActionListener e){
        resetBalls.addActionListener(e);
    }

    public void addBallXSpeedChangeListener(ChangeListener e){
        ballXSpeed.addChangeListener(e);
    }

    public void addBallYSpeedChangeListener(ChangeListener e){
        ballYSpeed.addChangeListener(e);
    }
}
