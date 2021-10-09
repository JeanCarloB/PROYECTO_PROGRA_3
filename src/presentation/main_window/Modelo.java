package presentation.main_window;

import logic.Cliente;
import logic.Provincia;

import java.util.Observable;
import java.util.Observer;

public class Modelo extends Observable {

    Cliente cliente;
    Provincia provincia;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        this.commit();
    }

    public void commit(){
        this.setChanged();
        this.notifyObservers();
    }
}
