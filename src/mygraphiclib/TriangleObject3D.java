/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author tukalov
 */
public class TriangleObject3D extends Object3D{
    
    public TriangleObject3D (ArrayList<Triangle3D> triangles) {
        super.triangles = triangles;
    }
    
    public void drawOrtho(BufferedImage bi) {
        System.out.println("TriangleObject3D: drawOrtho");
        for (Triangle3D t : triangles) {
            Color color = t.getColor();
            int x1 = (int) t.getLine1().getOrthoV1().getX();
            int y1 = (int) t.getLine1().getOrthoV1().getY();
            int x2 = (int) t.getLine1().getOrthoV2().getX();
            int y2 = (int) t.getLine1().getOrthoV2().getY();
            super.drawLine(x1, y1, x2, y2, bi, color.getRGB());
            
            x1 = (int) t.getLine2().getOrthoV1().getX();
            y1 = (int) t.getLine2().getOrthoV1().getY();
            x2 = (int) t.getLine2().getOrthoV2().getX();
            y2 = (int) t.getLine2().getOrthoV2().getY();
            super.drawLine(x1, y1, x2, y2, bi, color.getRGB());
            
            x1 = (int) t.getLine3().getOrthoV1().getX();
            y1 = (int) t.getLine3().getOrthoV1().getY();
            x2 = (int) t.getLine3().getOrthoV2().getX();
            y2 = (int) t.getLine3().getOrthoV2().getY();
            super.drawLine(x1, y1, x2, y2, bi, color.getRGB());
        }
    }
    
    public void drawPerspective(BufferedImage bi) {
        System.out.println("TriangleObject3D: drawPerspective");
        for (Triangle3D t : triangles) {
            Color color = t.getColor();
            int x1 = (int) t.getLine1().getPerspectiveV1().getX();
            int y1 = (int) t.getLine1().getPerspectiveV1().getY();
            int x2 = (int) t.getLine1().getPerspectiveV2().getX();
            int y2 = (int) t.getLine1().getPerspectiveV2().getY();
            super.drawLine(x1, y1, x2, y2, bi, color.getRGB());
            
            x1 = (int) t.getLine2().getPerspectiveV1().getX();
            y1 = (int) t.getLine2().getPerspectiveV1().getY();
            x2 = (int) t.getLine2().getPerspectiveV2().getX();
            y2 = (int) t.getLine2().getPerspectiveV2().getY();
            super.drawLine(x1, y1, x2, y2, bi, color.getRGB());
            
            x1 = (int) t.getLine3().getPerspectiveV1().getX();
            y1 = (int) t.getLine3().getPerspectiveV1().getY();
            x2 = (int) t.getLine3().getPerspectiveV2().getX();
            y2 = (int) t.getLine3().getPerspectiveV2().getY();
            super.drawLine(x1, y1, x2, y2, bi, color.getRGB());
        }
    }

    
}
