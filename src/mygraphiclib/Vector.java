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
public class Vector {
    
    private double x;
    private double y;
    private double z;
    
    public Vector() {
        x = 0;
        y = 0;
        z = 0;
    }
    
    public Vector(double x, double y, double z) {
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
    
    public Vector rotateX(double rotation) {
        double rot = Math.toRadians(rotation);
        //this.x = this.x;
        this.y = y * Math.cos(rot) - z * Math.sin(rot);
        this.z = y * Math.sin(rot) + z * Math.cos(rot);
        return this;
    }
    
    public Vector rotateY(double rotation) {
        double rot = Math.toRadians(rotation);
        this.x = x * Math.cos(rot) + z * Math.sin(rot);
        //this.y = this.y;
        this.z = - x * Math.sin(rot) + z * Math.cos(rot);
        return this;
    }
    
    public Vector rotateZ(double rotation) {
        double rot = Math.toRadians(rotation);
        this.x = x * Math.cos(rot) - y * Math.sin(rot);
        this.y = x * Math.sin(rot) + y * Math.cos(rot);
        //this.z = this.z;
        return this;
    }
}
