/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.proyectofinal.presentacion;

import java.util.Map;
import javax.swing.JComboBox;
import org.openstreetmap.gui.jmapviewer.Coordinate;

/**
 *
 * @author Dana Chavez
 */
public class CiudadesUtil {
    
    public static final Map<String, Coordinate> COORDENADAS = Map.ofEntries(
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

    public static void llenarComboCiudades(JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("-- Selecciona una ciudad --");
        for (String ciudad : COORDENADAS.keySet()) {
            combo.addItem(ciudad);
        }
    }
    
}
