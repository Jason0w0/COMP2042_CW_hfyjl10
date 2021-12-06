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
package test;

import model.Ball;
import model.Player;
import model.RubberBall;
import model.Wall;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;


public class Stage {

    private Random rnd;
    private Rectangle area;

    public Brick[] bricks;

    public Ball getBall() {
        return ball;
    }

    public Ball ball;

    public Player getPlayer() {
        return player;
    }

    private Player player;

    private Brick[][] levels;
    private int level;

    private Point startPoint;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;
    private int speedX;
    private int speedY;

    public Stage(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point ballPos){

        this.startPoint = new Point(ballPos);
        Wall wall = new Wall(drawArea);
        levels = wall.getLevels();
        level = 0;

        ballCount = 3;
        ballLost = false;

//        rnd = new Random();

        makeBall(ballPos);
        makePlayer((Point) ballPos.clone(), drawArea);
//        int speedX,speedY;

//        do{
//            speedX = rnd.nextInt(5) - 2;
//        }while(speedX == 0);
//        do{
//            speedY = -rnd.nextInt(3);
//        }while(speedY == 0);

        speedX = 10;
        speedY = -5;

        ball.setSpeed(speedX,speedY);

        area = drawArea;

    }

    private void makeBall(Point2D ballPos){
        ball = new RubberBall(ballPos);
    }

    private void makePlayer(Point playerPos, Rectangle drawArea){ player = new Player(playerPos, drawArea);}

    public void move(){
        player.move();
        ball.move();
    }

    public void findImpacts(){
        if(player.impact(ball)){
            ball.reverseY();
        }
        else if(impactWall()){
            /*for efficiency reverse is done into method impactWall
            * because for every brick program checks for horizontal and vertical impacts
            */
            brickCount--;
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

    private boolean impactWall(){
        for(Brick b : bricks){
            switch (b.findImpact(ball)) {
                //Vertical Impact
                case Brick.UP_IMPACT -> {
                    ball.reverseY();
                    return b.setImpact(ball.down, Brick.Crack.UP);
                }
                case Brick.DOWN_IMPACT -> {
                    ball.reverseY();
                    return b.setImpact(ball.up, Brick.Crack.DOWN);
                }

                //Horizontal Impact
                case Brick.LEFT_IMPACT -> {
                    ball.reverseX();
                    return b.setImpact(ball.right, Brick.Crack.RIGHT);
                }
                case Brick.RIGHT_IMPACT -> {
                    ball.reverseX();
                    return b.setImpact(ball.left, Brick.Crack.LEFT);
                }
            }
        }
        return false;
    }

    private boolean impactSideBorder(){
        Point2D p = ball.getPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    }

    private boolean impactTopBorder(){
        Point2D p = ball.getPosition();
        return (p.getY() < area.getY());
    }

    private boolean ballLost(){
        Point2D p = ball.getPosition();
        return (p.getY() > area.getY() + area.getHeight());
    }

    public int getBrickCount(){
        return brickCount;
    }

    public int getBallCount(){
        return ballCount;
    }

    public boolean isBallLost(){
        return ballLost;
    }

    public void ballReset(){
        ball.moveTo(startPoint);
//        int speedX,speedY;
//        do{
//            speedX = rnd.nextInt(5) - 2;
//        }while(speedX == 0);
//        do{
//            speedY = -rnd.nextInt(3);
//        }while(speedY == 0);

        ball.setSpeed(speedX,speedY);
        ballLost = false;
    }

    public void playerReset() {
        player.moveTo(startPoint);
    }

    public void wallReset(){
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    }

    public boolean ballEnd(){
        return ballCount == 0;
    }

    public boolean isDone(){
        return brickCount == 0;
    }

    public void nextLevel(){
        bricks = levels[level++];
        this.brickCount = bricks.length;
    }

    public boolean hasLevel(){
        return level < levels.length;
    }

    public void setBallXSpeed(int s){
        ball.setXSpeed(s);
    }

    public void setBallYSpeed(int s){
        ball.setYSpeed(s);
    }

    public void resetBallCount(){
        ballCount = 3;
    }


}
