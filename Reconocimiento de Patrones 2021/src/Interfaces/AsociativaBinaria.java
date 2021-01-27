package Interfaces;

import data.PatronBinario;
import java.util.ArrayList;

/**
 *
 * @author jesua
 */
public interface AsociativaBinaria{
    public abstract void aprendizaje(ArrayList<PatronBinario> instancias);
    public abstract void clasificacion(ArrayList<PatronBinario> instancias);
}