package presentation.lending;

import logic.Cliente;
import logic.Pago;
import logic.Prestamo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Vista extends JFrame implements Observer {
    Modelo modelo;
    Controlador controlador;

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    JPanel principal;
    JButton pago;
    JButton regresar;
    JTable tabla;
    public Vista() throws HeadlessException {
        setTitle("Prestamos");
        setSize(700,700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        iniciarComponentes(getContentPane());
        setLocationRelativeTo(null);
    }

    private void iniciarComponentes(Container contentPane) {
        principal=new JPanel(new FlowLayout());
        regresar=new JButton("Regresar");
        pago=new JButton("Pagar");
        tabla=new JTable();
        regresar.setActionCommand("regresar-prestamo");
        pago.setActionCommand("pagar-prestamo");
        principal.setBackground(new Color(176,196,222));
        principal.add(regresar);
        principal.add(pago);
        principal.add(tabla);
        contentPane.setBackground(new Color(176,196,222));

        contentPane.add(principal,BorderLayout.SOUTH);
    }
    public void agregarListener(ActionListener actionListener){
        regresar.addActionListener(actionListener);
        pago.addActionListener(actionListener);
    }
    public void showPrestamos(){
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        Prestamo prestamo=new Prestamo();
        modelo.setNuevoPrestamo(prestamo);
        Pago pago=new Pago();
        modelo.setPago(pago);
        Cliente cliente=new Cliente();
        modelo.setCliente(cliente);
    }
}
