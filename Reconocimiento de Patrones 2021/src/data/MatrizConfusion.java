/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.ArrayList;
/**
 *
 * @author Isma Cortes
 */
public class MatrizConfusion {
    private double[][] matriz;
    private ArrayList<Patron> instancias;
    private ArrayList<String> clases;
    
    public MatrizConfusion(ArrayList<Patron> instancias){
        this.instancias = instancias;
        this.clases = new ArrayList<>();
        this.matriz = null;
        startMatriz();
    }
    
    private void startMatriz(){
        for(Patron n: this.instancias){
            if(!this.clases.contains(n.getClase())){
                this.clases.add(n.getClase());
            }
        }
        int m = this.clases.size();
        this.matriz = new double[m][m+1];
        for(Patron n: this.instancias){
            int i = this.clases.indexOf(n.getClase());
            int j = this.clases.indexOf(n.getClaseResultante());
            this.matriz[i][j]++;
        }
    }
    
    @Override
    public String toString(){
      String aux = "";
      for(int i=0; i<this.matriz.length;i++){
          aux+="|";
          for(int j=0; j<this.matriz.length;j++){
              aux+=" "+this.matriz[i][j]+",";
          }
         aux+="|\n"; 
      }
      return aux;
    }
}