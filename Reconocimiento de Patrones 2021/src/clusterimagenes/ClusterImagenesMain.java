package clusterimagenes;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author working
 */
public class ClusterImagenesMain {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        ClusterizacionImagenes aux = new ClusterizacionImagenes();
        aux.abrir();
        aux.clusterizar(150);
    }
}