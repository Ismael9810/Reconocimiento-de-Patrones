package Interfaces;

import data.Patron;
import java.util.ArrayList;

/**
 *
 * @author working
 */
public interface ClasificadorSupervisado {
    
    public abstract void entrenar(ArrayList<Patron> instancias);
    public abstract void clasificar(ArrayList<Patron> instancias);
    public abstract void clasificar(Patron patron);
    
}