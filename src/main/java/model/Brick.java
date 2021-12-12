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
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * This abstract class contains the information of brick
 *
 * @author Jason
 */
abstract public class Brick  {
    protected static final int DEF_CRACK_DEPTH = 1;
    protected static final int DEF_STEPS = 35;
    protected static final int UP_IMPACT = 100;
    protected static final int DOWN_IMPACT = 200;
    protected static final int LEFT_IMPACT = 300;
    protected static final int RIGHT_IMPACT = 400;

    private static Random rnd;

    Shape brickFace;

    private final Color border;
    private final Color inner;

    private final int fullStrength;
    private int strength;
    private boolean broken;

    /**
     * This is the constructor of brick's class
     * @param pos Brick's upper left coordinate
     * @param size Size of brick
     * @param border Brick's border color
     * @param inner Brick's color
     * @param strength Brick's strength
     */
    public Brick(Point pos,Dimension size,Color border,Color inner,int strength){
        rnd = new Random();
        broken = false;
        brickFace = makeBrickFace(pos,size);
        this.border = border;
        this.inner = inner;
        this.fullStrength = this.strength = strength;
    }

    /**
     * This method generates the brick
     * @param pos Brick's location
     * @param size Brick's size
     * @return Brick
     */
    protected abstract Shape makeBrickFace(Point pos,Dimension size);

    /**
     * This method determines the impact on the brick
     * @param point Point of impact
     * @param dir Direction of impact
     * @return Boolean either is impact happens on the brick
     */
    public boolean setImpact(Point2D point , int dir){
        if(broken)
            return false;
        impact();
        return  broken;
    }

    /**
     * This method gets the parent class of Brick
     * @return Shape class
     */
    public abstract Shape getBrick();

    /**
     * This method gets the brick's border color
     * @return Brick's border color
     */
    public Color getBorderColor(){
        return  border;
    }

    /**
     * This method gets the brick's color
     * @return Brick's color
     */
    public Color getInnerColor(){
        return inner;
    }

    /**
     * This method finds the type of impact
     * @param b Ball
     * @return Type of impact
     */
    public final int findImpact(Ball b){
        if(broken)
            return 0;
        int out  = 0;
        if(brickFace.contains(b.getRight()))
            out = LEFT_IMPACT;
        else if(brickFace.contains(b.getLeft()))
            out = RIGHT_IMPACT;
        else if(brickFace.contains(b.getUp()))
            out = DOWN_IMPACT;
        else if(brickFace.contains(b.getDown()))
            out = UP_IMPACT;
        return out;
    }

    /**
     * This method gets the broken variable
     * @return Either if the brick is broken
     */
    public final boolean isBroken(){
        return broken;
    }

    /**
     * This method returns brick to their original condition
     */
    public void repair() {
        broken = false;
        strength = fullStrength;
    }

    /**
     * This method calculates the impact on brick
     */
    public void impact(){
        strength--;
        broken = (strength == 0);
    }

    /**
     * This class generates the cracks on brick
     */
    protected class Crack{

        private static final int CRACK_SECTIONS = 3;
        private static final double JUMP_PROBABILITY = 0.7;

        protected static final int LEFT = 10;
        protected static final int RIGHT = 20;
        protected static final int UP = 30;
        protected static final int DOWN = 40;
        protected static final int VERTICAL = 100;
        protected static final int HORIZONTAL = 200;

        private final GeneralPath crack;

        private final int crackDepth;
        private final int steps;

        /**
         * This is the constructor of class Crack
         * @param crackDepth Length of crack
         * @param steps Number of turning points of crack line
         */
        public Crack(int crackDepth, int steps){
            crack = new GeneralPath();
            this.crackDepth = crackDepth;
            this.steps = steps;
        }

        /**
         * This method gets the crack
         * @return Crack line
         */
        public GeneralPath draw(){
            return crack;
        }

        /**
         * This method resets the crack line
         */
        public void reset(){
            crack.reset();
        }

        /**
         * This method generates the crack line
         * @param point Coordinate of crack line
         * @param direction Crack line direction
         */
        protected void makeCrack(Point2D point, int direction){
            Rectangle bounds = Brick.this.brickFace.getBounds();
            Point impact = new Point((int)point.getX(),(int)point.getY());
            Point start = new Point();
            Point end = new Point();

            switch(direction){
                case LEFT:
                    start.setLocation(bounds.x + bounds.width, bounds.y);
                    end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
                    Point tmp = makeRandomPoint(start,end,VERTICAL);
                    makeCrack(impact,tmp);
                    break;

                case RIGHT:
                    start.setLocation(bounds.getLocation());
                    end.setLocation(bounds.x, bounds.y + bounds.height);
                    tmp = makeRandomPoint(start,end,VERTICAL);
                    makeCrack(impact,tmp);
                    break;

                case UP:
                    start.setLocation(bounds.x, bounds.y + bounds.height);
                    end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
                    tmp = makeRandomPoint(start,end,HORIZONTAL);
                    makeCrack(impact,tmp);
                    break;

                case DOWN:
                    start.setLocation(bounds.getLocation());
                    end.setLocation(bounds.x + bounds.width, bounds.y);
                    tmp = makeRandomPoint(start,end,HORIZONTAL);
                    makeCrack(impact,tmp);
                    break;
            }
        }

        /**
         * This method generates the crack line
         * @param start Starting point of crack line
         * @param end End point of crack line
         */
        protected void makeCrack(Point start, Point end){

            GeneralPath path = new GeneralPath();

            path.moveTo(start.x,start.y);

            double w = (end.x - start.x) / (double)steps;
            double h = (end.y - start.y) / (double)steps;

            int bound = crackDepth;
            int jump  = bound * 5;

            double x,y;

            for(int i = 1; i < steps;i++){

                x = (i * w) + start.x;
                y = (i * h) + start.y + randomInBounds(bound);

                if(inMiddle(i, steps))
                    y += jumps(jump);

                path.lineTo(x,y);
            }

            path.lineTo(end.x,end.y);
            crack.append(path,true);
        }

        /**
         * This method generates random integer in a range
         * @param bound Range of integer
         * @return Integer in range
         */
        private int randomInBounds(int bound){
            int n = (bound * 2) + 1;
            return rnd.nextInt(n) - bound;
        }

        /**
         * This method determines either integer is in middle
         * @param i integer
         * @param divisions Number of crack lines
         * @return Either the integer is in middle
         */
        private boolean inMiddle(int i, int divisions){
            int low = (Crack.CRACK_SECTIONS / divisions);
            int up = low * (divisions - 1);

            return  (i > low) && (i < up);
        }

        /**
         * This method determines if a V-type crack line will be generated
         * @param bound Range of integer
         * @return Either V-type crack line will be generated
         */
        private int jumps(int bound){

            if(rnd.nextDouble() > Crack.JUMP_PROBABILITY)
                return randomInBounds(bound);
            return  0;

        }

        /**
         * This method generates random coordinate
         * @param from Starting range of coordinate
         * @param to Ending range of coordinate
         * @param direction Type of direction
         * @return Random coordinate
         */
        private Point makeRandomPoint(Point from,Point to, int direction){

            Point out = new Point();
            int pos;

            switch (direction) {
                case HORIZONTAL -> {
                    pos = rnd.nextInt(to.x - from.x) + from.x;
                    out.setLocation(pos, to.y);
                }
                case VERTICAL -> {
                    pos = rnd.nextInt(to.y - from.y) + from.y;
                    out.setLocation(to.x, pos);
                }
            }
            return out;
        }

    }
}





