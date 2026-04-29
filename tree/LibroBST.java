package tree;

import model.Libro;

public class LibroBST {

    private NodoLibro raiz;

    public LibroBST() {
        this.raiz = null;
    }

    public void insertar(Libro libro) {
        raiz = insertarRecursivo(raiz, libro);
    }

    private NodoLibro insertarRecursivo(NodoLibro actual, Libro libro) {

        if (actual == null) {
            return new NodoLibro(libro);
        }

        if (libro.getId() < actual.libro.getId()) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, libro);
        } else if (libro.getId() > actual.libro.getId()) {
            actual.derecho = insertarRecursivo(actual.derecho, libro);
        }

        return actual;
    }

    public Libro buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Libro buscarRecursivo(NodoLibro actual, int id) {

        if (actual == null) {
            return null;
        }

        if (id == actual.libro.getId()) {
            return actual.libro;
        }

        if (id < actual.libro.getId()) {
            return buscarRecursivo(actual.izquierdo, id);
        }

        return buscarRecursivo(actual.derecho, id);
    }

    public void mostrarLibrosOrdenados() {
        inorden(raiz);
    }

    private void inorden(NodoLibro nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.println(nodo.libro);
            inorden(nodo.derecho);
        }
    }
}