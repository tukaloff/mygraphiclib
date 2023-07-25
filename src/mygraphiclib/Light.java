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
public class Light {
    
    private Vector location;
    private Vector direction;
    private double distance;
    private double intensity;
    
    public Light() {
        this.location = new Vector();
        this.direction = new Vector(0, 0, 1);
        this.distance = 600;
        this.intensity = 0.8;
    }
    
    public Vector getLocation() {
        return location;
    }
    
    public Vector getDirection() {
        return direction;
    }
    
    public double getDistance() {
        return distance;
    }
    
    public double getIntensity() {
        return intensity;
    }
}
