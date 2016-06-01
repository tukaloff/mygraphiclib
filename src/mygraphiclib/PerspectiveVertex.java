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
    private double z;
    
    public PerspectiveVertex(Vector vector) {
        double x3 = vector.getX();
        double y3 = vector.getY();
        double z3 = vector.getZ();
        //System.out.println(x3 + "/" + y3 + "/" + z3);
        double k = Preferences.getDistance();
        x = (k * x3) / z3;
        y = (k * y3) / z3;
        z = z3;
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
    
    public Vector getVector() {
        return new Vector(x, y, z);
    }
}
