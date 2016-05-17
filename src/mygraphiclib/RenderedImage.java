package mygraphiclib;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tukalov
 */
public class RenderedImage {
    
    private BufferedImage bi;

    public RenderedImage() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = this.bi.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
    }
    
    public RenderedImage(int width, int height) {
        this.bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = this.bi.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
    }
    
    public void paint() {
        System.out.println("RenderedImage: paint");
        Vertex3D v1 = new Vertex3D(-200, -100, 10);
        Vertex3D v2 = new Vertex3D(500, -200, 100);
        Vertex3D v3 = new Vertex3D(300, 400, 50);
        Triangle3D t = new Triangle3D(v1, v2, v3);
        ArrayList<Triangle3D> ta = new ArrayList<>();
        ta.add(t);
        TriangleObject3D to = new TriangleObject3D(ta);
        to.drawPerspective(bi);
        to.drawOrtho(bi);
    }
    
    public BufferedImage getBufferedImage() {
        return bi;
    }
}
