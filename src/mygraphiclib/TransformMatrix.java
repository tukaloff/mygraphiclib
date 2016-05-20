/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphiclib;

/**
 *
 * @author tukalov
 */
public class TransformMatrix {
    
    public static double[][] getSimpleMatrix() {
        double[][] matrix = 
        {
            {1,           0,           0,           0           },
            {0,           1,           0,           0           },
            {0,           0,           1,           0           },
            {0,           0,           0,           1           }
        };
        return matrix;
    }
    
    public static double[][] getRotationX(double angle) {
        double a = Math.toRadians(angle);
        double[][] matrix = 
        {
            {1,           0,           0,           0           },
            {0,           Math.cos(a), Math.sin(a), 0           },
            {0,         - Math.sin(a), Math.cos(a), 0           },
            {0,           0,           0,           1           }
        };
        return matrix;
    }
    
    public static double[][] getRotationY(double angle) {
        double a = Math.toRadians(angle);
        double[][] matrix = 
        {
            {Math.cos(a), 0,         - Math.sin(a), 0           },
            {0,           1,           0,           0           },
            {Math.sin(a), 0,           Math.cos(a), 0           },
            {0,           0,           0,           1           }
        };
        return matrix;
    }
    
    public static double[][] getRotationZ(double angle) {
        double a = Math.toRadians(angle);
        double[][] matrix = 
        {
            {Math.cos(a), Math.sin(a), 0,           0           },
            {-Math.sin(a),Math.cos(a), 0,           0           },
            {0,           0,           1,           0           },
            {0,           0,           0,           1           }
        };
        return matrix;
    }
    
    public static double[][] getScale(double alpha, double beta, double gamma) {
        double[][] matrix = 
        {
            {alpha,       0,           0,           0           },
            {0,           beta,        0,           0           },
            {0,           0,           gamma,       0           },
            {0,           0,           0,           1           }
        };
        return matrix;
    }
    
    public static double[][] getTranslate(Vector vector) {
        double x = vector.getX();
        double y = vector.getY();
        double z = vector.getZ();
        double[][] matrix = 
        {
            {1,           0,           0,           0           },
            {0,           1,           0,           0           },
            {0,           0,           1,           0           },
            {x,           y,           z,           1           }
        };
        return matrix;
    }
    
    public static double[][] getComplex(double[][] m1, double[][] m2) {
        double[][] mc = new double[m2.length][m1[0].length];
        for(int i = 0; i < m2.length; i++) {
            for(int j = 0; j < m1[i].length; j++) {
                mc[i][j] = m2[i][0] * m1[0][j]
                        + m2[i][1] * m1[1][j]
                        + m2[i][2] * m1[2][j]
                        + m2[i][3] * m1[3][j];
            }
        }
        return mc;
    }
    
    public static double[][] getMatrixFromVector(Vector vector) {
        return new double[][]{{vector.getX(), vector.getY(), vector.getZ(), 1}};
    }
    
    public static Vector getVectorFtomMatrix(double[][] m) {
        return new Vector(m[0][0], m[0][1], m[0][2]);
    }
    
    public static double getXFromMatrix(double[][] m) {
        return m[0][0] + m[1][0] + m[2][0] + m[3][0];
    }
    
    public static double getYFromMatrix(double[][] m) {
        return m[0][1] + m[1][1] + m[2][1] + m[3][1];
    }
    
    public static double getZFromMatrix(double[][] m) {
        return m[0][2] + m[1][2] + m[2][2] + m[3][2];
    }
}
