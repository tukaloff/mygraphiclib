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
public class VertexObject3D extends Object3D{

    public VertexObject3D(Vector basisVector) {
        super(basisVector);
    }
    /*
    public VertexObject3D(ArrayList<Vertex3D> vertexes) {
        super.vertexes = vertexes;
    }
    */
    public double getMaxZ() {
        double z = 0;
        for (Vertex3D v : vertexes) {
            if (v.getZ() > z)
                z = v.getZ();
        }
        return z;
    }
    
    public double getMinZ() {
        double z = 0;
        for (Vertex3D v : vertexes) {
            if (v.getZ() < z)
                z = v.getZ();
        }
        return z;
    }
}
