# Sistema de Biblioteca en Java

Este proyecto implementa un sistema de gestión de biblioteca en Java con un menú interactivo en consola.  
Permite registrar libros y usuarios, realizar préstamos, devoluciones y consultar historial de acciones.

## Funcionalidades

- **Agregar libros** con ID único automático.
- **Registrar usuarios** con validación para evitar IDs duplicados.
- **Solicitar préstamo**: cada usuario solo puede tener un libro prestado a la vez.
- **Devolver libro**: el usuario debe devolver su libro antes de solicitar otro.
- **Mostrar listas** de libros y usuarios.
- **Ver solicitudes pendientes**.
- **Historial de acciones** para rastrear operaciones realizadas.
- **Validación de entradas**: el menú no se rompe si el usuario escribe letras en lugar de números.

## Estructura del código

- `Libro`: clase que representa un libro con ID, título, autor y estado (disponible/prestado).
- `Usuario`: clase que representa un usuario con nombre e ID único.
- `Biblioteca`: clase principal que contiene las listas de libros, usuarios, solicitudes, historial y préstamos activos.
- `main`: método con menú interactivo para gestionar la biblioteca desde consola.

## Ejecución

1. Compilar el archivo:

    ```bash
    javac Biblioteca.java
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
    Elige una opcion: 8

    Historial de acciones:
    Se agrego el libro: 1984
    Se registro el usuario: Juan Manuel Garcia (ID: 1027150930)
    Prestamo realizado: 1984 a Juan Manuel Garcia
    Se devolvió el libro: 1984 por Juan Manuel Garcia
    ```
