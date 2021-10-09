package presentation.pay;

import logic.Pago;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Vista extends JFrame implements Observer {
    private Controlador controlador;
    private Modelo modelo;
    private JPanel principal;
    private JButton regresar;
    private JTable tabla;

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
    }

    public Vista() throws HeadlessException {
        setTitle("Pagos");
        setSize(700,700);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        iniciarComponentes(getContentPane());
        setLocationRelativeTo(null);
    }

    private void iniciarComponentes(Container contentPane) {
        principal=new JPanel(new FlowLayout());
        regresar=new JButton("Regresar");
        regresar.setActionCommand("regresar-pago");
        principal.setBackground(new Color(176,196,222));
        principal.add(regresar);
        tabla=new JTable();
        contentPane.setBackground(new Color(176,196,222));
        contentPane.add(tabla,BorderLayout.CENTER);
        contentPane.add(principal,BorderLayout.SOUTH);
    }
    public void agregarListener(ActionListener actionListener){
        regresar.addActionListener(actionListener);
    }
    public void showPagos(){
        this.setVisible(true);
    }
    @Override
    public void update(Observable o, Object arg) {
        Pago pago=new Pago();
        modelo.setPago(pago);
        tabla.setModel(modelo.getTabla());
    }

    public void agregaTabla(JScrollPane jScrollPane1) {
        if(getContentPane().getComponentCount()>0){
            getContentPane().remove(0);
        }
        getContentPane().add(jScrollPane1);
        getContentPane().validate();
    }

}
