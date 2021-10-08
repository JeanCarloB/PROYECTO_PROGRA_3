package presentation.client;

import logic.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Modelo extends Observable {
    Cliente cliente;
    List<Cliente> listaClientes;
    boolean editar;
    public Modelo() {
        cliente=new Cliente();
        listaClientes=new ArrayList<>();
        editar=false;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        commit();
    }
    public void commit(){
        this.setChanged();
        this.notifyObservers();
    }
    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
