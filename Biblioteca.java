import java.util.*;
import model.Libro;
import model.Usuario;
import tree.UsuarioBST;
import tree.NodoUsuario;
import tree.LibroBST;

public class Biblioteca {

    List<Libro> libros = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    Queue<String> solicitudes = new LinkedList<>();
    Stack<String> historial = new Stack<>();
    Map<Integer, Libro> prestamosActivos = new HashMap<>();
    UsuarioBST arbolUsuarios = new UsuarioBST();
    LibroBST arbolLibros = new LibroBST();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        arbolLibros.insertar(libro);
        historial.push("Se agrego el libro: " + libro.getTitulo());
    }

    public void registrarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId()) {
                System.out.println("Ya existe un usuario con el ID " + usuario.getId() + ". Por favor usa otro ID.");
                return;
            }
        }

        usuarios.add(usuario);
        arbolUsuarios.insertar(usuario);
        historial.push("Se registro el usuario: " + usuario.getNombre() + " (ID: " + usuario.getId() + ")");
        System.out.println("Usuario registrado correctamente: " + usuario.getNombre() + " (ID: " + usuario.getId() + ")");
    }

    public void solicitarPrestamo(Usuario usuario, Libro libro) {

        if (prestamosActivos.containsKey(usuario.getId())) {
            System.out.println("El usuario " + usuario.getNombre() + " ya tiene un libro prestado. Debe devolverlo antes de solicitar otro.");
            return;
        }

        if (libro.isDisponible()) {
            libro.setDisponible(false);
            prestamosActivos.put(usuario.getId(), libro);
            solicitudes.add(usuario.getNombre() + " solicito " + libro.getTitulo());
            historial.push("Prestamo realizado: " + libro.getTitulo() + " a " + usuario.getNombre());
        } else {
            System.out.println("El libro no esta disponible.");
        }
    }

    public void devolverLibro(Usuario usuario) {

        if (prestamosActivos.containsKey(usuario.getId())) {
            Libro libro = prestamosActivos.remove(usuario.getId());
            libro.setDisponible(true);
            historial.push("Se devolvió el libro: " + libro.getTitulo() + " por " + usuario.getNombre());
            System.out.println("El usuario " + usuario.getNombre() + " devolvió el libro: " + libro.getTitulo());
        } else {
            System.out.println("El usuario " + usuario.getNombre() + " no tiene libros prestados.");
        }
    }

    public void mostrarLibros() {
        System.out.println("\nLista de libros:");
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i+1) + ". " + libros.get(i));
        }
    }

    public void mostrarUsuarios() {
        System.out.println("\nLista de usuarios:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i+1) + ". " + usuarios.get(i));
        }
    }

    public void mostrarSolicitudes() {
        System.out.println("\nSolicitudes pendientes:");
        for (String s : solicitudes) {
            System.out.println(s);
        }
    }

    public void mostrarHistorial() {
        System.out.println("\nHistorial de acciones:");
        for (String h : historial) {
            System.out.println(h);
        }
    }

    // Menu interactivo
    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menu Biblioteca ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Solicitar prestamo");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar libros");
            System.out.println("6. Mostrar usuarios");
            System.out.println("7. Mostrar solicitudes");
            System.out.println("8. Mostrar historial");
            System.out.println("9. Buscar usuario por ID (árbol)");
            System.out.println("10. Mostrar usuarios ordenados por ID");
            System.out.println("11. Buscar libro por ID (árbol)");
            System.out.println("12. Mostrar libros ordenados por ID");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingresa un número válido entre las opciones del menú.");
                sc.nextLine();
                opcion = -1;
            }

            switch(opcion) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    biblio.agregarLibro(new Libro(titulo, autor));
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    biblio.registrarUsuario(new Usuario(nombre, id));
                    break;
                case 3:
                    biblio.mostrarUsuarios();
                    System.out.print("Numero de usuario: ");
                    int idxUsuarioPrestamo = sc.nextInt() - 1;
                    sc.nextLine();
                    biblio.mostrarLibros();
                    System.out.print("Numero del libro: ");
                    int idxLibro = sc.nextInt() - 1;
                    sc.nextLine();
                    if (idxUsuarioPrestamo >= 0 && idxUsuarioPrestamo < biblio.usuarios.size() &&
                        idxLibro >= 0 && idxLibro < biblio.libros.size()) {
                        biblio.solicitarPrestamo(biblio.usuarios.get(idxUsuarioPrestamo), biblio.libros.get(idxLibro));
                    } else {
                        System.out.println("Indice invalido.");
                    }
                    break;
                case 4:
                    biblio.mostrarUsuarios();
                    System.out.print("Numero de usuario que devuelve el libro: ");
                    int idxUsuarioDevolucion = sc.nextInt() - 1;
                    sc.nextLine();

                    if (idxUsuarioDevolucion >= 0 && idxUsuarioDevolucion < biblio.usuarios.size()) {
                        Usuario usuarioSeleccionado = biblio.usuarios.get(idxUsuarioDevolucion);
                        biblio.devolverLibro(usuarioSeleccionado);
                    } else {
                        System.out.println("Indice de usuario invalido.");
                    }
                    break;
                case 5:
                    biblio.mostrarLibros();
                    break;
                case 6:
                    biblio.mostrarUsuarios();
                    break;
                case 7:
                    biblio.mostrarSolicitudes();
                    break;
                case 8:
                    biblio.mostrarHistorial();
                    break;
                case 9:
                    System.out.print("Ingrese el ID del usuario: ");
                    int buscarId = sc.nextInt();
                    sc.nextLine();

                    Usuario encontrado = biblio.arbolUsuarios.buscar(buscarId);

                    if (encontrado != null) {
                        System.out.println("Usuario encontrado: " + encontrado);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 10:
                    biblio.arbolUsuarios.mostrarUsuariosOrdenados();
                    break;
                case 11:
                    System.out.print("Ingrese el ID del libro: ");
                    int idLibro = sc.nextInt();
                    sc.nextLine();

                    Libro libroEncontrado = biblio.arbolLibros.buscar(idLibro);

                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " + libroEncontrado);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 12:
                    biblio.arbolLibros.mostrarLibrosOrdenados();
                    break;
            }
        } while(opcion != 0);

        sc.close();
        System.out.println("Gracias por usar el sistema de biblioteca.");
    }
}
