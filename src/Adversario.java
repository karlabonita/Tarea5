
import java.util.TimerTask;

public class Adversario extends TimerTask implements Constantes {

    public int posicionX;
    public int posicionY;
    public Escenario escenario;
    public BusquedaPorAnchuraAdversario inteligencia;

    public Adversario(Escenario escenario) {

        posicionX = 0;
        posicionY = 0;
        this.escenario = escenario;
        inteligencia = new BusquedaPorAnchuraAdversario(escenario, this);

    }

    public boolean puedeMoverse(int posicionX, int posicionY) {
        if (posicionX < NUMERO_CELDAS_ANCHO && posicionX > -1 && posicionY < NUMERO_CELDAS_LARGO && posicionY > -1 && escenario.celdas[posicionX][posicionY].tipo != 'O') {
            return true;

        }
        return false;
    }

    public void moverArriba() {
        if (posicionY > -1 && puedeMoverse(posicionX, posicionY - 1)) {
            if (escenario.esRecompensa(posicionX, posicionY - 1)) {

            }
            escenario.celdas[posicionX][posicionY].tipo = 'V';
            escenario.celdas[posicionX][--posicionY].tipo = 'A';
        }
    }

    public void moverAbajo() {
        if (posicionY < NUMERO_CELDAS_LARGO && puedeMoverse(posicionX, posicionY + 1)) {
            if (escenario.esRecompensa(posicionX, posicionY + 1)) {
            }
            escenario.celdas[posicionX][posicionY].tipo = 'V';
            escenario.celdas[posicionX][++posicionY].tipo = 'A';

        }
    }

    public void moverIzquierda() {
        if (posicionX > 0 && puedeMoverse(posicionX - 1, posicionY)) {
            if (escenario.esRecompensa(posicionX - 1, posicionY)) {

            }
            escenario.celdas[posicionX][posicionY].tipo = 'V';
            escenario.celdas[--posicionX][posicionY].tipo = 'A';

        }
    }

    public void moverDerecha() {
        if (posicionX < NUMERO_CELDAS_ANCHO && puedeMoverse(posicionX + 1, posicionY)) {
            if (escenario.esRecompensa(posicionX + 1, posicionY)) {

            }
            escenario.celdas[posicionX][posicionY].tipo = 'V';
            escenario.celdas[++posicionX][posicionY].tipo = 'A';

        }
    }

    public void run() {

    }

}
