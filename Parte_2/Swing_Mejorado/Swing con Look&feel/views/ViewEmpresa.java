package views;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.SQLException;

public class ViewEmpresa extends JFrame {


    public JTabbedPane pPestanias; // Panel general de la interfaz
    public JPanel pPrincipalPrimero; // Panel general de la vista
    // Título
    JPanel pTitulo;
    JLabel lTitulo;
    // Datos de la empresa
    JPanel pDatosEmpresa;
    JPanel pDatosEmpresaSup;
    JLabel lCodEmpresa;
    public JTextField tfCodEmpresa;
    JLabel lCifEmpresa;
    public JTextField tfCifEmpresa;
    JLabel lNombreEmpresa;
    public JTextField tfNombreEmpresa;
    JPanel pDatosEmpresaMid;
    JLabel lDirecEmpresa;
    public JTextField tfDirecEmpresa;
    JLabel lCodPostalEmpresa;
    public JTextField tfCodPostalEmpresa;
    JLabel lLocalidadEmpresa;
    public JTextField tfLocalidadEmpresa;
    JPanel pDatosEmpresaInf;
    JLabel lJornadaEmpresa;
    public JComboBox<String> cbJornadaEmpresa;
    JLabel lModalidadEmpresa;
    public JComboBox<String> cbModalidadEmpresa;
    JLabel lMailEmpresa;
    public JTextField tfMailEmpresa;
    // Sección Personas / Botones / Tabla BBDD
    JPanel pPrincipalSegundo; // Panel general de la sección
    // Personas
    JPanel pPersonas;
    JPanel pPersonasSup;
    JLabel lDniRepLegal;
    public JTextField tfDniRepLegal;
    JLabel lNombreRL;
    public JTextField tfNombreRL;
    JLabel lApellidosRL;
    public JTextField tfApellidosRL;
    JPanel pPersonasMid;
    JLabel lDniTutLaboral;
    public JTextField tfDniTutLaboral;
    JLabel lNombreTL;
    public JTextField tfNombreTL;
    JLabel lApellidosTL;
    public JTextField tfApellidosTL;
    JLabel lTelefonoTL;
    public JTextField tfTelefonoTL;
    // Botones
    JPanel pBotones;
    public JButton bInsert;
    public JButton bUpdate;
    public JButton bDelete;
    // Tabla BBDD
    public JPanel pTablaBaseDatos;
    public JTable tBaseDatos;
    public JScrollPane tablaEmpresa;

    public ViewAlumnos viewAlumnos;
    public ViewTutores viewTutores;
    public ViewAsignacion viewAsignacion;

    public ViewEmpresa() throws SQLException{
        try {
            UIManager.setLookAndFeel ( new FlatDarculaLaf()) ;
        } catch ( Exception e ) {
            e.printStackTrace ( ) ;
        }

        // Título principal del programa
        lTitulo = new JLabel("GESTIÓN DE DATOS DE EMPRESAS");
        lTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        pTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        pTitulo.add(lTitulo);

        // Elementos del panel para los datos de las empresas
        JPanel pCodEmpresa = new JPanel();
        JPanel pCifEmpresa = new JPanel();
        JPanel pNombreEmpresa = new JPanel();
        JPanel pDirecEmpresa = new JPanel();
        JPanel pCodPostalEmpresa = new JPanel();
        JPanel pLocalidad = new JPanel();
        JPanel pJornada = new JPanel();
        JPanel pModalidad = new JPanel();
        JPanel pMailEmpresa = new JPanel();

        lCodEmpresa = new JLabel("Código Empresa: ");
        tfCodEmpresa = new JTextField();
        tfCodEmpresa.setHorizontalAlignment(0);
        tfCodEmpresa.setEditable(false);
        tfCodEmpresa.setBorder(BorderFactory.createLineBorder(Color.white));
        pCodEmpresa.add(lCodEmpresa);
        pCodEmpresa.add(tfCodEmpresa);
        tfCodEmpresa.setPreferredSize(new Dimension(40,20));

        lCifEmpresa = new JLabel("CIF: ");
        tfCifEmpresa = new JTextField();
        tfCifEmpresa.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        pCifEmpresa.add(lCifEmpresa);
        pCifEmpresa.add(tfCifEmpresa);
        tfCifEmpresa.setPreferredSize(new Dimension(130,20));

        lNombreEmpresa = new JLabel("Nombre: ");
        tfNombreEmpresa = new JTextField();
        tfNombreEmpresa.setPreferredSize(new Dimension(410,20));
        pNombreEmpresa.add(lNombreEmpresa);
        pNombreEmpresa.add(tfNombreEmpresa);

        lDirecEmpresa = new JLabel("Dirección: ");
        tfDirecEmpresa = new JTextField();
        tfDirecEmpresa.setPreferredSize(new Dimension(260,20));
        pDirecEmpresa.add(lDirecEmpresa);
        pDirecEmpresa.add(tfDirecEmpresa);

        lCodPostalEmpresa = new JLabel("C.P.: ");
        tfCodPostalEmpresa = new JTextField();
        tfCodPostalEmpresa.setPreferredSize(new Dimension(90,20));
        pCodPostalEmpresa.add(lCodPostalEmpresa);
        pCodPostalEmpresa.add(tfCodPostalEmpresa);

        lLocalidadEmpresa = new JLabel("Localidad: ");
        tfLocalidadEmpresa = new JTextField();
        tfLocalidadEmpresa.setPreferredSize(new Dimension(210,20));
        pLocalidad.add(lLocalidadEmpresa);
        pLocalidad.add(tfLocalidadEmpresa);

        lJornadaEmpresa = new JLabel("Jornada: ");
        cbJornadaEmpresa = new JComboBox<>();
        cbJornadaEmpresa.addItem("Partida");
        cbJornadaEmpresa.addItem("Continua");
        pJornada.add(lJornadaEmpresa);
        pJornada.add(cbJornadaEmpresa);

        lModalidadEmpresa = new JLabel("Modalidad: ");
        cbModalidadEmpresa = new JComboBox<>();
        cbModalidadEmpresa.addItem("Presencial");
        cbModalidadEmpresa.addItem("Semipresencial");
        cbModalidadEmpresa.addItem("Distancia");
        pModalidad.add(lModalidadEmpresa);
        pModalidad.add(cbModalidadEmpresa);

        lMailEmpresa = new JLabel("Mail: ");
        tfMailEmpresa = new JTextField();
        tfMailEmpresa.setPreferredSize(new Dimension(240,20));
        pMailEmpresa.add(lMailEmpresa);
        pMailEmpresa.add(tfMailEmpresa);

        // Panel general para gestionar los datos de empresa
        pDatosEmpresa = new JPanel(new GridLayout(3, 1));
        // Se añaden características al panel de empresa
        Border bordeAzul = BorderFactory.createLineBorder(Color.white);
        Border bordeEmpresa = BorderFactory.createTitledBorder(
                bordeAzul, "Empresa",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION);
        pDatosEmpresa.setBorder(bordeEmpresa);
        pDatosEmpresa.setSize(new Dimension(670, 200));

        // Subpanel superior del panel de empresa
        pDatosEmpresaSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        pDatosEmpresaSup.add(pCodEmpresa);
        pDatosEmpresaSup.add(pCifEmpresa);
        pDatosEmpresaSup.add(pNombreEmpresa);

        // Subpanel medio del panel de empresa
        pDatosEmpresaMid = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));
        pDatosEmpresaMid.add(pDirecEmpresa);
        pDatosEmpresaMid.add(pCodPostalEmpresa);
        pDatosEmpresaMid.add(pLocalidad);

        // Subpanel inferior del panel de empresa
        pDatosEmpresaInf = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));
        pDatosEmpresaInf.add(pJornada);
        pDatosEmpresaInf.add(pModalidad);
        pDatosEmpresaInf.add(pMailEmpresa);

        // Se añaden los subpaneles al panel de empresa
        pDatosEmpresa.add(pDatosEmpresaSup, BorderLayout.NORTH);
        pDatosEmpresa.add(pDatosEmpresaMid, BorderLayout.CENTER);
        pDatosEmpresa.add(pDatosEmpresaInf, BorderLayout.SOUTH);

        // Panel para gestionar las personas (empleados)
        pPersonas = new JPanel(new BorderLayout(5,15));
        // Se añaden las características al panel personas
        Border bordePersonas = BorderFactory.createTitledBorder(
                bordeAzul, "Personas",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION);
        pPersonas.setBorder(BorderFactory.createCompoundBorder(bordePersonas, BorderFactory.createEmptyBorder(5,5,10,5)));

        // Subpaneles para el panel personas
        pPersonasSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));
        pPersonasMid = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));

        // Todos los elementos para el panel personas, divididos en cada subpanel
        // Subpanel superior para personas
        lDniRepLegal = new JLabel("DNI Rep. Legal: ");
        tfDniRepLegal = new JTextField();
        tfDniRepLegal.setPreferredSize(new Dimension(130,20));

        lNombreRL = new JLabel("Nombre RL:");
        tfNombreRL = new JTextField();
        tfNombreRL.setPreferredSize(new Dimension(130,20));

        lApellidosRL = new JLabel("Apellidos RL:");
        tfApellidosRL = new JTextField();
        tfApellidosRL.setPreferredSize(new Dimension(130,20));

        pPersonasSup.add(lDniRepLegal);
        pPersonasSup.add(tfDniRepLegal);
        pPersonasSup.add(lNombreRL);
        pPersonasSup.add(tfNombreRL);
        pPersonasSup.add(lApellidosRL);
        pPersonasSup.add(tfApellidosRL);

        // Subpanel inferior para personas
        lDniTutLaboral = new JLabel("DNI Tut. Laboral: ");
        tfDniTutLaboral = new JTextField();
        tfDniTutLaboral.setPreferredSize(new Dimension(130,20));

        lNombreTL = new JLabel("Nombre TL: ");
        tfNombreTL = new JTextField();
        tfNombreTL.setPreferredSize(new Dimension(130,20));

        lApellidosTL = new JLabel("Apellidos TL: ");
        tfApellidosTL = new JTextField();
        tfApellidosTL.setPreferredSize(new Dimension(130,20));

        lTelefonoTL = new JLabel("Tlf. TL:");
        tfTelefonoTL = new JTextField();
        tfTelefonoTL.setPreferredSize(new Dimension(130,20));

        pPersonasMid.add(lDniTutLaboral);
        pPersonasMid.add(tfDniTutLaboral);
        pPersonasMid.add(lNombreTL);
        pPersonasMid.add(tfNombreTL);
        pPersonasMid.add(lApellidosTL);
        pPersonasMid.add(tfApellidosTL);
        pPersonasMid.add(lTelefonoTL);
        pPersonasMid.add(tfTelefonoTL);

        // Se añaden los subpaneles de personas al panel general de personas
        pPersonas.add(pPersonasSup, BorderLayout.NORTH);
        pPersonas.add(pPersonasMid, BorderLayout.CENTER);

        // Panel para los botones de insertar, modificar y eliminar
        pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,15));
        // Se ajustan las características para el panel de botones
        pBotones.setSize(new Dimension(330, 120));
        pBotones.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createEmptyBorder(10,330,10,330)
                        , BorderFactory.createBevelBorder(BevelBorder.LOWERED)));

        // Se crean y añaden los botones al panel
        bInsert = new JButton("Insertar");
        bUpdate = new JButton("Modificar");
        bDelete = new JButton("Eliminar");
        pBotones.add(bInsert);
        pBotones.add(bUpdate);
        pBotones.add(bDelete);

        // Panel para la tabla empresa de la base de datos
        pTablaBaseDatos = new JPanel();
        pTablaBaseDatos.setLayout(new FlowLayout());

        // Se ajustan las características necesarias
        Border bordeTablaEmpresa = BorderFactory.createTitledBorder(
                bordeAzul, "Reflejo de la Base de Datos",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION);
        pTablaBaseDatos.setBorder(bordeTablaEmpresa);
        pTablaBaseDatos.setPreferredSize(new Dimension(1, 145));

        // Se crean los paneles principales de la aplicación
        pPrincipalPrimero = new JPanel(new BorderLayout(5,15));
        pPrincipalSegundo = new JPanel(new BorderLayout(5,10));

        // Se añaden los paneles correspondientes al panel secundario, que irá introducido en el panel principal
        pPrincipalSegundo.add(pPersonas, BorderLayout.NORTH);
        pPrincipalSegundo.add(pBotones, BorderLayout.CENTER);
        pPrincipalSegundo.add(pTablaBaseDatos, BorderLayout.SOUTH);

        // Se añade el título, el panel de empresa y el panel secundario al panel principal
        pPrincipalPrimero.add(pTitulo, BorderLayout.NORTH);
        pPrincipalPrimero.add(pDatosEmpresa, BorderLayout.CENTER);
        pPrincipalPrimero.add(pPrincipalSegundo, BorderLayout.SOUTH);

        // Se crea el panel para las pestañas superiores
        pPestanias = new JTabbedPane(JTabbedPane.TOP);
        pPestanias.add("Empresa",pPrincipalPrimero);
        // Aquí se añadirá la vista de Alumnos
        viewAlumnos = new ViewAlumnos();
        pPestanias.add("Alumno", viewAlumnos);
        // Aquí se añadirá la vista de Tutores
        viewTutores = new ViewTutores();
        pPestanias.add("Tutores", viewTutores);
        // Aquí se añadirá la vista de Asignación
        viewAsignacion = new ViewAsignacion();
        pPestanias.add("Asignación", viewAsignacion);


        add(pPestanias, BorderLayout.NORTH);
        setTitle("Programa FCT Centro Educativo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1015, 680));
        setResizable(false);
        setVisible(true);
    }

}