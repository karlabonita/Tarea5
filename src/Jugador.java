
import java.util.TimerTask;


public class Jugador extends TimerTask implements Constantes {
    public int posicionX;
    public int posicionY;
    
    public static int energia;
    public Escenario escenario;
    public BusquedaAnchura inteligencia;
    
    public Jugador(Escenario escenario){
        energia=10;
        posicionX=0;
        posicionY=0;
        this.escenario=escenario;
        inteligencia = new BusquedaAnchura(escenario);
    
    }
    
     public boolean puedeMoverse(int posicionX, int posicionY){
       if(posicionX<NUMERO_CELDAS_ANCHO && posicionX>-1 && posicionY<NUMERO_CELDAS_LARGO && posicionY>-1 && escenario.celdas[posicionX][posicionY].tipo!='O'){
           return true;
           
       }    
       return false;
   }
    
    public void moverArriba(){
        if(posicionY>-1 && puedeMoverse (posicionX, posicionY-1 )){   
            if(escenario.esRecompensa(posicionX,posicionY-1)){
                 energia+=10;
             }
            escenario.celdas[posicionX][posicionY].tipo='V';
            escenario.celdas[posicionX][--posicionY].tipo='J';
        }
    }
    
    public void moverAbajo(){
        if(posicionY<NUMERO_CELDAS_LARGO && puedeMoverse(posicionX,posicionY +1)){  
            if(escenario.esRecompensa(posicionX,posicionY+1)){
                 energia+=10;
             }
            escenario.celdas[posicionX][posicionY].tipo='V';
            escenario.celdas[posicionX][++posicionY].tipo='J';
    
        }
    }
    
    public void moverIzquierda(){
        if(posicionX>0 && puedeMoverse(posicionX -1,posicionY)){
            if(escenario.esRecompensa(posicionX-1,posicionY)){
                 energia+=10;
             }
            escenario.celdas[posicionX][posicionY].tipo='V';
            escenario.celdas[--posicionX][posicionY].tipo='J';
            
        }
    }
    
    public void moverDerecha(){
        if(posicionX< NUMERO_CELDAS_ANCHO && puedeMoverse(posicionX +1,posicionY)){
            if(escenario.esRecompensa(posicionX+1,posicionY)){
                 energia+=10;
             }
            escenario.celdas[posicionX][posicionY].tipo='V';
            escenario.celdas[++posicionX][posicionY].tipo='J';
   
        }
    }
    
    
    public void run(){
        if(energia>0)
            energia=energia-5;
        
    }
    
}
