/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

import java.awt.Color;

/**
 *
 * @author tukalov
 */
public class Triangle3D {
    
    private Vertex3D v1;
    private Vertex3D v2;
    private Vertex3D v3;
    private Line3D l1;
    private Line3D l2;
    private Line3D l3;
    private int rgbColor;
    
    private double xDet, yDet, zDet;
    
    public Triangle3D() {
        int c = Color.BLACK.getRGB();
        double r = Math.random();
        this.rgbColor = (int) (c * r);
        v1 = new Vertex3D();
        v2 = new Vertex3D();
        v3 = new Vertex3D();
        l1 = new Line3D(v1, v2);
        l2 = new Line3D(v1, v3);
        l3 = new Line3D(v2, v3);
    }
    
    public Triangle3D(Vertex3D v1, Vertex3D v2, Vertex3D v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        l1 = new Line3D(v1, v2);
        l2 = new Line3D(v1, v3);
        l3 = new Line3D(v2, v3);
    }
    /*
    public double getPerimeter() {
        return l1.getLenght() + l2.getLenght() + l3.getLenght();
    }*/
    /*
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - l1.getLenght()) 
                * (p - l2.getLenght()) 
                * (p - l3.getLenght()));
    }*/
    
    public void setPaint(int color) {
        this.rgbColor = color;
    }
    
    public Color getPaint() {
        return new Color(rgbColor);
    }
    
    public Vertex3D getV1() {
        return v1;
    }
    
    public Vertex3D getV2() {
        return v2;
    }
    
    public Vertex3D getV3() {
        return v3;
    }
    
    public Line3D getLine1() {
        return l1;
    }
    
    public Line3D getLine2() {
        return l2;
    }
    
    public Line3D getLine3() {
        return l3;
    }

    public int getColor() {
        return rgbColor;
    }
    
    public Vertex3D getUp() {
        double y1 = this.v1.getY();
        double y2 = this.v2.getY();
        double y3 = this.v3.getY();
        double max = y1;
        if (max > y2) 
            max = y2;
        if (max > y3)
            max = y3;
        if (max == y1)
            return this.v1;
        if (max == y2) 
            return this.v2;
        return this.v3;
    }
    
    public double getDeterminant(double a, double b, double c, double d) {
        return a * d - b * c;
    }
    
    public void calcPlaneEquation() {
        double x0 = v1.getX();
        double x1 = v2.getX();
        double x2 = v3.getX();
        double y0 = v1.getY();
        double y1 = v2.getY();
        double y2 = v3.getY();
        double z0 = v1.getZ();
        double z1 = v2.getZ();
        double z2 = v3.getZ();
        xDet = getDeterminant(y1 - y0, y2 - y0, z1 - z0, z2 - z0);
        yDet = getDeterminant(x1 - x0, x2 - x0, z1 - z0, z2 - z0);
        zDet = getDeterminant(x1 - x0, x2 - x0, y1 - y0, y2 - y0);
    }
}
