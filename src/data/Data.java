package data;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import logic.Cliente;
import logic.Provincia;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private List<Cliente> clientes;
    private List<Provincia> provincias;

    public Data() {
        clientes = new ArrayList<>();
        provincias = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
    public String mostrarProvincias(){
        String str="";
        for(int i=0;i<provincias.size();i++){
            str+=provincias.toString()+"\n";
        }
        return str;
    }
    public String mostrarClientes(){
        String str="";
        for(int i=0;i<clientes.size();i++){
            str+=clientes.toString()+"\n";
        }
        return str;
    }
}
