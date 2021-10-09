package presentation.pay;

import logic.Pago;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controlador {
    Modelo modelo;
    Vista vista;

    public Controlador(Modelo modelo,Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        modelo.setListaPagos(new ArrayList<>());
        vista.agregarListener(new ClassAction());
        JTable jTable=lista();
        jTable.setBounds(200,200,200,100);
        jTable.setBackground(new Color(176,196,222));
        JScrollPane jScrollPane1=new JScrollPane(jTable);
        vista.agregaTabla(jScrollPane1);
    }
    public JTable lista(){
        List<Pago> lista=new ArrayList<>();
        lista.add(new Pago(new Date(10,10,10),0,0,0,0));
        lista.add(new Pago(new Date(10,10,10),0,0,0,0));
        lista.add(new Pago(new Date(10,10,10),0,0,0,0));
        lista.add(new Pago(new Date(10,10,10),0,0,0,0));
        lista.add(new Pago(new Date(10,10,10),0,0,0,0));
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
