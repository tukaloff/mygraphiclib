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
    
    //private double[][] matrix = TransformMatrix.getSimpleMatrix();
    private Vector vector;
    
    public Vertex3D() {
        
    }
    
    public Vertex3D(double x, double y, double z) {
        this.vector = new Vector(x, y, z);
    }
    
    public Vertex3D(Vector vector) {
        this.vector = vector;
    }
    
    public Vector getVector() {
        return vector;
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
        return new OrthoVertex(this, vector);
    }
}
