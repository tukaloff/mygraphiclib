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
    
    private double[][] zBuffer;
    
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
    
    public void setTriangle(int x1, int x2, int x3, int[][] image) {
        int vCount = this.vertexes.size();
        if (x1 >= 0 && x1 < vCount 
                && x2 >= 0 && x2 < vCount
                && x3 >= 0 && x3 < vCount) {
            Triangle3D tr = new Triangle3D(vertexes.get(x1), vertexes.get(x2), vertexes.get(x3));
            tr.setPaint(image);
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
    
    public Vector getLocation() {
        return this.basisVector;
    }
    
    public void paintTriangles(BufferedImage bi, Light light) {
        zBuffer = new double[bi.getWidth()][bi.getHeight()];
        for(int i = 0; i < zBuffer.length; i++) {
            for (int j = 0; j < zBuffer[i].length; j++)
                zBuffer[i][j] = Integer.MAX_VALUE;
        }
        /*
        triangles.sort((Triangle3D o1, Triangle3D o2) -> {            
            double comp = (getVectorTransform(o1.getV1().getVector()).getZ() - getVectorTransform(o2.getV1().getVector()).getZ())
                    + (getVectorTransform(o1.getV2().getVector()).getZ() - getVectorTransform(o2.getV2().getVector()).getZ())
                    + (getVectorTransform(o1.getV3().getVector()).getZ() - getVectorTransform(o2.getV3().getVector()).getZ());
            return Double.compare(0, comp);
        });
        */
        for(int i = 0; i < triangles.size(); i++) {
            Triangle3D tr = triangles.get(i);
            int rgb = tr.getColor();
            Vector normal = tr.getNormal(false);
            Vector rotNorm = TransformMatrix.rotate(normal, rx, ry, rz);
            Vector nNorm = (getVectorTransform(normal)).normalize();
            if (rotNorm.getZ() < 0) {
                normal = tr.getNormal(true);
                nNorm = (getVectorTransform(normal)).normalize();
            }
            tr.giveNormal(nNorm);
            //System.out.println(normal);
            double brightness = Vector.getScalar(light.getDirection().normalize(), 
                    nNorm);
            brightness = brightness < 0 ? 0 : brightness;
            brightness *= light.getIntensity();
            if (brightness > 0) {
                fillTriangle(tr, i, bi, rgb, light, brightness);
            }
            /*
            transformNDrawLine(tr.getLine1(), bi);
            transformNDrawLine(tr.getLine2(), bi);
            transformNDrawLine(tr.getLine3(), bi);
            */
        }
    }
    
    public void fillTriangle(Triangle3D tr, int num, BufferedImage bi, int rgb, Light light, double brightness) {
        int w = bi.getWidth();
        int h = bi.getHeight();
        int halfW = (int)(0.5 + w / 2);
        int halfH = (int)(0.5 + h / 2);
        Vector v1 = getVectorTransform(tr.getV1().getVector());
        Vector v2 = getVectorTransform(tr.getV2().getVector());
        Vector v3 = getVectorTransform(tr.getV3().getVector());
        Graphics2D g2 = ((Graphics2D)(bi.getGraphics()));
        /*g2.setColor(new Color(rgb));
        String s1 = num + ": v1(" + (int)v1.getX() + "; " + (int)v1.getY() + "; " + (int)v1.getZ() + ")";
        g2.drawString(s1, 10, 10 + num * 20);
        String s2 = num + ": v2(" + (int)v2.getX() + "; " + (int)v2.getY() + "; " + (int)v2.getZ() + ")";
        g2.drawString(s2, 150, 10 + num * 20);
        String s3 = num + ": v3(" + (int)v3.getX() + "; " + (int)v3.getY() + "; " + (int)v3.getZ() + ")";
        g2.drawString(s3, 300, 10 + num * 20);*/
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
            int segmentHeight = (int)(0.5 + (secondHalf ? pv3.getY() - pv2.getY() :
                    pv2.getY() - pv1.getY()));
            float alpha = (float)i / totalHeight;
            float beta = (float)(i - (secondHalf ? pv2.getY() - pv1.getY():0)) / segmentHeight;
            Vector a = Vector.getSum(pv1.getVector(), 
                    Vector.getMultForNum(Vector.getDiff(pv3.getVector(), 
                            pv1.getVector()), alpha));
            //double az = pv1.getZ() + (pv3.getZ() - pv1.getZ()) * alpha;
            Vector b = secondHalf ? (Vector.getSum(pv2.getVector(), 
                    Vector.getMultForNum(Vector.getDiff(pv3.getVector(), 
                            pv2.getVector()), beta))) :
                    (Vector.getSum(pv1.getVector(), 
                            Vector.getMultForNum(Vector.getDiff(pv2.getVector(), 
                                    pv1.getVector()), beta)));
            /*double bz = secondHalf ? pv2.getZ() + (pv3.getZ() - pv2.getZ()) * beta :
                    pv1.getZ() + (pv2.getZ() - pv1.getZ()) * beta;*/
            if (a.getX() > b.getX()) {
                Vector tmp = a;
                a = b;
                b = tmp;
            }
            for (int j = (int)(0.5 + a.getX()); j <= b.getX() + 1; j++) {
                double phi = a.getX() == b.getX() ? 1. : (double)(j-a.getX())/(double)(b.getX()-a.getX());
                //Vector p = Vector.getSum(a, Vector.getMultForNum(Vector.getDiff(b, a), phi));
                double pz = a.getZ() + (b.getZ() - a.getZ()) * phi;
                int xCor = j + halfW;
                int yCor = (int)(0.5 + h - (pv1.getY() + i + halfH));
                if (!(xCor < 0 || xCor >= w || yCor < 0 || yCor >= h)) {
                    if (zBuffer[xCor][yCor] > pz) {
                        
                        double maxX = pv1.getX();
                        if (pv2.getX() > maxX)
                            maxX = pv2.getX();
                        if (pv3.getX() > maxX)
                            maxX = pv3.getX();
                        double minX = pv1.getX();
                        if (pv2.getX() < minX)
                            minX = pv2.getX();
                        if (pv3.getX() < minX)
                            minX = pv3.getX();
                        double maxY = pv3.getY();
                        double minY = pv1.getY();
                        
                        double u = (maxX - j) / (maxX - minX);
                        double v = i / (maxY - minY);
                        
                        //rgb = tr.getRGBTexture((int)(tr.getV1().getX() + j), (int)(tr.getV1().getY() + i));
                        rgb = tr.getRGBTexture(u, v);
                        int alphaColor = (rgb >> 24) & 0xff;
                        int red = (rgb >> 16) & 0xff;
                        int green = (rgb >>  8) & 0xff;
                        int blue = (rgb ) & 0xff;
                        double lDist = (light.getLocation().getZ() + light.getDistance() - pz) / light.getDistance();
                        lDist = lDist < 0 ? 0 : lDist;
                        double bright = brightness * lDist;
                        red *= bright;
                        green *= bright;
                        blue *= bright;
                        //alphaColor *= bright;
                        int newRGB = blue + (green << 8) + (red << 16) + (alphaColor << 24);
                        zBuffer[xCor][yCor] = pz;
                        bi.setRGB(xCor, yCor, newRGB);
                    }
                }
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
