/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores;


import data.MatrizConfusion;
import java.util.ArrayList;
import Interfaces.ClasificadorSupervisado;
import data.Patron;

/**
 *
 * @author GitHub
 */
public class Cap_1 implements ClasificadorSupervisado{
    
    private double rendimiento;
    private MatrizConfusion matriz;
    private double[][] memoria;
    private ArrayList<String> clases;
    private Patron patronMedio;
    private ArrayList<Patron> instancias;
    public Cap_1() {
        this.clases = new ArrayList<>();
    }

    
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
       // determinar las clases participantes
       this.instancias=instancias;
       determinarClasesInvolucradas(instancias);
       // crear la matriz 
       this.memoria = new double[this.clases.size()][instancias.get(0).getVectorC().length];
       // calcular el vector promedio para trasladar el conjunto fundamental
       calcularPatronMedio(instancias);
       // trasladar todo el junto fundamental
       for(Patron aux: instancias)
           aux.trasladar(patronMedio);
       // construir la memoria
       for(Patron aux: instancias){
       int indiceClase = this.clases.indexOf(aux.getClase());
       // acumulamos en la clase que le corresponde 
       for(int x=0; x<this.memoria[indiceClase].length;x++){
         this.memoria[indiceClase][x]+=aux.getVectorC()[x];
       }
       }   
        
       
    }

    @Override
    public void clasificar(Patron patron) {
       // trasladar el patron 
       // patron.trasladar(this.patronMedio);
       // ejecutamos la clasificación 
       // recorremos la memoria 
       
       double aso[] = new double[this.memoria.length];
       int iM = 0;
       for (int x=0; x<this.memoria.length;x++){
            double acu = 0;
            for (int y=0;y<this.memoria[x].length;y++){
              acu+=patron.getVectorC()[y]*
                     this.memoria[x][y];
            }
            // asignamos la parte de la asociacion que 
            // corresponde
            aso[x]=acu;
            if (aso[x]>aso[iM]){
             iM = x;
            }
            patron.setClaseResultante(this.clases.get(iM));
       }  
    }

    
    public void clasificaConjunto(ArrayList<Patron> conjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public double getRendimiento() {
        int cont=0;
       for(int x=0; x<this.instancias.size();x++){
//         System.out.println("Clase "+x+" = "+instancias.get(x).getClase()+" -> Clase Resultante = "+instancias.get(x).getClaseResultante());
         if(instancias.get(x).getClase().equals(instancias.get(x).getClaseResultante())){
             cont++;
         }
     }
     rendimiento=(cont*100)/instancias.size();
     System.out.println(cont+" de "+instancias.size());
     return this.rendimiento;
    }

   
    public MatrizConfusion getMatriz() {
        return this.matriz;
    }

    private void determinarClasesInvolucradas(ArrayList<Patron> instancias) {
      // agregamos la primer clase
       this.clases.add(instancias.get(0).getClase());
      // recorremos el conjunto para encontrar clases
      for(int x=1;x<instancias.size();x++){
        if(!this.clases.contains(instancias.get(x).getClase())){
            // si no la contiene la agrega
            this.clases.add(instancias.get(x).getClase());
        }
      }
    }

    private void calcularPatronMedio(ArrayList<Patron> instancias) {
        // acumulamos en un patron existente
        this.patronMedio = new Patron(instancias.get(0).getVectorC().length);
        // recorrer las instancias
        for (Patron aux: instancias){
           for(int x=0;x<aux.getVectorC().length;x++){
               patronMedio.getVectorC()[x]+=aux.getVectorC()[x];
           }
        }
        // dividimos 
        for(int x=0;x<patronMedio.getVectorC().length;x++){
               patronMedio.getVectorC()[x]/=instancias.size();
           }  
    }
    @Override
    public void clasificar(ArrayList<Patron> instancias) {
       for(int x=0; x<instancias.size() ;x++)
       {
          clasificar(instancias.get(x)); 
       }
    }
    
    
}