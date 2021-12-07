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

import controller.GameFrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;


public class HomeMenuView extends JComponent {

    private static final String GREETINGS = "Welcome to:";
    private static final String GAME_TITLE = "Brick Destroy";
    private static final String CREDITS = "Version 0.1";
    private static final String START_TEXT = "Start";
    private static final String MENU_TEXT = "Exit";
    private static final String INFO_TEXT = "Info";

    private static final Color TEXT_COLOR = Color.BLACK;//egyptian blue
    private static final Color CLICKED_BUTTON_COLOR = Color.LIGHT_GRAY;
    private static final Color CLICKED_TEXT = Color.lightGray;

    private Rectangle menuFace;
    private Rectangle startButton;
    private Rectangle menuButton;
    private Rectangle infoButton;

    private Font greetingsFont;
    private Font gameTitleFont;
    private Font creditsFont;
    private Font buttonFont;

    private GameFrameController owner;

    private boolean startClicked;
    private boolean menuClicked;
    private boolean infoClicked;

    public HomeMenuView() {
        Dimension area = new Dimension(450, 300);
        Dimension btnDim = new Dimension(area.width / 3, area.height / 12);
        initialize(area);
        setInterface(btnDim, area);
        setFont();
    }

    //set up function of HomeMenu
    private void initialize(Dimension area) {
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(area);
    }

    //create interface component
    private void setInterface(Dimension btnDim, Dimension area) {
        menuFace = new Rectangle(new Point(0, 0), area);
        startButton = new Rectangle(btnDim);
        menuButton = new Rectangle(btnDim);
        infoButton = new Rectangle(btnDim);
    }

    public void setOwner(GameFrameController owner) {
        this.owner = owner;
    }

    public Rectangle getStartButton() {
        return startButton;
    }

    public Rectangle getMenuButton() {
        return menuButton;
    }

    public Rectangle getInfoButton() {
        return infoButton;
    }

    public GameFrameController getOwner() {
        return owner;
    }

    public void setStartClicked(boolean startClicked) {
        this.startClicked = startClicked;
    }

    public void setMenuClicked(boolean menuClicked) {
        this.menuClicked = menuClicked;
    }

    public void setInfoClicked(boolean infoClicked) {
        this.infoClicked = infoClicked;
    }

    //define Font
    private void setFont() {
        greetingsFont = new Font("Noto Mono", Font.BOLD, 30);
        gameTitleFont = new Font("Noto Mono", Font.BOLD, 40);
        creditsFont = new Font("Monospaced", Font.BOLD, 20);
        buttonFont = new Font("Monospaced", Font.BOLD, startButton.height - 2);
    }

    public void paint(Graphics g) {
        drawMenu((Graphics2D) g);
    }

    //change from public to private
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

        //start methods calls
        drawText(g2d);
        drawButton(g2d);
        //end of methods calls

        g2d.translate(-x, -y);
        g2d.setFont(prevFont);
        g2d.setColor(prevColor);
    }

    private void drawText(Graphics2D g2d) {
        g2d.setColor(TEXT_COLOR);

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D greetingsRect = greetingsFont.getStringBounds(GREETINGS, frc);
        Rectangle2D gameTitleRect = gameTitleFont.getStringBounds(GAME_TITLE, frc);
        Rectangle2D creditsRect = creditsFont.getStringBounds(CREDITS, frc);

        int sX;
        int sY;

        sX = (int) (menuFace.getWidth() - greetingsRect.getWidth()) / 2;
        sY = (int) (menuFace.getHeight() / 4);

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

    private void drawButton(Graphics2D g2d) {
        FontRenderContext frc = g2d.getFontRenderContext();

        g2d.setColor(new Color(48, 99, 175));
        g2d.fill(menuButton);
        g2d.fill(startButton);
        g2d.fill(infoButton);
        g2d.setColor(Color.BLACK);

        Rectangle2D txtRect = buttonFont.getStringBounds(START_TEXT, frc);
        Rectangle2D mTxtRect = buttonFont.getStringBounds(MENU_TEXT, frc);
        Rectangle2D iTxtRect = buttonFont.getStringBounds(INFO_TEXT, frc);

        g2d.setFont(buttonFont);

        int x = (menuFace.width - startButton.width) / 2;
        int y = (int) ((menuFace.height - startButton.height) * 0.8);


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

        x = startButton.x;
        y = startButton.y;

        y *= 1.2;

        menuButton.setLocation(x, y);

        x = (int) (menuButton.getWidth() - mTxtRect.getWidth()) / 2;
        y = (int) (menuButton.getHeight() - mTxtRect.getHeight()) / 2;

        x += menuButton.x;
        y += menuButton.y + (startButton.height * 0.9);

        if (menuClicked) {
            Color tmp = g2d.getColor();

            g2d.setColor(CLICKED_BUTTON_COLOR);
            g2d.draw(menuButton);
            g2d.setColor(CLICKED_TEXT);
            g2d.drawString(MENU_TEXT, x, y);
            g2d.setColor(tmp);
        } else {
            g2d.draw(menuButton);
            g2d.drawString(MENU_TEXT, x, y);
        }

        x = startButton.x;
        y = startButton.y;

        y -= 44;

        infoButton.setLocation(x,y);

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
}
