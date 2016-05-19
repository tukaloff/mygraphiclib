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
    
    public static double[][] getComplex(double[][] m1, double[][]m2) {
        double[][] mc = new double[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                mc[i][j] = m1[i][0] * m2[0][j]
                        + m1[i][1] * m2[1][j]
                        + m1[i][2] * m2[2][j]
                        + m1[i][3] * m2[3][j];
            }
        }
        return mc;
    }
    
    public static double getXFromMatrix(double[][] m) {
        return m[0][0] * m[3][0]
                + m[0][1] * m[3][1]
                + m[0][2] * m[3][2]
                + m[0][3] * m[3][3];
    }
    
    public static double getYFromMatrix(double[][] m) {
        return m[1][0] * m[3][0]
                + m[1][1] * m[3][1]
                + m[1][2] * m[3][2]
                + m[1][3] * m[3][3];
    }
    
    public static double getZFromMatrix(double[][] m) {
        return m[2][0] * m[3][0]
                + m[2][1] * m[3][1]
                + m[2][2] * m[3][2]
                + m[2][3] * m[3][3];
    }
}
