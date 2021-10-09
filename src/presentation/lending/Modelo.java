package presentation.lending;

import logic.Cliente;
import logic.Pago;
import logic.Prestamo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Modelo extends Observable {
    private TableModel table;
    private Cliente cliente;
    private Pago pago;
    private List<Prestamo> lista;
    private boolean editable;
    private Prestamo nuevoPrestamo;
    private TableModel tablePrestamo;

    public Modelo() {
        lista=new ArrayList<>();
        table=new TableModel(lista);
        cliente=new Cliente();
        cliente.getListaPrestamos().add(new Prestamo(00,0,0));
        pago=new Pago();
        editable=false;
        nuevoPrestamo=new Prestamo();
        tablePrestamo=new TableModel(cliente.getListaPrestamos());
    }

    public TableModel getTable() {
        return table;
    }

    public void setTable(TableModel table) {
        this.table = new TableModel(cliente.getListaPrestamos());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public List<Prestamo> getLista() {
        return lista;
    }

    public void setLista(List<Prestamo> lista) {
        this.lista = lista;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Prestamo getNuevoPrestamo() {
        return nuevoPrestamo;
    }

    public void setNuevoPrestamo(Prestamo nuevoPrestamo) {
        this.nuevoPrestamo = nuevoPrestamo;
    }


    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        refresh();
    }

    private void refresh() {
        cliente=new Cliente();
        pago=new Pago();
        nuevoPrestamo=new Prestamo();
        this.setChanged();
        this.notifyObservers();
    }
}
