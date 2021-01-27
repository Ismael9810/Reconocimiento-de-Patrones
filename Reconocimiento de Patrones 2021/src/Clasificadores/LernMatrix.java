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



import data.PatronBinario;
import Interfaces.AsociativaBinaria;
import java.util.ArrayList;
       
/**
 *
 * @author jesua
 */
public class LernMatrix implements AsociativaBinaria {
    private int[][] m;
    private int[] aux;
    static int eps=1;
    ArrayList<PatronBinario> instancias;
    @Override
    public void aprendizaje(ArrayList<PatronBinario> instancias) {
        this.instancias=instancias;
        int vector = instancias.get(0).getVectorC().length;
        int clases = instancias.get(0).getClase().length;
        this.m = new int[clases][vector];
	this.aux = new int[clases];	
		for(int k=0;k<instancias.size();k++){
			for(int i=0;i<clases;i++){
				for(int j=0;j<vector;j++){
					if(instancias.get(k).getVectorC()[j] == instancias.get(k).getClase()[i] && instancias.get(k).getClase()[i] == 1){
						this.m[i][j]+=eps;
					}else{
						if(instancias.get(k).getVectorC()[j] == 0 && instancias.get(k).getClase()[i] == 1){
							this.m[i][j]+=-eps;
						}else{
							this.m[i][j]+=0;
						} 
					}
				}
			}
                    System.out.println(imprimirLernMatrix());
		}
    }

    @Override
    public void clasificacion(ArrayList<PatronBinario> instancias) {
        for(int x=0;x<instancias.size();x++){
            clasificar(instancias.get(x));
        }
    }
    
    public void clasificar(PatronBinario x){
		for(int i=0;i<x.getClase().length;i++){
			for(int j=0;j<x.getVectorC().length;j++){
				x.getClaseResultante()[i]+=m[i][j]*x.getVectorC()[j];
                         
			}
		}
                int mayor= 0;
                for(int i=0;i<x.getClaseResultante().length;i++){
                        if(x.getClaseResultante() [i] > mayor) {
                            mayor = x.getClaseResultante()[i];
                        }   
		}
                for(int i=0;i<x.getClaseResultante().length;i++){
                        if(x.getClaseResultante() [i] == mayor) {
                            this.aux[i]=1;
                        }else{
                            this.aux[i]=0;
                        }
		}
                System.out.println(imprimirLernMatrix()+"*"+x.imprimirVector()+"="+x.imprimirClaseResultante()+"="+imprimirAux());
	}
    
    public String imprimirLernMatrix() {
         String aux = "";
           for(int i=0; i<this.m.length;i++){
                aux+="|";
                    for(int j=0; j<this.m.length;j++){
                        aux+=" "+this.m[i][j]+"e ,";
                    }
                aux+="|\n"; 
            }
        return aux;     
    }
     public String imprimirAux (){
        String aux= "";
        for(int j=0; j<this.aux.length;j++){
                        aux+=" |"+this.aux[j]+"|\n";
                    }
        return aux;
    }
    
}