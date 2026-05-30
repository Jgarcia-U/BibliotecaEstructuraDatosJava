package graph;
import java.util.*;

public class GrafoBiblioteca {

    private Map<Integer, List<Integer>> grafo = new HashMap<>();

    public void agregarRelacion(int idUsuario, int idLibro) {
        grafo.putIfAbsent(idUsuario, new ArrayList<>());
        grafo.get(idUsuario).add(idLibro);
    }

    public List<Integer> obtenerLibrosDeUsuario(int idUsuario) {
        return grafo.getOrDefault(idUsuario, new ArrayList<>());
    }

    public void eliminarRelacion(int idUsuario, int idLibro) {
        if (grafo.containsKey(idUsuario)) {
            grafo.get(idUsuario).remove(Integer.valueOf(idLibro));
        }
    }

    public void mostrarGrafo() {
        System.out.println("\nRelaciones Usuario -> Libros:");
        for (Map.Entry<Integer, List<Integer>> entry : grafo.entrySet()) {
            System.out.println("Usuario " + entry.getKey() + " -> Libros " + entry.getValue());
        }
    }
}