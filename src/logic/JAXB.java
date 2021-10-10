package logic;

import data.ListaProvincia;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileOutputStream;

public class JAXB {
    public void marshall(ListaProvincia student){
        try{
            //crea contexto JAXB
            JAXBContext jaxbContext=JAXBContext.newInstance(ListaProvincia.class);
            //se crea obejeto para realizar marshaller
            Marshaller marshaller=jaxbContext.createMarshaller();
            //se configura la preopiedad para mostrar el xml en formato de salida
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(student,new FileOutputStream("src/Provincias.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ListaProvincia unmarshall(){
        ListaProvincia student=null;
        try{
            //archivo que se lee
            File file=new File("src/Provincias.xml");
            //creando el JABX context
            JAXBContext jaxbContext=JAXBContext.newInstance(ListaProvincia.class);
            //creando el unmarshaller
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
            //llamando al unmarshaller method
            student=(ListaProvincia) unmarshaller.unmarshal(file);
        }catch(Exception e){
            e.printStackTrace();
        }
        return student;
    }
}
