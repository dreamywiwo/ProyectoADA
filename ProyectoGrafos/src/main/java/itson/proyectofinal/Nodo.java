package itson.proyectofinal;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Nodo {
    private final String nombre;
    private final Coordinate coordenada;

    public Nodo(String nombre, Coordinate coordenada
    ) {
        this.nombre = nombre;
        this.coordenada = coordenada;
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public double getLatitud() {
        return coordenada.getLat();
    }

    public double getLongitud() {
        return coordenada.getLon();
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Nodo nodo = (Nodo) obj;
        return nombre.equals(nodo.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}

