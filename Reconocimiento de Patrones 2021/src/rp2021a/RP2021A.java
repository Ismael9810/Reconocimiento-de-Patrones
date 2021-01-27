
package rp2021a;


import Clasificadores.Bayes;
import Clasificadores.CMeans;
import Clasificadores.KNN;
import data.LeerDatos;
import data.Patron;
import java.util.ArrayList;
import Clasificadores.MinimaDistancia;
import Clasificadores.LernMatrix;
import Clasificadores.Cap_1;
import Clasificadores.MaxMin;
import clusterimagenes.PatronImagen;
import data.PatronBinario;
/**
 *
 * @author  Isma Cortes
 */
public class RP2021A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        ArrayList<Patron> instancias = LeerDatos.tokenizarDataSet();
//        MinimaDistancia m1 = new MinimaDistancia();
//        
//        double[] distancias = new double[instancias.size()];
//        
//        Patron j = new Patron("","", new double[]{2.4,3.3,5.6,7.8}); // Iris.txt
//        //Patron j = new Patron("","", new double[]{13.2,1.78,2.14,11.2,100,2.65,2.76,.26,1.28,4.38,1.05}); //Wine.txt
//        //Patron j = new Patron("","", new double[]{0.455,0.365,0.095,0.514,0.2245,0.101,0.15,15}); //abalone.txt
//        //Patron j = new Patron("","", new double[]{1.52101,13.64,4.49,1.1,71.78,0.06,8.75,0}); //glass.txt
//        //Patron j = new Patron("","", new double[]{0,0,0,0,0,0,1,-1,0,0,-1,-1,0,0,0,0,1,1,-1,-1,0,0,0,0,1,1,1,1,0,0,1,1,0,0}); // inosfere.txt
//        for(int x = 0 ; x<  instancias.size();x++){
//            distancias[x] =    instancias.get(x).calcularDistancia(j);
//          // System.out.println(x+"= "+distancias[x]);
//        }
//        m1.entrenar(instancias);
//        m1.clasificar(instancias);
//        
//        System.out.println();
//        // TODO: TOKENIZADOR PARA PODER SEPARAR POR COMAS Y GENERAR UN COLECCION DE PATRONES
      // ArrayList<PatronImagen> instancias;
        ArrayList<Patron> instancias = LeerDatos.tokenizarDataSet();
        //ArrayList<Patron> instancias2 = instancias;
       // ArrayList<Patron> instancias3= instancias;
        Bayes in = new Bayes();
       // CMeans c = new CMeans(instancias,4);
        KNN in2 = new KNN(3);
        MinimaDistancia in3 = new MinimaDistancia();
        double[] distancias = new double[instancias.size()];
        LernMatrix lm = new LernMatrix();
         MaxMin m = new MaxMin (instancias,3);
//        Cap_1 r = new Cap_1();
//        ArrayList<PatronBinario> entrenamiento = new ArrayList<>();
//        entrenamiento.add(new PatronBinario(new int[]{1,1,1,1,1},new int[]{1,0,0},new int[]{0,0,0}));
//        entrenamiento.add(new PatronBinario(new int[]{1,0,1,0,1},new int[]{0,1,1},new int[]{0,0,0}));
//        entrenamiento.add(new PatronBinario(new int[]{1,0,1,1,1},new int[]{0,0,1},new int[]{0,0,0}));
      // Patron j= new Patron("","", new double[]{2.4,14.3});
        Patron j = new Patron("","", new double[]{2.4,3.3,5.6,7.8}); // Iris.txt
       // Patron j = new Patron("","", new double[]{13.2,1.78,2.14,11.2,100,2.65,2.76,.26,1.28,4.38,1.05}); //Wine.txt
        //Patron j = new Patron("","", new double[]{0.455,0.365,0.095,0.514,0.2245,0.101,0.15,15}); //abalone.txt
       // Patron j = new Patron("","", new double[]{1.52101,13.64,4.49,1.1,71.78,0.06,8.75,0}); //glass.txt
       // Patron j = new Patron("","", new double[]{0,0,0,0,0,0,1,-1,0,0,-1,-1,0,0,0,0,1,1,-1,-1,0,0,0,0,1,1,1,1,0,0,1,1,0,0}); // inosfere.txt
//        for(int x = 0 ; x<  instancias.size();x++){
//            distancias[x] =    instancias.get(x).calcularDistancia(j);
//           System.out.println(x+"= "+distancias[x]);
//        }
            //m.clasifica();
            m.clasificaMd(j);
//        in.entrenar(instancia1);
//        in.clasificar(instancia1);
//        System.out.println("\n");
//        in2.entrenar(instancia2);
//        in2.clasificar(instancia2);
//         System.out.println("\n");
//        in3.entrenar(instancia3);
//        in3.clasificar(instancia3);
//         System.out.println("\n");
        // c.clusterizar(instancia1);
     //   c.imprimir();
      //Cap_
      // r.entrenar(instancias);
      // r.clasificar(instancias2);
      // System.out.println(r.getRendimiento());
//     lm.aprendizaje(entrenamiento);
//       ArrayList<PatronBinario> datos = new ArrayList<>();
//       
//       datos.add(new PatronBinario(new int[]{1,0,1,0,1},new int[]{1,0,0},new int[]{0,0,0}));
//       datos.add(new PatronBinario(new int[]{1,1,0,0,1},new int[]{0,1,0},new int[]{0,0,0}));
//       datos.add(new PatronBinario(new int[]{1,0,1,1,0},new int[]{0,0,1},new int[]{0,0,0}));
//       
//       
//       lm.clasificacion(datos);
     
        
    }
    
}