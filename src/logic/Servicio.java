package logic;

import data.Data;
import data.XMLPersister;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class Servicio {
    private Data datos;
    private static Servicio  theInstance;

    public static Servicio instance(){
        if(theInstance == null){
            theInstance = new Servicio();
        }
        return theInstance;
    }

    private Servicio(){
        try{
            datos = XMLPersister.instance().load();

             //System.out.println("se cargo");
        }
        catch(Exception e){
           // System.out.println("no se cargo");
            datos = new Data();
        }
    }


    public String toStringClientes(){
        return datos.mostrarClientes();
    }

    public String toStringProvincias(){
        return datos.mostrarProvincias();
    }

    public List<Cliente> clienteSearch(String id){
        List<Cliente> result=datos.getClientes().stream().filter(f->f.getId().startsWith(id)).collect(Collectors.toList());
        return result;
    }

    public Cliente clienteGet(String cedula) throws Exception{
        Cliente result=datos.getClientes().stream().filter(c->c.getId().equals(cedula)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Cliente no existe");
    }


    public List<Provincia> provinciasGetList(){
        List<Provincia> pro = datos.getProvincias();
        return pro;
    }

    public void addCliente(Cliente cliente) throws Exception{
        Cliente old=datos.getClientes().stream().filter(f->f.getId().equals(cliente.getId())).findFirst().orElse(null);
        if (old==null) datos.getClientes().add(cliente);
        else throw new Exception("Cliente ya existe");

    }

    public List<Provincia> getProvincias(){
        return datos.getProvincias();
    }
    public void addProvincias(Provincia provincia){
         datos.getProvincias().add(provincia);
    }
    public void addCanton(int pos,Canton canton){
        provinciasGetList().get(pos).addCanton(canton);
    }
    public void addDistrito(Distrito distrito){
         //datos.getProvincias().get();
    }
    public List<Cliente> getClientes(){
        return datos.getClientes();
    }
    public Cliente getCliente(String p){
        Cliente prod=null;
        for(int i=0;i< getClientes().size();i++){
            if(getClientes().get(i).getId().equals(p)){
                prod= getClientes().get(i);
            }
        }
        return prod;
    }
    public void store(){
        try{
            XMLPersister.instance().store(datos);
        }
        catch(Exception e){
            //System.out.println("no se guardo");
        }
    }

}
