/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author tukalov
 */
public class RenderPanel extends JPanel {
    
    Model model;
    int lastX, lastY, diffX, diffY;
    
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
        initListeners();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        RenderedImage ri = new RenderedImage(g.getClipBounds().width, g.getClipBounds().height);
        
        ri.setModel(model);
        ri.paint();
        g2.setPaint(new TexturePaint(ri.getBufferedImage(), g.getClipBounds()));
        g2.fillRect(g.getClipBounds().x, g.getClipBounds().y, g.getClipBounds().width, g.getClipBounds().height);
    }
    
    private void initListeners() {
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                diffX = x - lastX;
                diffY = y - lastY;
                if (Math.abs(diffX) > 10)
                    diffX = 0;
                if (Math.abs(diffY) > 10)
                    diffY = 0;
                //System.out.println(diffX + "; " + diffY);
                model.getDraw().rotate(-diffY, -diffX, 0);
                diffX = 0;
                diffY = 0;
                lastX = x;
                lastY = y;
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}
