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
public class Tetrahedron extends Object3D{
    
    public Tetrahedron(Vector basis) {
        super(basis);
        Vertex3D v0 = new Vertex3D(100, 100, 100);
        Vertex3D v1 = new Vertex3D(-100, -100, 100);
        Vertex3D v2 = new Vertex3D(-100, 100, -100);
        Vertex3D v3 = new Vertex3D(100, -100, -100);
        super.addTriangle(v0, v1, v2);
        super.addTriangle(v0, v1, v3);
        super.addTriangle(v2, v3, v0);
        super.addTriangle(v2, v3, v1);
    }
    
    public void paint(BufferedImage bi, Light light) {
        super.paintTriangles(bi, light);
    }
}
