package presentation.pay;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador {
    Modelo modelo;
    Vista vista;

    public Controlador(Modelo modelo,Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        modelo.setListaPagos(new ArrayList<>());
        vista.agregarListener(new ClassAction());
    }

    private class ClassAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando=((JButton)e.getSource()).getActionCommand();
            switch(comando){

            }
        }
    }
}
