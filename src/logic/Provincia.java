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
    public static List<Distrito> getLista(){
        return getLista();
    }
    public ArrayList<String> nombresCantones(){
        ArrayList<String> listacantones=new ArrayList<>();
        for(int i=0;i< listaCantones.size();i++){
            listacantones.add(listaCantones.get(i).getNombre());
        }
        return listacantones;
    }
    public Canton buscarCanton(int pos){
        Canton prod=null;
        for(int i=0;i< getListaCantones().size();i++){
            if(i==pos){
                prod= getListaCantones().get(i);
            }
        }
        return prod;
    }
}