package views;

import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.sql.SQLException;

public class ViewEmpresa extends JFrame {


    public JTabbedPane pPestanias; // Panel general de la interfaz
    public JPanel pPrincipal; // Panel general de la vista
    JPanel pPrincipalPrimero;
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
    JPanel pDatosEmpresaMid1;
    JPanel pDatosEmpresaMid2;
    JLabel lDirecEmpresa;
    public JTextField tfDirecEmpresa;
    JLabel lCodPostalEmpresa;
    public JTextField tfCodPostalEmpresa;
    JLabel lLocalidadEmpresa;
    public JTextField tfLocalidadEmpresa;
    JPanel pDatosEmpresaInf1;
    JPanel pDatosEmpresaInf2;
    JLabel lJornadaEmpresa;
    public JComboBox<String> cbJornadaEmpresa;
    JLabel lModalidadEmpresa;
    public JComboBox<String> cbModalidadEmpresa;
    JLabel lMailEmpresa;
    public JTextField tfMailEmpresa;
    // Sección Personas / Botones / Tabla BBDD
    JPanel pPrincipalSegundo; // Panel general de la sección
    JPanel pPrincipalTabla;
    // Personas

    JLabel lTutLegal;
    JPanel pPersonas;
    JLabel lDniRepLegal;
    public JTextField tfDniRepLegal;
    JLabel lNombreRL;
    public JTextField tfNombreRL;
    JLabel lApellidosRL;
    public JTextField tfApellidosRL;
    JPanel pPersonasSup,pPersonasSup1,pPersonasSup2,pPersonasSup3;
    JPanel pPersonasMid,pPersonasMid1,pPersonasMid2,pPersonasMid3;
    JLabel lRepLegal;
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
        lTitulo.setForeground(Color.white);
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

        Border bordeTextos = BorderFactory.createLineBorder(Color.white);

        lCodEmpresa = new JLabel("Código Empresa: ");
        tfCodEmpresa = new JTextField();
        tfCodEmpresa.setHorizontalAlignment(0);
        tfCodEmpresa.setEditable(false);
        tfCodEmpresa.setBorder(bordeTextos);
        pCodEmpresa.add(lCodEmpresa);
        pCodEmpresa.add(tfCodEmpresa);
        tfCodEmpresa.setPreferredSize(new Dimension(40,20));

        lCifEmpresa = new JLabel("CIF: ");
        tfCifEmpresa = new JTextField();
        tfCifEmpresa.setBorder(bordeTextos);
        pCifEmpresa.add(lCifEmpresa);
        pCifEmpresa.add(tfCifEmpresa);
        tfCifEmpresa.setPreferredSize(new Dimension(130,20));

        lNombreEmpresa = new JLabel("Nombre: ");
        tfNombreEmpresa = new JTextField();
        tfNombreEmpresa.setBorder(bordeTextos);
        tfNombreEmpresa.setPreferredSize(new Dimension(380,20));
        pNombreEmpresa.add(lNombreEmpresa);
        lNombreEmpresa.setBorder(new EmptyBorder(0,0,0,14));
        pNombreEmpresa.add(tfNombreEmpresa);


        lDirecEmpresa = new JLabel("Dirección: ");
        tfDirecEmpresa = new JTextField();
        tfDirecEmpresa.setBorder(bordeTextos);
        tfDirecEmpresa.setPreferredSize(new Dimension(220,20));
        pDirecEmpresa.add(lDirecEmpresa);
        lDirecEmpresa.setBorder(new EmptyBorder(0,0,0,7));
        pDirecEmpresa.add(tfDirecEmpresa);

        lCodPostalEmpresa = new JLabel("C.P.: ");
        tfCodPostalEmpresa = new JTextField();
        tfCodPostalEmpresa.setBorder(bordeTextos);
        tfCodPostalEmpresa.setPreferredSize(new Dimension(100,20));
        pCodPostalEmpresa.add(lCodPostalEmpresa);
        pCodPostalEmpresa.add(tfCodPostalEmpresa);

        lLocalidadEmpresa = new JLabel("Localidad: ");
        tfLocalidadEmpresa = new JTextField();
        tfLocalidadEmpresa.setBorder(bordeTextos);
        tfLocalidadEmpresa.setPreferredSize(new Dimension(100,20));
        pLocalidad.add(lLocalidadEmpresa);
        pLocalidad.add(tfLocalidadEmpresa);

        lJornadaEmpresa = new JLabel("Jornada: ");
        cbJornadaEmpresa = new JComboBox<>();
        cbJornadaEmpresa.setBorder(bordeTextos);
        cbJornadaEmpresa.addItem("Partida");
        cbJornadaEmpresa.addItem("Continua");
        pJornada.add(lJornadaEmpresa);

        pJornada.add(cbJornadaEmpresa);
        cbJornadaEmpresa.setPreferredSize(new Dimension(100,20));
        lJornadaEmpresa.setBorder(new EmptyBorder(0,0,0,10));

        lModalidadEmpresa = new JLabel("Modalidad: ");
        cbModalidadEmpresa = new JComboBox<>();
        cbModalidadEmpresa.setBorder(bordeTextos);
        cbModalidadEmpresa.addItem("Presencial");
        cbModalidadEmpresa.addItem("Semipresencial");
        cbModalidadEmpresa.addItem("Distancia");
        cbModalidadEmpresa.setPreferredSize(new Dimension(190,20));
        pModalidad.add(lModalidadEmpresa);
        pModalidad.add(cbModalidadEmpresa);


        lMailEmpresa = new JLabel("Mail: ");
        tfMailEmpresa = new JTextField();
        tfMailEmpresa.setBorder(bordeTextos);
        tfMailEmpresa.setPreferredSize(new Dimension(190,20));
        pMailEmpresa.add(lMailEmpresa);
        lMailEmpresa.setBorder(new EmptyBorder(0,0,0,34));
        pMailEmpresa.add(tfMailEmpresa);

        // Panel general para gestionar los datos de empresa
        pDatosEmpresa = new JPanel(new GridLayout(5,1));
        // Se añaden características al panel de empresa
        Border bordeBlanco = BorderFactory.createLineBorder(Color.white);
        Border bordeEmpresa = BorderFactory.createTitledBorder(
                bordeBlanco, "Empresa",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION);
        pDatosEmpresa.setBorder(bordeEmpresa);

        // Subpanel superior del panel de empresa
        pDatosEmpresaSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));
        pDatosEmpresaSup.add(pCodEmpresa);
        pDatosEmpresaSup.add(pCifEmpresa);

        // Subpanel medio 1 del panel de empresa
        pDatosEmpresaMid1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));
        pDatosEmpresaMid1.add(pNombreEmpresa);

        // Subpanel medio 2 del panel de empresa
        pDatosEmpresaMid2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));
        pDatosEmpresaMid2.add(pDirecEmpresa);
        pDatosEmpresaMid2.add(pCodPostalEmpresa);

        // Subpanel inferior 1 del panel de empresa
        pDatosEmpresaInf1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));
        pDatosEmpresaInf1.add(pMailEmpresa);
        pDatosEmpresaInf1.add(pLocalidad);

        // Subpanel inferior 2 del panel de empresa
        pDatosEmpresaInf2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));
        pDatosEmpresaInf2.add(pModalidad);
        pDatosEmpresaInf2.add(pJornada);

        // Se añaden los subpaneles al panel de empresa
        pDatosEmpresa.add(pDatosEmpresaSup, BorderLayout.NORTH);
        pDatosEmpresa.add(pDatosEmpresaMid1, BorderLayout.CENTER);
        pDatosEmpresa.add(pDatosEmpresaMid2, BorderLayout.CENTER);
        pDatosEmpresa.add(pDatosEmpresaInf1, BorderLayout.SOUTH);
        pDatosEmpresa.add(pDatosEmpresaInf2, BorderLayout.SOUTH);

        // Se añaden los subpaneles al panel de empresa
        pDatosEmpresa.add(pDatosEmpresaSup, BorderLayout.NORTH);
        pDatosEmpresa.add(pDatosEmpresaMid1, BorderLayout.CENTER);
        pDatosEmpresa.add(pDatosEmpresaMid2, BorderLayout.CENTER);
        pDatosEmpresa.add(pDatosEmpresaInf1, BorderLayout.SOUTH);
        pDatosEmpresa.add(pDatosEmpresaInf2, BorderLayout.SOUTH);

        // Panel para gestionar las personas (empleados)
        pPersonas = new JPanel(new BorderLayout(5,15));
        //pPersonas.setBackground(Color.MAGENTA);
        // Se añaden las características al panel personas
        Border bordePersonas = BorderFactory.createTitledBorder(
                bordeBlanco, "Personas",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION);
        pPersonas.setBorder(BorderFactory.createCompoundBorder(bordePersonas, BorderFactory.createEmptyBorder(5,5,10,5)));

        // Subpaneles para el panel personas

        pPersonasSup = new JPanel(new FlowLayout(FlowLayout.LEFT, 20,7));
        pPersonasSup = new JPanel(new GridLayout(3,1));
        pPersonasMid = new JPanel(new FlowLayout(FlowLayout.LEFT, 20,7));
        pPersonasMid = new JPanel(new GridLayout(3,1));

        // Todos los elementos para el panel personas, divididos en cada subpanel

        pPersonasSup1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 7));
        pPersonasSup2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));
        pPersonasSup3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));

        // Subpanel superior para personas

        lRepLegal = new JLabel("DATOS DEL REPRESENTANTE LEGAL");

        lDniRepLegal = new JLabel("DNI Rep. Legal: ");
        tfDniRepLegal = new JTextField();
        tfDniRepLegal.setBorder(bordeTextos);
        tfDniRepLegal.setPreferredSize(new Dimension(110,20));
        lDniRepLegal.setBorder(new EmptyBorder(0,0,0,10));

        lNombreRL = new JLabel("Nombre RL:");
        tfNombreRL = new JTextField();
        tfNombreRL.setBorder(bordeTextos);
        tfNombreRL.setPreferredSize(new Dimension(110,20));
        lNombreRL.setBorder(new EmptyBorder(0,0,0,30));

        lApellidosRL = new JLabel("Apellidos RL:");
        tfApellidosRL = new JTextField();
        tfApellidosRL.setBorder(bordeTextos);
        tfApellidosRL.setPreferredSize(new Dimension(120,20));

        // SubPanel superior 1 para Personas (Representante Legal)
        pPersonasSup1.add(lRepLegal);

        // SubPanel superior 2 para Personas (Representante Legal)
        pPersonasSup2.add(lDniRepLegal);
        pPersonasSup2.add(tfDniRepLegal);

        // SubPanel superior 3 para Personas (Representante Legal)
        pPersonasSup3.add(lNombreRL);
        pPersonasSup3.add(tfNombreRL);
        pPersonasSup3.add(lApellidosRL);
        pPersonasSup3.add(tfApellidosRL);

        // Panel Superior para Personas (Representante Legal)
        pPersonasSup.add(pPersonasSup1);
        pPersonasSup.add(pPersonasSup2);
        pPersonasSup.add(pPersonasSup3);


        // Subpanel inferior para personas
        pPersonasMid1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 7));
        pPersonasMid2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));
        pPersonasMid3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 7));

        lTutLegal = new JLabel("DATOS DEL REPRESENTANTE LEGAL");

        lDniTutLaboral = new JLabel("DNI Tut. Laboral: ");
        tfDniTutLaboral = new JTextField();
        tfDniTutLaboral.setBorder(bordeTextos);
        tfDniTutLaboral.setPreferredSize(new Dimension(110,20));

        lNombreTL = new JLabel("Nombre TL: ");
        tfNombreTL = new JTextField();
        tfNombreTL.setBorder(bordeTextos);
        tfNombreTL.setPreferredSize(new Dimension(110,20));
        lNombreTL.setBorder(new EmptyBorder(0,0,0,26));

        lApellidosTL = new JLabel("Apellidos TL: ");
        tfApellidosTL = new JTextField();
        tfApellidosTL.setBorder(bordeTextos);
        tfApellidosTL.setPreferredSize(new Dimension(120,20));

        lTelefonoTL = new JLabel("Tlf. TL:");
        tfTelefonoTL = new JTextField();
        tfTelefonoTL.setBorder(bordeTextos);
        tfTelefonoTL.setPreferredSize(new Dimension(120,20));
        lTelefonoTL.setBorder(new EmptyBorder(0,0,0,35));

        // SubPanel Inferior 1 (Tutor Legal)
        pPersonasMid1.add(lTutLegal);

        // SubPanel Inferior 2 (Tutor Legal)
        pPersonasMid2.add(lDniTutLaboral);
        pPersonasMid2.add(tfDniTutLaboral);
        pPersonasMid2.add(lTelefonoTL);
        pPersonasMid2.add(tfTelefonoTL);

        // SubPanel Inferior 3 (Tutor Legal)
        pPersonasMid3.add(lNombreTL);
        pPersonasMid3.add(tfNombreTL);
        pPersonasMid3.add(lApellidosTL);
        pPersonasMid3.add(tfApellidosTL);

        //Panel Inferior (Tutor Legal)
        pPersonasMid.add(pPersonasMid1);
        pPersonasMid.add(pPersonasMid2);
        pPersonasMid.add(pPersonasMid3);


        // Se añaden los subpaneles de personas al panel general de personas
        pPersonas.add(pPersonasSup, BorderLayout.NORTH);
        pPersonas.add(pPersonasMid, BorderLayout.CENTER);

        // Panel para los botones de insertar, modificar y eliminar
        pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Se ajustan las características para el panel de botones
        pBotones.setBorder(BorderFactory.createCompoundBorder
                (BorderFactory.createEmptyBorder(10,330,10,330), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
        //pBotones.setSize(new Dimension(330, 250));

        // Se crean y añaden los botones al panel
        bInsert = new JButton("Insertar");
        bUpdate = new JButton("Modificar");
        bDelete = new JButton("Eliminar");

        pBotones.add(bInsert);
        pBotones.add(bUpdate);
        pBotones.add(bDelete);

        // Panel para la tabla empresa de la base de datos
        pTablaBaseDatos = new JPanel();

        // Se ajustan las características necesarias
        Border bordeTablaEmpresa = BorderFactory.createTitledBorder(
                bordeBlanco, "Reflejo de la Base de Datos",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION);
        pTablaBaseDatos.setBorder(bordeTablaEmpresa);
        pTablaBaseDatos.setPreferredSize(new Dimension(500, 900));

        // Se crean los paneles principales de la aplicación
        pPrincipal = new JPanel(new BorderLayout(5,15));
        pPrincipalPrimero = new JPanel(new BorderLayout(5,15));
        pPrincipalPrimero.setPreferredSize(new Dimension(500,535));

        pPrincipalSegundo = new JPanel(new BorderLayout(5,10));

        pPrincipalTabla = new JPanel(new BorderLayout(5,15));
        pPrincipalTabla.setPreferredSize(new Dimension(500,535));
        pPrincipalTabla.add(pTablaBaseDatos);

        // Se añaden los paneles correspondientes al panel secundario, que irá introducido en el panel principal
        pPrincipalSegundo.add(pPersonas, BorderLayout.NORTH);
        pPrincipalSegundo.add(pBotones, BorderLayout.CENTER);

        // Se añade el título, el panel de empresa y el panel secundario al panel principal
        pPrincipalPrimero.add(pDatosEmpresa, BorderLayout.NORTH);
        pPrincipalPrimero.add(pPrincipalSegundo, BorderLayout.CENTER);

        pPrincipal.add(pTitulo,BorderLayout.NORTH);
        pPrincipal.add(pPrincipalPrimero,BorderLayout.WEST);
        pPrincipal.add(pPrincipalTabla,BorderLayout.EAST);

        // Se crea el panel para las pestañas superiores
        pPestanias = new JTabbedPane(JTabbedPane.TOP);
        pPestanias.add("Empresa", pPrincipal);
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
        setLocation(190, 35);
        setResizable(false);
        setVisible(true);
    }

}