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
    private Vector basis = new Vector(1, 1, 1);
    
    public Model(Vector vector) {
        this.vector = vector;
        Vertex3D v1 = new Vertex3D(new Vector(100, 100, 100));
        Vertex3D v2 = new Vertex3D(new Vector(-100, -100, 100));
        Vertex3D v3 = new Vertex3D(new Vector(-100, 100, -100));
        Vertex3D v4 = new Vertex3D(new Vector(100, -100, -100));
        object = new Object3D(vector, basis);
        object.add(v1);
        object.add(v2);
        object.add(v3);
        object.add(v4);
        
        object.setLine(0, 1);
        object.setLine(0, 2);
        object.setLine(1, 2);
        object.setLine(3, 0);
        object.setLine(3, 1);
        object.setLine(3, 2);
        
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
