# Sistema de Biblioteca en Java

Este proyecto implementa un sistema de gestión de biblioteca en Java con un menú interactivo en consola.  
Permite registrar libros y usuarios, realizar préstamos, devoluciones y consultar historial de acciones.

## Visualizacion online

Esto es un proyecto publicado en github de manera publica: [Jgarcia-U/BibliotecaEstructuraDatosJava](https://github.com/Jgarcia-U/BibliotecaEstructuraDatosJava)

## Funcionalidades

- **Agregar libros** con ID único automático.
- **Registrar usuarios** con validación para evitar IDs duplicados.
- **Solicitar préstamo**: cada usuario solo puede tener un libro prestado a la vez.
- **Devolver libro**: el usuario debe devolver su libro antes de solicitar otro.
- **Mostrar listas** de libros y usuarios.
- **Ver solicitudes pendientes**.
- **Historial de acciones** para rastrear operaciones realizadas.
- **Validación de entradas**: el menú no se rompe si el usuario escribe letras en lugar de números.

## Uso de árboles binarios de búsqueda

Para mejorar la eficiencia en la gestión y consulta de la información del sistema, se implementaron árboles binarios de búsqueda (BST) para representar tanto a los usuarios como a los libros de la biblioteca.
Un árbol binario de búsqueda permite organizar los datos de forma jerárquica utilizando una clave única, lo que optimiza operaciones como la inserción, búsqueda y recorrido, en comparación con estructuras lineales.

## Árbol de usuarios (UsuarioBST)

Se implementó un árbol binario de búsqueda de usuarios, utilizando el ID del usuario como clave principal.

### Diseño usuarios

- Cada nodo del árbol representa un usuario.
- El ID del usuario es único y se utiliza para ordenar el árbol.
- Los nodos con ID menor se ubican en el subárbol izquierdo y los mayores en el derecho.

### Componentes usuarios

- NodoUsuario: representa un nodo del árbol y almacena un objeto Usuario.
- UsuarioBST: gestiona la lógica del árbol (inserción, búsqueda y recorrido).

### Operaciones implementadas usuarios

- Inserción de usuarios en orden según el ID.
- Búsqueda de usuario por ID.
- Recorrido inorden, que permite mostrar los usuarios ordenados por ID.

### Integración usuarios

Cada vez que se registra un nuevo usuario, este se inserta automáticamente en el árbol.
Desde el menú principal se pueden:

- Buscar usuarios por ID usando el árbol.
- Mostrar todos los usuarios ordenados mediante recorrido inorden.

## Árbol de libros (LibroBST)

De forma similar, se implementó un árbol binario de búsqueda para los libros, utilizando el ID del libro como clave.

### Diseño libros

- Cada nodo representa un libro del sistema.
- El ID del libro se genera automáticamente y es único.
- El árbol se mantiene ordenado por ID.

### Componentes libros

- NodoLibro: nodo del árbol que contiene un objeto Libro.
- LibroBST: clase que implementa la lógica del árbol de libros.

### Operaciones implementadas libros

- Inserción de libros en el árbol al momento de agregarlos.
- Búsqueda de libros por ID.
- Recorrido inorden para mostrar los libros ordenados.

### Integración libros

Al agregar un libro al sistema, este se inserta tanto en la estructura general como en el árbol de libros.
Desde el menú se puede:

- Buscar libros por ID utilizando el árbol.
- Mostrar todos los libros ordenados por ID.

## Estructura del código

- model/Libro: clase del modelo que representa un libro de la biblioteca. Contiene un identificador único, título, autor y el estado de disponibilidad. Implementa encapsulamiento mediante atributos privados y métodos getter/setter.

- model/Usuario: clase del modelo que representa un usuario del sistema. Define un nombre y un ID único para identificar a cada usuario, aplicando encapsulamiento y métodos de acceso.

- Biblioteca: clase principal que gestiona la lógica del sistema. Administra las colecciones de libros y usuarios, controla los préstamos activos mediante un Map, registra solicitudes en una Queue y mantiene un historial de acciones con una Stack.

- main: método de ejecución que presenta un menú interactivo por consola, permitiendo al usuario agregar libros, registrar usuarios, gestionar préstamos y consultar la información del sistema.

## Ejecución

1. Compilar el archivo:

    ```bash
    javac model/Libro.java model/Usuario.java Biblioteca.java
    ```

2. Ejecutar el archivo:

    ```bash
    java Biblioteca
    ```

## Pruebas

1. Creacion de libros

    ```bash
    --- Menu Biblioteca ---
    1. Agregar libro
    2. Registrar usuario
    3. Solicitar prestamo
    4. Devolver libro
    5. Mostrar libros
    6. Mostrar usuarios
    7. Mostrar solicitudes
    8. Mostrar historial
    0. Salir
    Elige una opcion: 1
    Titulo: 1984
    Autor: George Orwell
    ```

2. Creacion de Usuarios

    ```Bash
    --- Menu Biblioteca ---
    1. Agregar libro
    2. Registrar usuario
    3. Solicitar prestamo
    4. Devolver libro
    5. Mostrar libros
    6. Mostrar usuarios
    7. Mostrar solicitudes
    8. Mostrar historial
    0. Salir
    Elige una opcion: 2
    Nombre: Juan Manuel Garcia
    ID: 1027150930
    Usuario registrado correctamente: Juan Manuel Garcia (ID: 1027150930)
    ```

3. Creacion de prestamo

    ```Bash
    --- Menu Biblioteca ---
    1. Agregar libro
    2. Registrar usuario
    3. Solicitar prestamo
    4. Devolver libro
    5. Mostrar libros
    6. Mostrar usuarios
    7. Mostrar solicitudes
    8. Mostrar historial
    0. Salir
    Elige una opcion: 3

    Lista de usuarios:
    1. Juan Manuel Garcia (ID: 1027150930)
    Numero de usuario: 1

    Lista de libros:
    1. ID: 1 | 1984 - George Orwell (Disponible)
    Numero del libro: 1
    ```

4. Devolucion de libros

    ```Bash
    --- Menu Biblioteca ---
    1. Agregar libro
    2. Registrar usuario
    3. Solicitar prestamo
    4. Devolver libro
    5. Mostrar libros
    6. Mostrar usuarios
    7. Mostrar solicitudes
    8. Mostrar historial
    0. Salir
    Elige una opcion: 4

    Lista de usuarios:
    1. Juan Manuel Garcia (ID: 1027150930)
    Numero de usuario que devuelve el libro: 1
    El usuario Juan Manuel Garcia devolvió el libro: 1984
    ```

5. Mostrar libros

    ```Bash
    --- Menu Biblioteca ---
    1. Agregar libro
    2. Registrar usuario
    3. Solicitar prestamo
    4. Devolver libro
    5. Mostrar libros
    6. Mostrar usuarios
    7. Mostrar solicitudes
    8. Mostrar historial
    0. Salir
    Elige una opcion: 5

    Lista de libros:
    1. ID: 1 | 1984 - George Orwell (Disponible)
    ```

6. Mostrar Usuarios

    ```Bash
    --- Menu Biblioteca ---
    1. Agregar libro
    2. Registrar usuario
    3. Solicitar prestamo
    4. Devolver libro
    5. Mostrar libros
    6. Mostrar usuarios
    7. Mostrar solicitudes
    8. Mostrar historial
    0. Salir
    Elige una opcion: 6

    Lista de usuarios:
    1. Juan Manuel Garcia (ID: 1027150930)
    ```

7. Mostrar solicitudes

    ```bash
    --- Menu Biblioteca ---
    1. Agregar libro
    2. Registrar usuario
    3. Solicitar prestamo
    4. Devolver libro
    5. Mostrar libros
    6. Mostrar usuarios
    7. Mostrar solicitudes
    8. Mostrar historial
    0. Salir
    Elige una opcion: 7

    Solicitudes pendientes:
    Juan Manuel Garcia solicito 1984
    ```

8. Mostrar historial

    ```Bash
    --- Menu Biblioteca ---
    1. Agregar libro
    2. Registrar usuario
    3. Solicitar prestamo
    4. Devolver libro
    5. Mostrar libros
    6. Mostrar usuarios
    7. Mostrar solicitudes
    8. Mostrar historial
    0. Salir
    Elige una opcion: 8

    Historial de acciones:
    Se agrego el libro: 1984
    Se registro el usuario: Juan Manuel Garcia (ID: 1027150930)
    Prestamo realizado: 1984 a Juan Manuel Garcia
    Se devolvió el libro: 1984 por Juan Manuel Garcia
    ```

9. Salir del sistema

    ```Bash
    --- Menu Biblioteca ---
    1. Agregar libro
    2. Registrar usuario
    3. Solicitar prestamo
    4. Devolver libro
    5. Mostrar libros
    6. Mostrar usuarios
    7. Mostrar solicitudes
    8. Mostrar historial
    0. Salir
    Elige una opcion: 0
    Gracias por usar el sistema de biblioteca.
    ```
