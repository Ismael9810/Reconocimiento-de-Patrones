/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Ismael Cortes
 */
import java.util.ArrayList;
import data.Patron;

public interface Clusterizacion {

    public abstract void clusterizar(ArrayList<Patron> instancias);

}