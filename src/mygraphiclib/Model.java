/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

import java.util.ArrayList;

/**
 *
 * @author tukalov
 */
public class Model {
    
    private TriangleObject3D to;
    
    public Model() {
        Vertex3D v1 = new Vertex3D(-200, -100, 10);
        Vertex3D v2 = new Vertex3D(500, -200, 100);
        Vertex3D v3 = new Vertex3D(300, 400, 50);
        Triangle3D t = new Triangle3D(v1, v2, v3);
        ArrayList<Triangle3D> ta = new ArrayList<>();
        ta.add(t);
        to = new TriangleObject3D(ta);
    }
    
    public TriangleObject3D getDraw() {
        return to;
    }
}
