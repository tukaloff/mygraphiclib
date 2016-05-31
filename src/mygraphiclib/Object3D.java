/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author tukalov
 */
public class Object3D{
    
    protected ArrayList<Vertex3D> vertexes = new ArrayList<>();
    protected ArrayList<Line3D> lines = new ArrayList<>();
    protected ArrayList<Triangle3D> triangles = new ArrayList<>();
    protected int distX;
    protected int distY;
    protected Vector basisVector;
    //protected Vector rotation;
    
    protected double rx = 0;
    protected double ry = 0;
    protected double rz = 0;
    
    public Object3D(Vector basis/*, Vector rotation*/) {
        this.basisVector = basis;
        //this.rotation = rotation;
    }
    
    public void add(Vertex3D v)  {
        this.vertexes.add(v);
    }
    
    public void setLine(int x1, int x2) {
        int vCount = this.vertexes.size();
        if (x1 >= 0 && x1 < vCount && x2 >= 0 && x2 < vCount) {
            lines.add(new Line3D(vertexes.get(x1), vertexes.get(x2)));
        }
    }
    
    public void addLine(Vertex3D v1, Vertex3D v2) {
        vertexes.add(v1);
        vertexes.add(v2);
        lines.add(new Line3D(v1, v2));
    }
    
    public void addLine(Line3D line) {
        vertexes.add(line.getV1());
        vertexes.add(line.getV2());
        lines.add(line);
    }
    
    public void setTriangle(int x1, int x2, int x3) {
        int vCount = this.vertexes.size();
        if (x1 >= 0 && x1 < vCount 
                && x2 >= 0 && x2 < vCount
                && x3 >= 0 && x3 < vCount) {
            Triangle3D tr = new Triangle3D(vertexes.get(x1), vertexes.get(x2), vertexes.get(x3));
            int c = Color.BLACK.getRGB();
            double r = Math.random();
            int rgbColor = (int) (c * r);
            rgbColor = Color.WHITE.getRGB();
            tr.setPaint(rgbColor);
            triangles.add(tr);
        }
    }
    
    public void addTriangle(Vertex3D v1, Vertex3D v2, Vertex3D v3) {
        vertexes.add(v1);
        vertexes.add(v2);
        vertexes.add(v3);
        triangles.add(new Triangle3D(v1, v2, v3));
    }
    
    public void paintLines(BufferedImage bi) {
        for(Line3D line : lines) {
            transformNDrawLine(line, bi);
        }
    }
    
    public void transformNDrawLine(Line3D line, BufferedImage bi) {
        Vector vector1 = getVectorTransform(line.getV1().getVector());
        Vector vector2 = getVectorTransform(line.getV2().getVector());
        PerspectiveVertex pv1 = new PerspectiveVertex(vector1);
        PerspectiveVertex pv2 = new PerspectiveVertex(vector2);
        drawLine((int)pv1.getX(), (int)pv1.getY(), 
                (int)pv2.getX(), (int)pv2.getY(), 
                bi, Color.BLACK.getRGB());
    }
    
    protected Vector getVectorTransform(Vector v) {
        Vector rot = TransformMatrix.rotate(v, rx, ry, rz);
        Vector absVector1 = Vector.getSum(basisVector, rot);
        //System.out.println(absVector1.toString());
        return absVector1;
    }
    
    public void paintTriangles(BufferedImage bi, Light light) {
        triangles.sort((Triangle3D o1, Triangle3D o2) -> {            
            double comp = (getVectorTransform(o1.getV1().getVector()).getZ() - getVectorTransform(o2.getV1().getVector()).getZ())
                    + (getVectorTransform(o1.getV2().getVector()).getZ() - getVectorTransform(o2.getV2().getVector()).getZ())
                    + (getVectorTransform(o1.getV3().getVector()).getZ() - getVectorTransform(o2.getV3().getVector()).getZ());
            return Double.compare(0, comp);
        });
        for(int i = 0; i < triangles.size(); i++) {
            Triangle3D tr = triangles.get(i);
            int rgb = tr.getColor();
            Color color = new Color(rgb);
            Vector normal = tr.getNormal(false);
            Vector rotNorm = TransformMatrix.rotate(normal, rx, ry, rz);
            Vector nNorm = (getVectorTransform(normal)).normalize();
            if (rotNorm.getZ() < 0) {
                normal = tr.getNormal(true);
                nNorm = (getVectorTransform(normal)).normalize();
            }
            //System.out.println(normal);
            double brightness = Vector.getScalar(light.getDirection().normalize(), 
                    nNorm);
            brightness = brightness < 0 ? 0 : brightness;
            //System.out.println(brightness);
            int newRgb = (new Color((int)(color.getRed() * brightness * light.getIntensity()), 
                    (int)(color.getRed() * brightness * light.getIntensity()), 
                    (int)(color.getRed() * brightness * light.getIntensity()))).getRGB();
            fillTriangle(tr, i, bi, newRgb);
            
            transformNDrawLine(tr.getLine1(), bi);
            transformNDrawLine(tr.getLine2(), bi);
            transformNDrawLine(tr.getLine3(), bi);
            
        }
    }
    
    public void fillTriangle(Triangle3D tr, int num, BufferedImage bi, int rgb) {
        int w = bi.getWidth();
        int h = bi.getHeight();
        int halfW = w / 2;
        int halfH = h / 2;
        Vector v1 = getVectorTransform(tr.getV1().getVector());
        Vector v2 = getVectorTransform(tr.getV2().getVector());
        Vector v3 = getVectorTransform(tr.getV3().getVector());
        Graphics2D g2 = ((Graphics2D)(bi.getGraphics()));
        g2.setColor(new Color(rgb));
        String s1 = num + ": v1(" + (int)v1.getX() + "; " + (int)v1.getY() + "; " + (int)v1.getZ() + ")";
        g2.drawString(s1, 10, 10 + num * 20);
        String s2 = num + ": v2(" + (int)v2.getX() + "; " + (int)v2.getY() + "; " + (int)v2.getZ() + ")";
        g2.drawString(s2, 150, 10 + num * 20);
        String s3 = num + ": v3(" + (int)v3.getX() + "; " + (int)v3.getY() + "; " + (int)v3.getZ() + ")";
        g2.drawString(s3, 300, 10 + num * 20);
        PerspectiveVertex pv1 = new PerspectiveVertex(v1);
        PerspectiveVertex pv2 = new PerspectiveVertex(v2);
        PerspectiveVertex pv3 = new PerspectiveVertex(v3);
        PerspectiveVertex pvBuffer = pv1;
        if (pv1.getY() > pv2.getY()) {
            pvBuffer = pv1;
            pv1 = pv2;
            pv2 = pvBuffer;
        }
        if (pv1.getY() > pv3.getY()) {
            pvBuffer = pv1;
            pv1 = pv3;
            pv3 = pvBuffer;
        }
        if (pv2.getY() > pv3.getY()) {
            pvBuffer = pv2;
            pv2 = pv3;
            pv3 = pvBuffer;
        }
        int totalHeight = (int) (pv3.getY() - pv1.getY());
        for (int i = 0; i < totalHeight; i++) {
            boolean secondHalf = i > pv2.getY() - pv1.getY() || 
                    pv2.getY() == pv1.getY();
            int segmentHeight = (int) (secondHalf ? pv3.getY() - pv2.getY() :
                    pv2.getY() - pv1.getY());
            float alpha = (float)i / totalHeight;
            float beta = (float)(i - (secondHalf ? pv2.getY() - pv1.getY():0)) / segmentHeight;
            int ax = (int) (pv1.getX() + alpha * (pv3.getX() - pv1.getX()));
            int ay = (int) (pv1.getY() + alpha * (pv3.getY() - pv1.getY()));
            int bx = (int) (secondHalf ? (pv2.getX() + beta * (pv3.getX() - pv2.getX())) :
                    (pv1.getX() + beta * (pv2.getX() - pv1.getX())));
            int by = (int) (secondHalf ? (pv2.getY() + beta * (pv3.getY() - pv2.getY())) :
                    (pv1.getY() + beta * (pv2.getY() - pv1.getY())));
            if (ax > bx) {
                int tmp = ax;
                ax = bx;
                bx = tmp;
                tmp = ay;
                ay = by;
                by = tmp;
            }
            for (int j = ax; j <= bx; j++) {
                int xCor = j + halfW;
                int yCor = (int) (h - (pv1.getY() + i + halfH) + 0.5);
                if (!(xCor < 0 || xCor >= w || yCor < 0 || yCor >= h))
                    bi.setRGB(xCor, yCor, rgb);
            }
        }
    }
    
    public void rotate(double rx, double ry, double rz) {
        this.rx += rx;
        this.ry += ry;
        this.rz += rz;
    }
    
    protected void drawLine(int x1, int y1, int x2, int y2, BufferedImage bi, int rgb) {
        boolean steep = false;
        int w = bi.getWidth();
        int h = bi.getHeight();
        int halfW = w / 2;
        int halfH = h / 2;
        if (Math.abs(x2 - x1) < Math.abs(y2 - y1)) {
            int tmp = x1;
            x1 = y1;
            y1 = tmp;
            tmp = x2;
            x2 = y2;
            y2 = tmp;
            steep = true;
        }
        if (x1 > x2) {
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        float d = (float) 1 / (x2 - x1);
        for (int x = x1; x <= x2; x++) {
            float t = (x - x1) * d;
            int y = (int) ((y1 + 0.005) * (1.0 - t) + (y2 + 0.005) * t);
            if (steep) {
                int rx = halfW + y;
                int ry = h - (halfH + x);
                if (!(rx < 0 || rx >= w || ry < 0 || ry >= h))
                    bi.setRGB(rx, ry, rgb);
            } else {
                int rx = halfW + x;
                int ry = h - (halfH + y);
                if (!(rx < 0 || rx >= w || ry < 0 || ry >= h))
                    bi.setRGB(rx, ry, rgb);
            }
        }
    }
}
