package presentation.lending;

import logic.Cliente;
import logic.Pago;
import logic.Prestamo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Vista extends JFrame implements Observer {
    private Modelo modelo;
    private Controlador controlador;
    private JPanel sur;
    private JPanel norte;
    private JButton pago;
    private JLabel monto;
    private JLabel plazo;
    private JLabel tasaInteres;
    private JTextField textoMonto;
    private JTextField textoPlazo;
    private JTextField textoTasaInteres;
    private JButton agregar;
    private JButton regresar;
    private JTable tabla;

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        modelo.addObserver(this);
        this.modelo = modelo;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }


    public Vista() throws HeadlessException {
        setTitle("Prestamos");
        setSize(700,700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        iniciarComponentes(getContentPane());
        setLocationRelativeTo(null);
    }

    private void iniciarComponentes(Container contentPane) {
        sur=new JPanel(new FlowLayout());
        norte=new JPanel(new GridLayout(3,3));
        monto=new JLabel("Monto");
        plazo=new JLabel("Tasa de interes");
        tasaInteres=new JLabel("Plazo");
        textoMonto=new JTextField(10);
        textoPlazo=new JTextField(10);
        textoTasaInteres=new JTextField(10);
        agregar=new JButton("Agregar");
        agregar.setActionCommand("agregar-leading");

        norte.add(monto);
        norte.add(textoMonto);
        norte.add(agregar);
        norte.add(tasaInteres);
        norte.add(textoTasaInteres);
        norte.add(new JLabel(""));
        norte.add(plazo);
        norte.add(textoPlazo);
        norte.add(new JLabel(""));
        norte.setBorder(new EmptyBorder(10,10,10,10));
        norte.setBackground(new Color(176,196,222));




        regresar=new JButton("Regresar");
        pago=new JButton("Pagar");
        tabla=new JTable();
        tabla.setBackground(new Color(176,196,222));
        regresar.setActionCommand("regresar-prestamo");
        pago.setActionCommand("pagar-prestamo");
        sur.setBackground(new Color(176,196,222));
        sur.add(regresar);
        sur.add(pago);
        contentPane.setBackground(new Color(176,196,222));
        contentPane.add(tabla,BorderLayout.CENTER);
        contentPane.add(sur,BorderLayout.SOUTH);
        contentPane.add(norte,BorderLayout.NORTH);
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
        this.tabla.setModel(modelo.getTable());
    }

    public void agregaTabla(JScrollPane jScrollPane1) {
            if(getContentPane().getComponentCount()>0){
                getContentPane().remove(0);
            }
            getContentPane().add(jScrollPane1);
            getContentPane().validate();
        }

}
