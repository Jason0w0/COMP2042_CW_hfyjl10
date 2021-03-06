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
package Wall;

import Bricks.*;

import java.awt.*;


/**
 * This class is for generating bricks for each levels
 *
 * @author Jason
 */
public class Wall {
    private static final int LEVELS_COUNT = 8;
    private static final int CLAY = 1;
    private static final int STEEL = 2;
    private static final int CEMENT = 3;
    private static final int SUPREME = 4;

    private final Brick[][] levels;

    /**
     * This is class Wall's constructor
     * This constructor initializes the brickCount, lineCount and brickDimensionRatio value
     * This constructor calls makeLevels method to generate all bricks needed for all level
     * @param drawArea Draw area of bricks
     */
    public Wall(Rectangle drawArea) {
        int brickCount = 30;
        int lineCount = 3;
        double brickDimensionRatio = 3;
        levels = makeLevels(drawArea, brickCount, lineCount, brickDimensionRatio);
    }

    /**
     * This method is to get all bricks for all level
     * @return Bricks for all level
     */
    public Brick[][] getLevels() {
        return levels;
    }

    /**
     * This method is used to generate a single brick type level
     * @param drawArea Draw area of bricks
     * @param brickCnt Total number of bricks needed
     * @param lineCnt Total number of lines of brick needed
     * @param brickSizeRatio Brick's width to height ratio
     * @param type Brick's type
     * @return Single brick type level
     */
    private Brick[] makeSingleTypeLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int type){
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller then brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        Brick[] tmp  = new Brick[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            double x = (i % brickOnLine) * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,type);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            switch (type){
                case CLAY -> tmp[i] = new ClayBrick(p,brickSize);
                case CEMENT -> tmp[i] = new CementBrick(p,brickSize);
                case STEEL -> tmp[i] = new SteelBrick(p,brickSize);
                case SUPREME -> tmp[i] = new SupremeBrick(p,brickSize);
            }
        }
        return tmp;

    }

    /**
     * This method is used to generate a chessboard brick type level where each brick is different from its adjacent brick
     * @param drawArea Draw area of bricks
     * @param brickCnt Total number of bricks needed
     * @param lineCnt Total number of lines of brick needed
     * @param brickSizeRatio Brick's width to height ratio
     * @param typeA Brick's type
     * @param typeB Brick's type
     * @return Chessboard brick type level
     */
    private Brick[] makeChessboardLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int typeA, int typeB){
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller then brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        int centerLeft = brickOnLine / 2 - 1;
        int centerRight = brickOnLine / 2 + 1;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        Brick[] tmp  = new Brick[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            int posX = i % brickOnLine;
            double x = posX * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);

            boolean b = ((line % 2 == 0 && i % 2 == 0) || (line % 2 != 0 && posX > centerLeft && posX <= centerRight));
            tmp[i] = b ?  makeBrick(p,brickSize,typeA) : makeBrick(p,brickSize,typeB);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,typeA);
        }
        return tmp;
    }

    /**
     * This method is used to generate levels of this game
     * @param drawArea Draw area of bricks
     * @param brickCount Total number of bricks needed
     * @param lineCount Total number of lines of brick needed
     * @param brickDimensionRatio Brick's width to height ratio
     * @return Bricks of all level
     */
    private Brick[][] makeLevels(Rectangle drawArea,int brickCount,int lineCount,double brickDimensionRatio){
        Brick[][] tmp = new Brick[LEVELS_COUNT][];
        tmp[0] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY);
        tmp[1] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,CEMENT);
        tmp[2] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,STEEL);
        tmp[3] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CEMENT);
        tmp[4] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL,CEMENT);
        tmp[5] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL);
        tmp[6] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL,SUPREME);
        tmp[7] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,SUPREME);
        return tmp;
    }

    /**
     * This method is used to create brick
     * @param point Top left location of brick
     * @param size Size of brick
     * @param type Type of brick
     * @return Brick
     */
    private Brick makeBrick(Point point, Dimension size, int type){
        return switch (type) {
            case CLAY -> new ClayBrick(point, size);
            case STEEL -> new SteelBrick(point, size);
            case CEMENT -> new CementBrick(point, size);
            case SUPREME -> new SupremeBrick(point,size);
            default -> throw new IllegalArgumentException(String.format("Unknown Type:%d\n", type));
        };
    }
}
