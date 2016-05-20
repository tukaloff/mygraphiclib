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
    
    public Cube(Vector vector) {
        super(vector);
        Vertex3D v0 = new Vertex3D(100, 100, 100);
        Vertex3D v1 = new Vertex3D(100, -100, 100);
        Vertex3D v2 = new Vertex3D(100, -100, -100);
        Vertex3D v3 = new Vertex3D(100, 100, -100);
        Vertex3D v4 = new Vertex3D(-100, 100, 100);
        Vertex3D v5 = new Vertex3D(-100, 100, -100);
        Vertex3D v6 = new Vertex3D(-100, -100, 100);
        Vertex3D v7 = new Vertex3D(-100, -100, -100);
        
        super.add(v0);
        super.add(v1);
        super.add(v2);
        super.add(v3);
        super.add(v4);
        super.add(v5);
        super.add(v6);
        super.add(v7);
        
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
        super.setLine(6, 7);
    }

    public void paint(BufferedImage bi) {
        super.paintLines(bi);
    }
}
