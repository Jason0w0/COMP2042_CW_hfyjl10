package model;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class SupremeBrick extends Brick{

    private static final Color DEF_INNER = new Color(250, 1, 1);
    private static final Color DEF_BORDER = Color.BLACK;
    private static final int SUPREME_STRENGTH = 4;

    private final Crack crack;
    private Shape brickFace;

    public SupremeBrick(Point point, Dimension size){
        super(point,size,DEF_BORDER,DEF_INNER,SUPREME_STRENGTH);
        crack = new Crack(DEF_CRACK_DEPTH,DEF_STEPS);
        brickFace = super.brickFace;
    }


    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick() {
        return brickFace;
    }

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

    private void updateBrick(){
        if(!super.isBroken()){
            GeneralPath gp = crack.draw();
            gp.append(super.brickFace,false);
            brickFace = gp;
        }
    }

    public void repair(){
        super.repair();
        crack.reset();
        brickFace = super.brickFace;
    }
}
