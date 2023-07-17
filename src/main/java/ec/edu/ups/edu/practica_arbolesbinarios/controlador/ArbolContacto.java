/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.edu.practica_arbolesbinarios.controlador;

import ec.edu.ups.edu.practica_arbolesbinarios.modelo.Contacto;
import ec.edu.ups.edu.practica_arbolesbinarios.modelo.Nodo;

/**
 *
 * @author jf001
 */
public class ArbolContacto {
    private Nodo raiz;

    public ArbolContacto(Nodo raiz) {
        this.raiz = null;
    }

    public ArbolContacto() {
    }
    
    
    
    public void insert(Contacto newContacto){
        if(raiz == null){
          raiz = new Nodo(newContacto);  
        }else{
            insertRecursivo(raiz, newContacto);
        }
    }
   
    private void insertRecursivo (Nodo nodo,Contacto newContacto){
     if(newContacto.getNombre().compareTo(nodo.getContacto().getNombre())< 0){
       if(nodo.getIzquierda()== null){
         nodo.setIzquierda( new Nodo(newContacto));
       }else{
         insertRecursivo(nodo.getIzquierda(),newContacto);  
       }  
     }else if(newContacto.getNombre().compareTo(nodo.getContacto().getNombre())> 0){
         if(nodo.getDerecha()==null){
         nodo.setDerecha(new Nodo (newContacto));
         }else{
          insertRecursivo(nodo.getDerecha(),newContacto);   
         }
     }else{
         //si es igual el contacto 
     }  
    }
    
    
    public boolean estaEquilibrado(){
       return verificarBalance(raiz); 
    }
    
    private boolean verificarBalance(Nodo nodo){
        if(nodo==null){
            return true;//arbol vacio se considera balanceado
        }
        int alturaIzquierda = obtenerAltura(nodo.getIzquierda());
        int alturaDerecha = obtenerAltura(nodo.getDerecha());
        int diferencia =Math.abs(alturaIzquierda-alturaDerecha);
       // validacion de la diferencia de altura
        if(diferencia > 1){
            return false;
        } 
       return verificarBalance(nodo.getIzquierda())&& verificarBalance(nodo.getDerecha()); 
    }
    
    
    private int obtenerAltura (Nodo nodo){
        if(nodo == null){
         return 0;   
        }
        int alturaIzquierda = obtenerAltura(nodo.getIzquierda());
        int alturaDerecha = obtenerAltura(nodo.getDerecha());
         
      return Math.max(alturaIzquierda, alturaDerecha+1);
    }
    
    
    
}
