package aplication;

import data.XMLPersister;
import logic.*;
import presentation.client.Controlador;
import presentation.client.Modelo;
import presentation.client.Vista;

import java.util.Iterator;

public class Aplicacion {
    public static void main(String[] args) {
        presentation.client.Modelo modelo=new Modelo();
        presentation.client.Vista vista=new Vista();
        XMLPersister.instance().read();
        vista.setVisible(true);
        presentation.client.Controlador controlador = new Controlador(modelo, vista);

        try {
            for(int i=0;i<Servicio.instance().getProvincias().size();i++){
                if(Servicio.instance().getProvincias().get(i).getNumero().equals("1")) {
                    for (int j = 0; j < Servicio.instance().getProvincias().get(i).getListaCantones().size(); j++) {
                        vista.agregarComboCanton(Servicio.instance().getProvincias().get(i).getListaCantones().get(j).getNombre());
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            for(int i=0;i<7;i++) {
                if(Servicio.instance().getProvincias().get(i).getNumero().equals("1")){
                for (int p = 0; p < Servicio.instance().getProvincias().get(i).getListaCantones().size(); p++)
                    for (int l = 0; l < Servicio.instance().getProvincias().get(i).getListaCantones().get(i).getListaDistritos().size(); l++) {
                        System.out.println(Servicio.instance().getProvincias().get(i).getListaCantones().get(i).getListaDistritos().get(l).getNombre());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
