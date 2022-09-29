package controllers;

import models.ConexionBD;
import views.ViewEmpresa;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.sql.SQLException;
import static java.awt.Frame.MAXIMIZED_BOTH;

public class PilotInicial {
    public static void main(String[] args) throws SQLException {
        ConexionBD conexBd = new ConexionBD();
        ViewEmpresa vistaEmpresa = new ViewEmpresa();


        ControllerEmpresa controllerEmpresa = new ControllerEmpresa(vistaEmpresa, conexBd);
        ControllerAlumnos controllerAlumnos = new ControllerAlumnos(vistaEmpresa.viewAlumnos, conexBd);
        ControllerTutores controllerTutores = new ControllerTutores(vistaEmpresa.viewTutores, conexBd);
        ControllerAsignacion controllerAsignacion = new ControllerAsignacion(vistaEmpresa.viewAsignacion, conexBd);
    }
}