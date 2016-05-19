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
    
    public PerspectiveVertex(Vertex3D v3d, Vector vector) {
        double x3 = v3d.getX()/* + vector.getX()*/;
        double y3 = v3d.getY()/* + vector.getY()*/;
        double z3 = v3d.getZ()/* + vector.getZ()*/;
        //System.out.println(x3 + "/" + y3 + "/" + z3);
        double k = 100;
        x = (double)(k * x3) / (double)(z3 + k);
        y = (double)(k * y3) / (double)(z3 + k);
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
}
