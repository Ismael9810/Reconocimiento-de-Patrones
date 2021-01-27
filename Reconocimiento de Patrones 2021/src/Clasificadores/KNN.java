/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores;

import Interfaces.ClasificadorSupervisado;
import data.MatrizConfusion;
import data.Patron;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Isma Cortes
 */
public class KNN implements ClasificadorSupervisado{
    private ArrayList<String> clases, aux;
    private ArrayList<Patron> instancias;
    private MatrizConfusion mc;
    private int k, max;
    private int mayor[];
    public KNN(int k) {
        this.clases = new ArrayList<>();
        this.k = k;
    }
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
        aux = new ArrayList();
       
        for(int x=0; x<instancias.size(); x++){
                aux.add(instancias.get(x).getClase());
        }
       
       Set<String> hs = new HashSet<String>(aux);
       aux.clear();
       aux.addAll(hs);
       
       this.instancias = (ArrayList<Patron>) instancias.clone();
        // generamos un arraylist con las clases que se estan trabajando
        for(Patron p: instancias){
           if(!this.clases.contains(p.getClase())){
                this.clases.add(p.getClase());
           } 
       }
        mayor = new int[aux.size()];
          //contamos el numero de instancias por clase para obtener nuestro k maximo
        for(int x=0; x<aux.size();x++){
            for(int y=0; y<instancias.size(); y++){
                if(instancias.get(y).getClase().equals(aux.get(x))){
                   mayor[x]++; 
                   
                }
                if(mayor [x] > max) {
                    max = mayor[x];
                }
            }
         }
    }

    @Override
    public void clasificar(ArrayList<Patron> instancias) {
        int cont =0;
        int eficacia=0;
        for(Patron p: instancias){
           clasificar(p);
       }
        for(int x=0; x<instancias.size();x++){
      //   System.out.println("Clase "+x+" = "+instancias.get(x).getClase()+" -> Clase Resultante = "+instancias.get(x).getClaseResultante());
         if(instancias.get(x).getClase().equals(instancias.get(x).getClaseResultante())){
             cont++;
         }
        this.mc = new MatrizConfusion(instancias); 
     }
     eficacia=(cont*100)/instancias.size();
     System.out.println("Eficacia de Knn= "+eficacia+"%");
      System.out.println(cont+" de "+instancias.size());
    }
    
    public void clasificar(Patron patron) {
        
        if(k!=0 && k<max){
         //sort funciona como algoritmo de ordenamiento burbuja
        instancias.sort((a, b) -> new Double(a.calcularDistancia(patron)).compareTo(new Double(b.calcularDistancia(patron))));
        int contador[] = new int[this.clases.size()];
        // clasificacion de acuerdo a los k-vecinos
        for(Patron aux: this.instancias){
            int i = this.clases.indexOf(aux.getClase());
            contador[i]++;
            if(contador[i]==this.k){
                // clasificacion
                patron.setClaseResultante(this.clases.get(i));
                break;
            }
        }
        
      }else{
         System.out.println("El número k de vecinos introducido no esta definido");
         System.out.close();
         
        }
       
    }
    public MatrizConfusion obtenerMatriz() {
        return mc;
    }
    
}