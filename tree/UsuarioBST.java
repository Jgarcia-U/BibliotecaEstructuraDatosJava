package tree;

import model.Usuario;

public class UsuarioBST {

    private NodoUsuario raiz;

    public UsuarioBST() {
        this.raiz = null;
    }

    public void insertar(Usuario usuario) {
        raiz = insertarRecursivo(raiz, usuario);
    }

    private NodoUsuario insertarRecursivo(NodoUsuario actual, Usuario usuario) {

        if (actual == null) {
            return new NodoUsuario(usuario);
        }

        if (usuario.getId() < actual.usuario.getId()) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, usuario);
        } else if (usuario.getId() > actual.usuario.getId()) {
            actual.derecho = insertarRecursivo(actual.derecho, usuario);
        }

        return actual;
    }

    public Usuario buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Usuario buscarRecursivo(NodoUsuario actual, int id) {
        if (actual == null) {
            return null;
        }

        if (id == actual.usuario.getId()) {
            return actual.usuario;
        }

        if (id < actual.usuario.getId()) {
            return buscarRecursivo(actual.izquierdo, id);
        }

        return buscarRecursivo(actual.derecho, id);
    }

    public void mostrarUsuariosOrdenados() {
        inorden(raiz);
    }

    private void inorden(NodoUsuario nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.println(nodo.usuario);
            inorden(nodo.derecho);
        }
    }
}
