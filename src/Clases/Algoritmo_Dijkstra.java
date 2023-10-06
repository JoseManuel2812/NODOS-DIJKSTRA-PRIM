

package Clases;


import static Ventanas.VentanaPrincipal.jPanel1;
import static Ventanas.VentanaPrincipal.R_repaint;
import static Ventanas.VentanaPrincipal.ingresarNodoOrigen;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel,Jhostin Jheyson
 */
public class Algoritmo_Dijkstra {
   private  Arboles arboles;//Almacena referencias de los nodos
   private int subTope; //Para hacer el seguiente de las iteracion de un bucle
   private Nodo auxi=null;//Almacena la referencia de un nodo
   private int auxAumulado; // es un acumulado auxiliar
   private int subAcomulado;//Almacena temporalmente el camino mas corto
   private Nodo nodo[]; //Almacena informacion de cada nodo
   private int tope;//Almacena la cantidad de nodos en los grafos
   private int permanente; //Almacena el indice del nodo    
   private int nodoFin; //Almacena el indice del nodo final
   
   
    public Algoritmo_Dijkstra (Arboles arboles, int tope,int permanente, int nodoFin){
        this.arboles = arboles;        
        this.tope = tope;
        this.nodo= new Nodo[tope]; 
        this.permanente = permanente;
        this.nodoFin = nodoFin;
        
    }

    public int getAcumulado(){
        return nodo[nodoFin].getAcumulado(); //Retorna eel costo recorrido del camino mas corto
    }
        
    public void dijkstra() {
    for (int i = 0; i < tope; i++)
        nodo[i] = new Nodo();

    if (permanente != nodoFin) {
        Graphics g = jPanel1.getGraphics();
        jPanel1.paint(g);
        R_repaint(g, tope, arboles);
        Pintar.clickSobreNodo(g, arboles.getCordeX(permanente), arboles.getCordeY(permanente), null, Color.GREEN);
        
        nodo[permanente].setVisitado(true);
        nodo[permanente].setNombre(permanente);

        do {
            subAcomulado = 0;
            auxAumulado = 2000000000;
            nodo[permanente].setEtiqueta(true);

            for (int j = 0; j < tope; j++) {
                if (arboles.getmAdyacencia(j, permanente) == 1) {
                    subAcomulado = nodo[permanente].getAcumulado() + arboles.getmCoeficiente(j, permanente);

                    if (subAcomulado <= nodo[j].getAcumulado() && nodo[j].isVisitado() == true && nodo[j].isEtiqueta() == false) {
                        nodo[j].setAcumulado(subAcomulado);
                        nodo[j].setVisitado(true);
                        nodo[j].setNombre(j);
                        nodo[j].setPredecesor(nodo[permanente]);
                    } else if (nodo[j].isVisitado() == false) {
                        nodo[j].setAcumulado(subAcomulado);
                        nodo[j].setVisitado(true);
                        nodo[j].setNombre(j);
                        nodo[j].setPredecesor(nodo[permanente]);
                    }
                }
            }

            for (int i = 0; i < tope; i++) {
                if (nodo[i].isVisitado() == true && nodo[i].isEtiqueta() == false) {
                    if (nodo[i].getAcumulado() <= auxAumulado) {
                        permanente = nodo[i].getNombre();
                        auxAumulado = nodo[i].getAcumulado();
                    }
                }
            }

            subTope++;
        } while (subTope < tope + 1);

        auxi = nodo[nodoFin];

        if (auxi.getPredecesor() == null) {
            JOptionPane.showMessageDialog(null, "No se Pudo LLegar Al Nodo " + nodoFin);
        }
        
        while (auxi.getPredecesor() != null) {
            Pintar.pintarCamino(g, arboles.getCordeX(auxi.getNombre()), arboles.getCordeY(auxi.getNombre()),
                    arboles.getCordeX(auxi.getPredecesor().getNombre()), arboles.getCordeY(auxi.getPredecesor().getNombre()), Color.GREEN);
            Pintar.clickSobreNodo(g, arboles.getCordeX(auxi.getNombre()), arboles.getCordeY(auxi.getNombre()), null, Color.GREEN);
            auxi = auxi.getPredecesor();
        }

        Pintar.clickSobreNodo(g, arboles.getCordeX(nodoFin), arboles.getCordeY(nodoFin), null, Color.GREEN);
    } else {
        Graphics g = jPanel1.getGraphics();
        Pintar.clickSobreNodo(g, arboles.getCordeX(nodoFin), arboles.getCordeY(nodoFin), null, Color.GREEN);
    }
}
    
}
