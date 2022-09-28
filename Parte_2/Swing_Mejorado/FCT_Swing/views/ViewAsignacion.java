package views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ViewAsignacion extends JPanel {
    JPanel pTitulo;
    JPanel pEleccionAlumno;
    JPanel pEleccionEmpresa;
    JPanel pEleccionTutor;
    JLabel lTitulo;
    JLabel ltituloEleccion;
    JLabel ltituloEleccionEmp;
    JLabel ltituloEleccionTut;
    JPanel pMensaje;
    public JButton bConfirm;
    JPanel pBoton;
    public JComboBox cbAlumnos;
    public JComboBox cbEmpresas;
    public JComboBox cbTutores;
    public JLabel lMensaje;

    public ViewAsignacion(){
        super();
        setSize(620, 340);
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
        pMensaje.add(lMensaje);


        // Líneas para el JLabel inferior
        LineBorder line = new LineBorder(Color.white, 2, true);
        lMensaje.setBorder(line);

        // Añadimos al panel principal
        add(pTitulo);
        add(pEleccionAlumno);
        add(pEleccionEmpresa);
        add(pEleccionTutor);
        add(pBoton);
        add(pMensaje);


    }


}
