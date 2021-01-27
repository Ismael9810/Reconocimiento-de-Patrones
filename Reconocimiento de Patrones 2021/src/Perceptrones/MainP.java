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
public class MainP {
  public static void main(String[] args) {       
      System.out.println(" == Neurons == "); 
 
        // or 
        Patron p1 = new Patron("0", new double[]{0,0}); 
        Patron p2 = new Patron("1", new double[]{0,1}); 
        Patron p3 = new Patron("1", new double[]{1,0}); 
        Patron p4 = new Patron("1", new double[]{1,1});         
        ArrayList<Patron> setOR = new ArrayList<>();         
        setOR.add(p1);      
        setOR.add(p2);        
        setOR.add(p3);       
        setOR.add(p4); 
 
        Perceptron perceptron = new Perceptron(setOR, 0.9);         perceptron.simpleTraining(); 
        perceptron.clasification(perceptron.getPatrones());  
    } 
  
}
