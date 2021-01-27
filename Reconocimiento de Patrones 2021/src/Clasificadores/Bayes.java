/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Interfaces.ClasificadorSupervisado;
import data.MatrizConfusion;
import data.Patron;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javafx.util.Pair;

public class Bayes implements ClasificadorSupervisado {

   
    ArrayList<Patron> promedio,varianza,desviacion;
    ArrayList<String> nombre;
    ArrayList<Pair<String,Double>>  numPatronClase = new ArrayList<>();
    
    Patron promedios, varianzas, desviaciones;
    double[] auxiliar,var, des,porcentaje;
    public Bayes() {
        this.promedio = new ArrayList<>();
        this.varianza = new ArrayList<>();
        this.desviacion = new ArrayList<>();
        this.nombre = new ArrayList();
        this.numPatronClase = new ArrayList();
        
    }
    
    
    @Override
      public void entrenar(ArrayList<Patron> instancias) {
       
       
        for(int x=0; x<instancias.size(); x++){
                this.nombre.add(instancias.get(x).getClase());
        }
       Set<String> hs = new HashSet<String>(this.nombre);
       this.nombre.clear();
       this.nombre.addAll(hs);
     //Calculamos el promedio o media
     calcularVectorPromedio(this.nombre,instancias);
     //Calculamos la varianza
     calcularVectorVarianza(this.nombre,instancias);
     //Calculamos la desviación estandar
     calcularVectorDesviacion(this.nombre,instancias);
     //Calculamos los patrones por clase y su porcentaje
     porcentaje = new double[nombre.size()];
     for(int w=0; w<nombre.size(); w++){
         
         double contador = 0;
        for(int x=0; x<instancias.size(); x++){
            if(nombre.get(w).equals(instancias.get(x).getClase()))
            {
               contador++;
            }
        }
       porcentaje[w]=(contador/instancias.size());
       numPatronClase.add(new Pair<>(nombre.get(w),contador));
     }
    }

    @Override
    public void clasificar(ArrayList<Patron> instancias) {
        int cont=0,eficacia;
        for(int x =0; x<instancias.size(); x++){
            clasificarPatron(instancias.get(x));
//            System.out.println("Clase "+x+" = "+instancias.get(x).getClase()+" -> Clase Resultante = "+instancias.get(x).getClaseResultante());
            if(instancias.get(x).getClase().equals(instancias.get(x).getClaseResultante())){
             
             cont++;
         }
     }
     eficacia=(cont*100)/instancias.size();
     System.out.println("Eficacia de Bayes="+eficacia+"%");
     System.out.println(cont+" de "+instancias.size());
         
  
    }
    
    private void calcularVectorVarianza(ArrayList<String> aux,ArrayList<Patron> instancias){
        int contInsClas;
        for(int w=0; w<aux.size();w++){
         this.var = new double[instancias.get(0).getVectorC().length];
         contInsClas=0;
        for(int x=0; x<instancias.size();x++){
          if(aux.get(w).equals(instancias.get(x).getClase())){
              contInsClas+=1;
            for(int y=0; y<instancias.get(x).getVectorC().length;y++){
                  var[y]=var[y]+Math.pow(instancias.get(x).getVectorC()[y]-this.promedio.get(w).getVectorC()[y], 2);
                 }
             }
         }
        for(int x=0; x<this.var.length; x++){
          this.var[x]=this.var[x]/(contInsClas-1);
        }
        this.varianzas = new Patron(aux.get(w),"",this.var);
        this.varianza.add(this.varianzas);
     }
//      System.out.println("Vectores Varianza");
//      imprimirMatrices(this.varianza);
    }
    private void calcularVectorPromedio(ArrayList<String> aux,ArrayList<Patron> instancias){
        int contInsClas;
     for(int w=0; w<aux.size();w++){
         this.auxiliar = new double[instancias.get(0).getVectorC().length];
         contInsClas=0;
        for(int x=0; x<instancias.size();x++){
          if(aux.get(w).equals(instancias.get(x).getClase())){
              contInsClas+=1;
            for(int y=0; y<instancias.get(x).getVectorC().length;y++){
                auxiliar[y]=auxiliar[y]+instancias.get(x).getVectorC()[y];
                  
                 }
             }
         }
        for(int x=0; x<this.auxiliar.length; x++){
           this.auxiliar[x]=this.auxiliar[x]/contInsClas;
        }
        this.promedios = new Patron(aux.get(w),"",this.auxiliar);
        this.promedio.add(this.promedios);
     }
//       System.out.println("Vectores Promedio");
//      imprimirMatrices(this.promedio);
    }
    private void calcularVectorDesviacion(ArrayList<String> aux,ArrayList<Patron> instancias){
        for(int w=0; w<aux.size();w++){
        this.des = new double[instancias.get(0).getVectorC().length];
        for(int x=0; x<varianza.size();x++){
          if(aux.get(w).equals(varianza.get(x).getClase())){
            for(int y=0; y<instancias.get(x).getVectorC().length;y++){
                  this.des[y]= Math.sqrt(this.varianza.get(x).getVectorC()[y]);
                 }
             }
         }
        
        this.desviaciones = new Patron(aux.get(w),"",this.des);
        this.desviacion.add(this.desviaciones);
     }
//      System.out.println("Vectores Desviacion");
//      imprimirMatrices(this.desviacion);
        
    } 
    
    private void clasificarPatron(Patron p){
     ArrayList<Patron> distribucion = new ArrayList<>();
     ArrayList<Pair<String,Double>>posteriori = new ArrayList<>();
     ArrayList<Double> promXClase = new ArrayList<>();
     Double evidencia=0.0;
     for(int x=0; x<desviacion.size();x++){
         double[] norm=new double[desviacion.get(x).getVectorC().length];
         for(int y=0; y<desviacion.get(x).getVectorC().length;y++){
             double raiz=2*Math.PI*varianza.get(x).getVectorC()[y];
             double factor1=1/Math.sqrt(raiz);
             double exp=-1*((Math.pow(p.getVectorC()[y]-promedio.get(x).getVectorC()[y], 2)/(2*varianza.get(x).getVectorC()[y])));
             double factor2=Math.pow(Math.E, exp);
             norm[y]=factor1*factor2; }
         Patron n = new Patron("",desviacion.get(x).getClaseResultante(),norm);
         distribucion.add(n); }
     for(int x=0; x<numPatronClase.size();x++){
         double aux=porcentaje[x];
         for(int y=0; y<desviacion.get(x).getVectorC().length;y++){
             aux*=desviacion.get(x).getVectorC()[y]; }
       evidencia+=aux; }
     for(int x=0; x<numPatronClase.size();x++){
         double aux=porcentaje[x];
         for(int y=0; y<distribucion.get(x).getVectorC().length;y++){
             aux*=distribucion.get(x).getVectorC()[y]; }
       posteriori.add(new Pair<>(numPatronClase.get(x).getKey(),aux/evidencia));  }
     double mayor=0;
     for(int x=0; x<numPatronClase.size();x++){
        if(mayor<posteriori.get(x).getValue()){
            p.setClaseResultante(posteriori.get(x).getKey());
            mayor=posteriori.get(x).getValue();
            }
        }
    }
    private void imprimirMatrices(ArrayList<Patron> instancias){
        for(int x=0; x<instancias.size(); x++){
            for(int y=0; y<instancias.get(x).getVectorC().length; y++){
                System.out.print("[ "+instancias.get(x).getVectorC()[y]+" ]");
            }
            System.out.print(" -> "+instancias.get(x).getClase()+"\n");
        }
    }
}
    
    