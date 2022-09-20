package Tarea_2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSimples {
    static JFrame marco;
        static JTabbedPane pPestanas;
            static JPanel pSimples;
                static ButtonGroup boxBotones;
                    static JRadioButton iconoMensaje;
                    static JRadioButton mensajeSinIcono;
                    static JRadioButton iconoWarning;
                    static JRadioButton iconoError;
                    static JRadioButton iconoInfo;
                    static JRadioButton iconoPregunta;
                    static JRadioButton iconoPerso;
                static JButton bMostrar;
            static PanelComplejos pComplejos;


    public static void main(String[] args) {
        marco = new JFrame("Repaso Java Swing 2");
        marco.setSize(350, 335);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pPestanas = new JTabbedPane(JTabbedPane.TOP);



        pSimples = new JPanel();

        //
        iconoMensaje=new JRadioButton("Icono y mensaje por defecto");
        mensajeSinIcono = new JRadioButton("Mensaje sin icono");
        iconoWarning = new JRadioButton("Icono de Warning");
        iconoError = new JRadioButton("Icono de error");
        iconoInfo = new JRadioButton("Icono de información");
        iconoPerso = new JRadioButton("icono personalizado");
        iconoPregunta = new JRadioButton("Icono Pregunta");




        Box verticalBox = Box.createVerticalBox();
        verticalBox.setSize(350,250);

        JPanel pBotones = new JPanel();
        pBotones.setPreferredSize(new Dimension(350,200));

        pBotones.setLayout(new FlowLayout(FlowLayout.LEFT));

        Border interior = BorderFactory.createEmptyBorder(0, 5, 0, 150);
        pBotones.setBorder(interior);



        pBotones.add(iconoMensaje);
        pBotones.add(mensajeSinIcono);
        pBotones.add(iconoWarning);
        pBotones.add(iconoError);
        pBotones.add(iconoInfo);
        pBotones.add(iconoPregunta);
        pBotones.add(iconoPerso);



        boxBotones = new ButtonGroup();

        boxBotones.add(iconoMensaje);
        boxBotones.add(mensajeSinIcono);
        boxBotones.add(iconoWarning);
        boxBotones.add(iconoError);
        boxBotones.add(iconoInfo);
        boxBotones.add(iconoPregunta);
        boxBotones.add(iconoPerso);

        Icon iconoPersonalizado = new ImageIcon("img/sunicon.png");

        bMostrar = new JButton("Mostrar");
        bMostrar.setPreferredSize(new Dimension(320,30));
        bMostrar.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                if(iconoMensaje.isSelected()){
                   JOptionPane.showMessageDialog(pSimples,"Mensaje por defecto....");
                }
                else if (mensajeSinIcono.isSelected()){
                    JOptionPane.showMessageDialog(pSimples,"Mensaje por defecto...","Message",JOptionPane.PLAIN_MESSAGE);
                }
                else if (iconoWarning.isSelected()){
                    JOptionPane.showMessageDialog(pSimples,"","Message",JOptionPane.WARNING_MESSAGE);
                }
                else if (iconoError.isSelected()){
                    JOptionPane.showMessageDialog(pSimples,"","Message",JOptionPane.ERROR_MESSAGE);
                }
                else if (iconoInfo.isSelected()){
                    JOptionPane.showMessageDialog(pSimples,"","Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else if (iconoPregunta.isSelected()){
                    JOptionPane.showMessageDialog(pSimples,"","Message",JOptionPane.QUESTION_MESSAGE);
                }
                else if (iconoPerso.isSelected()){
                    JOptionPane.showMessageDialog(pSimples,"","Message",JOptionPane.INFORMATION_MESSAGE,iconoPersonalizado);
                }
            }
        });



        pSimples.add(pBotones);
        pSimples.add(bMostrar);

        pComplejos = new PanelComplejos();
        
        
        pPestanas.addTab("Simples",null,pSimples,null);
        pPestanas.addTab("Complejos",null,pComplejos,null);

        marco.add(pPestanas);

        marco.setVisible(true);

    }
}
