package presentation.main_window;

import logic.Servicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador {
    Modelo modelo;
    Vista vista;
    presentation.client.Modelo modeloCliente;
    presentation.client.Vista vistaCliente;
    presentation.client.Controlador controladorCliente;
    presentation.pay.Modelo modeloPago;
    presentation.pay.Vista vistaPago;
    presentation.pay.Controlador controladorPago;
    presentation.lending.Modelo modeloPrestamo;
    presentation.lending.Vista vistaPrestamo;
    presentation.lending.Controlador controladorPrestamo;

    public Controlador(Modelo modelo,Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        init();
        vistaCliente.setVisible(true);
        vistaCliente.agregarListener(new ClassAction());
        vistaPrestamo.agregarListener(new ClassAction());
        vistaPago.agregarListener(new ClassAction());
        data.XMLPersister.instance().read();
       // System.out.println(Servicio.instance().getProvincias().get(0).getListaCantones().get(0).nombresDistritos());
        //System.out.println( logic.Servicio.getInstance().getListaProvincias());
    }
    public void init(){
        modeloCliente=new presentation.client.Modelo();
        vistaCliente=new presentation.client.Vista();
        controladorCliente=new presentation.client.Controlador(modeloCliente,vistaCliente);
        modeloPago=new presentation.pay.Modelo();
        vistaPago=new presentation.pay.Vista();
        controladorPago=new presentation.pay.Controlador(modeloPago,vistaPago);
        modeloPrestamo=new presentation.lending.Modelo();
        vistaPrestamo=new presentation.lending.Vista();
        controladorPrestamo=new presentation.lending.Controlador(modeloPrestamo,vistaPrestamo);
    }

    private class ClassAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando=((JButton)e.getSource()).getActionCommand();
            if(comando.equals("prestamo-cliente")){
                vistaCliente.setVisible(false);
                vistaPrestamo.showPrestamos();
            }
            if(comando.equals("pagar-prestamo")){
                vistaPrestamo.setVisible(false);
                vistaPago.showPagos();
            }
            if(comando.equals("regresar-prestamo")){
                vistaPrestamo.setVisible(false);
                vistaCliente.showClientes();
            }
            if(comando.equals("regresar-pago")){
                vistaPago.setVisible(false);
                vistaPrestamo.showPrestamos();
            }
        }
    }

}
