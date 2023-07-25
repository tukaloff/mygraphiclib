/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
        super.setLine(0, 3);6
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
        Image img = Toolkit.getDefaultToolkit().getImage("F://texture.jpg").getScaledInstance(100, 100, Image.SCALE_FAST);
        try {
            img = ImageIO.read(new File("F://texture.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Cube.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        bi.createGraphics().drawImage(img, 0, 0, null);
        int[][] image = new int[bi.getWidth()][bi.getHeight()];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = bi.getRGB(image.length - 1 - i, image[i].length - 1 - j);
            }
        }
        super.setTriangle(0, 1, 2, image);
        super.setTriangle(0, 3, 2, image);
        super.setTriangle(0, 3, 5, image);
        super.setTriangle(0, 4, 5, image);
        super.setTriangle(0, 3, 5, image);
        super.setTriangle(0, 1, 6, image);
        super.setTriangle(0, 4, 6, image);
        super.setTriangle(7, 2, 3, image);
        super.setTriangle(7, 5, 3, image);
        super.setTriangle(7, 2, 1, image);
        super.setTriangle(7, 6, 1, image);
        super.setTriangle(7, 5, 4, image);
        super.setTriangle(7, 6, 4, image);
    }

    public void paint(BufferedImage bi, Light light) {
        //super.paintLines(bi);
        super.paintTriangles(bi, light);
    }
}
