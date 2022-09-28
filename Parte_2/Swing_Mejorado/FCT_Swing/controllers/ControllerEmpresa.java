package controllers;

import models.ConexionBD;
import models.Empresa;
import views.ViewEmpresa;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.*;

public class ControllerEmpresa {

    private final ViewEmpresa viewEmpresa;
    private final ConexionBD cbd;

    public ControllerEmpresa(ViewEmpresa vistaEmpresa, ConexionBD cbd) {
        this.viewEmpresa = vistaEmpresa;
        this.cbd = cbd;
        controllerInsert();
        controllerUpdate();
        controllerDelete();
        controllerTabbedPane();
        controllerTablaEmpresa();
        setDefaultTFs();

    }

    public void setDefaultTFs() {
        Object currentCode = null;
        try {
            Statement s = cbd.conectar().createStatement();
            ResultSet rs = s.executeQuery("SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES " +
                    "WHERE TABLE_SCHEMA = 'bdgestionfct' AND   TABLE_NAME   = 'empresas'");
            if (rs.next()) {
                currentCode = rs.getObject("AUTO_INCREMENT");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        viewEmpresa.tfCodEmpresa.setText(currentCode.toString());
        viewEmpresa.tfCifEmpresa.setText("");
        viewEmpresa.tfNombreEmpresa.setText("");
        viewEmpresa.tfDirecEmpresa.setText("");
        viewEmpresa.tfCodPostalEmpresa.setText("");
        viewEmpresa.tfLocalidadEmpresa.setText("");
        viewEmpresa.cbJornadaEmpresa.setSelectedItem("Partida");
        viewEmpresa.cbModalidadEmpresa.setSelectedItem("Presencial");
        viewEmpresa.tfMailEmpresa.setText("");
        viewEmpresa.tfDniRepLegal.setText("");
        viewEmpresa.tfNombreRL.setText("");
        viewEmpresa.tfApellidosRL.setText("");
        viewEmpresa.tfDniTutLaboral.setText("");
        viewEmpresa.tfNombreTL.setText("");
        viewEmpresa.tfApellidosTL.setText("");
        viewEmpresa.tfTelefonoTL.setText("");
    }

    public void controllerInsert() {
        viewEmpresa.bInsert.addActionListener(e -> {

                try {
                    Connection conexion = cbd.conectar();
                    try {
                        PreparedStatement ps = conexion.prepareStatement
                                ("INSERT INTO EMPRESAS " +
                                        "(CIF, Nombre, Direccion, CP, Localidad, Jornada, Modalidad" +
                                        ",Mail, DNI_RL, Nombre_RL, Apellidos_RL, DNI_TL" +
                                        ", Nombre_TL, Apellidos_TL, Tlfn_TL) " +
                                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                        setStatement(ps);

                        if (ps.executeUpdate() == 1) {
                            JOptionPane.showMessageDialog(viewEmpresa.pPrincipal, "Empresa registrada correctamente");
                            controllerTablaEmpresa();
                            ControllerAsignacion.datosEmpresa();
                            setDefaultTFs();
                        } else {
                            JOptionPane.showMessageDialog(viewEmpresa.pPrincipal, ("No se ha podido registrar la empresa"));
                        }
                        controllerTablaEmpresa();
                        ps.close();
                    } catch (Exception ee) {
                        System.out.println(ee.getClass());
                    }
                    conexion.close();

                } catch (SQLException xx) {
                    xx.printStackTrace();
                }

        });
    }

    public void controllerUpdate() {
        viewEmpresa.bUpdate.addActionListener(e -> {
            try {
                Connection conexion = cbd.conectar();
                try {
                    PreparedStatement ps = conexion.prepareStatement
                            ("UPDATE empresas SET CIF = ?, Nombre = ?, Direccion = ?, CP = ?, Localidad = ?, Jornada = ?," +
                                    "Modalidad = ?, Mail = ?, DNI_RL = ?, Nombre_RL = ?, Apellidos_RL = ?, DNI_TL = ?," +
                                    "Nombre_TL = ?, Apellidos_TL = ?, Tlfn_TL = ? WHERE Cod_Empresas = ?");

                    setStatement(ps);
                    ps.setString(16, viewEmpresa.tfCodEmpresa.getText());
                    System.out.println(ps);

                    if (ps.executeUpdate() == 1) {
                        JOptionPane.showMessageDialog(viewEmpresa.pPrincipal, "Empresa modificada correctamente");
                        controllerTablaEmpresa();
                        setDefaultTFs();
                    } else {
                        JOptionPane.showMessageDialog(viewEmpresa.pPrincipal, ("No se ha podido modificar la empresa"));
                    }
                    controllerTablaEmpresa();
                    ps.close();
                } catch (Exception ee) {
                    System.out.println(ee.getClass());
                }
                conexion.close();

            } catch (SQLException xx) {
                xx.printStackTrace();
            }
        });
    }

    public void controllerDelete(){
        viewEmpresa.bDelete.addActionListener(e -> {
            try {
                Connection conexion = cbd.conectar();
                try {
                    PreparedStatement ps = conexion.prepareStatement
                            ("DELETE FROM empresas WHERE Cod_Empresas = ?");
                    ps.setString(1, viewEmpresa.tfCodEmpresa.getText());

                    if (ps.executeUpdate() == 1) {
                        JOptionPane.showMessageDialog(viewEmpresa.pPrincipal, "Empresa eliminada correctamente");
                        controllerTablaEmpresa();
                        setDefaultTFs();
                    } else {
                        JOptionPane.showMessageDialog(viewEmpresa.pPrincipal, ("No se ha podido eliminar la empresa"));
                    }
                    controllerTablaEmpresa();
                    ps.close();
                } catch (Exception ee) {
                    System.out.println(ee.getClass());
                }
                conexion.close();

            } catch (SQLException xx) {
                xx.printStackTrace();
            }
        });
    }

    private void setStatement(PreparedStatement ps) throws SQLException {
        ps.setString(1, viewEmpresa.tfCifEmpresa.getText());
        ps.setString(2, viewEmpresa.tfNombreEmpresa.getText());
        ps.setString(3, viewEmpresa.tfDirecEmpresa.getText());
        ps.setString(4, viewEmpresa.tfCodPostalEmpresa.getText());
        ps.setString(5, viewEmpresa.tfLocalidadEmpresa.getText());
        ps.setShort(6, (short) (viewEmpresa.cbJornadaEmpresa.getSelectedIndex() + 1));
        ps.setShort(7, (short) (viewEmpresa.cbModalidadEmpresa.getSelectedIndex() + 1));
        ps.setString(8, viewEmpresa.tfMailEmpresa.getText());
        ps.setString(9, viewEmpresa.tfDniRepLegal.getText());
        ps.setString(10, viewEmpresa.tfNombreRL.getText());
        ps.setString(11, viewEmpresa.tfApellidosRL.getText());
        ps.setString(12, viewEmpresa.tfDniTutLaboral.getText());
        ps.setString(13, viewEmpresa.tfNombreTL.getText());
        ps.setString(14, viewEmpresa.tfApellidosTL.getText());
        ps.setString(15, viewEmpresa.tfTelefonoTL.getText());
    }

    public void controllerTabbedPane() {
        viewEmpresa.pPestanias.addChangeListener(e -> {
            if (viewEmpresa.pPrincipal.isVisible()) {
                viewEmpresa.setSize(new Dimension(1015, 680));
                viewEmpresa.pPestanias.setPreferredSize(new Dimension(1015, 641));
            } else {
                viewEmpresa.setSize(new Dimension(620, 340));
                viewEmpresa.pPestanias.setPreferredSize(new Dimension(620, 301));
            }
        });
    }

    public void controllerTablaEmpresa() {
        try {
            viewEmpresa.pTablaBaseDatos.removeAll();
            Empresa empresa = new Empresa();

            // Atributos
            viewEmpresa.tBaseDatos = new JTable(empresa.getTablaProducto(cbd));

            // columnas
            viewEmpresa.tBaseDatos.getColumnModel().getColumn(0).setPreferredWidth(80);
            viewEmpresa.tBaseDatos.getColumnModel().getColumn(1).setPreferredWidth(80);
            viewEmpresa.tBaseDatos.getColumnModel().getColumn(2).setPreferredWidth(80);
            viewEmpresa.tBaseDatos.getColumnModel().getColumn(3).setPreferredWidth(35);
            viewEmpresa.tBaseDatos.getColumnModel().getColumn(4).setPreferredWidth(85);
            viewEmpresa.tBaseDatos.getColumnModel().getColumn(5).setPreferredWidth(80);
            viewEmpresa.tBaseDatos.getColumnModel().getColumn(6).setPreferredWidth(100);
            viewEmpresa.tBaseDatos.getColumnModel().getColumn(7).setPreferredWidth(90);


            ListSelectionModel listModel = viewEmpresa.tBaseDatos.getSelectionModel();
            listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listModel.addListSelectionListener(e -> {
                int[] sel;
                Object value = null;
                if (!e.getValueIsAdjusting()) {
                    sel = viewEmpresa.tBaseDatos.getSelectedRows();
                    TableModel tm = viewEmpresa.tBaseDatos.getModel();
                    value = tm.getValueAt(sel[0], 8);
                    System.out.println(value);
                }
                try {
                    Statement s = cbd.conectar().createStatement();
                    ResultSet rs = s.executeQuery("select * from empresas where Cod_Empresas = " + value);
                    if (rs.next()) {

                        viewEmpresa.tfCodEmpresa.setText(rs.getObject(1).toString());
                        viewEmpresa.tfCifEmpresa.setText(rs.getObject(2).toString());
                        viewEmpresa.tfNombreEmpresa.setText(rs.getObject(3).toString());
                        viewEmpresa.tfDirecEmpresa.setText(rs.getObject(4).toString());
                        viewEmpresa.tfCodPostalEmpresa.setText(rs.getObject(5).toString());
                        viewEmpresa.tfLocalidadEmpresa.setText(rs.getObject(6).toString());
                        viewEmpresa.cbJornadaEmpresa.setSelectedItem(rs.getObject(7).toString());
                        viewEmpresa.cbModalidadEmpresa.setSelectedItem(rs.getObject(8).toString());
                        viewEmpresa.tfMailEmpresa.setText(rs.getObject(9).toString());
                        viewEmpresa.tfDniRepLegal.setText(rs.getObject(10).toString());
                        viewEmpresa.tfNombreRL.setText(rs.getObject(11).toString());
                        viewEmpresa.tfApellidosRL.setText(rs.getObject(12).toString());
                        viewEmpresa.tfDniTutLaboral.setText(rs.getObject(13).toString());
                        viewEmpresa.tfNombreTL.setText(rs.getObject(14).toString());
                        viewEmpresa.tfApellidosTL.setText(rs.getObject(15).toString());
                        viewEmpresa.tfTelefonoTL.setText(rs.getObject(16).toString());
                    }


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });

            viewEmpresa.tablaEmpresa = new JScrollPane(viewEmpresa.tBaseDatos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            viewEmpresa.tBaseDatos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            //viewEmpresa.tablaEmpresa.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            viewEmpresa.tablaEmpresa.setPreferredSize(new Dimension(450, 490));
            viewEmpresa.pTablaBaseDatos.add(viewEmpresa.tablaEmpresa);
            viewEmpresa.pTablaBaseDatos.updateUI();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
