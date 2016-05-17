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
public class Object3D{
    
    protected ArrayList<Vertex3D> vertexes;
    protected ArrayList<Line3D> lines;
    protected ArrayList<Triangle3D> triangles;
    private int lx = 0;
    private int ly = 0;
    protected int distX;
    protected int distY;
    
    public Object3D() {
        vertexes = new ArrayList<>();
        vertexes.add(new Vertex3D());
    }
}
