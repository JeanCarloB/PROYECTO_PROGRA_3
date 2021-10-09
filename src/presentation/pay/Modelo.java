package presentation.pay;

import logic.Pago;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Modelo extends Observable {
    Pago pago;
    List<Pago> listaPagos;
    TableModel tabla;
    boolean editar;

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        refresh();
    }
    private void refresh(){
        pago=new Pago();
        this.setChanged();
        this.notifyObservers();
    }
    public Modelo() {
        pago=new Pago();
        listaPagos=new ArrayList<>();
        tabla=new TableModel(listaPagos);
        editar=false;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public List<Pago> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(List<Pago> listaPagos) {
        this.listaPagos = listaPagos;
    }

    public TableModel getTabla() {
        return tabla;
    }

    public void setTabla(TableModel tabla) {
        this.tabla = new TableModel(listaPagos);
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
}
