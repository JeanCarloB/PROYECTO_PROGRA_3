package presentation.lending;

import logic.Cliente;
import logic.Prestamo;
import logic.Servicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controlador {
    Modelo modelo;
    Vista vista;

    public Controlador(Modelo modelo,Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.agregarListener(new ClassAction());
    }
    public void agregarPrestamo(String monto,String tasaInteres,String plazo){
        try {
            Prestamo prestamo=new Prestamo(Double.parseDouble(monto),Double.parseDouble(tasaInteres),Double.parseDouble(plazo));
            Servicio.instance().getPrestamos().add(prestamo);
            modelo.setNuevoPrestamo(prestamo);
            modelo.refresh();
        } catch (Exception ex) {

        }
    }

    public boolean validarEspacios(String monto,String tasaInteres,String plazo){

        if (monto.isEmpty()) {
            vista.mensajeError("Digite el monto");
            return false;

        }
        if (tasaInteres.isEmpty()) {
            vista.mensajeError("Digite la tasa de interes");
            return false;

        }
        if (plazo.isEmpty()) {
            vista.mensajeError("Digite el plazo");
            return false;

        }
        try {
            Double.parseDouble(monto);
        } catch (Exception ex) {
            vista.mensajeError("Digite solamente datos numericos");
            return false;
        }
        try {
            Double.parseDouble(tasaInteres);
        } catch (Exception ex) {
            vista.mensajeError("Digite solamente datos numericos");
            return false;
        }
        try {
            Double.parseDouble(plazo);
        } catch (Exception ex) {
            vista.mensajeError("Digite solamente datos numericos");
            return false;
        }
        return true;
    }
    private class ClassAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando=((JButton)e.getSource()).getActionCommand();
            switch(comando) {
                case "agregar-lending":
                    String monto = vista.getTextoMonto().getText();
                    String tasaInteres = vista.getTextoTasaInteres().getText();
                    String plazo = vista.getTextoPlazo().getText();
                    if (validarEspacios(monto,tasaInteres,plazo)) {
                        agregarPrestamo(monto,tasaInteres,plazo);
                    }
            }
        }
    }
}
