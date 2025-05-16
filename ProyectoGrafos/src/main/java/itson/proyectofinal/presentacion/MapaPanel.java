
package itson.proyectofinal.presentacion;

import itson.proyectofinal.Arista;
import itson.proyectofinal.Grafo;
import itson.proyectofinal.Nodo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;
import java.util.ArrayList;
import java.util.List;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

public class MapaPanel extends JMapViewer {

    private final Grafo grafo;
    private final List<MapPolygon> lineas;

    public MapaPanel(Grafo grafo) {
        this.grafo = grafo;
        this.lineas = new ArrayList<>();
        setDisplayPosition(new Coordinate(21.019, -101.257), 9); 
        setTileSource(new OsmTileSource.Mapnik());
        setZoomContolsVisible(true);
        dibujarGrafo();
        
        
    }

    private void dibujarGrafo() {
        getMapMarkerList().clear();
        lineas.forEach(this::removeMapPolygon);
        lineas.clear();

        for (Nodo nodo : grafo.getNodos()) {
            Coordinate coord = new Coordinate(nodo.getLatitud(), nodo.getLongitud());
            MapMarkerDot marker = new MapMarkerDot(nodo.getNombre(), coord);
            marker.setBackColor(Color.RED);
            marker.setColor(Color.WHITE);
            marker.setName(nodo.getNombre());
            addMapMarker(marker);
        }

        for (Nodo nodo : grafo.getNodos()) {
            Coordinate coordOrigen = new Coordinate(nodo.getLatitud(), nodo.getLongitud());

            for (Arista arista : grafo.getVecinos(nodo)) {
                Nodo destino = arista.getDestino();
                Coordinate coordDestino = new Coordinate(destino.getLatitud(), destino.getLongitud());

                List<Coordinate> puntos = new ArrayList<>();
                puntos.add(coordOrigen);
                puntos.add(coordDestino);
                puntos.add(coordDestino); 

                MapPolygon linea = new CustomPolyline(puntos, Color.BLUE);
                addMapPolygon(linea);
                lineas.add(linea);
            }
        }
        repaint();
    }

    private static class CustomPolyline extends MapPolygonImpl {
        private final Color color;
        private final Stroke stroke;

        public CustomPolyline(List<Coordinate> points, Color color) {
            super(points);
            this.color = color;
            this.stroke = new BasicStroke(4);
        }

        @Override
        public void paint(Graphics g, List<Point> points) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(color);
            g2.setStroke(stroke);

            if (points.size() >= 2) {
                Point prev = points.get(0);
                for (int i = 1; i < points.size(); i++) {
                    Point curr = points.get(i);
                    g2.drawLine(prev.x, prev.y, curr.x, curr.y);
                    prev = curr;
                }
            }
            g2.dispose();
        }
    }
}