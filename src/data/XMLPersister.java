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
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLPersister {
    private String path;
    private static XMLPersister theInstance;
    private int contProvincia;
    private int contCantones;
    private int contDistritos;
    private List<Provincia> listaProvincia;

    public static XMLPersister instance() {
        if (theInstance == null) {
            theInstance = new XMLPersister("src/data.xml");
        }
        return theInstance;
    }

    public XMLPersister(String p) {
        path = p;
        listaProvincia = new ArrayList<>();
        contProvincia = 1;
        contCantones = 1;
        contDistritos = 1;
    }

    public Data load() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        FileInputStream is = new FileInputStream(path);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Data result = (Data) unmarshaller.unmarshal(is);
        is.close();
        return result;
    }
    public ListaProvincia loadXML() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        FileInputStream is = new FileInputStream("src/Provincias.xml");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ListaProvincia result = (ListaProvincia) unmarshaller.unmarshal(is);
        is.close();
        return result;
    }
    public void store(Data d) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        FileOutputStream os = new FileOutputStream(path);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(d, os);
        os.flush();
        os.close();
    }

}
