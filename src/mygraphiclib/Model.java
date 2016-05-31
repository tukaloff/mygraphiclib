/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

import java.awt.image.BufferedImage;

/**
 *
 * @author tukalov
 */
public class Model {
    
    private Object3D object;
    private Vector vector;
    private Light light;
    private boolean finished = false;
    
    public Model(Vector vector) {
        this.vector = vector;
        //Tetrahedron th = new Tetrahedron(vector);
        Cube cube = new Cube(vector, 100);
        light = new Light();
        object = cube;
    }
    
    public Object3D getDraw() {
        return object;
    }
    
    public void paint(BufferedImage bi) {
        finished = false;
        switch(object.getClass().getSimpleName()) {
            case "Tetrahedron": {
                ((Tetrahedron)object).paint(bi, light);
                break;
            }
            case "Cube": {
                ((Cube)object).paint(bi, light);
                break;
            }
            default:
                System.out.println(object.getClass().getName());
        }
        finished = true;
    }
    
    public boolean isFinished() {
        return finished;
    }
    
    public Vector getVector() {
        return vector;
    }
}
