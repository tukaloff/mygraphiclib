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
    
    public LineObject3D(ArrayList<Line3D> lines) {
        super.lines = lines;
    }
    
    public void drawOrtho(BufferedImage bi) {
        System.out.println("TriangleObject3D: drawOrtho");
        for (Line3D l : super.lines) {
            Color color = Color.GRAY;
            int x1 = (int) l.getOrthoV1().getX();
            int y1 = (int) l.getOrthoV1().getY();
            int x2 = (int) l.getOrthoV2().getX();
            int y2 = (int) l.getOrthoV2().getY();
            drawLine(x1, y1, x2, y2, bi, color.getRGB());
            System.out.println(x1 + "/" + y1 + "/" + x2 + "/" + y2);
        }
    }
    
    public void drawPerspective(BufferedImage bi) {
        System.out.println("TriangleObject3D: drawPerspective");
        for (Line3D l : super.lines) {
            Color color = Color.GRAY;
            int x1 = (int) l.getPerspectiveV1().getX();
            int y1 = (int) l.getPerspectiveV1().getY();
            int x2 = (int) l.getPerspectiveV2().getX();
            int y2 = (int) l.getPerspectiveV2().getY();
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
