import java.util.*;

// Clase Libro
class Libro {
    private static int contador = 1;
    int id;
    String titulo;
    String autor;
    boolean disponible;

    public Libro(String titulo, String autor) {
        this.id = contador++;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + titulo + " - " + autor + 
               (disponible ? " (Disponible)" : " (Prestado)");
    }
}


// Clase Usuario
class Usuario {
    String nombre;
    int id;

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}

// Clase principal
public class Biblioteca {

    List<Libro> libros = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    Queue<String> solicitudes = new LinkedList<>();
    Stack<String> historial = new Stack<>();
    Map<Integer, Libro> prestamosActivos = new HashMap<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        historial.push("Se agrego el libro: " + libro.titulo);
    }

    public void registrarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.id == usuario.id) {
                System.out.println("Ya existe un usuario con el ID " + usuario.id + ". Por favor usa otro ID.");
                return;
            }
        }

        usuarios.add(usuario);
        historial.push("Se registro el usuario: " + usuario.nombre + " (ID: " + usuario.id + ")");
        System.out.println("Usuario registrado correctamente: " + usuario.nombre + " (ID: " + usuario.id + ")");
    }

    public void solicitarPrestamo(Usuario usuario, Libro libro) {

        if (prestamosActivos.containsKey(usuario.id)) {
            System.out.println("El usuario " + usuario.nombre + " ya tiene un libro prestado. Debe devolverlo antes de solicitar otro.");
            return;
        }

        if (libro.disponible) {
            libro.disponible = false;
            prestamosActivos.put(usuario.id, libro);
            solicitudes.add(usuario.nombre + " solicito " + libro.titulo);
            historial.push("Prestamo realizado: " + libro.titulo + " a " + usuario.nombre);
        } else {
            System.out.println("El libro no esta disponible.");
        }
    }

    public void devolverLibro(Usuario usuario) {

        if (prestamosActivos.containsKey(usuario.id)) {
            Libro libro = prestamosActivos.remove(usuario.id);
            libro.disponible = true;
            historial.push("Se devolvió el libro: " + libro.titulo + " por " + usuario.nombre);
            System.out.println("El usuario " + usuario.nombre + " devolvió el libro: " + libro.titulo);
        } else {
            System.out.println("El usuario " + usuario.nombre + " no tiene libros prestados.");
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
            }
        } while(opcion != 0);

        sc.close();
        System.out.println("Gracias por usar el sistema de biblioteca.");
    }
}
