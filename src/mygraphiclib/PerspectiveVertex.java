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
public class PerspectiveVertex {
    
    private double x;
    private double y;
    
    public PerspectiveVertex(Vertex3D v3d) {
        double x3 = v3d.getX();
        double y3 = v3d.getY();
        double z3 = v3d.getZ();
        int k = 100;
        x = k * x3 / (z3 + k);
        y = k * y3 / (z3 + k);
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
}
