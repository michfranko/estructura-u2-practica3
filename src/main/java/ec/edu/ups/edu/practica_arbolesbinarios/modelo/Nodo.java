/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.edu.practica_arbolesbinarios.modelo;

/**
 *
 * @author jf001
 */
public class Nodo{
    private Contacto contacto;
    private Nodo left;
    private Nodo right;

    public Nodo(Contacto contacto) {
        this.contacto = contacto;
        left = null;
        right =  null;
    }
    
    
    

    public Nodo getLeft() {
        return left;
    }

    public Nodo getRight() {
        return right;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }
    

    public void setRight(Nodo right) {
        this.right = right;
    }

    public void setValue(Contacto value) {
        this.contacto = value;
    }
    
}
