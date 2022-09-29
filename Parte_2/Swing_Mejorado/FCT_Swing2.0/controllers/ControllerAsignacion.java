package controllers;

import models.Asignacion;
import models.ConexionBD;
import models.Empresa;
import views.ViewAsignacion;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.time.LocalTime;


public class ControllerAsignacion {

    private static ViewAsignacion viewAsignacion;
    private static ConexionBD cbd;

    public ControllerAsignacion(ViewAsignacion viewAsignacion, ConexionBD cbd) {
        this.viewAsignacion = viewAsignacion;
        this.cbd = cbd;
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
                        while (rsCodAlumno.next()) {
                            codAlumno = rsCodAlumno.getString(1);
                        }

                        ResultSet rsCodEmpresa = s.executeQuery("SELECT Cod_Empresas from Empresas where Nombre = '" + empresa + "'");
                        while (rsCodEmpresa.next()) {
                            codEmpresa = rsCodEmpresa.getString(1);
                        }
                        ResultSet rsCodTutor = s.executeQuery("SELECT Cod_Tutor from tutores_p where Nombre = '" + tutor + "'");
                        while (rsCodTutor.next()) {
                            codTutor = rsCodTutor.getString(1);
                        }

                        PreparedStatement ps = conexion.prepareStatement
                                ("INSERT INTO Asignacion (Cod_Alumno, Cod_Tutor, Cod_Empresas, Fecha_Asignacion) VALUES (?, ?, ?, ?)");
                        String auxTime = String.valueOf(new Timestamp(System.currentTimeMillis()));
                        auxTime = auxTime.substring(0, auxTime.length() - 4);
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


    public void controllerTablaAsignacion() {
        try {
            viewAsignacion.ptablaAsignacion.removeAll();
            Asignacion asignacion = new Asignacion();

            // Atributos
            viewAsignacion.tAlumnos = new JTable(asignacion.getTablaProducto(cbd));

            // columnas
            viewAsignacion.tAlumnos.getColumnModel().getColumn(0).setPreferredWidth(80);
            viewAsignacion.tAlumnos.getColumnModel().getColumn(1).setPreferredWidth(80);
            viewAsignacion.tAlumnos.getColumnModel().getColumn(2).setPreferredWidth(80);

            /*ListSelectionModel listModel = viewAsignacion.tAlumnos.getSelectionModel();
            listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listModel.addListSelectionListener(e -> {
                int[] sel;
                Object value = null;
                if (!e.getValueIsAdjusting()) {
                    sel = viewAsignacion.tAlumnos.getSelectedRows();
                    TableModel tm = viewAsignacion.tAlumnos.getModel();
                    value = tm.getValueAt(sel[0], 2);
                    System.out.println(value);
                }
                try {
                    Statement s = cbd.conectar().createStatement();
                    ResultSet rs = s.executeQuery("select * from asignacion");
                    if (rs.next()) {
                        viewAsignacion.cbAlumnos.getSelectedItem();
                        viewAsignacion.cbEmpresas.getSelectedItem();
                        viewAsignacion.cbTutores.getSelectedItem();
                    }


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });*/

            viewAsignacion.tablaAsignacion = new JScrollPane(viewAsignacion.tAlumnos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            viewAsignacion.tAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            viewAsignacion.tablaAsignacion.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            viewAsignacion.tablaAsignacion.setPreferredSize(new Dimension(450, 490));
            viewAsignacion.ptablaAsignacion.add(viewAsignacion.tablaAsignacion);
            viewAsignacion.ptablaAsignacion.updateUI();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
