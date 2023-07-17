/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.edu.practica_arbolesbinarios.modelo;

/**
 *
 * @author jf001
 */
public class Nodo {
    private Contacto contacto;
    private Nodo Izquierda;
    private Nodo derecha;

    public Nodo(Contacto contacto, Nodo Izquierda, Nodo derecha) {
        this.contacto = contacto;
        this.Izquierda = null;
        this.derecha = null;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Nodo getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(Nodo Izquierda) {
        this.Izquierda = Izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
    
    
    
    
}
