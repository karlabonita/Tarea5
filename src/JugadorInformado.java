
public class JugadorInformado implements Constantes  {
    public int posicionX;
    public int posicionY;
    public Escenario escenario;
    public BusquedaAnchuraInformada inteligencia1;

    public JugadorInformado( Escenario escenario) {
        posicionX = 0;
        posicionY = 0;
        this.escenario = escenario;
        inteligencia1 = new BusquedaAnchuraInformada(escenario);
    }
    
    
 public boolean puedeMoverse(int posicionX, int posicionY){
       if(posicionX<NUMERO_CELDAS_ANCHO && posicionX>-1 && posicionY<NUMERO_CELDAS_LARGO && posicionY>-1 && escenario.celdas[posicionX][posicionY].tipo!='O'){
           return true;
           
       }    
       return false;
   }
    
    public void moverArriba(){
        if(posicionY>-1 && puedeMoverse (posicionX, posicionY-1 )){   
            escenario.celdas[posicionX][posicionY].tipo='V';
            escenario.celdas[posicionX][--posicionY].tipo='I';
        }
    }
    
    public void moverAbajo(){
        if(posicionY<NUMERO_CELDAS_LARGO && puedeMoverse(posicionX,posicionY +1)){  
            escenario.celdas[posicionX][posicionY].tipo='V';
            escenario.celdas[posicionX][++posicionY].tipo='I';
    
        }
    }
    
    public void moverIzquierda(){
        if(posicionX>0 && puedeMoverse(posicionX -1,posicionY)){
            escenario.celdas[posicionX][posicionY].tipo='V';
            escenario.celdas[--posicionX][posicionY].tipo='I';
            
        }
    }
    
    public void moverDerecha(){
        if(posicionX< NUMERO_CELDAS_ANCHO && puedeMoverse(posicionX +1,posicionY)){           
            escenario.celdas[posicionX][posicionY].tipo='V';
            escenario.celdas[++posicionX][posicionY].tipo='I';
   
        }
    }   
    
    
}
