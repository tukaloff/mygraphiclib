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
        Vertex3D v0 = new Vertex3D(new Vector(100, 100, 100));
        Vertex3D v1 = new Vertex3D(new Vector(100, -100, 100));
        Vertex3D v2 = new Vertex3D(new Vector(100, -100, -100));
        Vertex3D v3 = new Vertex3D(new Vector(100, 100, -100));
        Vertex3D v4 = new Vertex3D(new Vector(-100, 100, 100));
        Vertex3D v5 = new Vertex3D(new Vector(-100, 100, -100));
        Vertex3D v6 = new Vertex3D(new Vector(-100, -100, 100));
        Vertex3D v7 = new Vertex3D(new Vector(-100, -100, -100));
        object = new Object3D(vector, basis);
        object.add(v0);
        object.add(v1);
        object.add(v2);
        object.add(v3);
        object.add(v4);
        object.add(v5);
        object.add(v6);
        object.add(v7);
        
        object.setLine(0, 1);
        object.setLine(0, 3);
        object.setLine(0, 4);
        object.setLine(1, 2);
        object.setLine(1, 6);
        object.setLine(2, 3);
        object.setLine(2, 7);
        object.setLine(3, 5);
        object.setLine(4, 6);
        object.setLine(4, 5);
        object.setLine(5, 7);
        object.setLine(6, 7);
        
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
