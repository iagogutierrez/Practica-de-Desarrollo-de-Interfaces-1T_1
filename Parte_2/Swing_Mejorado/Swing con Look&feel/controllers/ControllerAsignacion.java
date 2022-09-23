package controllers;

import models.ConexionBD;
import views.ViewAsignacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.time.LocalTime;


public class ControllerAsignacion {

    private static ViewAsignacion viewAsignacion = null;
    private static ConexionBD cbd = null;

    public ControllerAsignacion(ViewAsignacion viewAsignacion, ConexionBD cbd) {
        ControllerAsignacion.viewAsignacion = viewAsignacion;
        ControllerAsignacion.cbd = cbd;
        datosAlumnos();
        datosEmpresa();
        datosTutores();
        controllerConfirmar();
    }

    public static void datosAlumnos() {
        try {
            Statement s = cbd.conectar().createStatement();
            ResultSet rs = s.executeQuery("select * from alumnos");

            String auxApellido;
            String auxNombre;
            while (rs.next()) {
                byte[] dataApellido = rs.getBytes("Apellidos");
                auxApellido = new String(dataApellido, StandardCharsets.UTF_8);
                byte[] dataNombre = rs.getBytes("Nombre");
                auxNombre = new String(dataNombre, StandardCharsets.UTF_8);
                viewAsignacion.cbAlumnos.addItem(auxApellido + ", " + auxNombre);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void datosEmpresa() {
        try {
            Statement s = cbd.conectar().createStatement();
            ResultSet rs = s.executeQuery("select * from empresas");

            String auxNombre;
            while (rs.next()) {
                byte[] dataNombre = rs.getBytes("Nombre");
                auxNombre = new String(dataNombre, StandardCharsets.UTF_8);
                viewAsignacion.cbEmpresas.addItem(auxNombre);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void datosTutores() {
        try {
            Statement s = cbd.conectar().createStatement();
            ResultSet rs = s.executeQuery("select * from tutores_p");

            String auxNombre;
            while (rs.next()) {
                byte[] dataNombre = rs.getBytes("Nombre");
                auxNombre = new String(dataNombre, StandardCharsets.UTF_8);
                viewAsignacion.cbTutores.addItem(auxNombre);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void controllerConfirmar() {
        viewAsignacion.bConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conexion = cbd.conectar();

                    String alumno = viewAsignacion.cbAlumnos.getSelectedItem().toString();
                    String[] apellidoAux = alumno.split(",");
                    String codAlumno = null;
                    String empresa = viewAsignacion.cbEmpresas.getSelectedItem().toString();
                    String codEmpresa = null;
                    String tutor = viewAsignacion.cbTutores.getSelectedItem().toString();
                    String codTutor = null;

                    try {
                        Statement s = conexion.createStatement();
                        ResultSet rsCodAlumno = s.executeQuery("SELECT Cod_Alumno from Alumnos where Apellidos = '" + apellidoAux[0] + "'");
                        while(rsCodAlumno.next()){
                            codAlumno = rsCodAlumno.getString(1);
                        }

                        ResultSet rsCodEmpresa = s.executeQuery("SELECT Cod_Empresas from Empresas where Nombre = '" + empresa + "'");
                        while(rsCodEmpresa.next()){
                            codEmpresa = rsCodEmpresa.getString(1);
                        }
                        ResultSet rsCodTutor = s.executeQuery("SELECT Cod_Tutor from tutores_p where Nombre = '" + tutor + "'");
                        while(rsCodTutor.next()){
                            codTutor = rsCodTutor.getString(1);
                        }

                        PreparedStatement ps = conexion.prepareStatement
                                ("INSERT INTO Asignacion (Cod_Alumno, Cod_Tutor, Cod_Empresas, Fecha_Asignacion) VALUES (?, ?, ?, ?)");
                        String auxTime = String.valueOf(new Timestamp(System.currentTimeMillis()));
                        auxTime = auxTime.substring(0, auxTime.length()-4);
                        ps.setString(1, codAlumno);
                        ps.setString(2, codTutor);
                        ps.setString(3, codEmpresa);
                        ps.setString(4, auxTime);
                        System.out.println(ps);

                        if (ps.executeUpdate() == 1) {
                            ResultSet rsTutorLaboral = s.executeQuery("SELECT Nombre_TL, Apellidos_TL from " +
                                    "empresas where Nombre = '" + empresa + "'");
                            String nombreTL = null;
                            String apellidoTL = null;
                            while (rsTutorLaboral.next()) {
                                nombreTL = rsTutorLaboral.getString(1);
                                apellidoTL = rsTutorLaboral.getString(2);
                            }

                            String mensaje = "<html> <p style=\"text-align:center\">El alumno " + alumno + " queda asignado a la empresa "
                                    + empresa + "<br/> supervisado por el tutor docente " + tutor +
                                    " y por el tutor laboral " + nombreTL + " " + apellidoTL + ".</p> </html>";
                            viewAsignacion.lMensaje.setText(mensaje);
                        } else {
                            JOptionPane.showMessageDialog(viewAsignacion, ("No se ha podido registrar la asignación"));
                        }

                        ps.close();
                    } catch (Exception ee) {
                        System.out.println(ee.getClass());
                    }

                    conexion.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

}
