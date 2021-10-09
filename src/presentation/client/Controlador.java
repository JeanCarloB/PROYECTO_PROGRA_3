package presentation.client;

import logic.Cliente;
import logic.Servicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public boolean isVerdad() {
        return verdad;
    }

    boolean verdad = true;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        modelo.setListaClientes(Servicio.instance().getClientes());
        matchProvincias();
        vista.agregarListener(new Listener());
        vista.addMouseListenerCombo(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        vista.addMouseListenerImagen(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Rectangle[] Coordenadas = vista.creaCoordenada();

                int mouseX = e.getX();
                int mouseY = e.getY();

                Coordenadas[0] = new Rectangle(234, 62, 29, 53);
                Coordenadas[1] = new Rectangle(257, 142, 30, 23);
                Coordenadas[2] = new Rectangle(66, 75, 79, 38);
                Coordenadas[3] = new Rectangle(157, 42, 62, 36);
                Coordenadas[4] = new Rectangle(269, 97, 49, 30);
                Coordenadas[5] = new Rectangle(315, 171, 57, 28);
                Coordenadas[6] = new Rectangle(119, 139, 19, 23);
                Coordenadas[7] = new Rectangle(295, 229, 80, 34);
                Coordenadas[8] = new Rectangle(195, 148, 48, 23);
                Coordenadas[9] = new Rectangle(160, 113, 10, 10);
                Coordenadas[10] = new Rectangle(274, 187, 20, 30);
                Coordenadas[11] = new Rectangle(220, 180, 10, 10);

                if (Coordenadas[0].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia4.jpg");
                    ;
                }
                if (Coordenadas[1].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia3.jpg");
                    ;
                }
                if (Coordenadas[2].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia5.jpg");
                    ;
                }
                if (Coordenadas[3].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia2.jpg");
                    ;
                }
                if (Coordenadas[4].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia7.jpg");
                    ;
                }
                if (Coordenadas[5].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia7.jpg");
                    ;
                }
                if (Coordenadas[6].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia6.jpg");
                    ;
                }
                if (Coordenadas[7].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia6.jpg");
                    ;
                }
                if (Coordenadas[8].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia1.jpg");
                    ;
                }
                if (Coordenadas[9].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia6.jpg");
                }
                if (Coordenadas[10].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia1.jpg");
                }
                if (Coordenadas[11].contains(mouseX, mouseY)) {
                    vista.setearRuta("src/map/provincia6.jpg");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                verdad = false;
            }
        });

        vista.addMouseMotionListenerImagen(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //seleccionArea(e);
            }
        });
    }

    private boolean validaCedula(String cedula) {
        if (cedula.isEmpty()) {
            vista.mensajeError("Digite una cedula");
            return false;
        }
        try {
            Integer.parseInt(cedula);
        } catch (Exception ex) {
            vista.mensajeError("Digite numeros");
            return false;
        }
        return true;
    }

    public void buscarCliente(String cedula) {
        if (Servicio.instance().getCliente(cedula) != null) {
            modelo.setCliente(new Cliente(cedula, "", "", "", ""));
            modelo.setListaClientes(Servicio.instance().getClientes());
            modelo.commit();
        } else {
            vista.mensajeError("No se encuentra");
        }
    }


    public void agregar() {
        String cedulaS = vista.getTextoCedula();
        String nombreS = vista.getTextoNombre();
        String provinciaS = vista.getOpcionesProvincias();
        String cantonS = vista.getOpcionesCanton();
        String distritoS = vista.getOpcionesDistrito();
        if (validaEspaciosVacios(cedulaS, nombreS, provinciaS, cantonS, distritoS)) {
            agregarCliente(cedulaS, nombreS, provinciaS, cantonS, distritoS);
        }
    }

    public boolean validaEspaciosVacios(String cedula, String nombre, String provinciaS, String cantonS, String distritoS) {
        if (cedula.isEmpty()) {
            vista.mensajeError("Digite una cedula");
            return false;
        }
        try {
            Integer.parseInt(cedula);
        } catch (Exception ex) {
            vista.mensajeError("Digite numeros");
            return false;
        }
        if (nombre.isEmpty()) {
            vista.mensajeError("Digite un nombre");
            return false;

        }
        if (nombre.isEmpty()) {
            vista.mensajeError("Digite un nombre");
            return false;

        }
        if (provinciaS.isEmpty()) {
            vista.mensajeError("No se ha seleccionado una provincia");
            return false;

        }
        if (cantonS.isEmpty()) {
            vista.mensajeError("No se ha seleccionado un canton");
            return false;

        }
        if (distritoS.isEmpty()) {
            vista.mensajeError("No se ha seleccionado un distrito");
            return false;

        }

        return true;
    }

    public void agregarCliente(String cedulaS, String nombreS, String provinciaS, String cantonS, String distritoS) {
        Cliente cliente = new Cliente(cedulaS, nombreS, provinciaS, cantonS, distritoS);
        try {
            Servicio.instance().addCliente(cliente);
            modelo.setCliente(cliente);
            modelo.setListaClientes(Arrays.asList(cliente));
            modelo.commit();
            // System.out.println(Servicio.instance().getClientes());
        } catch (Exception ex) {
            vista.mensajeError(ex.getMessage());
        }
    }

    public void buscar() {
        String cedula = vista.getTextoCedula();
        if (validaCedula(cedula)) {
            buscarCliente(cedula);
        }

    }

    public void seleccionArea(MouseEvent event) {
        Rectangle[] Coordenadas = vista.creaCoordenada();

        int mouseX = event.getX();
        int mouseY = event.getY();

        Coordenadas[0] = new Rectangle(234, 62, 29, 53);
        Coordenadas[1] = new Rectangle(257, 142, 30, 23);
        Coordenadas[2] = new Rectangle(66, 75, 79, 38);
        Coordenadas[3] = new Rectangle(157, 42, 62, 36);
        Coordenadas[4] = new Rectangle(269, 97, 49, 30);
        Coordenadas[5] = new Rectangle(315, 171, 57, 28);
        Coordenadas[6] = new Rectangle(119, 139, 19, 23);
        Coordenadas[7] = new Rectangle(295, 229, 80, 34);
        Coordenadas[8] = new Rectangle(195, 148, 48, 23);
        Coordenadas[9] = new Rectangle(160, 113, 10, 10);
        Coordenadas[10] = new Rectangle(274, 187, 20, 30);
        Coordenadas[11] = new Rectangle(220, 180, 10, 10);

        if (Coordenadas[0].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia4.jpg");
            ;
        }
        if (Coordenadas[1].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia3.jpg");
            ;
        }
        if (Coordenadas[2].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia5.jpg");
            ;
        }
        if (Coordenadas[3].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia2.jpg");
            ;
        }
        if (Coordenadas[4].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia7.jpg");
            ;
        }
        if (Coordenadas[5].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia7.jpg");
            ;
        }
        if (Coordenadas[6].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia6.jpg");
            ;
        }
        if (Coordenadas[7].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia6.jpg");
            ;
        }
        if (Coordenadas[8].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia1.jpg");
            ;
        }
        if (Coordenadas[9].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia6.jpg");
        }
        if (Coordenadas[10].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia1.jpg");
        }
        if (Coordenadas[11].contains(mouseX, mouseY)) {
            vista.setearRuta("src/map/provincia6.jpg");
        }

    }

    public class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = ((JButton) e.getSource()).getActionCommand();

            if (comando.equals("buscar-cliente")) {
                buscar();
            }
            if (comando.equals("guardar-cliente")) {
                agregar();
            }

        }
    }

    public void matchProvincias() {

        String control = vista.getTextFieldPrrovincia().getText();
        switch (control) {
            case "San José" -> {
                ArrayList<String> stringArrayList = Servicio.instance().provinciasGetList().get(1).nombresCantones();
                vista.agregarComboCanton(stringArrayList);
            }
            case "Alajuela" -> {
                ArrayList<String> stringArrayList = Servicio.instance().provinciasGetList().get(2).nombresCantones();
                vista.agregarComboCanton(stringArrayList);
            }
            case "Cartago" -> {
                ArrayList<String> stringArrayList = Servicio.instance().provinciasGetList().get(3).nombresCantones();
                vista.agregarComboCanton(stringArrayList);
            }
            case "Heredia" -> {
                ArrayList<String> stringArrayList = Servicio.instance().provinciasGetList().get(4).nombresCantones();
                vista.agregarComboCanton(stringArrayList);
            }
            case "Guanacaste" -> {
                ArrayList<String> stringArrayList = Servicio.instance().provinciasGetList().get(5).nombresCantones();
                vista.agregarComboCanton(stringArrayList);
            }
            case "Puntarenas" -> {
                ArrayList<String> stringArrayList = Servicio.instance().provinciasGetList().get(6).nombresCantones();
                vista.agregarComboCanton(stringArrayList);
            }
            case "Limón" -> {
                ArrayList<String> stringArrayList = Servicio.instance().provinciasGetList().get(7).nombresCantones();
                vista.agregarComboCanton(stringArrayList);
            }
        }
    }

    public void cantonesMatchDistritos() {
//        ArrayList<String> distritosList = new ArrayList<>();
//        String canton = (String) vista.getCantonesCombo();
//        for (int j = 0; j < 7; j++) {
//            ArrayList<String> stringArrayList = Servicio.(j + 1).nombreCantones();
//            for (int i = 0; i < stringArrayList.size(); i++) {
//                if (Objects.equals(stringArrayList.get(i), canton)) {
//                    distritosList = dataProvincias.buscaProvincia(j + 1).buscaCantones(i + 1).nombreDistritos();// error linea 77
//                }
//            }
//        }
//        ventanaPrincipal.comboBoxDistritos(distritosList);
//    }
    }
}
