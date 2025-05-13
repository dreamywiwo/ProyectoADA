
package itson.proyectofinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {
    
    private final Map<Nodo, List<Arista>> adyacencias = new HashMap<>();

    public void agregarNodo(Nodo nodo) {
        adyacencias.putIfAbsent(nodo, new ArrayList<>());
    }

    public void agregarArista(Nodo origen, Nodo destino, double peso) {
        if (!adyacencias.containsKey(origen) || !adyacencias.containsKey(destino)) {
            throw new IllegalArgumentException("Ambos nodos deben existir en el grafo");
        }
        adyacencias.get(origen).add(new Arista(destino, peso));
        adyacencias.get(destino).add(new Arista(origen, peso)); 
    }

    public Map<Nodo, List<Arista>> getAdyacencias() {
        return adyacencias;
    }

    public Set<Nodo> getNodos() {
        return adyacencias.keySet();
    }

    public List<Arista> getVecinos(Nodo nodo) {
        return adyacencias.getOrDefault(nodo, Collections.emptyList());
    }

    public void imprimirGrafo() {
        for (Nodo nodo : adyacencias.keySet()) {
            System.out.println(nodo + " conectado a:");
            for (Arista arista : adyacencias.get(nodo)) {
                System.out.println("   " + arista);
            }
        }
    }
}
