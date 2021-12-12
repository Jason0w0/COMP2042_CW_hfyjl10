/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Lee Jason
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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * This class is a children class of class Ball
 *
 * @author Jason
 */
public class RubberBall extends Ball {
    private static final int DEF_RADIUS = 10;
    private static final Color DEF_INNER_COLOR = new Color(255, 219, 88);
    private static final Color DEF_BORDER_COLOR = DEF_INNER_COLOR.darker().darker();

    /**
     * This is the constructor of class RubberBall
     * @param center Location of ball
     */
    public RubberBall(Point2D center){
        super(center,DEF_RADIUS,DEF_RADIUS,DEF_INNER_COLOR,DEF_BORDER_COLOR);
    }

    /**
     * This method creates the ball
     * @param center Ball's location
     * @param radiusA Ball's height
     * @param radiusB Ball's width
     * @return Ball
     */
    @Override
    protected Shape makeBall(Point2D center, int radiusA, int radiusB) {

        double x = center.getX() - ((double)radiusA / 2);
        double y = center.getY() - ((double)radiusB / 2);

        return new Ellipse2D.Double(x,y,radiusA,radiusB);
    }
}
