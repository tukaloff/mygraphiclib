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
public class Model {
    
    private Object3D object;
    private Vector vector;
    
    public Model(Vector vector) {
        Vertex3D v1 = new Vertex3D(-200, -100, 10);
        Vertex3D v2 = new Vertex3D(500, -200, 100);
        Vertex3D v3 = new Vertex3D(300, 400, 50);
        this.vector = vector;
        object = new Object3D(vector);
        object.add(v1);
        object.add(v2);
        object.add(v3);
        
        object.setLine(0, 1);
        object.setLine(0, 2);
        object.setLine(1, 2);
        
        /*
        object.addLine(v1, v2);
        object.addLine(v1, v3);
        object.addLine(v2, v3);
        */
    }
    
    public Object3D getDraw() {
        return object;
    }
    
    public Vector getVector() {
        return vector;
    }
}
