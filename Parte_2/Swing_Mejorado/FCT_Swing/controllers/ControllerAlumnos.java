package controllers;

import models.Alumno;
import models.ConexionBD;
import views.ViewAlumnos;
import views.ViewEmpresa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerAlumnos {

    ArrayList<Alumno> listAlumnos = new ArrayList<>();
    ViewAlumnos viewAlumnos;
    ConexionBD cbd;

    public ControllerAlumnos(ViewAlumnos viewAlumnos, ConexionBD cbd) throws SQLException {


        this.viewAlumnos = viewAlumnos;
        this.cbd = cbd;
        controllerBotonAlumnos();

        Connection conex = cbd.conectar();
        Statement stmt = conex.createStatement();
        stmt.executeUpdate("DELETE FROM ALUMNOS");
        stmt.close();
        conex.close();
    }

    public void intoValueDatos() throws ClassNotFoundException, SQLException {

        Connection conexion = cbd.conectar();

        PreparedStatement actualiza = conexion.prepareStatement("INSERT INTO ALUMNOS(DNI, Nombre, Apellidos, Fecha_Nac) VALUES( ?, ?, ?, ?) ");


        for (Alumno x:listAlumnos) {
            actualiza.setString(1, x.getDni());
            actualiza.setString(2, x.getNombre());
            actualiza.setString(3, x.getApellidos());

            String fecha = DateTimeFormatter.ofPattern("yyyy,MM,dd").format(LocalDate.parse(x.getFechanacimiento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            actualiza.setString(4, fecha);
            actualiza.executeUpdate();

        }
        actualiza.close();
        conexion.close();
    }


// *******************************************************************************************************

    public void leerfichero() {
        // Se declaran las variables de método para guardar lo leído
        //Cod_alumno
        int cod;
        String dni;
        String nombre;
        String apellidos;
        String fechanacimiento;


        // Se genera el objeto en memoria para trasegar con el fichero
        File fich = new File("src/alumnos2cfs.dat");
        // Se crea el amarre para la "manguera base" que permita leer del fichero
        FileInputStream fis = null;
        // Se crea el amarre pensando en aplicar métodos específicos [readXXX()]
        DataInputStream dis = null;
        try {
            // Se crea la "manguera base" para grabar datos en el fichero
            fis = new FileInputStream(fich);
            // Se crea el envoltorio que aplique a la "manguera base" métodos como readXXX()
            dis = new DataInputStream(fis);
            // Extraemos datos del fichero hasta llegar al final del mismo



            while (dis.available() > 0) {
                cod = dis.readInt();
                dni = dis.readUTF();
                nombre = dis.readUTF();
                apellidos = dis.readUTF();
                fechanacimiento = dis.readUTF();

                Alumno alumnos = new Alumno(cod,dni,nombre,apellidos,fechanacimiento);
                listAlumnos.add(alumnos);

            }

        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
            System.out.println(" ");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
                System.out.println(" ");
            }
        }

    }

    public void controllerBotonAlumnos(){

        viewAlumnos.boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAlumnos.texto.setVisible(true);
                leerfichero();

                try {
                    intoValueDatos();
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
                ControllerAsignacion.datosAlumnos();
                JButton b = (JButton) e.getSource();
                b.setEnabled(false);
            }
        });
    }
}
