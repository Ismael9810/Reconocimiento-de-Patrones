/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perceptrones;
 import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ismael Cortes
 */
public class Perceptrones {


     public static void main(String[] args) {
        
        //  x0   x1   x2
        float[][] entradas = {
       {1f, 1f, 1f},
       {1f, 1f, -1f},
       {1f, -1f, 1f},
       {1f, -1f, -1f}
                            };
        
        // yD
        float[] salidas = new float[4];
                salidas[0] = 1f;
                salidas[1] = -1f;
                salidas[2] = -1f;
                salidas[3] = -1f;
        
        float w0 = new Random().nextFloat();
        float w1 = new Random().nextFloat();
        float w2 = new Random().nextFloat();
        
        float factorAprendizaje=(new Random().nextInt(8)+2);
        factorAprendizaje=factorAprendizaje/10;
        
        float y = 0.0f;
        float error=0.0f;
        int fila=0;
        int repeticion=1;
        
        System.out.println("PERCEPTRON AND");
        System.out.println("Factor de Aprendizaje: "+factorAprendizaje);
        System.out.println("Peso 0: "+w0);
        System.out.println("Peso 1: "+w1);
        System.out.println("Peso 2: "+w2);
        System.out.println("");
        System.out.println("ITERACION: "+repeticion+"----------------------------------------------");
        
        while (fila<4) {
            
            System.out.println("y =("+w0+"*"+entradas[fila][0]+") + ("+w1+"*"+entradas[fila][1]+") + ("+w2+"*"+entradas[fila][2]+")");
            y=w0*entradas[fila][0]+w1*entradas[fila][1]+w2*entradas[fila][2];
            
            System.out.println("y = " + y);
            
            if (y >= 0) {
                y = 1;
                System.out.println("Como y>=0 entonces");
            } else if (y < 0) {
                y = -1;
                System.out.println("Como y<0 entonces");
            }

            System.out.println("y= " + y);
            error = salidas[fila] - y;
          
            System.out.println("Error= " + error);

            if (error == 0f) {
                System.out.println("----------------------------------------------------------");
                fila++;
            } else {
                
                if (error != 0) {
                        System.out.println("----------------------------------------------------------");
                        System.out.println("Recalculamos los Pesos");
                        
                        w0=w0+(factorAprendizaje*(error)*entradas[fila][0]);
                        w1=w1+(factorAprendizaje*(error)*entradas[fila][1]);
                        w2=w2+(factorAprendizaje*(error)*entradas[fila][2]);
                        
                        System.out.println("Nuevo Peso w0= "+w0);
                        System.out.println("Nuevo Peso w1= "+w1);
                        System.out.println("Nuevo Peso w2= "+w2);
                }
                
                fila=0;
                repeticion++;
                System.out.println("");
                System.out.println("");
                System.out.println("ITERACION: "+repeticion+"----------------------------------------------");
            }
        }
        
        System.out.println("");
        System.out.println("_________________________________");
        System.out.println("| PESOS FINALES\t\t\t|");
        System.out.println("| Factor de Aprendizaje: "+factorAprendizaje+"\t|");
        System.out.println("| Peso w0: "+w0+"\t\t|");
        System.out.println("| Peso w1: "+w1+"\t\t|");
        System.out.println("| Peso w2: "+w2+"\t\t|");
        System.out.println("_________________________________");
        System.out.println("");
        
        Scanner dato=new Scanner(System.in);
        int entrada1,entrada2;
        
        System.out.println("Ingresa la Entrada1 (1,-1):");
        entrada1=dato.nextInt();
        System.out.println("Ingresa la Entrada2 (1,-1):");
        entrada2=dato.nextInt();
        
        y=(w0*1)+(w1*entrada1)+(w2*entrada2);
        if (y >= 0) {
            y = 1;
        } else if (y < 0) {
                y = -1;
        }
        
        System.out.println("La salida es: \n" + y);
                
        }

    
}
