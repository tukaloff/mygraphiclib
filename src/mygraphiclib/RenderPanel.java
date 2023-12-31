/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private int time;
    private int fps = 30;
    
    public RenderPanel() {
        super();
        model = new Model(new Vector(0, 0, 400));
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        if (1000 / fps - time > 0)
                            Thread.sleep((int)(1000 / fps - time));
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
        long startTime = System.currentTimeMillis();
        RenderedImage ri = new RenderedImage(g.getClipBounds().width, g.getClipBounds().height);
        ri.setModel(model);
        ri.paint();
        if(ri.isFinished()) {
            g2.setPaint(new TexturePaint(ri.getBufferedImage(), g.getClipBounds()));
            g2.fillRect(g.getClipBounds().x, g.getClipBounds().y, g.getClipBounds().width, g.getClipBounds().height);
        }
        time = (int) (System.currentTimeMillis() - startTime);
        g2.setPaint(Color.WHITE);
        g2.drawString("Max FPS: " + 1000 / time, g.getClipBounds().width - 70, 20);
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
        
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //System.out.println("keyTyped: " + e.getKeyCode() + ": " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println("keyPressed: " + e.getKeyCode() + ": " + e.getKeyChar());
                switch (e.getKeyCode()) {
                    case 107:
                        Preferences.setDistance(Preferences.getDistance() + 2);
                        break;
                    case 109:
                        Preferences.setDistance(Preferences.getDistance() - 2);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println("keyReleased: " + e.getKeyCode() + ": " + e.getKeyChar());
            }
        });
        
    }
}
