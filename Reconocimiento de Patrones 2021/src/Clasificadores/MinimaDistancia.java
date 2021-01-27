/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificadores;

import data.Patron;
import Interfaces.ClasificadorSupervisado;
import data.MatrizConfusion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author working
 */
public class MinimaDistancia implements ClasificadorSupervisado{

    ArrayList<Patron> representativos;
    ArrayList<String> aux;
    MatrizConfusion mc;
    Patron m;
    double[] sumatoria;
    public MinimaDistancia() {
        this.representativos = new ArrayList<>();
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
     // recorre el vector característico
     int contInsClas;
     for(int w=0; w<aux.size();w++){
         sumatoria = new double[instancias.get(0).getVectorC().length];
         contInsClas=0;
        for(int x=0; x<instancias.size();x++){
          if(aux.get(w).equals(instancias.get(x).getClase())){
              contInsClas+=1;
            for(int y=0; y<instancias.get(x).getVectorC().length;y++){
                  sumatoria[y]=sumatoria[y]+instancias.get(x).getVectorC()[y];
                  
                 }
             }
         }
        for(int x=0; x<sumatoria.length; x++){
            sumatoria[x]=sumatoria[x]/contInsClas;
        }
        m = new Patron(aux.get(w),"",sumatoria);
        representativos.add(m);
     }
//    for(int x=0; x<representativos.size(); x++){
//        for(int y=0; y<representativos.get(x).getVectorC().length; y++){
//                System.out.println(representativos.get(x).getVectorC()[y]+"-> clase -> "+representativos.get(x).getClase());
//            }
//            
//        }
     
    }
    @Override
    public void clasificar(ArrayList<Patron> instancias) {
      int cont=0;
      double eficacia;
      double[] distancias = new double[representativos.size()];
      int menor =0;
      for(int x=0; x<instancias.size();x++){
          for(int y=0; y<representativos.size();y++){
              distancias[y]=representativos.get(y).calcularDistancia(instancias.get(x));
          }
          for (int i = 0; i < distancias.length; i++) {
			if (distancias[i] < distancias[menor]) {
				menor = i;
			}
		}
          instancias.get(x).setClaseResultante(representativos.get(menor).getClase());
      }
     this.mc = new MatrizConfusion(instancias);
     for(int x=0; x<instancias.size();x++){
      //   System.out.println("Clase "+x+" = "+instancias.get(x).getClase()+" -> Clase Resultante = "+instancias.get(x).getClaseResultante());
         if(instancias.get(x).getClase().equals(instancias.get(x).getClaseResultante())){
             cont++;
         }
     }
     eficacia=(cont*100)/instancias.size();
     System.out.println("Eficacia de Minima Distancia= "+eficacia+"%");
      System.out.println(cont+" de "+instancias.size());
    }
    
     public MatrizConfusion obtenerMatriz() {
        return mc;
    }
}

    