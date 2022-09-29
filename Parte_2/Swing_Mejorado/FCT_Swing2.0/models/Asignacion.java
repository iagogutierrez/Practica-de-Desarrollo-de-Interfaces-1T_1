package models;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Asignacion {

    private int eleccAl;
    private int eleccEmpresa;
    private int eleccTutor;

    public Asignacion(){}

    public Asignacion(int eleccAl, int eleccEmpresa, int eleccTutor){
        this.eleccAl = eleccAl;
        this.eleccEmpresa = eleccEmpresa;
        this.eleccTutor = eleccTutor;
    }

    public int getEleccAl() {
        return eleccAl;
    }

    public void setEleccAl(int eleccAl) {
        this.eleccAl = eleccAl;
    }

    public int getEleccEmpresa() {
        return eleccEmpresa;
    }

    public void setEleccEmpresa(int eleccEmpresa) {
        this.eleccEmpresa = eleccEmpresa;
    }

    public int getEleccTutor() {
        return eleccTutor;
    }

    public void setEleccTutor(int eleccTutor) {
        this.eleccTutor = eleccTutor;
    }

    public TableModel getTablaProducto(ConexionBD cbd) {

        String[] columNames = {"Codigo Alumno", "Codigo Tutor", "Codigo Empresa",};
        TableModel model = null;
        try {
            Statement s = cbd.conectar().createStatement();
            ResultSet rsAux = s.executeQuery("select count(*) from asignacion");
            rsAux.next();
            int rows = rsAux.getInt(1); // Conseguir número de filas de la tabla Empresas

            ResultSet rs = s.executeQuery("select cod_Alumno, Cod_Tutor, Cod_Empresas from asignacion");
            Object[][] resultSet = new Object[rows][3];
            int row = 0;
            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    resultSet[row][i] = rs.getObject(i + 1);
                }
                row++;
            }

            model = new AbstractTableModel() {
                public int getColumnCount() {
                    return columNames.length;
                }

                public int getRowCount() {
                    return resultSet.length;
                }

                public Object getValueAt(int row, int col) {
                    return resultSet[row][col];
                }

                public String getColumnName(int column) {
                    return columNames[column];
                }

                public Class getColumnClass(int col) {
                    return getValueAt(0, col).getClass();
                }

                public void setValueAt(Object aValue, int row, int column) {
                    resultSet[row][column] = aValue;
                }
            };


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }
}
