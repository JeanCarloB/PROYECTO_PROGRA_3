package data;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import logic.Canton;
import logic.Distrito;
import logic.Provincia;
import logic.Servicio;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLPersister {
    private String path;
    private static XMLPersister theInstance;
    private int contProvincia;
    private int contCantones;
    private int contDistritos;
    private List<Provincia> listaProvincia;
    public static XMLPersister instance(){
        if (theInstance==null){
            theInstance=new XMLPersister("src/data.xml");
        }
        return theInstance;
    }

    public XMLPersister(String p) {
        path=p;
        listaProvincia=new ArrayList<>();
        contProvincia=1;
        contCantones=1;
        contDistritos=1;
    }

    public Data load() throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        FileInputStream is = new FileInputStream(path);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Data result = (Data) unmarshaller.unmarshal(is);
        is.close();
        return result;
    }

    public void store(Data d)throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        FileOutputStream os = new FileOutputStream(path);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(d, os);
        os.flush();
        os.close();
    }
    public void read(){
        try{
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File("src/Provincias.xml"));

            // agarro la etiquete emp del documento
            NodeList lista = documento.getElementsByTagName("provincias");

            // Recorro las etiquetas
            for (int i = 0; i < lista.getLength(); i++) {
                // Cojo el nodo actual
                Node elemento = lista.item(i);
                // Compruebo si el nodo es un elemento
                if (elemento.getNodeType()==Node.ELEMENT_NODE) {
                    Element e = (Element) elemento;
                    NodeList provincias = e.getChildNodes();

                    // Lo transformo a Element
                    for (int j = 0; j < provincias.getLength();j++) {
                        Node provincia = provincias.item(j);
                        if (provincia.getNodeType()==Node.ELEMENT_NODE) {
                            if(provincia.getNodeName().equals("nombre")) {
                                Servicio.instance().getProvincias().add(new Provincia(String.valueOf(contProvincia),provincia.getTextContent()));
                                contProvincia+=1;
                            }
                            Element e2 = (Element) provincia;
                            NodeList cantones= e2.getChildNodes();
                            for(int z=0;z<cantones.getLength();z++){
                                Node canton=cantones.item(z);
                                if(canton.getNodeType()==Node.ELEMENT_NODE){
                                    if(canton.getNodeName().equals("nombre")) {
//                                        Servicio.instance().addCanton(elemento.getNodeName(),new Canton("", canton.getTextContent()));
//                                        System.out.println(provincia.getTextContent());
                                        Servicio.instance().getProvincias().get(i).getListaCantones().add(new Canton(String.valueOf(contCantones), canton.getTextContent()));
                                        contCantones+=1;
                                    }
                                    Element d=(Element) canton;
                                    NodeList distritos=d.getChildNodes();
                                    for(int k=0;k<distritos.getLength();k++){
                                        Node distrito=distritos.item(k);
                                        if(distrito.getNodeType()==Node.ELEMENT_NODE){
                                            if(distrito.getNodeName().equals("nombre")) {
                                            //AGREGAR DISTRITO
                                                //System.out.println(distrito.getTextContent());
                                               // System.out.println(provincia.);
                                                try {
                                                    for(int p=0;p<Servicio.instance().getProvincias().get(i).getListaCantones().size();p++) {
                                                        Servicio.instance().getProvincias().get(i).getListaCantones().get(p).getListaDistritos().add(new Distrito("", distrito.getTextContent()));
                                                    }
                                                }catch (Exception m){
                                                    m.getMessage();
                                                }

                                                }
                                        }

                                    }
                                }

                            }

                        }

                    }
                }

            }
            System.out.println(Servicio.instance().getProvincias().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
