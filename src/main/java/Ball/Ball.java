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
package Ball;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 * This is an abstract class the creates the game's ball
 *
 * @author Jason
 */
abstract public class Ball {
    private Shape ballFace;

    private final Point2D center;
    private final Point2D up;
    private final Point2D down;
    private final Point2D left;
    private final Point2D right;

    private final Color border;
    private final Color inner;

    private int speedX;
    private int speedY;


    /**
     * This is the constructor of class Ball
     * @param center Center of ball
     * @param radiusA Ball's height
     * @param radiusB Ball's width
     * @param inner Ball's color
     * @param border Ball's border color
     */
    public Ball(Point2D center,int radiusA,int radiusB,Color inner,Color border){
        this.center = center;

        up = new Point2D.Double();
        down = new Point2D.Double();
        left = new Point2D.Double();
        right = new Point2D.Double();

        up.setLocation(center.getX(),center.getY()-((double) radiusB / 2));
        down.setLocation(center.getX(),center.getY()+((double) radiusB / 2));

        left.setLocation(center.getX()-((double) radiusA /2),center.getY());
        right.setLocation(center.getX()+((double) radiusA /2),center.getY());


        ballFace = makeBall(center,radiusA,radiusB);
        this.border = border;
        this.inner  = inner;

        speedX = 0;
        speedY = 0;
    }

    /**
     * This method generates the ball
     * @param center Center of ball
     * @param radiusA Ball's height
     * @param radiusB Ball's width
     * @return Ball
     */
    protected abstract Shape makeBall(Point2D center,int radiusA,int radiusB);

    /**
     * This method calculates and moves the ball
     */
    public void move(){
        RectangularShape tmp = (RectangularShape) ballFace;
        center.setLocation((center.getX() + speedX),(center.getY() + speedY));
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        setPoints(w,h);


        ballFace = tmp;
    }

    /**
     * This method gets the upper-most coordinate of the ball
     * @return Upper-most coordinate
     */
    public Point2D getUp() {
        return up;
    }

    /**
     * This method gets the lower-most coordinate of the ball
     * @return Lower-most coordinate
     */
    public Point2D getDown() {
        return down;
    }

    /**
     * This method gets the left-most coordinate of the ball
     * @return Left-most coordinate
     */
    public Point2D getLeft() {
        return left;
    }

    /**
     * This method gets the right-most coordinate of the ball
     * @return Right-most coordinate
     */
    public Point2D getRight() {
        return right;
    }

    /**
     * This method speed the speed that the ball moves
     * @param x Ball's horizontal speed
     * @param y Ball's vertical speed
     */
    public void setSpeed(int x,int y){
        setXSpeed(x);
        setYSpeed(y);
    }

    /**
     * This method gets the ball's horizontal speed
     * @return Ball's horizontal speed
     */
    public int getSpeedX() {
        return speedX;
    }

    /**
     * This method gets the ball's vertical speed
     * @return Ball's vertical speed
     */
    public int getSpeedY() {
        return speedY;
    }

    /**
     * This method sets the ball's horizontal speed
     * @param s Ball's horizontal speed
     */
    public void setXSpeed(int s){
        speedX = s;
    }

    /**
     * This method sets the ball's vertical speed
     * @param s Ball's vertical speed
     */
    public void setYSpeed(int s){
        speedY = s;
    }

    /**
     * This method reverse the ball's horizontal direction
     */
    public void reverseX(){
        speedX *= -1;
    }

    /**
     * This method reverse the ball's vertical direction
     */
    public void reverseY(){
        speedY *= -1;
    }

    /**
     * This method gets the ball's border color
     * @return Ball's border color
     */
    public Color getBorderColor(){
        return border;
    }

    /**
     * This method gets the ball's color
     * @return Ball's color
     */
    public Color getInnerColor(){
        return inner;
    }

    /**
     * This method gets the ball's location
     * @return Ball's location
     */
    public Point2D getPosition(){
        return center;
    }

    /**
     * This method gets the parent class of ball
     * @return Shape class
     */
    public Shape getBallFace(){
        return ballFace;
    }

    /**
     * This method moves ball's to desired location
     * @param p Desired coordinate
     */
    public void moveTo(Point p){
        center.setLocation(p);

        RectangularShape tmp = (RectangularShape) ballFace;
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        ballFace = tmp;
    }

    /**
     * This method sets upper-most, lower-most, left-most and right-most location of the ball
     * @param width Ball's width
     * @param height Ball's height
     */
    private void setPoints(double width,double height){
        up.setLocation(center.getX(),center.getY()-(height / 2));
        down.setLocation(center.getX(),center.getY()+(height / 2));

        left.setLocation(center.getX()-(width / 2),center.getY());
        right.setLocation(center.getX()+(width / 2),center.getY());
    }
}
