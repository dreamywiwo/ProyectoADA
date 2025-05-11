package itson.proyectofinal.grafo;

import itson.proyectofinal.Grafo;
import itson.proyectofinal.Nodo;
import java.util.HashMap;
import java.util.Map;

public class MapaCiudades {

    public static Grafo construirGrafo() {
        Grafo grafo = new Grafo();
        Map<String, Nodo> nodos = new HashMap<>();

        // TODO: arreglar las cords
        Map<String, double[]> coordenadas = Map.ofEntries(
                //1
                Map.entry("Leon de los Aldana", new double[]{21.15327, -101.60057}),
                //2
                Map.entry("Irapuato", new double[]{20.6767, -101.3564}),
                //3
                Map.entry("Celaya", new double[]{20.5235, -100.8157}),
                //4
                Map.entry("Salamanca", new double[]{20.53627, -101.20445}),
                //5
                Map.entry("Silao", new double[]{20.97045, -101.37358}),
                //6
                Map.entry("San Francisco del Rincon", new double[]{20.9977, -101.81554}),
                //7
                Map.entry("Valle de Santiago", new double[]{20.46838, -101.14442}),
                //8
                Map.entry("San Miguel de Allende", new double[]{20.86089, -100.85307}),
                //9
                Map.entry("Guanajuato", new double[]{21.07784, -101.25289}),
                //10
                Map.entry("Cortazar", new double[]{20.41526, -100.8368}),
                //11
                Map.entry("Dolores Hidalgo", new double[]{21.17, -100.93}),
                //12
                Map.entry("Acambaro", new double[]{20.13805, -100.69914}),
                //13
                Map.entry("Purisima de Bustos", new double[]{21.04442, -101.79677}),
                //14
                Map.entry("Uriangato", new double[]{20.10214, -101.15135}),
                //15
                Map.entry("San Luis de la Paz", new double[]{21.3164, -100.42917}),
                //16
                Map.entry("Juventino Rosas", new double[]{20.63646, -100.99004}),
                //17
                Map.entry("Penjamo", new double[]{20.42505, -101.72038}),
                //18
                Map.entry("Moroleon", new double[]{20.13471, -101.18505}),
                //19
                Map.entry("Salvatierra", new double[]{20.21494, -100.83878}),
                //20
                Map.entry("Marfil", new double[]{21.0000, -101.2500}),
                //21
                Map.entry("San Felipe", new double[]{21.43333, -101.56667}),
                //22
                Map.entry("Apaseo el Grande", new double[]{20.5835, -100.49469}),
                //23
                Map.entry("Abasolo", new double[]{20.45, -101.55}),
                //24
                Map.entry("Apaseo el Alto", new double[]{20.46264, -100.54586}),
                //25
                Map.entry("Villagran", new double[]{20.55423, -101.03719}),
                //26
                Map.entry("San Jose Iturbide", new double[]{21.0187, -100.42026}),
                //27
                Map.entry("Yuriria", new double[]{20.15787, -101.06788}),
                //28
                Map.entry("Romita", new double[]{20.8751, -101.51807}),
                //29
                Map.entry("Comonfort", new double[]{20.72128, -100.76207}),
                //30
                Map.entry("Jaral del Progreso", new double[]{20.3716, -101.06068})
        );

        for (Map.Entry<String, double[]> entry : coordenadas.entrySet()) {
            Nodo nodo = new Nodo(entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
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
