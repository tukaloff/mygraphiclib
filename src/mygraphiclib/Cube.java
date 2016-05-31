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
public class Cube extends Object3D{
    
    public Cube(Vector vector, double edge) {
        super(vector);
        Vertex3D v0 = new Vertex3D(edge, edge, edge);
        Vertex3D v1 = new Vertex3D(edge, -edge, edge);
        Vertex3D v2 = new Vertex3D(edge, -edge, -edge);
        Vertex3D v3 = new Vertex3D(edge, edge, -edge);
        Vertex3D v4 = new Vertex3D(-edge, edge, edge);
        Vertex3D v5 = new Vertex3D(-edge, edge, -edge);
        Vertex3D v6 = new Vertex3D(-edge, -edge, edge);
        Vertex3D v7 = new Vertex3D(-edge, -edge, -edge);
        
        super.add(v0);
        super.add(v1);
        super.add(v2);
        super.add(v3);
        super.add(v4);
        super.add(v5);
        super.add(v6);
        super.add(v7);
        /*
        super.setLine(0, 1);
        super.setLine(0, 3);
        super.setLine(0, 4);
        super.setLine(1, 2);
        super.setLine(1, 6);
        super.setLine(2, 3);
        super.setLine(2, 7);
        super.setLine(3, 5);
        super.setLine(4, 6);
        super.setLine(4, 5);
        super.setLine(5, 7);
        super.setLine(6, 7);*/
        super.setTriangle(0, 1, 2);
        super.setTriangle(0, 3, 2);
        super.setTriangle(0, 3, 5);
        super.setTriangle(0, 4, 5);
        super.setTriangle(0, 3, 5);
        super.setTriangle(0, 1, 6);
        super.setTriangle(0, 4, 6);
        super.setTriangle(7, 2, 3);
        super.setTriangle(7, 5, 3);
        super.setTriangle(7, 2, 1);
        super.setTriangle(7, 6, 1);
        super.setTriangle(7, 5, 4);
        super.setTriangle(7, 6, 4);
    }

    public void paint(BufferedImage bi, Light light) {
        //super.paintLines(bi);
        super.paintTriangles(bi, light);
    }
}
