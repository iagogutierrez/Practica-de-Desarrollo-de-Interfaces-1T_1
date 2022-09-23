package views;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAlumnos extends JPanel {
    public JButton boton;
    public JLabel texto;

    public ViewAlumnos() {

        setSize(new Dimension(620, 340));


        // Panel main
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelsuperior = new JPanel();

        JLabel titulo = new JLabel("GESTIÓN DE DATOS DE ALUMNOS");
        titulo.setBorder(new EmptyBorder(10, 0, 5, 0));
        Font fuente = new Font("ARIAL", Font.BOLD, 20);
        titulo.setFont(fuente);

        panelsuperior.add(titulo);
        add(panelsuperior, BorderLayout.NORTH);

        // Panel medio
        JPanel panelmedio = new JPanel();

        panelmedio.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,5,10,5), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));

        boton = new JButton();
        JLabel imagen=new JLabel(new ImageIcon("DATaTabla.png"));
        boton.add(imagen);
        JPanel panelBoton = new JPanel();
        panelBoton.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        panelBoton.add(boton);
        panelmedio.add(panelBoton);
        add(panelmedio, BorderLayout.CENTER);

        // Panel inferior
        JPanel panelinferior = new JPanel();


        texto = new JLabel("      Información del fichero ahora registrada en la tabla Alumnos      ");
        Font fuente2 = new Font("ARIAL", 1, 15);
        texto.setFont(fuente2);
        Color Colortextoinferior = new Color(153, 204, 102);
        texto.setBackground(Colortextoinferior);
        texto.setOpaque(true);

        texto.setVisible(false);
        panelinferior.add(texto);
        add(panelinferior, BorderLayout.SOUTH);



    }

}