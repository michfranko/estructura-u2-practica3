/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.edu.practica_arbolesbinarios;

import ec.edu.ups.edu.practica_arbolesbinarios.controlador.ArbolContacto;
import ec.edu.ups.edu.practica_arbolesbinarios.modelo.Contacto;

/**
 *
 * @author jf001
 */
public class Practica_ArbolesBinarios {

    public static void main(String[] args) {
        ArbolContacto arbol = new ArbolContacto();
        
       Contacto c1 = new Contacto("juan","0199120231");
       Contacto c2 = new Contacto("maria","0199120232");
       Contacto c3 = new Contacto("pedro","0199120233");
       Contacto c4 = new Contacto("pablo","0199120234");
       
       arbol.insert(c1);
       arbol.insert(c2);
       arbol.insert(c3);
       arbol.insert(c4);
       arbol.insert(new Contacto("juliana","09956683"));
       arbol.insert(new Contacto("jhon","09956685"));
       
    }
}
