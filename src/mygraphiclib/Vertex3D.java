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
public class Vertex3D {
    
    private double x;
    private double y;
    private double z;
    private double[][] matrix = TransformMatrix.getSimpleMatrix();
    private Vector vector;
    
    public Vertex3D() {
        x = 0;
        y = 0;
        z = 0;
        //this.vector = new Vector();
    }
    
    public Vertex3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.vector = new Vector(x, y, z);
        /*matrix = TransformMatrix.getTranslate(this.vector);*/
        translate(vector);
    }
    /*
    public Vertex3D(Vector vector) {
        this.vector = vector;
    }
    */
    public double getX() {
        return TransformMatrix.getXFromMatrix(matrix);
    }
    
    public double getY() {
        return TransformMatrix.getYFromMatrix(matrix);
    }
    
    public double getZ() {
        return TransformMatrix.getZFromMatrix(matrix);
    }
    
    public OrthoVertex getOrtho() {
        return new OrthoVertex(this);
    }
    
    public PerspectiveVertex getPerspective(Vector vector) {
        return new PerspectiveVertex(this, vector);
    }
    
    public void rotate(double rx, double ry, double rz) {
        /*
        if (x == 500) {
            System.out.println("====================================");
            System.out.println(rx);
            for(double[] i : matrix) {
                for(double j : i) {
                    System.out.print(j + "\t");
                }
                System.out.println("");
            }
            System.out.println("====================================");
        }
        */
        if(rx > 0)
            matrix = TransformMatrix.getRotationX(rx);
        if(ry > 0)
            matrix = TransformMatrix.getRotationY(ry);
        if(rz > 0)
            matrix = TransformMatrix.getRotationZ(rz);
        translate(vector);
    }
    
    public void translate(Vector vector) {
        this.matrix = TransformMatrix.getComplex(matrix, TransformMatrix.getTranslate(vector));
    }
}
