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
    private Model model;

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
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, width, height);
    }
    
    public void setModel(Model model) {
        this.model = model;
    }
    
    public void paint() {
        model.paint(bi);
    }
    
    public BufferedImage getBufferedImage() {
        return bi;
    }
}
