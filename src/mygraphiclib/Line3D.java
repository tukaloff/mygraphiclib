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
public class Line3D {
    
    private Vertex3D v1;
    private Vertex3D v2;
    private Color color;
    
    public Line3D() {
        this.v1 = new Vertex3D();
        this.v2 = new Vertex3D();
        this.color = Color.WHITE;
    }
    
    public Line3D(Vertex3D v1, Vertex3D v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.color = Color.WHITE;
    }
    
    public Vertex3D getV1() {
        return v1;
    }
    
    public OrthoVertex getOrthoV1() {
        return v1.getOrtho();
    }
    
    public Vertex3D getV2() {
        return v2;
    }
    
    public OrthoVertex getOrthoV2() {
        return v2.getOrtho();
    }
    
    public double getLenght() {
        double x1 = v1.getX();
        double y1 = v1.getY();
        double z1 = v1.getZ();
        double x2 = v2.getX();
        double y2 = v2.getY();
        double z2 = v2.getZ();
        return Math.sqrt(Math.pow((x2 - x1), 2) 
                + Math.pow((y2 - y1), 2)
                + Math.pow((z2 - z1), 2));
    }

    public PerspectiveVertex getPerspectiveV1(Vector basisVector) {
        return v1.getPerspective(basisVector);
    }

    public PerspectiveVertex getPerspectiveV2(Vector basisVector) {
        return v2.getPerspective(basisVector);
    }
    
    public Color getColor() {
        return this.color;
    }
}
