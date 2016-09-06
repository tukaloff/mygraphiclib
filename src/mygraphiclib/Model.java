/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author tukalov
 */
public class Model {
    
    private ArrayList<Object3D> object = new ArrayList<>();
    private Vector vector;
    private Light light;
    private boolean finished = false;
    
    public Model(Vector vector) {
        this.vector = vector;
        //Tetrahedron th = new Tetrahedron(vector);
        Cube cube = new Cube(vector, 100);
        light = new Light();
        object.add(cube);/*
        object.add(new Cube(new Vector(200, 200, 500), 50));
        object.add(new Cube(new Vector(0, 200, 500), 50));
        object.add(new Cube(new Vector(-200, 200, 500), 50));*/
        
        object.sort((Object3D o1, Object3D o2) -> {
            double comp = o1.getLocation().getZ() - o1.getLocation().getZ();
            return Double.compare(comp, 0);
        });
    }
    
    public Object3D getDraw() {
        return object.get(0);
    }
    
    public void paint(BufferedImage bi) {
        finished = false;
        for (int i = 0; i < object.size(); i++)
            switch(object.get(i).getClass().getSimpleName()) {
                case "Tetrahedron": {
                    ((Tetrahedron)(object.get(i))).paint(bi, light);
                    break;
                }
                case "Cube": {
                    ((Cube)(object.get(i))).paint(bi, light);
                    break;
                }
                default:
                    System.out.println(object.getClass().getName());
            }
        finished = true;
    }
    
    public boolean isFinished() {
        return finished;
    }
    
    public Vector getVector() {
        return vector;
    }
}
