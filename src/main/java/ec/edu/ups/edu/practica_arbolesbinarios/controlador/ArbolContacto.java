/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.edu.practica_arbolesbinarios.controlador;

import ec.edu.ups.edu.practica_arbolesbinarios.modelo.Contacto;
import ec.edu.ups.edu.practica_arbolesbinarios.modelo.Nodo;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author jf001
 */
public class ArbolContacto {
    private Nodo raiz;


    public ArbolContacto() {
        this.raiz = null;
    }


    public void insertar(Contacto nuevoContacto) {
        if (raiz == null) {
            raiz = new Nodo(nuevoContacto);
        } else {
            insertarRecursivo(raiz, nuevoContacto);
        }
    }

    private void insertarRecursivo(Nodo nodo, Contacto nuevoContacto) {

        if (nuevoContacto.getNombre().compareTo(nodo.getContacto().getNombre()) < 0) {
            if (nodo.getLeft() == null) {
                nodo.setLeft(new Nodo(nuevoContacto));
            } else {
                insertarRecursivo(nodo.getLeft(), nuevoContacto);
            }
        } else if (nuevoContacto.getNombre().compareTo(nodo.getContacto().getNombre()) > 0) {
            if (nodo.getRight() == null) {
                nodo.setRight(new Nodo(nuevoContacto));
            } else {
                insertarRecursivo(nodo.getRight(), nuevoContacto);
            }
        } else {
            // El nombre del contacto ya existe, se puede manejar el caso según tus
            // necesidades
            // Por ejemplo, puedes actualizar los datos del contacto existente
        }
    }

    public void inorderRecursivo(Nodo node) {
        if (node != null) {
            inorderRecursivo(node.getLeft());
            System.out.print(node.getContacto() + " - ");
            inorderRecursivo(node.getRight());

        }
    }

     public void postOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            postOrderRecursivo(nodo.getLeft());
            postOrderRecursivo(nodo.getRight());
            System.out.print(nodo.getContacto() + " - ");
        }
    }

    // Método para recorrer el árbol en preorden (raíz - izquierda - derecha)
    public void preOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getContacto() + " - ");
            preOrderRecursivo(nodo.getLeft());
            preOrderRecursivo(nodo.getRight());
        }
    }

    public void printTreeNode(Nodo root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getContacto());
            printTreeNode(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
            printTreeNode(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }

    }

    public Nodo getRoot() {
        return raiz;
    }

    public boolean estaBalanceado() {
        return verificarBalance(raiz);
    }

    private boolean verificarBalance(Nodo nodo) {
        if (nodo == null) {
            return true; // Árbol vacío, se considera balanceado
        }

        int alturaIzquierda = obtenerAltura(nodo.getLeft());
        int alturaDerecha = obtenerAltura(nodo.getRight());

        int diferenciaAlturas = Math.abs(alturaIzquierda - alturaDerecha);

        // Verificar si las alturas difieren en más de 1 unidad
        if (diferenciaAlturas > 1) {
            return false; // No está balanceado
        }

        // Verificar recursivamente los subárboles izquierdo y derecho
        return verificarBalance(nodo.getLeft()) && verificarBalance(nodo.getRight());
    }

    private int obtenerAltura(Nodo nodo) {
        if (nodo == null) {
            return 0; // Altura de un árbol vacío es 0
        }

        int alturaIzquierda = obtenerAltura(nodo.getLeft());
        int alturaDerecha = obtenerAltura(nodo.getRight());

        // La altura del nodo es el máximo entre la altura de sus subárboles más 1
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    //// [Eliminar un nodo]

    public void eliminarContacto(String nombre) {
        raiz = eliminarContactoRec(raiz, nombre);
    }

    public Nodo eliminarContactoRec(Nodo nodo, String nombre) {
        // Caso base: si el nodo es nulo, no se puede eliminar
        if (nodo == null) {
            return nodo;
        }

        // Buscar el nodo a eliminar según el nombre del contacto
        if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
            // Si el nombre es menor, buscar en el subárbol izquierdo
            nodo.setLeft(eliminarContactoRec(nodo.getLeft(), nombre));
        } else if (nombre.compareTo(nodo.getContacto().getNombre()) > 0) {
            // Si el nombre es mayor, buscar en el subárbol derecho
            nodo.setRight(eliminarContactoRec(nodo.getRight(), nombre));
        } else {
            // Si el nombre coincide, este es el nodo a eliminar

            // Caso 1: nodo sin hijos o con un solo hijo
            if (nodo.getLeft() == null) {
                return nodo.getRight();
            } else if (nodo.getRight() == null) {
                return nodo.getLeft();
            }

            // Caso 2: nodo con dos hijos
            // Encontrar el nodo sucesor más pequeño en el subárbol derecho o el nodo
            // predecesor más grande en el subárbol izquierdo
            Nodo sucesor = encontrarMinimo(nodo.getRight());
            nodo.setValue(sucesor.getContacto());

            // Eliminar el sucesor encontrado
            nodo.setRight(eliminarContactoRec(nodo.getRight(), sucesor.getContacto().getNombre()));
        }

        return nodo;
    }

    private Nodo encontrarMinimo(Nodo root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }
    
     public void agregarCorreo(String nombre, String correo) {
        Nodo nodoContacto = buscarContacto(nombre);
        if (nodoContacto != null) {
            nodoContacto.getContacto().getEmails().add(correo);
            System.out.println("Correo agregado con éxito al contacto: " + nombre);
        } else {
            System.out.println("Contacto no encontrado: " + nombre);
        }
    }

    // Método para agregar una red social al contacto
    public void agregarRedSocial(String nombre, String redSocial, String url) {
        Nodo nodoContacto = buscarContacto(nombre);
        if (nodoContacto != null) {
            nodoContacto.getContacto().getRedesSociales().put(redSocial, url);
            System.out.println("Red social agregada con éxito al contacto: " + nombre);
        } else {
            System.out.println("Contacto no encontrado: " + nombre);
        }
    }

    // Método para buscar un contacto por nombre
    public Nodo buscarContacto(String nombre) {
        return buscarContactoRecursivo(raiz, nombre);
    }

    private Nodo buscarContactoRecursivo(Nodo nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        int comparacion = nombre.compareTo(nodo.getContacto().getNombre());

        if (comparacion < 0) {
            return buscarContactoRecursivo(nodo.getLeft(), nombre);
        } else if (comparacion > 0) {
            return buscarContactoRecursivo(nodo.getRight(), nombre);
        } else {
            return nodo;
        }
    }

    // Método para obtener el número total de contactos en el árbol
    public int getNumeroContactos() {
        return obtenerNumeroContactosRecursivo(raiz);
    }

    private int obtenerNumeroContactosRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        return 1 + obtenerNumeroContactosRecursivo(nodo.getLeft()) + obtenerNumeroContactosRecursivo(nodo.getRight());
    }

    // Método para obtener el número de niveles del árbol
    public int getNumeroNiveles() {
        return obtenerNumeroNivelesRecursivo(raiz);
    }

    private int obtenerNumeroNivelesRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        int alturaIzquierda = obtenerNumeroNivelesRecursivo(nodo.getLeft());
        int alturaDerecha = obtenerNumeroNivelesRecursivo(nodo.getRight());

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // Método para imprimir el árbol por anchura (BFS)
    public void imprimirAnchura(Nodo raiz) {
        if (raiz == null) {
            return;
        }

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo nodoActual = cola.poll();
            System.out.print(nodoActual.getContacto() + " - ");

            if (nodoActual.getLeft() != null) {
                cola.add(nodoActual.getLeft());
            }
            if (nodoActual.getRight() != null) {
                cola.add(nodoActual.getRight());
            }
        }
    }

}
   
   
   

