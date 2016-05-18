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
    private Vector vector;
    
    public Vertex3D() {
        /*x = 0;
        y = 0;
        z = 0;*/
        this.vector = new Vector();
    }
    
    public Vertex3D(double x, double y, double z) {
        /*this.x = x;
        this.y = y;
        this.z = z;*/
        this.vector = new Vector(x, y, z);
    }
    
    public Vertex3D(Vector vector) {
        this.vector = vector;
    }
    
    public double getX() {
        return vector.getX();
    }
    
    public double getY() {
        return vector.getY();
    }
    
    public double getZ() {
        return vector.getZ();
    }
    
    public OrthoVertex getOrtho() {
        return new OrthoVertex(this);
    }
    
    public PerspectiveVertex getPerspective() {
        return new PerspectiveVertex(this);
    }
    
    public void rotate(double rx, double ry, double rz) {
        if(rx > 0)
            vector.rotateX(rx);
        if(ry > 0)
            vector.rotateY(ry);
        if(rz > 0)
            vector.rotateZ(rz);
    }
}
