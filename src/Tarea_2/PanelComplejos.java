package Tarea_2;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComplejos extends JPanel {
    static ButtonGroup boxBotonesComplejos;
    static JRadioButton iconoYesNo;
    static JRadioButton iconoOkCancel;
    static JRadioButton iconoYesNoCancel;
    static JRadioButton iconoCuatroOpc;
    static JRadioButton iconoTextoPrueba;
    static JRadioButton iconoCombo;
    static JButton bMostrarComplejos;

    public PanelComplejos(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        iconoYesNo = new JRadioButton("ShowConfirmDialog YES/NO");
        iconoOkCancel = new JRadioButton("ShowConfirmDialog OK/CANCEL");
        iconoYesNoCancel = new JRadioButton("ShowConfirmDialog YES/NO/CANCEL");
        iconoCuatroOpc = new JRadioButton("ShowOptionDialog con cuatro opciones");
        iconoTextoPrueba = new JRadioButton("ShowInputDialog con texto de prueba");
        iconoCombo= new JRadioButton("ShowInputDialog con combo");

        Box verticalBox = Box.createVerticalBox();
        verticalBox.setSize(350,250);

        JPanel pBotonesComplejos = new JPanel();
        pBotonesComplejos.setPreferredSize(new Dimension(350,200));

        pBotonesComplejos.setLayout(new FlowLayout(FlowLayout.LEFT, 0,10));

        Border interior = BorderFactory.createEmptyBorder(0, 5, 0, 150);



        pBotonesComplejos.add(iconoYesNo);
        pBotonesComplejos.add(iconoOkCancel);
        pBotonesComplejos.add(iconoYesNoCancel);
        pBotonesComplejos.add(iconoCuatroOpc);
        pBotonesComplejos.add(iconoTextoPrueba);
        pBotonesComplejos.add(iconoCombo);

        boxBotonesComplejos = new ButtonGroup();

        boxBotonesComplejos.add(iconoYesNo);
        boxBotonesComplejos.add(iconoOkCancel);
        boxBotonesComplejos.add(iconoYesNoCancel);
        boxBotonesComplejos.add(iconoCuatroOpc);
        boxBotonesComplejos.add(iconoTextoPrueba);
        boxBotonesComplejos.add(iconoCombo);

        bMostrarComplejos = new JButton("Mostrar");
        bMostrarComplejos.setPreferredSize(new Dimension(320,30));
        String cResultado = "";
        JLabel lResultado = new JLabel(cResultado);
        bMostrarComplejos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(iconoYesNo.isSelected()){
                    JOptionPane.showConfirmDialog(pBotonesComplejos,"Ventana YES/NO", "Ventana YES/NO",JOptionPane.YES_NO_OPTION);
                    lResultado.setText("ShowConfirmDialog YES/NO");
                }
                else if (iconoOkCancel.isSelected()){
                    JOptionPane.showConfirmDialog(pBotonesComplejos,"Ventana OK/CANCEL","Ventana OK/CANCEL",JOptionPane.OK_CANCEL_OPTION);
                    lResultado.setText("ShowConfirmDialog OK/CANCEL");
                }
                else if (iconoYesNoCancel.isSelected()){
                    JOptionPane.showConfirmDialog(pBotonesComplejos,"Ventana YES/NO/CANCEL","Ventana YES/NO/CANCEL",JOptionPane.YES_NO_CANCEL_OPTION);
                    lResultado.setText("ShowConfirmDialog YES/NO/CANCEL");
                }
                else if (iconoCuatroOpc.isSelected()){
                    String[] options = new String[] {"Yes", "No", "Ok", "Cancel"};
                    JOptionPane.showOptionDialog(pBotonesComplejos, "Ventana con cuatro opciones", "Ventana con cuatro opciones",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[0]);
                    lResultado.setText("ShowOptionDialog con cuatro opciones");
                }
                else if (iconoTextoPrueba.isSelected()){
                    JOptionPane.showInputDialog(pBotonesComplejos,"Ventana con texto de prueba","Texto de prueba");
                    lResultado.setText("showInputDialog con texto de prueba");
                }
                else if (iconoCombo.isSelected()){
                    String[] options = new String[] {"Yes", "No", "Ok", "Cancel"};
                    JOptionPane.showInputDialog(pBotonesComplejos,"Ventana con combo","Ventana con combo", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    lResultado.setText("showInputDialog con combo");
                }

            }
        });


        add(pBotonesComplejos);
        add(bMostrarComplejos);
        add(lResultado);
    }
}
