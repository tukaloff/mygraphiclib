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
public class Object3D{
    
    protected ArrayList<Vertex3D> vertexes = new ArrayList<>();
    protected ArrayList<Line3D> lines = new ArrayList<>();
    protected ArrayList<Triangle3D> triangles = new ArrayList<>();
    protected int distX;
    protected int distY;
    protected Vector basisVector;
    //protected Vector rotation;
    
    protected double rx = 0;
    protected double ry = 0;
    protected double rz = 0;
    
    public Object3D(Vector basis/*, Vector rotation*/) {
        this.basisVector = basis;
        //this.rotation = rotation;
    }
    
    public void add(Vertex3D v)  {
        this.vertexes.add(v);
    }
    
    public void setLine(int x1, int x2) {
        int vCount = this.vertexes.size();
        if (x1 >= 0 && x1 < vCount && x2 >= 0 && x2 < vCount) {
            lines.add(new Line3D(vertexes.get(x1), vertexes.get(x2)));
        }
    }
    
    public void addLine(Vertex3D v1, Vertex3D v2) {
        vertexes.add(v1);
        vertexes.add(v2);
        lines.add(new Line3D(v1, v2));
    }
    
    public void addLine(Line3D line) {
        vertexes.add(line.getV1());
        vertexes.add(line.getV2());
        lines.add(line);
    }
    
    public void setTriangle(int x1, int x2, int x3) {
        int vCount = this.vertexes.size();
        if (x1 >= 0 && x1 < vCount 
                && x2 >= 0 && x2 < vCount
                && x3 >= 0 && x3 < vCount) {
            triangles.add(new Triangle3D(vertexes.get(x1), vertexes.get(x2), vertexes.get(x3)));
        }
    }
    
    public void addTriangle(Vertex3D v1, Vertex3D v2, Vertex3D v3) {
        vertexes.add(v1);
        vertexes.add(v2);
        vertexes.add(v3);
        triangles.add(new Triangle3D(v1, v2, v3));
    }
    
    public void paintLines(BufferedImage bi) {
        for(Line3D line : lines) {
            transformNDrawLine(line, bi);
        }
    }
    
    public void transformNDrawLine(Line3D line, BufferedImage bi) {
        Vector vector1 = getVectorTransform(line.getV1().getVector());
        Vector vector2 = getVectorTransform(line.getV2().getVector());
        PerspectiveVertex pv1 = new PerspectiveVertex(vector1);
        PerspectiveVertex pv2 = new PerspectiveVertex(vector2);
        drawLine((int)pv1.getX(), (int)pv1.getY(), 
                (int)pv2.getX(), (int)pv2.getY(), 
                bi, Color.WHITE.getRGB());
    }
    
    protected Vector getVectorTransform(Vector v) {
        Vector rot = TransformMatrix.rotate(v, rx, ry, rz);
        Vector absVector1 = Vector.getSum(basisVector, rot);
        return absVector1;
    }
    
    public void paintTriangles(BufferedImage bi) {
        for(Triangle3D tr : triangles) {
            transformNDrawLine(tr.getLine1(), bi);
            transformNDrawLine(tr.getLine2(), bi);
            transformNDrawLine(tr.getLine3(), bi);
        }
    }
    
    public void rotate(double rx, double ry, double rz) {
        this.rx += rx;
        this.ry += ry;
        this.rz += rz;
    }
    
    protected void drawLine(int x1, int y1, int x2, int y2, BufferedImage bi, int rgb) {
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
            int y = (int) ((y1 + 0.005) * (1.0 - t) + (y2 + 0.005) * t);
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
