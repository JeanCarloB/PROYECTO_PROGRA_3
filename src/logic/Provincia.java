package logic;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name="provincias")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Provincia {
    private String numero;
    private String nombre;
    List<Canton> listaCantones;

    public Provincia(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
        listaCantones=new ArrayList<>();
    }

    public Provincia() {
        this.numero="";
        this.nombre="";
        listaCantones=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
@XmlElement(name="cantones")
    public List<Canton> getListaCantones() {
        return listaCantones;
    }

    public void setListaCantones(List<Canton> listaCantones) {
        this.listaCantones = listaCantones;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", listaCantones=" + listaCantones.toString() +
                "\n\n\n"+'}';
    }

    public void addCanton(Canton canton) {
        listaCantones.add(canton);
    }

}