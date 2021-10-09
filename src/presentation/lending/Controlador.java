package presentation.lending;

import logic.Prestamo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    Modelo modelo;
    Vista vista;

    public Controlador(Modelo modelo,Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.agregarListener(new ClassAction());
        JTable jTable=lista();
        jTable.setBounds(200,200,200,100);
        jTable.setBackground(new Color(176,196,222));
        JScrollPane jScrollPane1=new JScrollPane(jTable);
        vista.agregaTabla(jScrollPane1);
    }
    public JTable lista(){
        List<Prestamo> lista=new ArrayList<>();
        lista.add(new Prestamo(0,0,0));
        lista.add(new Prestamo(1,1,1));
        lista.add(new Prestamo(2,2,2));
        lista.add(new Prestamo(3,3,3));
        JTable table=new JTable();
        table.setModel(new TableModel(lista));
        return table;
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
