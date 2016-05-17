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
        
        Vertex3D xv1 = new Vertex3D(100 - bi.getWidth() / 2, -10000, 0);
        Vertex3D xv2 = new Vertex3D(100 - bi.getWidth() / 2, 10000, 0);
        Vertex3D yv1 = new Vertex3D(-10000, 100 - bi.getHeight() / 2, 0);
        Vertex3D yv2 = new Vertex3D(10000, 100 - bi.getHeight() / 2, 0);
        Vertex3D zv1 = new Vertex3D(100 - bi.getWidth() / 2, 100 - bi.getHeight() / 2, 0);
        Vertex3D zv2 = new Vertex3D(100 - bi.getWidth() / 2, 100 - bi.getHeight() / 2, 1000);
        
        Line3D lx = new Line3D(xv1, xv2);
        Line3D ly = new Line3D(yv1, yv2);
        Line3D lz = new Line3D(zv1, zv2);
        
        ArrayList<Line3D> la = new ArrayList<>();
        la.add(lx);
        la.add(ly);
        la.add(lz);
        
        LineObject3D lo = new LineObject3D(la);
        lo.drawPerspective(bi);
    }
    
    public BufferedImage getBufferedImage() {
        return bi;
    }
}
