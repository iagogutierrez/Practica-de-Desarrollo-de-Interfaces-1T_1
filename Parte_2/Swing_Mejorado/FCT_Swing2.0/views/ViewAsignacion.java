package views;

import javafx.scene.layout.BorderPane;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ViewAsignacion extends JPanel {
    JPanel izquierdo;

    JPanel derecho;
    JPanel pTitulo;
    JPanel pEleccionAlumno;
    JPanel pEleccionEmpresa;
    JPanel pEleccionTutor;
    JLabel lTitulo;
    JLabel ltituloEleccion;
    JLabel ltituloEleccionEmp;
    JLabel ltituloEleccionTut;
    JPanel pMensaje;

    public JScrollPane tablaAsignacion;
    public JPanel ptablaAsignacion;

    public JTable tAlumnos;
    public JButton bConfirm;
    JPanel pBoton;
    public JComboBox cbAlumnos;
    public JComboBox cbEmpresas;
    public JComboBox cbTutores;
    public JLabel lMensaje;

    public JPanel principal;
    public ViewAsignacion(){
        super();
        //setPreferredSize(new Dimension(1015, 700));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Título
        lTitulo = new JLabel("GESTIÓN DE LA ASIGNACIÓN DE PLAZAS");
        lTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        pTitulo = new JPanel(new FlowLayout());

        //Paneles contenido
        pEleccionAlumno = new JPanel(new FlowLayout());
        pEleccionEmpresa = new JPanel(new FlowLayout());
        pEleccionTutor = new JPanel(new FlowLayout());
        pBoton = new JPanel(new FlowLayout());

        //Panel principal

        ltituloEleccion = new JLabel("Elección de Alumno");

        pTitulo.add(lTitulo);
        pEleccionAlumno.add(ltituloEleccion);

        ltituloEleccionEmp = new JLabel("Elección de Empresa");
        pEleccionEmpresa.add(ltituloEleccionEmp);

        ltituloEleccionTut = new JLabel("Elección de Tutor");
        pEleccionTutor.add(ltituloEleccionTut);

        cbAlumnos = new JComboBox();
        cbEmpresas = new JComboBox();
        cbTutores = new JComboBox();

        pEleccionAlumno.add(cbAlumnos);
        pEleccionEmpresa.add(cbEmpresas);
        pEleccionTutor.add(cbTutores);

        bConfirm = new JButton("Confirmar");
        pBoton.add(bConfirm);

        pMensaje = new JPanel();
        lMensaje = new JLabel("");
        lMensaje.setOpaque(true);
        lMensaje.setBackground(Color.lightGray);
        pMensaje.setBorder(new EmptyBorder(15,0,5,0));
        pMensaje.add(lMensaje);


        // Líneas para el JLabel inferior
        LineBorder line = new LineBorder(Color.white, 2, true);
        lMensaje.setBorder(line);

        // Tabla
        ptablaAsignacion = new JPanel();
        Border bordeBlanco = BorderFactory.createLineBorder(Color.white);
        Border bordeTablaEmpresa = BorderFactory.createTitledBorder(
                bordeBlanco, "Reflejo de la Base de Datos",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION);
        ptablaAsignacion.setBorder(bordeTablaEmpresa);

        // Añadimos al panel principal
        principal = new JPanel(new GridLayout(1,2));
        izquierdo = new JPanel(new GridLayout(5,0));
        derecho = new JPanel(new BorderLayout(1,1));
        derecho.setPreferredSize(new Dimension(10,10));

        izquierdo.add(pEleccionAlumno);
        izquierdo.add(pEleccionEmpresa);
        izquierdo.add(pEleccionTutor);
        izquierdo.add(pBoton);

        derecho.add(ptablaAsignacion);


        principal.add(izquierdo);
        principal.add(derecho);

        add(pTitulo);
        add(principal);
        add(pMensaje);



        /*add(pTitulo);
        add(pEleccionAlumno);
        add(pEleccionEmpresa);
        add(pEleccionTutor);
        add(pBoton);
        add(pMensaje);*/


    }


}
