/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perceptrones;

import java.util.Random;

/**
 *
 * @author Ismael Cortes
 */
public class NeuralTool { 
    public static int unitScaler(double input) {         return (input >= 0) ? 1 : 0; 
    }  
    public static double[] weightGenerator(int n) { 
        double[] w = new double[n]; 
        Random r = new Random(); 
         for (int i = 0; i < n; i++) {             w[i] = r.nextDouble(); 
        } 
        return w; 
    }  
    public static double product(double[] x, double[] w) {         double ac = 0; 
        for (int i = 0; i < x.length; i++) {             ac += x[i] * w[i]; 
        } 
        return ac; 
    } 
} 
