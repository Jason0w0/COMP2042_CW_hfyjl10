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
package GameBoard;

import Ball.Ball;
import Player.Player;
import Bricks.Brick;
import Stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;

/**
 * This class is the game board's view
 *
 * @author Jason
 */
public class GameBoardView extends JComponent {
    private static final String CONTINUE = "Continue";
    private static final String RESTART = "Restart";
    private static final String EXIT = "Quit";
    private static final String PAUSE = "Pause Menu";
    private static final int TEXT_SIZE = 30;
    private static final Color MENU_COLOR = new Color(0,255,0);
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;
    private static final Color BG_COLOR = Color.WHITE;
    private final Font menuFont;

    private Stage stage;
    private String message;
    private String scoreBoard;
    private boolean showPauseMenu;

    private Rectangle continueButtonRect;
    private Rectangle exitButtonRect;
    private Rectangle restartButtonRect;
    private int strLen;

    /**
     * This is class GameBoardView's constructor
     */
    public GameBoardView(){
        super();
        strLen = 0;
        setMessage("");
        setScoreBoard("");
        menuFont = new Font("Monospaced",Font.PLAIN,TEXT_SIZE);
        this.initialize();
    }

    /**
     * This method gets the Continue Button
     * @return Continue button
     */
    public Rectangle getContinueButtonRect() {
        return continueButtonRect;
    }

    /**
     * This method gets the Exit Button
     * @return Exit button
     */
    public Rectangle getExitButtonRect() {
        return exitButtonRect;
    }

    /**
     * This method gets the Restart Button
     * @return Restart button
     */
    public Rectangle getRestartButtonRect() {
        return restartButtonRect;
    }

    /**
     * This method sets the game level
     * @param stage Game level
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * This method initializes the screen
     */
    private void initialize(){
        this.setPreferredSize(new Dimension(DEF_WIDTH,DEF_HEIGHT));
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    /**
     * This method adds KeyListener to the screen
     * @param e KeyListener
     */
    public void addGameBoardKeyListener( KeyListener e){
        this.addKeyListener(e);
    }

    /**
     * This method adds MouseListener to the screen
     * @param e MouseListener
     */
    public void addGameBoardMouseListener(MouseListener e){
        this.addMouseListener(e);
    }

    /**
     * This method adds MouseMotionListener to the screen
     * @param e MouseMotionListener
     */
    public void addGameBoardMouseMotionListener(MouseMotionListener e){
        this.addMouseMotionListener(e);
    }

    /**
     * This method overrides the paint method from JComponent
     * @param g Graphics
     */
    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;

        clear(g2d);

        g2d.setColor(Color.BLUE);
        g2d.drawString(message, 230,225);
        g2d.drawString(scoreBoard,230,250);

        drawBall(stage.getBall(),g2d);

        for(Brick b : stage.getBricks())
            if(!b.isBroken())
                drawBrick(b,g2d);

        drawPlayer(stage.getPlayer(),g2d);

        if(showPauseMenu)
            drawMenu(g2d);

        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * This method sets the showPauseMenu variable
     * @param showPauseMenu ShowPauseMenu variable
     */
    public void setShowPauseMenu(Boolean showPauseMenu){
        this.showPauseMenu = showPauseMenu;
    }

    /**
     * This method set the message to be displayed
     * @param message String to be displayed
     */
    public void setMessage(String message){
        this.message = message;
    }

    /**
     * This method set the score
     * @param score Score
     */
    public void setScoreBoard(String score){
        this.scoreBoard = score;
    }

    /**
     * This method clears the background
     * @param g2d Graphics2D
     */
    private void clear(Graphics2D g2d){
        Color tmp = g2d.getColor();
        g2d.setColor(BG_COLOR);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setColor(tmp);
    }

    /**
     * This method displayes the brick
     * @param brick Brick
     * @param g2d Graphics2D
     */
    private void drawBrick(Brick brick,Graphics2D g2d){
        Color tmp = g2d.getColor();

        g2d.setColor(brick.getInnerColor());
        g2d.fill(brick.getBrick());

        g2d.setColor(brick.getBorderColor());
        g2d.draw(brick.getBrick());


        g2d.setColor(tmp);
    }

    /**
     * This method displays the ball
     * @param ball Ball
     * @param g2d Graphics2D
     */
    private void drawBall(Ball ball, Graphics2D g2d){
        Color tmp = g2d.getColor();

        Shape s = ball.getBallFace();

        g2d.setColor(ball.getInnerColor());
        g2d.fill(s);

        g2d.setColor(ball.getBorderColor());
        g2d.draw(s);

        g2d.setColor(tmp);
    }

    /**
     * This method displays the player
     * @param p Player
     * @param g2d Graphics
     */
    private void drawPlayer(Player p, Graphics2D g2d){
        Color tmp = g2d.getColor();

        Shape s = p.getPlayerFace();
        g2d.setColor(p.getINNER_COLOR());
        g2d.fill(s);

        g2d.setColor(p.getBORDER_COLOR());
        g2d.draw(s);

        g2d.setColor(tmp);
    }

    /**
     * This method displays the pause menu
     * @param g2d Graphic2D
     */
    private void drawMenu(Graphics2D g2d){
        obscureGameBoard(g2d);
        drawPauseMenu(g2d);
    }

    /**
     * This method generates background to blur the game when pause menu is displayed
     * @param g2d Graphics2D
     */
    private void obscureGameBoard(Graphics2D g2d){

        Composite tmp = g2d.getComposite();
        Color tmpColor = g2d.getColor();

        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.55f);
        g2d.setComposite(ac);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,DEF_WIDTH,DEF_HEIGHT);

        g2d.setComposite(tmp);
        g2d.setColor(tmpColor);
    }

    /**
     * This method generates the pause menu
     * @param g2d Graphics2D
     */
    private void drawPauseMenu(Graphics2D g2d){
        Font tmpFont = g2d.getFont();
        Color tmpColor = g2d.getColor();


        g2d.setFont(menuFont);
        g2d.setColor(MENU_COLOR);

        if(strLen == 0){
            FontRenderContext frc = g2d.getFontRenderContext();
            strLen = menuFont.getStringBounds(PAUSE,frc).getBounds().width;
        }

        int x = (this.getWidth() - strLen) / 2;
        int y = this.getHeight() / 10;

        g2d.drawString(PAUSE,x,y);

        x = this.getWidth() / 8;
        y = this.getHeight() / 4;


        if(continueButtonRect == null){
            FontRenderContext frc = g2d.getFontRenderContext();
            continueButtonRect = menuFont.getStringBounds(CONTINUE,frc).getBounds();
            continueButtonRect.setLocation(x,y-continueButtonRect.height);
        }

        g2d.drawString(CONTINUE,x,y);

        y *= 2;

        if(restartButtonRect == null){
            restartButtonRect = (Rectangle) continueButtonRect.clone();
            restartButtonRect.setLocation(x,y-restartButtonRect.height);
        }

        g2d.drawString(RESTART,x,y);

        y *= 3.0/2;

        if(exitButtonRect == null){
            exitButtonRect = (Rectangle) continueButtonRect.clone();
            exitButtonRect.setLocation(x,y-exitButtonRect.height);
        }

        g2d.drawString(EXIT,x,y);



        g2d.setFont(tmpFont);
        g2d.setColor(tmpColor);
    }
}
