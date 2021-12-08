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
package model;

import java.awt.*;


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

    public Player(Point ballPoint,Rectangle container) {
        this.ballPoint = ballPoint;
        moveAmount = 0;
        int width = 150;
        int height = 10;
        playerFace = makeRectangle(width, height);
        min = container.x + (width / 2);
        max = min + container.width - width;
    }

    public Color getBORDER_COLOR() {
        return BORDER_COLOR;
    }

    public Color getINNER_COLOR() {
        return INNER_COLOR;
    }

    private Rectangle makeRectangle(int width,int height){
        Point p = new Point((int)(ballPoint.getX() - (width / 2)),(int)ballPoint.getY());
        return  new Rectangle(p,new Dimension(width,height));
    }

    public boolean impact(Ball b){
        return playerFace.contains(b.getPosition()) && playerFace.contains(b.getDown()) ;
    }

    public void move(){
        double x = ballPoint.getX() + moveAmount;
        if(x < min || x > max)
            return;
        ballPoint.setLocation(x,ballPoint.getY());
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }

    public void moveLeft(){
        moveAmount = -DEF_MOVE_AMOUNT;
    }

    public void movRight(){
        moveAmount = DEF_MOVE_AMOUNT;
    }

    public void stop(){
        moveAmount = 0;
    }

    public Shape getPlayerFace(){
        return  playerFace;
    }

    public void moveTo(Point p){
        ballPoint.setLocation(p);
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }

    public void playerReward(){
        playerFace = makeRectangle(playerFace.width+50, playerFace.height);
        DEF_MOVE_AMOUNT += 2;
        rewardSum += 1;
    }

    public void playerPenalty(){
        playerFace = makeRectangle(playerFace.width-30, playerFace.height);
        DEF_MOVE_AMOUNT -= 1;
        penaltySum += 1;
    }

    public void removeReward() {
        playerFace = makeRectangle(playerFace.width-(50*rewardSum), playerFace.height);
        DEF_MOVE_AMOUNT -= (2*rewardSum);
    }

    public void removePenalty() {
        playerFace = makeRectangle(playerFace.width+(50*penaltySum), playerFace.height);
        DEF_MOVE_AMOUNT += (2*penaltySum);
    }
}
