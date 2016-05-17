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
            drawLine(x1, y1, x2, y2, bi, color.getRGB());
            System.out.println(x1 + "/" + y1 + "/" + x2 + "/" + y2);
            
            x1 = (int) t.getLine2().getOrthoV1().getX();
            y1 = (int) t.getLine2().getOrthoV1().getY();
            x2 = (int) t.getLine2().getOrthoV2().getX();
            y2 = (int) t.getLine2().getOrthoV2().getY();
            drawLine(x1, y1, x2, y2, bi, color.getRGB());
            System.out.println(x1 + "/" + y1 + "/" + x2 + "/" + y2);
            
            x1 = (int) t.getLine3().getOrthoV1().getX();
            y1 = (int) t.getLine3().getOrthoV1().getY();
            x2 = (int) t.getLine3().getOrthoV2().getX();
            y2 = (int) t.getLine3().getOrthoV2().getY();
            drawLine(x1, y1, x2, y2, bi, color.getRGB());
            System.out.println(x1 + "/" + y1 + "/" + x2 + "/" + y2);
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
            drawLine(x1, y1, x2, y2, bi, color.getRGB());
            System.out.println(x1 + "/" + y1 + "/" + x2 + "/" + y2);
            
            x1 = (int) t.getLine2().getPerspectiveV1().getX();
            y1 = (int) t.getLine2().getPerspectiveV1().getY();
            x2 = (int) t.getLine2().getPerspectiveV2().getX();
            y2 = (int) t.getLine2().getPerspectiveV2().getY();
            drawLine(x1, y1, x2, y2, bi, color.getRGB());
            System.out.println(x1 + "/" + y1 + "/" + x2 + "/" + y2);
            
            x1 = (int) t.getLine3().getPerspectiveV1().getX();
            y1 = (int) t.getLine3().getPerspectiveV1().getY();
            x2 = (int) t.getLine3().getPerspectiveV2().getX();
            y2 = (int) t.getLine3().getPerspectiveV2().getY();
            drawLine(x1, y1, x2, y2, bi, color.getRGB());
            System.out.println(x1 + "/" + y1 + "/" + x2 + "/" + y2);
        }
    }

    private void drawLine(int x1, int y1, int x2, int y2, BufferedImage bi, int rgb) {
        boolean steep = false;
        if (Math.abs(x2 - x1) < Math.abs(y2 - y1)) {
            int tmp = x1;
            x1 = y1;
            y1 = tmp;
            tmp = x2;
            x2 = y2;
            y2 = tmp;
            steep = true;
        }
        if (x1 > x2) {
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        for (int x = x1; x <= x2; x++) {
            float t = (x - x1) / (float) (x2 - x1);
            int y = (int) (y1 * (1.0 - t) + y2 * t);
            int w = bi.getWidth();
            int h = bi.getHeight();
            if (steep) {
                int rx = w / 2 + y;
                int ry = h - (h / 2 + x);
                if (!(rx < 0 || rx >= w || ry < 0 || ry >= h))
                    bi.setRGB(rx, ry, rgb);
            } else {
                int rx = w / 2 + x;
                int ry = h - (h / 2 + y);
                if (!(rx < 0 || rx >= w || ry < 0 || ry >= h))
                    bi.setRGB(rx, ry, rgb);
            }
        }
    }
}
