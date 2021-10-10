package data;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import logic.Provincia;
import logic.Servicio;

import java.util.List;
@XmlRootElement(name="data")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ListaProvincia {
    private static ListaProvincia  theInstance;

    public static ListaProvincia instance(){
        if(theInstance == null){
            theInstance = new ListaProvincia();
        }
        return theInstance;
    }
    private List<Provincia> provincias;

    public ListaProvincia(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public ListaProvincia() {
    }
    @XmlElement(name="provincias")
    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    @Override
    public String toString() {
        return "ListaProvincia{" +
                "provincias=" + provincias.toString() +
                '}';
    }
}
