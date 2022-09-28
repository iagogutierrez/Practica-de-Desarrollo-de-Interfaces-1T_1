package views;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTutores extends JPanel {
    public JButton boton;
    public JLabel texto;
    JPanel pSuperior;

    public ViewTutores() {
        super();
        setSize(1015, 700);

        // Panel main
        this.setLayout(new BorderLayout());

        // Panel superior
        pSuperior = new JPanel();

        JLabel titulo = new JLabel("GESTIÓN DE DATOS DE TUTORES");
        Font fuente = new Font("ARIAL", 1, 20);
        titulo.setBorder(new EmptyBorder(10, 0, 5, 0));
        titulo.setFont(fuente);

        pSuperior.add(titulo);
        this.add(pSuperior, BorderLayout.NORTH);

        // Panel medio
        JPanel panelmedio = new JPanel();
        panelmedio.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1,1,1,1), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
        JPanel panelBoton = new JPanel();
        panelBoton.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        boton = new JButton();
        JLabel imagen = new JLabel(new ImageIcon("img/XMLaTabla.png"));
        boton.add(imagen);

        panelBoton.add(boton);
        panelmedio.add(panelBoton);
        this.add(panelmedio, BorderLayout.CENTER);

        // Panel inferior
        JPanel panelinferior = new JPanel();

        texto = new JLabel("      Información del fichero ahora registrada en la tabla Tutores      ");
        Font fuente2 = new Font("ARIAL", 1, 15);
        texto.setFont(fuente2);
        Color Colortextoinferior = new Color(102, 153, 204);
        texto.setBackground(Colortextoinferior);
        texto.setOpaque(true);

        texto.setVisible(false);
        panelinferior.add(texto);
        this.add(panelinferior, BorderLayout.SOUTH);


    }
}