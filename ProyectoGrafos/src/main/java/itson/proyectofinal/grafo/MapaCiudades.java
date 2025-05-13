
package itson.proyectofinal.grafo;

import itson.proyectofinal.Grafo;
import itson.proyectofinal.Nodo;
import java.util.HashMap;
import java.util.Map;
import org.openstreetmap.gui.jmapviewer.Coordinate;

public class MapaCiudades {
    
    public static Grafo construirGrafo() {
        Grafo grafo = new Grafo();
        Map<String, Nodo> nodos = new HashMap<>();
        
        // TODO: arreglar las cords
        Map<String, Coordinate> coordenadas = Map.ofEntries(
            Map.entry("Leon de los Aldana", new Coordinate(21.15327, -101.60057)),
            Map.entry("Irapuato", new Coordinate(20.6767, -101.3564)),
            Map.entry("Celaya", new Coordinate(20.5235, -100.8157)),
            Map.entry("Salamanca", new Coordinate(20.53627, -101.20445)),
            Map.entry("Silao", new Coordinate(20.97045, -101.37358)),
            Map.entry("San Francisco del Rincon", new Coordinate(20.9977, -101.81554)),
            Map.entry("Valle de Santiago", new Coordinate(20.46838, -101.14442)),
            Map.entry("San Miguel de Allende", new Coordinate(20.86089, -100.85307)),
            Map.entry("Guanajuato", new Coordinate(21.07784, -101.25289)),
            Map.entry("Cortazar", new Coordinate(20.41526, -100.8368)),
            Map.entry("Dolores Hidalgo", new Coordinate(21.17, -100.93)),
            Map.entry("Acambaro", new Coordinate(20.13805, -100.69914)),
            Map.entry("Purisima de Bustos", new Coordinate(21.04442, -101.79677)),
            Map.entry("Uriangato", new Coordinate(20.10214, -101.15135)),
            Map.entry("San Luis de la Paz", new Coordinate(21.3164, -100.42917)),
            Map.entry("Juventino Rosas", new Coordinate(20.63646, -100.99004)),
            Map.entry("Penjamo", new Coordinate(20.42505, -101.72038)),
            Map.entry("Moroleon", new Coordinate(20.13471, -101.18505)),
            Map.entry("Salvatierra", new Coordinate(20.21494, -100.83878)),
            Map.entry("Marfil", new Coordinate(21.0000, -101.2500)),
            Map.entry("San Felipe", new Coordinate(21.43333, -101.56667)),
            Map.entry("Apaseo el Grande", new Coordinate(20.5835, -100.49469)),
            Map.entry("Abasolo", new Coordinate(20.45, -101.55)),
            Map.entry("Apaseo el Alto", new Coordinate(20.46264, -100.54586)),
            Map.entry("Villagran", new Coordinate(20.55423, -101.03719)),
            Map.entry("San Jose Iturbide", new Coordinate(21.0187, -100.42026)),
            Map.entry("Yuriria", new Coordinate(20.15787, -101.06788)),
            Map.entry("Romita", new Coordinate(20.8751, -101.51807)),
            Map.entry("Comonfort", new Coordinate(20.72128, -100.76207)),
            Map.entry("Jaral del Progreso", new Coordinate(20.3716, -101.06068))
        );

        for (Map.Entry<String, Coordinate> entry : coordenadas.entrySet()) {
            Nodo nodo = new Nodo(entry.getKey(), entry.getValue());
            grafo.agregarNodo(nodo);
            nodos.put(entry.getKey(), nodo);
        }

        agregarConexiones(grafo, nodos);

        return grafo;
    }
    
    // TODO: verificar las distancias
    private static void agregarConexiones(Grafo grafo, Map<String, Nodo> nodos) {
        grafo.agregarArista(nodos.get("Acambaro"), nodos.get("Celaya"), 90); // MEX-051
        grafo.agregarArista(nodos.get("Dolores Hidalgo"), nodos.get("San Miguel de Allende"), 35); // MEX-051-GTO
        grafo.agregarArista(nodos.get("San Miguel de Allende"), nodos.get("San Luis de la Paz"), 80); // MEX-057
        grafo.agregarArista(nodos.get("San Felipe"), nodos.get("San Luis de la Paz"), 60); // MEX-037
        grafo.agregarArista(nodos.get("Cortazar"), nodos.get("Valle de Santiago"), 55); // MEX-GTO-017
        grafo.agregarArista(nodos.get("Silao"), nodos.get("Irapuato"), 35); // MEX-045
        grafo.agregarArista(nodos.get("Irapuato"), nodos.get("Salamanca"), 20); // MEX-045
        grafo.agregarArista(nodos.get("Salamanca"), nodos.get("Leon de los Aldana"), 60); // MEX-045D (cuota)
        grafo.agregarArista(nodos.get("Leon de los Aldana"), nodos.get("Silao"), 25); // MEX-045
        grafo.agregarArista(nodos.get("Uriangato"), nodos.get("Yuriria"), 12); // GTO
        grafo.agregarArista(nodos.get("Salvatierra"), nodos.get("Cortazar"), 30); // GTO
        grafo.agregarArista(nodos.get("Romita"), nodos.get("Silao"), 20); // GTO
        grafo.agregarArista(nodos.get("Salamanca"), nodos.get("Juventino Rosas"), 25); // GTO
        grafo.agregarArista(nodos.get("Guanajuato"), nodos.get("Silao"), 22); // GTO-110D
        grafo.agregarArista(nodos.get("San Luis de la Paz"), nodos.get("Guanajuato"), 100); // MEX-110
        grafo.agregarArista(nodos.get("San Luis de la Paz"), nodos.get("San Jose Iturbide"), 35); // GTO
    }
}
