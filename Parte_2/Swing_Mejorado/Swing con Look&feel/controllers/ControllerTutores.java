package controllers;

import models.ConexionBD;
import models.Tutores;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import views.ViewTutores;


import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ControllerTutores {

    ConexionBD cbd;
    ViewTutores viewTutores;
    ArrayList<Tutores> listTutores = new ArrayList<>();

    public ControllerTutores(ViewTutores viewTutores, ConexionBD cbd) throws SQLException {


        this.viewTutores = viewTutores;
        this.cbd = cbd;
        controllerBotonTutores();

        Connection conex = cbd.conectar();
        Statement stmt = conex.createStatement();
        stmt.executeUpdate("DELETE FROM TUTORES_P");
        stmt.close();
        conex.close();
    }

    // ESTO TAMPOCO SE QUE COÑO ES
    public void consultaTabla() throws ClassNotFoundException, SQLException {

        Connection conexion = cbd.conectar();
        Statement stmt = conexion.createStatement();
        System.out.println("BD conectada");
        ResultSet rs = stmt.executeQuery("select * from Tutores_P");
        while (rs.next()) {
            System.out.println(rs.getString("Cod_Tutor"));
            System.out.println(rs.getString("DNI"));
            System.out.println(rs.getString("Nombrecompleto"));
            System.out.println(rs.getString("Mail"));
            System.out.println(rs.getString("Telefono"));
        }
        rs.close();
        stmt.close();

    }

    public void intoValueDatos() throws ClassNotFoundException, SQLException {


        Connection conexion = cbd.conectar();
        PreparedStatement actualiza = conexion.prepareStatement("INSERT INTO Tutores_P(Nombre, Mail, Tlfn) VALUES( ?, ?, ? ) ");


        for (Tutores x : listTutores) {
            actualiza.setString(1, x.getNombreCompleto());
            actualiza.setString(2, x.getCorreoElectronico());
            actualiza.setString(3, x.getTelefono());

            actualiza.executeUpdate();

        }
        actualiza.close();
        conexion.close();

    }
    public void lecturaXML() {


        //Creamos una referencia (fichXML) de tipo File al cargar el fichero XML existente
        File fichXML = new File("src/tutoresdoc.xml");
        {

            //Parsea el fichero y lo convierte de fichero a documento XML recorrible
            DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructDoc = null;
            try {
                constructDoc = factoriaDoc.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            }
            Document docDOM = null;
            try {
                docDOM = constructDoc.parse(fichXML);
            } catch (SAXException | IOException ex) {
                ex.printStackTrace();
            }

            //Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
            docDOM.getDocumentElement().normalize();
            //Localizamos e imprimimos cuál es el elemento raíz

            Element raiz = docDOM.getDocumentElement();

            //Vuelca a una lista los nodos que cuelgan del nodo raíz
            NodeList alumDam = docDOM.getElementsByTagName("tutordoc");
            for (int cont = 0; cont < alumDam.getLength(); cont++) {
                //Se recorre la lista con nodos y se extrae en nodo el que indica cont
                Node nodo = alumDam.item(cont);
                //Para saber qué nodo está procesando, imprime el nombre

                //Comprueba si se encuentra ante un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    //Castea el nodo de tipo Node a uno de tipo Element
                    Element element = (Element) nodo;

                    String cod = element.getElementsByTagName("codtut").item(0).getTextContent();
                    String Nombrecompleto = element.getElementsByTagName("nomap").item(0).getTextContent();
                    String CorreoElectronico = element.getElementsByTagName("correo").item(0).getTextContent();
                    String Telefono = element.getElementsByTagName("telefono").item(0).getTextContent();

                    Tutores tutores = new Tutores(Integer.parseInt(cod), Nombrecompleto, CorreoElectronico, Telefono);
                    listTutores.add(tutores);
                }
            }

        }
    }

    public void controllerBotonTutores(){
        viewTutores.boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTutores.texto.setVisible(true);
                lecturaXML();
                try {
                    intoValueDatos();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                ControllerAsignacion.datosTutores();
                JButton b = (JButton) e.getSource();
                b.setEnabled(false);
            }

        });
    }
}
