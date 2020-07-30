/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MILKA
 */
public class Cola {
    String elemento;
    Cola siguiente;
    
    public Cola(String x){
        elemento = x;
        siguiente = null;
    }
}
class ColaLista{
    protected Cola inicio;//controlar inicio de cola
    protected Cola fin; //controlar fianl de cola
    
    public ColaLista(){
        inicio = fin = null; //cuando se inicia la cola...
        
    }
    public void insertar(String elemento){
        Cola a;
        a = new Cola(elemento);
        if (colaVacia()){
            inicio = a;
        }else{
            fin.siguiente = a;
        }
        fin = a;
    }// se añade a la cola...
    public String quitar(){
        String aux;
        if (!colaVacia()){
            aux = inicio.elemento;
            inicio = inicio.siguiente;
        }else{
            return ("NO hay nadie en la cola");
        }
        return aux;
    }//obtener alguien de la cola...
    public void borrarCola(){
        while (inicio != null){
            inicio = inicio.siguiente;
        }
    }//para borrar de la cola
    public boolean colaVacia(){
        if (inicio == null){
            return true;
        }else{
            return false;
        }
    }//saber si la cola esta llena o vacia
}
