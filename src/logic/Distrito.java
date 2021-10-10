package logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Distrito {
    String numero;
    String nombre;

    public Distrito(){
        numero = "";
        nombre = "";
    }


    public Distrito( String num, String nom)
    {
        numero = num;
        nombre = nom;
    }


    public String getNombre(){
        return nombre;
    }

    public void setNombre( String nom )
    {
        nombre = nom;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero( String num )
    {
        numero = num;
    }
    @Override
    public String toString() {
        return "Distrito{" +
                "numero='" + numero + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
