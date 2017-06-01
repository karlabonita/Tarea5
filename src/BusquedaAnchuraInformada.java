
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TimerTask;


public class BusquedaAnchuraInformada extends TimerTask implements Constantes {
    public Escenario escenario;
    public Queue<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    
    public int index_pasos;
    public Estado inicial;
    public Estado objetivo;
    public Estado temp;
    public boolean exito;
    
    public  BusquedaAnchuraInformada(Escenario escenario){
        this.escenario=escenario;
        colaEstados = new PriorityQueue<>();
        historial=new ArrayList<>();
        pasos= new ArrayList<>();
        index_pasos =0;
        exito=false;
    
    }
    
    public void buscar(int x1, int y1, int x2, int y2){
        inicial = new Estado(x1,y1,'N',null);
        objetivo=new Estado(x2,y2,'P',null);
        //calidad
        inicial.distancia(objetivo);
        
        colaEstados.add(inicial);
        historial.add(inicial);
        
        if(inicial.equals(objetivo)) exito =true;
        
        while(!colaEstados.isEmpty() && !exito){
            temp=colaEstados.poll();
            System.out.println(temp.toString());
            colaEstados.remove(0);
            moverArriba(temp);
            moverAbajo(temp);
            moverIzquierda(temp);
            moverDerecha(temp);
           
        }
        
        if(exito) System.out.println("La ruta ha sido calculada");
        else System.out.println("La ruta no ha sido calculada");
    }
    
     private void moverDerecha(Estado e){
        
        if(e.x< NUMERO_CELDAS_ANCHO -1){
            if(escenario.celdas[e.x+1][e.y].tipo != 'O'){
            Estado derecha = new Estado(e.x+1, e.y,'R',e);
            derecha.distancia(objetivo);
            if(!historial.contains(derecha)){
                colaEstados.add(derecha);
                historial.add(derecha);
                
                if(derecha.equals(objetivo)){
                    objetivo=derecha;
                    exito=true;
                
                }
            }
        }    
      }
    }
    
    private void moverIzquierda(Estado e){
        if(e.x > 0){
            if(escenario.celdas[e.x-1][e.y].tipo!='O'){
            Estado izquierda = new Estado(e.x-1,e.y,'L',e);
            izquierda.distancia(objetivo);
            if(!historial.contains(izquierda)){
                colaEstados.add(izquierda);
                historial.add(izquierda);
            if(izquierda.equals(objetivo)){
                objetivo = izquierda;
                exito=true;
            
              }
            
             }
           }
        }
    }
    
    private void moverAbajo(Estado e){
        if(e.y+1 < NUMERO_CELDAS_LARGO){
            if(escenario.celdas[e.x][e.y+1].tipo!='O'){
            Estado abajo = new Estado(e.x,e.y+1,'D',e);
            abajo.distancia(objetivo);
            if(!historial.contains(abajo)){
                colaEstados.add(abajo);
                historial.add(abajo);
             if(abajo.equals(objetivo)){
                 objetivo=abajo;
                 exito=true;
             
               }
             }
            
            }
        }
    }
    
    private void moverArriba(Estado e){
        if(e.y>0){
            if(escenario.celdas[e.x][e.y-1].tipo!='O'){
            Estado arriba = new Estado(e.x,e.y-1,'U',e);
            arriba.distancia(objetivo);
            if(!historial.contains(arriba)){
                colaEstados.add(arriba);
                historial.add(arriba);
            if(arriba.equals(objetivo)){
                objetivo=arriba;
                exito=true;
 
             }
            }           
           }
        }   
    }

    @Override
    public void run() {
        
    }
    

}
