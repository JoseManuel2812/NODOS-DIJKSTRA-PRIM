

package Clases;

public class Arboles {
   private int mCoeficiente[][] = new int [5000][5000];// Almacena los pesos de las aristas
   private int mAdyacencia [][] = new int [5000][5000]; // Verifica si la matris de adyacencia es uno entonces i j esta conectado de los contrario no esta conectado
   private int cordeX [] = new int [5000]; //Almacena las coordenadas
   private int cordeY [] = new int [5000];
   private int nombre [] = new int [5000];//Vector que almacena  el nombre o etiqueta de loos nodos
   private int enArbol []; //Vector que almacena nodos de un arbol
   
   
   
   public Arboles(){
        
    }

    public int getmCoeficiente(int i, int j ) {
        return mCoeficiente[i][j];
    }

    public int getmAdyacencia(int i,int j) {
        return mAdyacencia[i][j];
    }

    public int getCordeX(int i) {
        return cordeX[i];
    }

    public int getCordeY(int i) {
        return cordeY[i];
    }

    public int getNombre(int i) {
        return nombre[i];
    }

    public int getEnArbol(int i) {
        return enArbol[i];
    }
    
    public void setmCoeficiente(int i,int j ,int mCoeficiente) {
        this.mCoeficiente[i][j] = mCoeficiente;
    }

    public void setmAdyacencia(int i,int j ,int mAdyacencia) {
        this.mAdyacencia[i][j] = mAdyacencia;
    }

    public void setCordeX(int i,int cordeX) {
        this.cordeX[i] = cordeX;
    }

    public void setCordeY(int i, int cordeY) {
        this.cordeY[i] = cordeY;
    }

    public void setNombre(int i,int nombre) {
        this.nombre[i] = nombre;
    }

    public void setEnArbol(int i,int enArbol) {
        this.enArbol[i] = enArbol;
    }
    public void crearEnArbol(int i){
       enArbol = new int [i]; 
    }  
    
}
