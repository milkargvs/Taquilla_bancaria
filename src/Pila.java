/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MILKA
 */
public class Pila {
    String elemento;
    Pila siguiente;
    Pila(String x){
        elemento = x;
        siguiente = null;
    }
}
class PilaLista{
    private Pila ultimo;
    public PilaLista(){
        ultimo = null;
    }
    
    //operaciones de la pila
    public boolean pilaVacia(){
        if( ultimo == null ) {
        return true;
    }else{
            return false;
            }
    } //saber si la pila esta llena o vacia
    public void insertar (String elemento){
        Pila nuevo;
        nuevo = new Pila(elemento);
        nuevo.siguiente = ultimo;
        ultimo = nuevo;
        
    }// inserta un dato en la pila
    public String quitar(){
        if (pilaVacia()){
            return ("La Pila esta vacia");
        }
        String aux = ultimo.elemento;
        ultimo = ultimo.siguiente;
        return aux;
    }//quitar un cliente de la pila
    public void limpiarPila(){
        Pila t;
        while(!pilaVacia()){
            t = ultimo;
            ultimo = ultimo.siguiente;
            t.siguiente = null;
        }
    }//vaciar toda la pila
}