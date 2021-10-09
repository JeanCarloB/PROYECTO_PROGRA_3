package logic;

import jakarta.xml.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name="cantones")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Canton {
    private String numero;
    private String nombre;
    List<Distrito> listaDistritos;

    public Canton(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
        listaDistritos=new ArrayList<>();
    }

    public Canton() {
        this.nombre = "";
        this.nombre = "";
        listaDistritos=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Canton{" +
                "numero='" + numero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaDistritos=" + listaDistritos.toString() +"\n"+
                "\n"+'}';
    }

    public String getNumero() {
        return numero;
    }
    public void addDistrito(Distrito distrito){
        listaDistritos.add(distrito);
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    @XmlElement(name="distritos")
    public List<Distrito> getListaDistritos() {
        return listaDistritos;
    }

    public void setListaDistritos(List<Distrito> listaDistritos) {
        this.listaDistritos = listaDistritos;
    }
    public ArrayList<String> nombresDistritos(){
        ArrayList<String> listadistritos=new ArrayList<>();
        for(int i=0;i< listaDistritos.size();i++){
            listadistritos.add(listaDistritos.get(i).getNombre());
        }
        return listadistritos;
    }

}
