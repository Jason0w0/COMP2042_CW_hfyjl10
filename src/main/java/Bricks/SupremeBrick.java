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
package Bricks;

import Bricks.Brick;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * This class generates the supreme brick
 *
 * @author Jason
 */
public class SupremeBrick extends Brick {
    private static final Color DEF_INNER = new Color(250, 1, 1);
    private static final Color DEF_BORDER = Color.BLACK;
    private static final int SUPREME_STRENGTH = 4;

    private final Crack crack;
    private Shape brickFace;

    /**
     * This is the constructor of class SupremeBrick
     * @param point Upper-left coordinate of supreme brick
     * @param size Size of supreme brick
     */
    public SupremeBrick(Point point, Dimension size){
        super(point,size,DEF_BORDER,DEF_INNER,SUPREME_STRENGTH);
        crack = new Crack(DEF_CRACK_DEPTH,DEF_STEPS);
        brickFace = super.brickFace;
    }

    /**
     * This method generates the supreme brick
     * @param pos Brick's location
     * @param size Brick's size
     * @return Supreme brick
     */
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    /**
     * This method gets the parent class of supreme brick
     * @return Shape class
     */
    @Override
    public Shape getBrick() {
        return brickFace;
    }

    /**
     * This method determines the impact on supreme brick
     * @param point Point of impact
     * @param dir Direction of impact
     * @return Either impact happens on supreme brick
     */
    @Override
    public boolean setImpact(Point2D point, int dir) {
        if(super.isBroken())
            return false;
        super.impact();
        if(!super.isBroken()){
            crack.makeCrack(point,dir);
            updateBrick();
            return false;
        }
        return true;
    }

    /**
     * This method updates the condition of supreme brick
     */
    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = crack.draw();
            gp.append(super.brickFace,false);
            brickFace = gp;
        }
    }

    /**
     * This method returns the supreme brick to its original condition
     */
    public void repair(){
        super.repair();
        crack.reset();
        brickFace = super.brickFace;
    }
}
