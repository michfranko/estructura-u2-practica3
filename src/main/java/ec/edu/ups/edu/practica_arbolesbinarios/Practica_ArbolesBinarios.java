/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.edu.practica_arbolesbinarios;

import ec.edu.ups.edu.practica_arbolesbinarios.controlador.ArbolContacto;
import ec.edu.ups.edu.practica_arbolesbinarios.modelo.Contacto;
import ec.edu.ups.edu.practica_arbolesbinarios.modelo.Nodo;
import java.util.Scanner;

/**
 *
 * @author jf001
 */
public class Practica_ArbolesBinarios {

    public static void main(String[] args) {

        ArbolContacto arbolContacto = new ArbolContacto();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("======= Menú de Contactos =======");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Buscar Contacto");
            System.out.println("3. Eliminar Contacto");
            System.out.println("4. Agregar un correo");
            System.out.println("5. Agregar una red social");
            System.out.println("6. Imprimir árbol (Recorridos)");
            System.out.println("7. Obtener número de contactos totales");
            System.out.println("8. Obtener número de niveles del árbol");
            System.out.println("0. Salir");
            System.out.println("==================================");

            System.out.print("Ingrese la opción deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    Contacto nuevoContacto = new Contacto(nombre, telefono);
                    arbolContacto.insertar(nuevoContacto);
                    System.out.println("Contacto agregado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    Nodo nodoEncontrado = arbolContacto.buscarContacto(nombreBusqueda);
                    if (nodoEncontrado != null) {
                        System.out.println("Contacto encontrado:");
                        System.out.println(nodoEncontrado.getContacto());
                    } else {
                        System.out.println("Contacto no encontrado.");
                        System.out.print("¿Desea crear un nuevo contacto con ese nombre? (S/N): ");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("S")) {
                            System.out.print("Ingrese el teléfono del nuevo contacto: ");
                            String nuevoTelefono = scanner.nextLine();
                            Contacto nuevoContactoExistente = new Contacto(nombreBusqueda, nuevoTelefono);
                            arbolContacto.insertar(nuevoContactoExistente);
                            System.out.println("Contacto agregado con éxito.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    arbolContacto.eliminarContacto(nombreEliminar);
                    System.out.println("Contacto eliminado con éxito.");
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del contacto al que desea agregar un correo: ");
                    String nombreCorreo = scanner.nextLine();
                    Nodo nodoCorreo = arbolContacto.buscarContacto(nombreCorreo);
                    if (nodoCorreo != null) {
                        System.out.print("Ingrese el correo a agregar: ");
                        String correo = scanner.nextLine();
                        nodoCorreo.getContacto().getEmails().add(correo);
                        System.out.println("Correo agregado con éxito.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el nombre del contacto al que desea agregar una red social: ");
                    String nombreRedSocial = scanner.nextLine();
                    Nodo nodoRedSocial = arbolContacto.buscarContacto(nombreRedSocial);
                    if (nodoRedSocial != null) {
                        System.out.print("Ingrese el nombre de la red social: ");
                        String redSocial = scanner.nextLine();
                        System.out.print("Ingrese la URL de la red social: ");
                        String urlRedSocial = scanner.nextLine();
                        nodoRedSocial.getContacto().getRedesSociales().put(redSocial, urlRedSocial);
                        System.out.println("Red social agregada con éxito.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Imprimir el árbol según el recorrido:");
                    System.out.println("1. Preorder");
                    System.out.println("2. Inorder");
                    System.out.println("3. Postorder");
                    System.out.println("4. Anchura");
                    System.out.print("Ingrese la opción deseada: ");
                    int opcionRecorrido = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionRecorrido) {
                        case 1:
                            System.out.println("Recorrido Preorder:");
                            arbolContacto.preOrderRecursivo(arbolContacto.getRoot());
                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Recorrido Inorder:");
                            arbolContacto.inorderRecursivo(arbolContacto.getRoot());
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("Recorrido Postorder:");
                            arbolContacto.postOrderRecursivo(arbolContacto.getRoot());
                            System.out.println();
                            break;
                        case 4:
                            System.out.println("Recorrido por Anchura:");
                            arbolContacto.imprimirAnchura(arbolContacto.getRoot());
                            System.out.println();
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;

                case 7:
                    int numeroContactos = arbolContacto.getNumeroContactos();
                    System.out.println("Número de contactos totales: " + numeroContactos);
                    break;

                case 8:
                    int numeroNiveles = arbolContacto.getNumeroNiveles();
                    System.out.println("Número de niveles del árbol: " + numeroNiveles);
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}


    
  
