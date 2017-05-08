
import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Timer;


public class Lienzo extends Canvas implements Constantes {
    public Escenario escenario;
    public Timer lanzadorTareas;
    
    public Lienzo(){
    
            escenario = new Escenario(this);
            escenario.jugador.inteligencia.buscar(0, 0, 9, 9);
            escenario.jugador.inteligencia.calcularRuta();
            lanzadorTareas=new Timer();
            lanzadorTareas.scheduleAtFixedRate(escenario.jugador.inteligencia, 0, 1000);
    
    }
    
    @Override
    public void paint(Graphics g){
        escenario.paintComponent(g);
    
    }
}