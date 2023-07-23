# Universidad Politecnica Salesiana

# Descripcion de Proyecto 
Se necesita desarrollar un programa para gestionar una lista de contactos telefónicos. 
Cada contacto tiene un nombre, un número de teléfono, una Coleccion de Correos y 
un Diccionario que almacenara las redes sociales del contacto.

El programa debe permitir agregar, buscar y eliminar 
contactos de la lista utilizando un árbol binario de búsqueda.

# Estructura del Proyecto:
* `ArbolContacto`: Implementa todas las operaciones necesarias para
  manejar una lista de contactos utilizando un árbol binario de búsqueda. Permite la
  inserción de nuevos contactos en orden, eliminación de contactos específicos, y
  realiza recorridos en el árbol (inorden, preorden, postorden) para obtener los
  contactos ordenados de diferentes maneras.

  Además, proporciona métodos para verificar si el árbol está balanceado, lo que es 
  importante para mantener una estructura de datos eficiente, y calcula la altura del 
  árbol. También incluye la funcionalidad para agregar direcciones de correo 
  electrónico y enlaces de redes sociales a los contactos existentes, porlo que esta
  colocada dentro de el paquete controlador.
   
*  `Contacto`:  Proporciona una estructura de datos simple pero
   efectiva para almacenar y gestionar información sobre un contacto, incluyendo su
   nombre, número de teléfono, correos electrónicos y perfiles de redes sociales. Es
   una base sólida para implementar una lista de contactos más completa y funcional
   en una aplicación más amplia.
   
 * `Nodo`:  La clase Nodo es una pieza fundamental para construir un árbol
   binario de búsqueda que almacena objetos de la clase Contacto. Cada objeto de
   tipo Nodo contiene un objeto de tipo Contacto y referencias a sus nodos hijos
   izquierdo y derecho. Estas referencias permiten la organización jerárquica de los
   contactos en el árbol y facilitan la realización de operaciones de búsqueda,
   inserción y eliminación en el árbol de manera eficiente.
   
 * `Main (Practica_ArbolesBinarios)`: Clase principal que contiene el punto de entrada
   del programa y se encarga de interactuar con el usuario a través de una interfaz
   sencilla para interactuar con un árbol binario de búsqueda que almacena contactos.
   Permite agregar, buscar, eliminar, y modificar información de los contactos, además
   de realizar diferentes tipos de recorridos del árbol y obtener estadísticas como el
   número de contactos y niveles del árbol.
   
  # Explicacion de Metodos dentro de la Clase ArbolContacto  
  
  1. `Insertar` : La inserción en un árbol binario de búsqueda se hace de forma recursiva,
    comparando el valor del nuevo elemento con los valores de los nodos existentes y
    colocándolo en el subárbol adecuado para mantener el orden. Los valores menores
    se colocan a la izquierda y los valores mayores a la derecha en cada nodo. Así, se
    garantiza que el árbol esté ordenado y optimizado para búsquedas eficientes.

 2. `inOrderRecursivo` : Realiza un recorrido inorden (inorder traversal)
    recursivo en un árbol binario de búsqueda. En este tipo de recorrido, se
    visitan los nodos en el siguiente orden: primero el subárbol izquierdo, luego
    el nodo actual y finalmente el subárbol derecho.
    
 3. `postOrderRecursivo ` : Realiza un recorrido postorden (postorder traversal)
    recursivo en un árbol binario de búsqueda. En este tipo de recorrido, se
    visitan los nodos en el siguiente orden: primero los subárboles izquierdo y derecho
    y luego el nodo actual.

 4. `preOrderRecursivo ` : Realiza un recorrido en preorden (preorder traversal)
    recursivo en un árbol binario de búsqueda. En este tipo de recorrido, se
    visita el nodo actual primero, luego se recorren los subárboles izquierdo y
    derecho.

 5. `printTreeNode` : es una función que imprime de manera visual la estructura de
    un árbol binario de búsqueda. La representación muestra los nodos del árbol
    junto con las conexiones entre ellos para visualizar la jerarquía y la
    disposición de los elementos en el árbol.

 6. `getRoot` :  es una función que devuelve el nodo raíz del árbol binario de
    búsqueda. La raíz es el nodo principal del árbol desde donde comienza toda
    la estructura y se puede acceder a todos los demás nodos del árbol mediante
    navegación.

  7. `estaBalanceado` : es una función que verifica si el árbol binario de búsqueda
     está balanceado o no. Un árbol se considera balanceado si la diferencia de
     alturas entre su subárbol izquierdo y derecho no excede una unidad.
     Si la diferencia de alturas en algún punto del árbol es mayor que uno,
     entonces el árbol no está balanceado.

   8. `obtenerAltura` : es una función recursiva que calcula la altura de un subárbol en
      un árbol binario de búsqueda. La altura de un subárbol se define como la cantidad
      de niveles que tiene dicho subárbol, es decir, la longitud del camino más largo
      desde la raíz hasta una hoja en el subárbol.

   9. `eliminarContacto` :  es una función que permite eliminar un contacto del árbol binario
      de búsqueda por su nombre. Además, se utiliza un método auxiliar
      eliminarContactoRec(Nodo nodo, String nombre) para realizar la eliminación de
      manera recursiva en el árbol.

   10. `encontrarMinimo ` :  es una función que busca y devuelve el nodo con el valor mínimo
       (el sucesor más pequeño) en un subárbol. Es específicamente utilizado para encontrar
       el nodo sucesor más pequeño en el subárbol derecho de un nodo dado, que se utiliza en
       el caso 2 de eliminación cuando se quiere eliminar un nodo con dos hijos.         
         
   11. `agregarCorreo` : permite agregar un correo electrónico a un contacto específico en el
       árbol binario de búsqueda. El método primero busca el contacto con el nombre proporcionado
       (nombre) y, si lo encuentra, agrega el correo electrónico proporcionado (correo) a la lista
       de correos electrónicos del contacto. Si no se encuentra el contacto, se muestra un mensaje
       indicando que el contacto no fue encontrado.

   12. `agregarRedSocial` : permite agregar una red social con su correspondiente URL a un contacto
       específico en el árbol binario de búsqueda. El método primero busca el contacto con el nombre
       proporcionado (nombre) y, si lo encuentra, agrega la red social y su URL proporcionadas
       (redSocial y url) al mapa de redes sociales del contacto. Si no se encuentra el contacto,
       se muestra un mensaje indicando que el contacto no fue encontrado.

   13. `buscarContacto` : permite buscar un contacto en el árbol binario de búsqueda por su nombre
       utilizando el método auxiliar buscarContactoRecursivo(Nodo nodo, String nombre) que realiza
       la búsqueda de manera recursiva en el árbol y devuelve el nodo que contiene el contacto si
       es encontrado, o null si no se encuentra el contacto con el nombre especificado.

   14.  `getNumeroContactos` : permite obtener el número total de contactos en el árbol binario de
       búsqueda utilizando el método auxiliar obtenerNumeroContactosRecursivo(Nodo nodo) que realiza
       el cálculo de manera recursiva contando los contactos en cada nodo y sumándolos en el árbol completo. 

  15. `getNumeroNiveles` : permite obtener el número total de niveles del árbol binario de búsqueda utilizando
      el método auxiliar obtenerNumeroNivelesRecursivo(Nodo nodo) que calcula de manera recursiva la altura del
      árbol contando los niveles en cada subárbol y determinando el máximo entre las alturas de los subárboles
      izquierdo y derecho para obtener el número total de niveles del árbol.
 
   16. `imprimirAnchura ` :  realiza el recorrido por niveles del árbol binario de búsqueda y muestra los contactos
       almacenados en el árbol en el orden en que se visitan, comenzando desde la raíz y avanzando nivel por nivel.
