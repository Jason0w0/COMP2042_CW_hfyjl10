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
package HomeMenu;

import GameFrame.GameFrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * This class generates home menu's view
 *
 * @author Jason
 */
public class HomeMenuView extends JComponent {
    private static final String GREETINGS = "Welcome to:";
    private static final String GAME_TITLE = "Brick Destroy";
    private static final String CREDITS = "Version 0.1";
    private static final String START_TEXT = "Start";
    private static final String EXIT_TEXT = "Exit";
    private static final String INFO_TEXT = "Info";
    private static final String HIGHSCORE_TEXT = "HighScore";

    private static final Color TEXT_COLOR = Color.BLACK;
    private static final Color CLICKED_BUTTON_COLOR = Color.LIGHT_GRAY;
    private static final Color CLICKED_TEXT = Color.lightGray;

    private Rectangle menuFace;
    private Rectangle startButton;
    private Rectangle exitButton;
    private Rectangle infoButton;
    private Rectangle highScoreButton;

    private Font greetingsFont;
    private Font gameTitleFont;
    private Font creditsFont;
    private Font buttonFont;

    private GameFrameController owner;

    private boolean startClicked;
    private boolean exitClicked;
    private boolean infoClicked;
    private boolean highScoreClicked;

    /**
     * This is the constructor of HomeMenuView class
     */
    public HomeMenuView() {
        Dimension area = new Dimension(450, 300);
        Dimension btnDim = new Dimension(area.width / 3, area.height / 12);
        initialize(area);
        setInterface(btnDim, area);
        setFont();
    }

    /**
     * This method initializes the home menu screen
     * @param area Size of screen
     */
    private void initialize(Dimension area) {
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(area);
    }

    /**
     * This method creates the interface component of home menu screen
     * @param btnDim Button size
     * @param area Size of home menu
     */
    private void setInterface(Dimension btnDim, Dimension area) {
        menuFace = new Rectangle(new Point(0, 0), area);
        startButton = new Rectangle(btnDim);
        exitButton = new Rectangle(btnDim);
        infoButton = new Rectangle(btnDim);
        highScoreButton = new Rectangle(btnDim);
    }

    /**
     * This method sets the owner variable
     * @param owner Game frame's controller
     */
    public void setOwner(GameFrameController owner) {
        this.owner = owner;
    }

    /**
     * This method gets the owner variable
     * @return Game frame's controller
     */
    public GameFrameController getOwner() {
        return owner;
    }

    /**
     * This method gets the start button
     * @return Start button
     */
    public Rectangle getStartButton() {
        return startButton;
    }

    /**
     * This method gets the exit button
     * @return Exit button
     */
    public Rectangle getMenuButton() {
        return exitButton;
    }

    /**
     * This method gets the info button
     * @return Info button
     */
    public Rectangle getInfoButton() {
        return infoButton;
    }

    /**
     * This method gets the high score button
     * @return High score button
     */
    public Rectangle getHighScoreButton() {
        return highScoreButton;
    }

    /**
     * This method sets the startClicked variable
     * @param startClicked Boolean startClicked variable
     */
    public void setStartClicked(boolean startClicked) {
        this.startClicked = startClicked;
    }

    /**
     * This method sets the exitClicked variable
     * @param exitClicked Boolean exitClicked variable
     */
    public void setExitClicked(boolean exitClicked) {
        this.exitClicked = exitClicked;
    }

    /**
     * This method sets the infoClicked variable
     * @param infoClicked Boolean infoClicked variable
     */
    public void setInfoClicked(boolean infoClicked) {
        this.infoClicked = infoClicked;
    }

    /**
     * This method sets the highScoreClicked variable
     * @param highScoreClicked Boolean highScoreClicked variable
     */
    public void setHighScoreClicked(boolean highScoreClicked) {
        this.highScoreClicked = highScoreClicked;
    }

    /**
     * This method defines the font used in home menu
     */
    private void setFont() {
        greetingsFont = new Font("Noto Mono", Font.BOLD, 30);
        gameTitleFont = new Font("Noto Mono", Font.BOLD, 40);
        creditsFont = new Font("Monospaced", Font.BOLD, 20);
        buttonFont = new Font("Monospaced", Font.BOLD, startButton.height - 2);
    }

    /**
     * This method generates the home menu interface
     * @param g Graphics
     */
    public void paint(Graphics g) {
        drawMenu((Graphics2D) g);
    }

    /**
     * This method creates and display the home menu interface component
     * @param g2d Graphics2D
     */
    private void drawMenu(Graphics2D g2d) {
        //add background image
        Image img = Toolkit.getDefaultToolkit().getImage("src/main/resources/brick-destroyer-img-resized.png");
        g2d.drawImage(img, 0, 0, this);
        /*
        all the following method calls need a relative
        painting directly into the HomeMenu rectangle,
        so the translation is made here so the other methods do not do that.
         */
        Color prevColor = g2d.getColor();
        Font prevFont = g2d.getFont();

        double x = menuFace.getX();
        double y = menuFace.getY();

        g2d.translate(x, y);

        drawText(g2d);
        drawButton(g2d);

        g2d.translate(-x, -y);
        g2d.setFont(prevFont);
        g2d.setColor(prevColor);
    }

    /**
     * This method creates texts in home menu
     * @param g2d Graphics2D
     */
    private void drawText(Graphics2D g2d) {

        g2d.setColor(new Color(251, 251, 252, 81));
        Rectangle introBox = new Rectangle(new Point(90,5), new Dimension(270,125));
        g2d.fill(introBox);

        g2d.setColor(TEXT_COLOR);

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D greetingsRect = greetingsFont.getStringBounds(GREETINGS, frc);
        Rectangle2D gameTitleRect = gameTitleFont.getStringBounds(GAME_TITLE, frc);
        Rectangle2D creditsRect = creditsFont.getStringBounds(CREDITS, frc);

        int sX;
        int sY;

        sX = (int) (menuFace.getWidth() - greetingsRect.getWidth()) / 2;
        sY = (int) (menuFace.getHeight() / 9);

        g2d.setFont(greetingsFont);
        g2d.drawString(GREETINGS, sX, sY);

        sX = (int) (menuFace.getWidth() - gameTitleRect.getWidth()) / 2;
        sY += (int) gameTitleRect.getHeight() * 1.1;//add 10% of String height between the two strings

        g2d.setFont(gameTitleFont);
        g2d.drawString(GAME_TITLE, sX, sY);

        sX = (int) (menuFace.getWidth() - creditsRect.getWidth()) / 2;
        sY += (int) creditsRect.getHeight() * 1.1;

        g2d.setFont(creditsFont);
        g2d.drawString(CREDITS, sX, sY);
    }

    /**
     * This method creates the buttons in home menu
     * @param g2d Graphics2D
     */
    private void drawButton(Graphics2D g2d) {
        FontRenderContext frc = g2d.getFontRenderContext();
        drawStartButton(g2d, frc);
        drawHighScoreButton(g2d, frc);
        drawInfoButton(g2d, frc);
        drawExitButton(g2d, frc);
    }
    /**
     * This method creates the start button
     * @param g2d Graphics2D
     * @param frc Font render context
     */
    private void drawStartButton(Graphics2D g2d, FontRenderContext frc) {
        g2d.setColor(new Color(48, 99, 175));
        g2d.fill(startButton);
        g2d.setColor(Color.BLACK);
        Rectangle2D txtRect = buttonFont.getStringBounds(START_TEXT, frc);
        g2d.setFont(buttonFont);

        int x = (menuFace.width - startButton.width) / 2;
        int y = (int) ((menuFace.height - startButton.height) * 0.5);


        startButton.setLocation(x, y);

        x = (int) (startButton.getWidth() - txtRect.getWidth()) / 2;
        y = (int) (startButton.getHeight() - txtRect.getHeight()) / 2;

        x += startButton.x;
        y += startButton.y + (startButton.height * 0.9);


        if (startClicked) {
            Color tmp = g2d.getColor();
            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(startButton);
            g2d.setColor(CLICKED_TEXT);
            g2d.drawString(START_TEXT, x, y);
            g2d.setColor(tmp);
        } else {
            g2d.draw(startButton);
            g2d.drawString(START_TEXT, x, y);
        }
    }
    /**
     * This method creates the high score button
     * @param g2d Graphics2D
     * @param frc Font render context
     */
    private void drawHighScoreButton(Graphics2D g2d, FontRenderContext frc) {
        g2d.setColor(new Color(48, 99, 175));
        g2d.fill(highScoreButton);
        g2d.setColor(Color.BLACK);
        Rectangle2D hTxtRect = buttonFont.getStringBounds(HIGHSCORE_TEXT, frc);
        g2d.setFont(buttonFont);

        int x = startButton.x;
        int y = startButton.y;

        y *= 1.3;

        highScoreButton.setLocation(x, y);

        x = (int) (highScoreButton.getWidth() - hTxtRect.getWidth()) / 2;
        y = (int) (highScoreButton.getHeight() - hTxtRect.getHeight()) / 2;

        x += highScoreButton.x;
        y += highScoreButton.y + (startButton.height * 0.9);

        if (highScoreClicked) {
            Color tmp = g2d.getColor();

            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(highScoreButton);
            g2d.setColor(CLICKED_TEXT);
            g2d.drawString(HIGHSCORE_TEXT, x, y);
            g2d.setColor(tmp);
        } else {
            g2d.draw(highScoreButton);
            g2d.drawString(HIGHSCORE_TEXT, x, y);
        }
    }

    /**
     * This method creates the info button
     * @param g2d Graphics2D
     * @param frc Font render context
     */
    private void drawInfoButton(Graphics2D g2d, FontRenderContext frc) {
        g2d.setColor(new Color(48, 99, 175));
        g2d.fill(infoButton);
        g2d.setColor(Color.BLACK);
        Rectangle2D iTxtRect = buttonFont.getStringBounds(INFO_TEXT, frc);
        g2d.setFont(buttonFont);

        int x = highScoreButton.x;
        int y = highScoreButton.y;

        y += (highScoreButton.y - startButton.y);

        infoButton.setLocation(x, y);

        x = (int) (infoButton.getWidth() - iTxtRect.getWidth()) / 2;
        y = (int) (infoButton.getHeight() - iTxtRect.getHeight()) / 2;

        x += infoButton.x;
        y += infoButton.y + (startButton.height * 0.9);

        if (infoClicked) {
            Color tmp = g2d.getColor();

            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(infoButton);
            g2d.setColor(CLICKED_TEXT);
            g2d.drawString(INFO_TEXT, x, y);
            g2d.setColor(tmp);
        } else {
            g2d.draw(infoButton);
            g2d.drawString(INFO_TEXT, x, y);
        }
    }

    /**
     * This method creates the exit button
     * @param g2d Graphics2D
     * @param frc Font render context
     */
    private void drawExitButton(Graphics2D g2d, FontRenderContext frc) {
        g2d.setColor(new Color(48, 99, 175));
        g2d.fill(exitButton);
        g2d.setColor(Color.BLACK);
        Rectangle2D iTxtRect = buttonFont.getStringBounds(EXIT_TEXT, frc);
        g2d.setFont(buttonFont);

        int x = infoButton.x;
        int y = infoButton.y;

        y += (highScoreButton.y - startButton.y);

        exitButton.setLocation(x, y);

        x = (int) (exitButton.getWidth() - iTxtRect.getWidth()) / 2;
        y = (int) (exitButton.getHeight() - iTxtRect.getHeight()) / 2;

        x += exitButton.x;
        y += exitButton.y + (startButton.height * 0.9);

        if (exitClicked) {
            Color tmp = g2d.getColor();

            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(exitButton);
            g2d.setColor(CLICKED_TEXT);
            g2d.drawString(EXIT_TEXT, x, y);
            g2d.setColor(tmp);
        } else {
            g2d.draw(exitButton);
            g2d.drawString(EXIT_TEXT, x, y);
        }
    }
}
