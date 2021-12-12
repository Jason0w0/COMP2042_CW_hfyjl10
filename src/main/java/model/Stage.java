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
import java.awt.geom.Point2D;

/**
 *  This class is for generating a level
 *
 * @author Jason
 */
public class Stage {
    private final Rectangle area;

    private Brick[] bricks;
    private Ball ball;
    private Player player;
    private final Brick[][] levels;

    private final Point startPoint;

    private int level;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;
    private int speedX;
    private int speedY;
    private int score;

    /**
     * This is class Stage's constructor
     * This constructor initializes all necessary values needed to generate a level
     * @param drawArea Draw area of bricks
     * @param ballPos Starting coordinate of ball and player
     */
    public Stage(Rectangle drawArea, Point ballPos){
        this.startPoint = new Point(ballPos);
        Wall wall = new Wall(drawArea);
        levels = wall.getLevels();
        level = 0;
        ballCount = 3;
        score = 0;
        ballLost = false;
        makeBall(ballPos);
        makePlayer((Point) ballPos.clone(), drawArea);
        speedX = 3;
        speedY = -5;
        ball.setSpeed(speedX,speedY);
        area = drawArea;
    }

    /**
     * This method is used to get all bricks in current level
     * @return Bricks in current level
     */
    public Brick[] getBricks() {
        return bricks;
    }

    /**
     * This method is used to get the player
     * @return Player class
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * This method is used to generate ball
     * @param ballPos Starting coordinate of ball
     */
    private void makeBall(Point2D ballPos){
        ball = new RubberBall(ballPos);
    }

    /**
     * This method is used to generate player
     * @param playerPos Starting coordinate of player
     * @param drawArea Draw area of player
     */
    private void makePlayer(Point playerPos, Rectangle drawArea){ player = new Player(playerPos, drawArea);}

    /**
     * This method is used to move the player and ball
     */
    public void move(){
        player.move();
        ball.move();
    }

    /**
     * This method is used to get the ball
     * @return Ball class
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * This method is used to detect impacts of ball and project its trajectory
     */
    public void findImpacts(){
        if(player.impact(ball)){
            ball.reverseY();
        }
        else if(impactWall()){
            /*for efficiency reverse is done into method impactWall
            * because for every brick program checks for horizontal and vertical impacts
            */
            brickCount--;
            score += 100;
        }
        else if(impactSideBorder()) {
            ball.reverseX();
        }
        else if(impactTopBorder()){
            ball.reverseY();
        }
        else if(ballLost()){
            ballCount--;
            ballLost = true;
        }
    }

    /**
     * This method is used to calculate impacts between ball and the bricks and project is trajectory
     * @return Boolean of either brick is broken
     */
    private boolean impactWall(){
        for(Brick b : bricks){
            switch (b.findImpact(ball)) {
                //Vertical Impact
                case Brick.UP_IMPACT -> {
                    ball.reverseY();
                    return b.setImpact(ball.getDown(), Brick.Crack.UP);
                }
                case Brick.DOWN_IMPACT -> {
                    ball.reverseY();
                    return b.setImpact(ball.getUp(), Brick.Crack.DOWN);
                }

                //Horizontal Impact
                case Brick.LEFT_IMPACT -> {
                    ball.reverseX();
                    return b.setImpact(ball.getRight(), Brick.Crack.RIGHT);
                }
                case Brick.RIGHT_IMPACT -> {
                    ball.reverseX();
                    return b.setImpact(ball.getLeft(), Brick.Crack.LEFT);
                }
            }
        }
        return false;
    }

    /**
     * This method is used to determine impacts between ball and the side border
     * @return Boolean of either ball impacts the side border
     */
    private boolean impactSideBorder(){
        Point2D p = ball.getPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    }

    /**
     * This method is used to determine impacts between ball and the top border
     * @return Boolean of either ball impacts the top border
     */
    private boolean impactTopBorder(){
        Point2D p = ball.getPosition();
        return (p.getY() < area.getY());
    }

    /**
     * This method is used to determine the presence of ball in screen
     * @return Boolean of either ball is lost
     */
    public boolean ballLost(){
        Point2D p = ball.getPosition();
        return (p.getY() > area.getY() + area.getHeight());
    }

    /**
     * This method is used to get the number of bricks presence in the level
     * @return Total number of bricks
     */
    public int getBrickCount(){
        return brickCount;
    }

    /**
     * This method is used to get the number of ball left available for the player
     * @return Number of ball available
     */
    public int getBallCount(){
        return ballCount;
    }

    /**
     * This method resets the ball to its start point and intended speed
     */
    public void ballReset(){
        ball.moveTo(startPoint);
        ball.setSpeed(speedX,speedY);
        ballLost = false;
    }

    /**
     * This method resets the player to its original position
     */
    public void playerReset() {
        player.moveTo(startPoint);
    }

    /**
     * This method reset the bricks to its original condition
     */
    public void wallReset(){
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    }

    /**
     * This method determines the bonus player will receive
     * @param ballRemain Number of ball left
     */
    public void playerBonus(int ballRemain){
        switch (ballRemain) {
            case 3 -> player.playerReward();
            case 1 -> player.playerPenalty();
        }
    }

    /**
     * This method determines either if there is no ball left
     * @return Boolean either if there is ball left
     */
    public boolean ballEnd(){
        return ballCount == 0;
    }

    /**
     * This method detects either if there are bricks left
     * @return Boolean either if there are brick left
     */
    public boolean isDone(){
        return brickCount == 0;
    }

    /**
     * This method generate the next level
     */
    public void nextLevel(){
        bricks = levels[level++];
        this.brickCount = bricks.length;
    }

    /**
     * This method determines if there is level left
     * @return Boolean either if there is level left
     */
    public boolean hasLevel(){
        return level < levels.length;
    }

    /**
     * This method sets the horizontal movement speed of the ball
     * @param s Horizontal speed of ball
     */
    public void setBallXSpeed(int s){
        speedX = s;
        ball.setXSpeed(speedX);
    }

    /**
     * This method sets the horizontal vertical speed of the ball
     * @param s Vertical speed of the ball
     */
    public void setBallYSpeed(int s){
        speedY = s;
        ball.setYSpeed(speedY);
    }

    /**
     * This method resets the number of ball
     */
    public void resetBallCount(){
        ballCount = 3;
    }

    /**
     * This method gets the player's score
     * @return Player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * This method resets the player's score
     */
    public void resetScore() {
        score = 0;
    }
}
