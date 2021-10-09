package presentation.lending;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    Modelo modelo;
    Vista vista;

    public Controlador(Modelo modelo,Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
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
