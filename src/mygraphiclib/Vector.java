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
        x = 1;
        y = 1;
        z = 1;
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
        double c = Math.cos(rot);
        double s = Math.sin(rot);
        //this.x = this.x;
        this.y = y * c + z * s;
        this.z = - y * s + z * c;
        return this;
    }
    
    public Vector rotateY(double rotation) {
        double rot = Math.toRadians(rotation);
        double c = Math.cos(rot);
        double s = Math.sin(rot);
        this.x = x * c - z * s;
        //this.y = this.y;
        this.z = x * s + z * c;
        return this;
    }
    
    public Vector rotateZ(double rotation) {
        double rot = Math.toRadians(rotation);
        double c = Math.cos(rot);
        double s = Math.sin(rot);
        this.x = x * c + y * s;
        this.y = - x * s + y * c;
        //this.z = this.z;
        return this;
    }
    
    public static Vector getSum(Vector vector1, Vector vector2) {
        return new Vector(
                vector1.getX() + vector2.getX(), 
                vector1.getY() + vector2.getY(), 
                vector1.getZ() + vector2.getZ());
    }
    /*
    public static Vector getRotate(Vector vector1, Vector vector2) {
        return new Vector(
                vector1.getY() * vector2.getZ() - vector1.getZ() * vector2.getY(),
                vector1.getZ() * vector2.getX() - vector1.getX() * vector2.getZ(),
                vector1.getX() * vector2.getY() - vector1.getY() * vector2.getX()
                );
    }
    */
    public static Vector getRotate(Vector vector1, Vector vector2) {
            return new Vector(
                vector1.getX() * vector2.getX(), 
                vector1.getY() * vector2.getY(), 
                vector1.getZ() * vector2.getZ());
    }
    
    public static Vector getMultiple(Vector vector1, Vector vector2) {
        //a × b = {aybz - azby; azbx - axbz; axby - aybx}
        return new Vector(vector1.getY() * vector2.getZ() - 
                vector1.getZ() * vector2.getY(), 
                vector1.getZ() * vector2.getX() - 
                vector1.getX() * vector2.getZ(), 
                vector1.getX() * vector2.getY() - 
                vector1.getY() * vector2.getX());
    }
    
    public static double getScalar(Vector vector1, Vector vector2) {
        //a · b = ax · bx + ay · by + az · bz
        return vector1.getX() * vector2.getX() +
                vector1.getY() * vector2.getY() +
                vector1.getZ() * vector2.getZ();
    }
    
    @Override
    public String toString() {
        return (getClass().getSimpleName() + 
                ": (" + getX() + "; " + getY() + "; " + getZ() + ")");
    }
    
    public Vector normalize() {
        double max = 1.0 / Math.sqrt(x * x + y * y + z * z);
        x *= max;
        y *= max;
        z *= max;
        return this;
    }
}
