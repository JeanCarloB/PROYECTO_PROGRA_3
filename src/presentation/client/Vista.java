package presentation.client;

import logic.Cliente;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Vista extends JFrame implements Observer {
    private Modelo modelo;
    private Controlador controlador;
    private JLabel cedula;
    private JButton botonBuscar;
    private JButton botonGuardar;
    private JLabel nombre;
    private JTextField textoNombre;
    private JTextField textoCedula;
    private JLabel provincia;
    private JLabel canton;
    private JLabel distrito;
    private JTextField opcionesProvincias;
    private JComboBox <String> opcionesCanton;
    private JComboBox <String> opcionesDistrito;
    private JLabel imagen;
    private JButton botonPrestamos;
    int n=7;
    ImageIcon[] flags;

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public String getTextoNombre() {
        return textoNombre.getText();
    }

    public String getTextoCedula() {
        return textoCedula.getText();
    }

    public String getOpcionesProvincias() {
        return opcionesProvincias.getText();
    }

    public String getOpcionesCanton() {
        return String.valueOf(opcionesCanton.getSelectedItem());
    }

    public String getOpcionesDistrito() {
        return String.valueOf(opcionesDistrito.getSelectedItem());
    }

    public Vista() throws HeadlessException {
        super("Clientes");
        setIconImage(new ImageIcon("src/map/clients.png").getImage());
        setSize(700,700);
        setLayout(new BorderLayout());
        iniciarComponentes(getContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void mensajeError(String men){
        JOptionPane.showMessageDialog(null,men,"Error",JOptionPane.ERROR_MESSAGE);
    }
    private void iniciarComponentes(Container contentPane) {
        ImageIcon imagenBotonBuscar=new ImageIcon("src/map/search.png");
        JPanel panel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panelP=new JPanel(new BorderLayout());
        cedula=new JLabel("Cedula");
        nombre=new JLabel("Nombre");
        botonBuscar=new JButton();
        botonBuscar.setActionCommand("buscar-cliente");
        botonBuscar.setBounds(10,10,20,25);
        textoCedula=new JTextField(10);
        textoNombre=new JTextField(14);
        Icon iconoBotonBuscar=new ImageIcon(imagenBotonBuscar.getImage().getScaledInstance(botonBuscar.getWidth(),botonBuscar.getHeight(),Image.SCALE_DEFAULT));
        botonBuscar.setIcon(iconoBotonBuscar);

        panel.add(cedula);
        panel.add(textoCedula);
        panel.add(botonBuscar);
        panel1.add(nombre);
        panel1.add(textoNombre);
        // panel.setBorder(new EmptyBorder(10,10,10,10));
        panelP.add(panel,BorderLayout.NORTH);
        panelP.add(panel1,BorderLayout.WEST);
        contentPane.add(panelP,BorderLayout.NORTH);
        //
        ImageIcon imagenBotonGuardar=new ImageIcon("src/map/save.png");
        JPanel panel2=new JPanel(new GridLayout(2,4,2,2));
        JPanel panelP2=new JPanel(new FlowLayout(FlowLayout.LEFT));

        provincia=new JLabel("Provincia");

        canton=new JLabel("Canton");
        distrito=new JLabel("Distrito");
        opcionesProvincias=new JTextField(12);
        opcionesCanton=new JComboBox<String>();
        opcionesDistrito=new JComboBox<String>();
        botonGuardar=new JButton();
        botonGuardar.setActionCommand("guardar-cliente");
        botonGuardar.setBounds(0,0,20,25);
        Icon iconoBotonGuardar=new ImageIcon(imagenBotonGuardar.getImage().getScaledInstance(botonGuardar.getWidth(),botonGuardar.getHeight(),Image.SCALE_DEFAULT));

        panel2.add(provincia);
        panel2.add(canton);
        panel2.add(distrito);
        panel2.add(new JLabel(""));
        panel2.add(opcionesProvincias);
        opcionesProvincias.setEditable(false);
        panel2.add(opcionesCanton);
        panel2.add(opcionesDistrito);
        botonGuardar.setIcon(iconoBotonGuardar);
        panel2.add(botonGuardar);
        //panel2.setBorder(new EmptyBorder(10,10,10,10));
        panelP2.add(panel2,BorderLayout.NORTH);
        contentPane.add(panelP2,BorderLayout.WEST);
        //
        ImageIcon imagenCartago=new ImageIcon("src/map/CostaRica.jpg");
        ImageIcon imagenBotonPrestamo=new ImageIcon("src/map/prestamos.png");
        JPanel panel3=new JPanel(new FlowLayout(FlowLayout.LEFT));
        imagen=new JLabel();
        botonPrestamos=new JButton();
        botonPrestamos.setActionCommand("prestamo-cliente");
        botonPrestamos.setBounds(10,10,50,50);

        Icon iconoBotonPrestamos=new ImageIcon(imagenBotonPrestamo.getImage().getScaledInstance(botonPrestamos.getWidth(),botonPrestamos.getHeight(),Image.SCALE_DEFAULT));
        imagen.setIcon(imagenCartago);
        botonPrestamos.setIcon(iconoBotonPrestamos);
        panel3.add(imagen);
        panel3.add(botonPrestamos);
        panel3.setBorder(new EmptyBorder(10,10,100,10));
        contentPane.add(panel3,BorderLayout.SOUTH);

    }
    public void agregarListener(ActionListener actionListener){
        botonBuscar.addActionListener(actionListener);
        botonGuardar.addActionListener(actionListener);
        botonPrestamos.addActionListener(actionListener);
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }

    public void showClientes(){
        this.setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
        Cliente cliente = modelo.getCliente();
        cedula.setText(cliente.getId());
        nombre.setText(cliente.getNombre());
        int prov;
        if (cliente.getId().isEmpty()) prov=0;
        else prov=Integer.parseInt(cliente.getId().substring(0, 1));
        provincia.setIcon(flags[prov]);
        repaint();
    }

    public void addMouseListenerCombo(MouseListener mouseListener) {
        opcionesCanton.addMouseListener(mouseListener);
        opcionesDistrito.addMouseListener(mouseListener);
    }
    public void addMouseMotionListenerImagen(MouseMotionAdapter motionAdapter) {
        imagen.addMouseMotionListener(motionAdapter);
    }

    public void loadFlags()
    {
        flags = new ImageIcon[n];
        try
        {
            for(int p=1;p<n;p++)
                flags[p] = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/map/provincia"+p+".jpg")));
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }
    public Rectangle[] creaCoordenada(){
        Rectangle[] Coordenadas = new Rectangle[12];

        Coordenadas[0] = new Rectangle(234,62,30,52);//HEREDIA;
        Coordenadas[1] = new Rectangle(257,142,30,23);//CARTAGO
        Coordenadas[2] = new Rectangle(66,75,79,38);//GUANACASTE
        Coordenadas[3] = new Rectangle(153,48,75,29);//ALAJUELA6
        Coordenadas[4] = new Rectangle(269,97,49,30);//LIMON
        Coordenadas[5] = new Rectangle(315,171,57,28);//LIMON
        Coordenadas[6] = new Rectangle(119,140,23,27);//PUNTARENAS
        Coordenadas[7] = new Rectangle(295,229,80,34);//PUNTARENAS
        Coordenadas[8] = new Rectangle(195,148,48,23);//SANJOSE
        Coordenadas[9] = new Rectangle(160,113,10,10);//PUNTARENAS
        Coordenadas[10] = new Rectangle(274,187,20,30);//SANJOSE
        Coordenadas[11] = new Rectangle(220,180,10,10);//PUNTARENAS
        return Coordenadas;
    }
    public void setearRuta(String path){
        ImageIcon iconaux=new ImageIcon(path);
        imagen.setIcon(iconaux);
    }
    public void agregarComboCanton(String nom){
        opcionesCanton.addItem(nom);
    }

    public void agregarComboDistrito(String nom){
        opcionesDistrito.addItem(nom);
    }
    public void agregarCliente(){
        try{
            if(textoCedula.getText().isEmpty()||textoNombre.getText().isEmpty()||opcionesProvincias.getText().isEmpty()||getOpcionesCanton().isEmpty()||getOpcionesDistrito().isEmpty())return;
            Cliente cliente;
            cliente = new Cliente();
            cliente.setId(textoCedula.getText());
            cliente.setNombre(textoNombre.getText());
            cliente.setProvincia(opcionesProvincias.getText());
            cliente.setCanton(getOpcionesCanton());
            cliente.setDistrito(getOpcionesDistrito());
           // controlador.agregar(cliente);
        } catch (Exception e) {
            mensajeError("No se puede agregar");
        }
    }

    public void addMouseListenerImagen(MouseListener trackerImagen) {
        imagen.addMouseListener(trackerImagen);
    }

}
