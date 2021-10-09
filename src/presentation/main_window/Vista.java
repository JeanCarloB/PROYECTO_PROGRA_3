package presentation.main_window;

import java.util.Observable;
import java.util.Observer;

public class Vista implements Observer {
    Controlador controlador;
    Modelo modelo;

    public void setController(Controlador controlador){
        this.controlador=controlador;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setModel(Modelo modelo){
        this.modelo=modelo;
        modelo.addObserver(this);
    }

    public Modelo getModel() {
        return modelo;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
