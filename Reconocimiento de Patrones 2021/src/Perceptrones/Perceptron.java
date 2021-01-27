/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perceptrones;

import data.Patron;
import java.util.ArrayList;

/**
 *
 * @author Ismael Cortes
 */
public class Perceptron { 
    private ArrayList<Patron> patrones;     private double bias, alfa;     private double[] w; 
 
    public ArrayList<Patron> getPatrones() {         return patrones; 
    }  
    public Perceptron(ArrayList<Patron> p, double a) {         
        this.patrones = p;         
        this.alfa = a;     
        this.bias = 0;        
        this.w = NeuralTool.weightGenerator(p.get(0).getVector().length); 
    }      
    
    
    public void simpleTraining(){         double sum; 
        int e, unit, t, passed = 0, generation = 0, it = this.patrones.size() + 1;         while(passed < it) { 
            for (Patron patrone : this.patrones) { 
                sum = NeuralTool.product((double[]) patrone.getVector(), this.w);                 
                unit = NeuralTool.unitScaler(sum - this.bias);                
                t = Integer.parseInt(patrone.getClase());               
                if (unit != t) {                     e = t - unit; 
                    double[] v = (double[]) patrone.getVector();                    
                    for (int j = 0; j < v.length; j++) {                         
                        this.w[j] += this.alfa * e * v[j];
} 
                    this.bias += this.alfa * e * (-1);                     passed = 0;                 } else passed++; 
            } 
            generation++; 
        } 
    }  
    public void clasification(ArrayList<Patron> instances){         
        int total= instances.size();       
        for (Patron instance : instances) { 
            predict(instance); 
            System.out.println("Original: " + instance.getClase()); 
            System.out.println("Result: " + instance.getPredicha()); 
        } 
    } 

   
 public int predict(Patron patron){ 
        double sum = NeuralTool.product((double[]) patron.getVector(), this.w);       
        int scalier = NeuralTool.unitScaler(sum - this.bias);     
        patron.setPredicha(String.valueOf(scalier));         return scalier; 
    }

 
}