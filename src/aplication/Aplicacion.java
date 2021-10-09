package aplication;
import presentation.main_window.Vista;
import presentation.main_window.Controlador;
import presentation.main_window.Modelo;


public class Aplicacion {
    public static void main(String[] args) {
        presentation.main_window.Modelo modelo=new Modelo();
        presentation.main_window.Vista vista=new Vista();
        presentation.main_window.Controlador controlador=new Controlador(modelo,vista);

    }

}
