/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

/**
 *
 * @author tukalov
 */
public class Vertex3D {
    
    private double x;
    private double y;
    private double z;
    
    public Vertex3D() {
        x = 0;
        y = 0;
        z = 0;
    }
    
    public Vertex3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getZ() {
        return z;
    }
    
    public OrthoVertex getOrtho() {
        return new OrthoVertex(this);
    }
    
    public PerspectiveVertex getPerspective() {
        return new PerspectiveVertex(this);
    }
}
