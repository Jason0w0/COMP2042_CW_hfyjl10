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
package Player;

import Ball.Ball;

import java.awt.*;

/**
 * This class is used to generate the player
 *
 * @author Jason
 */
public class Player {
    private final Color BORDER_COLOR = Color.GREEN.darker().darker();
    private final Color INNER_COLOR = Color.GREEN;

    private static int DEF_MOVE_AMOUNT = 5;

    private Rectangle playerFace;
    private final Point ballPoint;

    private int moveAmount;
    private final int min;
    private final int max;
    private int rewardSum;
    private int penaltySum;


    /**
     * This is class Player's constructor
     * This constructor initializes the value
     * @param ballPoint This initial coordinate of player
     * @param container The draw area of player
     */
    public Player(Point ballPoint,Rectangle container) {
        this.ballPoint = ballPoint;
        moveAmount = 0;
        int width = 150;
        int height = 10;
        playerFace = makeRectangle(width, height);
        min = container.x + (width / 2);
        max = min + container.width - width;
    }

    /**
     * This method gets the player's border color
     * @return Border's color
     */
    public Color getBORDER_COLOR() {
        return BORDER_COLOR;
    }

    /**
     * This method gets the player's color
     * @return Player's color
     */
    public Color getINNER_COLOR() {
        return INNER_COLOR;
    }

    /**
     * This method creates the player
     * @param width Player's width
     * @param height Player's height
     * @return Player
     */
    private Rectangle makeRectangle(int width,int height){
        Point p = new Point((int)(ballPoint.getX() - (width / 2)),(int)ballPoint.getY());
        return  new Rectangle(p,new Dimension(width,height));
    }

    /**
     * This method determines if the ball impacts the player
     * @param b Ball
     * @return Boolean either the ball impacts the player
     */
    public boolean impact(Ball b){
        return playerFace.contains(b.getPosition()) && playerFace.contains(b.getDown()) ;
    }

    /**
     * This method moves the player
     */
    public void move(){
        double x = ballPoint.getX() + moveAmount;
        if(x < min || x > max)
            return;
        ballPoint.setLocation(x,ballPoint.getY());
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }

    /**
     * This method determines the player move to the left
     */
    public void moveLeft(){
        moveAmount = -DEF_MOVE_AMOUNT;
    }

    /**
     * This method determines the player move to the right
     */
    public void movRight(){
        moveAmount = DEF_MOVE_AMOUNT;
    }

    /**
     * This method determines the player stop moving
     */
    public void stop(){
        moveAmount = 0;
    }

    /**
     * This method returns the parent class of player
     * @return Shape class
     */
    public Shape getPlayerFace(){
        return  playerFace;
    }

    /**
     * This method moves the player
     * @param p Coordinate where the player will move to
     */
    public void moveTo(Point p){
        ballPoint.setLocation(p);
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }

    /**
     * This method generates the player's reward
     */
    public void playerReward(){
        playerFace = makeRectangle(playerFace.width+50, playerFace.height);
        DEF_MOVE_AMOUNT += 2;
        rewardSum += 1;
    }

    /**
     * This method generates the player's penalty
     */
    public void playerPenalty(){
        playerFace = makeRectangle(playerFace.width-30, playerFace.height);
        DEF_MOVE_AMOUNT -= 1;
        penaltySum += 1;
    }

    /**
     * This method removes the player's reward
     */
    public void removeReward() {
        playerFace = makeRectangle(playerFace.width-(50*rewardSum), playerFace.height);
        DEF_MOVE_AMOUNT -= (2*rewardSum);
    }

    /**
     * This method removes the player's penalty
     */
    public void removePenalty() {
        playerFace = makeRectangle(playerFace.width+(50*penaltySum), playerFace.height);
        DEF_MOVE_AMOUNT += (2*penaltySum);
    }
}
