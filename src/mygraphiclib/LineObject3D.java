package mygraphiclib;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tukalov
 */
public class LineObject3D extends Object3D{

    public LineObject3D(Vector basisVector) {
        super(basisVector);
    }
    /*
    public LineObject3D(ArrayList<Line3D> lines, Vector basisVector) {
        super.lines = lines;
        super.basisVector = basisVector;
    }
    */
    public void drawOrtho(BufferedImage bi) {
        //System.out.println("TriangleObject3D: drawOrtho");
        for (Line3D l : super.lines) {
            Color color = new Color(50, 50, 50);
            int x1 = (int) l.getOrthoV1().getX();
            int y1 = (int) l.getOrthoV1().getY();
            int x2 = (int) l.getOrthoV2().getX();
            int y2 = (int) l.getOrthoV2().getY();
            super.drawLine(x1, y1, x2, y2, bi, color.getRGB());
        }
    }
    
    public void drawPerspective(BufferedImage bi) {
        //System.out.println("TriangleObject3D: drawPerspective");
        for (Line3D l : super.lines) {
            Color color = new Color(50, 50, 50);
            int x1 = (int) l.getPerspectiveV1(basisVector).getX();
            int y1 = (int) l.getPerspectiveV1(basisVector).getY();
            int x2 = (int) l.getPerspectiveV2(basisVector).getX();
            int y2 = (int) l.getPerspectiveV2(basisVector).getY();
            super.drawLine(x1, y1, x2, y2, bi, color.getRGB());
        }
    }
}
