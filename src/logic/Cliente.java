package logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente {
@XmlID
    private String id;
    private String nombre;
    private String provincia;
    private String canton;
    private String distrito;


    public Cliente() {
        this.id = "";
        this.nombre = "";
        this.provincia = "";
        this.canton = "";
        this.distrito = "";
    }

    public Cliente(String id, String nombre, String provincia, String canton, String distrito) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", provincia='" + provincia + '\'' +
                ", canton='" + canton + '\'' +
                ", distrito='" + distrito + '\'' +
                '}';
    }
}
