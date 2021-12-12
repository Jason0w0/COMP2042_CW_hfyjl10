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

/**
 * This class generates the debug pane's view
 *
 * @author Jason
 */
public class DebugPanelView extends JPanel {
    private static final Color DEF_BKG = Color.WHITE;

    private final JButton skipLevel;
    private final JButton resetBalls;

    private final JSlider ballXSpeed;
    private final JSlider ballYSpeed;

    /**
     * This is the constructor of DebugPanelView class
     * This constructor generates the component of debug panel
     */
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

    /**
     * This method initializes the debug panel frame
     */
    private void initialize(){
        this.setBackground(DEF_BKG);
        this.setLayout(new GridLayout(2,2));
    }

    /**
     * This method generates slider to change the ball's speed
     * @return Slider
     */
    private JSlider makeSlider(){
        JSlider out = new JSlider(-10, 10);
        out.setMajorTickSpacing(1);
        out.setSnapToTicks(true);
        out.setPaintTicks(true);
        return out;
    }

    /**
     * This method gets the ball's horizontal speed
     * @return Ball's horizontal speed
     */
    public JSlider getBallXSpeed() {
        return ballXSpeed;
    }

    /**
     * This method gets the ball's vertical speed
     * @return Ball's vertical speed
     */
    public JSlider getBallYSpeed() {
        return ballYSpeed;
    }

    /**
     * This method adds skip level function to skip level button
     * @param e Action listener
     */
    public void addSkipLevelActionListener(ActionListener e){
        skipLevel.addActionListener(e);
    }

    /**
     * This method adds reset ball count function to the reset ball button
     * @param e Action listener
     */
    public void addResetBallActionListener(ActionListener e){
        resetBalls.addActionListener(e);
    }

    /**
     * This method adds change ball's horizontal speed function to the slider
     * @param e Change listener
     */
    public void addBallXSpeedChangeListener(ChangeListener e){
        ballXSpeed.addChangeListener(e);
    }

    /**
     * This method adds change ball's vertical speed function to the slider
     * @param e Change listener
     */
    public void addBallYSpeedChangeListener(ChangeListener e){
        ballYSpeed.addChangeListener(e);
    }
}
