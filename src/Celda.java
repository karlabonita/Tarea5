import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Celda extends JComponent implements Constantes{
    public int x;
    public int y;
    public char tipo;
    
    //constructor 
    public Celda(int x, int y, char tipo){
        this.x=x;
        this.y=y;
        this.tipo=tipo;
    
    }
    
    public void esPared(){
        tipo='O';
    
    }
    
    public void esFinal(){
        tipo='F';
    
    }
    
    //metodo para dibujar casilla
    @Override
    public void paintComponent(Graphics g){
        switch(tipo){
            case 'J':
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(Jugador.energia), x + 10, y - 10);
                g.setColor(COLOR_JUGADOR);break;
            case 'O':g.setColor(COLOR_OBSTACULO);break;
            case 'V':g.setColor(COLOR_CAMINO);break;
            case 'A':g.setColor(COLOR_ADVERSARIO);break;
            case 'F':g.setColor(COLOR_FINAL);break;
            case 'R':g.setColor(Color.PINK);break;
       
        }
        g.fillRect(x, y, PIXEL_CELDA, PIXEL_CELDA);
    
    }

    void esRecompensa() {
        tipo='R';
    }
}
