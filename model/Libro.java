package model;

// Clase Libro
public class Libro {
    private static int contador = 1;
    private int id;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String titulo, String autor) {
        this.id = contador++;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public boolean isDisponible() {
        return disponible;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + titulo + " - " + autor + 
               (disponible ? " (Disponible)" : " (Prestado)");
    }

}
