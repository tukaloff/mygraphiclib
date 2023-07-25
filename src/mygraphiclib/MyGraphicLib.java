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
import javax.swing.JFrame;

/**
 *
 * @author tukalov
 */
public class MyGraphicLib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Image img = ImageIO.read(new File("F://texture.jpg"));
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        // TODO code application logic here
        JFrame frame = new JFrame();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,// / 10 * 8, 
                Toolkit.getDefaultToolkit().getScreenSize().height/* / 10 * 8*/);
        //frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RenderPanel rp = new RenderPanel();
        frame.add(rp);
        frame.addKeyListener(rp.getKeyListeners()[0]);
        frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - frame.getWidth() / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - frame.getHeight()/ 2);
        frame.setUndecorated(true);
        //frame.setOpacity((float)0.95);
        frame.setVisible(true);
        
        new Thread(() -> {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyGraphicLib.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.gc();
        }).start();
    }
    
}
