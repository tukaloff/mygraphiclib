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
public class Preferences {
    
    private static int distance = 500;

    public Preferences() {
        
    }
    
    public static void setDistance(int distance) {
        Preferences.distance = distance;
    }
    
    public static int getDistance() {
        return distance;
    }
    
}
