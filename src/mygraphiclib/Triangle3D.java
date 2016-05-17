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
    
    public Triangle3D() {
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
    
    public double getPerimeter() {
        return l1.getLenght() + l2.getLenght() + l3.getLenght();
    }
    
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - l1.getLenght()) 
                * (p - l2.getLenght()) 
                * (p - l3.getLenght()));
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

    public Color getColor() {
        return Color.WHITE;
    }
}
