/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import static Ventanas.VentanaPrincipal.R_repaint;
import static Ventanas.VentanaPrincipal.ingresarNodoOrigen;
import static Ventanas.VentanaPrincipal.jPanel1;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Manuel,Jhostin y Jheyson los mas duros y bellacones de la FIIS
 */
public class Algoritmo_Prim {
    
   private int cumulado; //Muestra la distancia
   private int aristaMenor; //Para verificar la arista menor
   private int  fin; // Para el final del nodo
   private boolean estaNodo=false; //Verifica si un nodo esta en el arbol
   private boolean aumentaTamano;
   private int nodoApuntado; //Ayudan a identificar los nodos que estan siendo examinados  
   private int nodoApuntador;//Ayudan a identificar los nodos que estan siendo examinados  
   private int tamano;
   private int arsitaMayor;//Sirve para establecer el arista mayor
   private  Arboles arboles;//
   private int tope; //Establece el limite de los nodos
   private  int  nodoOrigen; 
   
   
   
   public Algoritmo_Prim(Arboles arbol , int top ,int aristaMayor ){
       this.cumulado = 0;
       this.aristaMenor = 0;
       this.fin = 0;
       this.estaNodo=false;
       this.aumentaTamano = false;
       this.nodoApuntado = 0;  
       this.nodoApuntador = 0;
       this.tamano = 1;
       this. arsitaMayor=aristaMayor;
       this.arboles = arbol;
       this.tope = top;
   }

    public int getCumulado() {
        return cumulado;
    }
  
   
  public void prim(){
      this.nodoOrigen = ingresarNodoOrigen("Ingrese Nodo Origen..", "nodo Origen No existe", tope);

    Graphics g = jPanel1.getGraphics();
    
    

    R_repaint(g, tope, arboles); // Para Dibujar

    arboles.crearEnArbol(tope);
    arboles.setEnArbol(0, nodoOrigen);

    // Algoritmo de Prim ---->>
    do {
        this.aristaMenor = this.arsitaMayor;
        this.fin = 2;

        for (int j = 0; j < tamano; j++) {
            for (int k = 0; k < tope; k++) {
                if (arboles.getmAdyacencia(k, arboles.getEnArbol(j)) == 1) {
                    for (int h = 0; h < tamano; h++) {
                        if (arboles.getEnArbol(h) == k) {
                            this.estaNodo = true;
                            break;
                        }
                    }
                    if (estaNodo == false) {
                        if (arboles.getmCoeficiente(k, arboles.getEnArbol(j)) <= aristaMenor
                                && arboles.getmCoeficiente(k, arboles.getEnArbol(j)) > 0) {
                            aristaMenor = arboles.getmCoeficiente(k, arboles.getEnArbol(j));
                            this.nodoApuntado = k;
                            this.aumentaTamano = true;
                            this.nodoApuntador = arboles.getEnArbol(j);
                            this.fin = 1;
                        }
                    }
                    this.estaNodo = false;
                }
            }
        }

        if (aumentaTamano == true) {
            Pintar.pintarCamino(g, arboles.getCordeX(nodoApuntador), arboles.getCordeY(nodoApuntador),
                    arboles.getCordeX(nodoApuntado), arboles.getCordeY(nodoApuntado), Color.red);
            Pintar.clickSobreNodo(g, arboles.getCordeX(nodoApuntador), arboles.getCordeY(nodoApuntador), null,
                    Color.red);
            Pintar.clickSobreNodo(g, arboles.getCordeX(nodoApuntado), arboles.getCordeY(nodoApuntado), null,
                    Color.red);
            arboles.setEnArbol(tamano, nodoApuntado);
            this.tamano++;
            this.aumentaTamano = false;
            this.cumulado += this.aristaMenor;
        }
    } while (fin < 2);
    
}
}
