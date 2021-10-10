package logic;

import data.Data;
import data.ListaProvincia;
import data.XMLPersister;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Map;
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
    public Provincia buscarProvincia(int pos){
        Provincia prod=null;
        for(int i=0;i< getProvincias().size();i++){
            if(i==pos){
                prod= getProvincias().get(i);
            }
        }
        return prod;
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
    public List<Pago> getPagos(){
        return datos.getPagos();
    }
    public List<Prestamo> getPrestamos(){
        return datos.getPrestamos();
    }
    public List<Prestamo> getPrestamosPorCliente(String p){
        List<Prestamo> prod=null;
        for(int i=0;i< getClientes().size();i++){
            if(getClientes().get(i).getId().equals(p)){
                prod=getClientes().get(i).listaPrestamos;
            }
        }
        return prod;
    }

    public void setProvincias(List<Provincia> provincia) {
        datos.setProvincias(provincia);
    }
    public void setCantones(List<Canton> lista){
        for(int i=0;i<datos.getProvincias().size();i++){
            for(int j=0;j<lista.size();j++){
                datos.getProvincias().get(i).addCanton(lista.get(j));
            }
        }
    }

    public void filter(List<Distrito> listaD) {
        for(int i=0;i<7;i++){
            System.out.println(datos.getProvincias().get(i).toString());
            for(int j=0;j<datos.getProvincias().get(i).getListaCantones().size();j++){
                //System.out.println(datos.getProvincias().get(i).getListaCantones().get(j).toString());
                for(int k=0;k< listaD.size();k++){
                        datos.getProvincias().get(i).getListaCantones().get(i).addDistrito(listaD.get(i));
                    }
                }
            }
        }

}
