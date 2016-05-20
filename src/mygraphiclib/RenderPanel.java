/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author tukalov
 */
public class RenderPanel extends JPanel {
    
    Model model;
    
    public RenderPanel() {
        super();
        model = new Model(new Vector(0, 0, 400));
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RenderPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    repaint();
                }
            }
        }).start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println("RenderPanel: paint");
        Graphics2D g2 = (Graphics2D) g;
        RenderedImage ri = new RenderedImage(g.getClipBounds().width, g.getClipBounds().height);
        
        ri.setModel(model);
        ri.paint();
        g2.setPaint(new TexturePaint(ri.getBufferedImage(), g.getClipBounds()));
        g2.fillRect(g.getClipBounds().x, g.getClipBounds().y, g.getClipBounds().width, g.getClipBounds().height);
    }
}
