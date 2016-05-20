package mygraphiclib;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

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
    //private TriangleObject3D to;
    private Object3D obj;

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
    
    public void setModel(Model model) {
        obj = model.getDraw();
    }
    
    public void paint() {
        //System.out.println("RenderedImage: paint");
        
        //to.getVector().rotateX(1);
        obj.rotate(2, 2, 2);
        
        //to.triangles.get(0).getV1().rotate(5, 0, 0);
        obj.paintLines(bi);
        //to.drawOrtho(bi);
        /*
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
        
        LineObject3D lo = new LineObject3D(la, new Vector());
        lo.drawPerspective(bi);*/
    }
    
    public BufferedImage getBufferedImage() {
        return bi;
    }
}
