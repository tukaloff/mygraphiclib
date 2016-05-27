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
    
    public Model(Vector vector) {
        this.vector = vector;
        //Tetrahedron th = new Tetrahedron(vector);
        Cube cube = new Cube(vector, 100);
        object = cube;
    }
    
    public Object3D getDraw() {
        return object;
    }
    
    public void paint(BufferedImage bi) {
        switch(object.getClass().getSimpleName()) {
            case "Tetrahedron": {
                ((Tetrahedron)object).paint(bi);
                break;
            }
            case "Cube": {
                ((Cube)object).paint(bi);
                break;
            }
            default:
                System.out.println(object.getClass().getName());
        }
    }
    
    public Vector getVector() {
        return vector;
    }
}
