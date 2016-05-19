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
public class OrthoVertex {
    
    private double x;
    private double y;
    
    public OrthoVertex(Vertex3D v3d, Vector basis) {
        this.x = basis.getX();
        this.y = basis.getY();
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
}
