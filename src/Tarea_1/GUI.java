package Tarea_1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Collections;
import java.util.Date;
import java.util.Calendar;

public class GUI {

    public void creaGUI() {
        JFrame marco = new JFrame();
        marco.setTitle("Ejercicios Repaso Swing 1");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(390, 300);
        marco.setLocation(500, 350);

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //panel1.setBackground(Color.lightGray);

        JPanel panel2 = new JPanel();
        //panel2.setBackground(Color.blue);

        JPanel panel3 = new JPanel();
        //panel3.setBackground(Color.green);

        JPanel panel4 = new JPanel();
        //panel4.setBackground(Color.red);

        JPanel contenedor =new JPanel();

        // SLIDER

        JSlider slider = new JSlider(JSlider.HORIZONTAL);
        JLabel tslider = new JLabel("Slider");
        JTextField statusslider = new JTextField("50",2);
        statusslider.setEditable(false);

        panel1.add(tslider);
        panel1.add(slider);
        panel1.add(statusslider);

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                statusslider.setText(""+ ((JSlider)e.getSource()).getValue());
            }
        });

        // SCROLLBAR

        JScrollBar scrollbar =new JScrollBar(Scrollbar.HORIZONTAL,50,0,0,100);
        scrollbar.setPreferredSize(new Dimension(200,20));
        JLabel tScrollbar = new JLabel("Scrollbar");
        JTextField statusscrollbar = new JTextField("50", 2);
        statusscrollbar.setEditable(false);

        panel2.add(tScrollbar);
        panel2.add(scrollbar);
        panel2.add(statusscrollbar);

        scrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                statusscrollbar.setText(""+ scrollbar.getValue());
            }
        });

        //SPINNER FECHA

        Calendar calendar = Calendar.getInstance();
        Date inicio = calendar.getTime();
        calendar.add(Calendar.YEAR,-100);
        Date dia = new Date();
        System.out.println(dia);
        SpinnerModel Spinner_Fecha = new SpinnerDateModel(inicio, null, null, Calendar.YEAR);
        JSpinner fecha = new JSpinner(Spinner_Fecha);
        JLabel texto_spinner = new JLabel("Spinner Fecha Completa");

        panel3.add(texto_spinner);
        panel3.add(fecha);

        // SPINNER FECHA DESGLOSADA

        JLabel texto_spinner2 = new JLabel("Spinner Fecha Desglobada");

        SpinnerModel Spinner_dia = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.DATE), 1,31,1);
        JSpinner Spinner1 = new JSpinner(Spinner_dia);

        String months[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        SpinnerModel Spinner_mes = new SpinnerListModel(Collections.singletonList(((months[calendar.get(Calendar.MONTH)]))));
        JSpinner Spinner2 = new JSpinner(Spinner_mes);
        Spinner2.setPreferredSize(new Dimension(90,20));

        SpinnerModel Spinner_anio = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR),null,null,1);
        JSpinner Spinner3 = new JSpinner(Spinner_anio);


        panel4.add(texto_spinner2);
        panel4.add(Spinner1);
        panel4.add(Spinner2);
        panel4.add(Spinner3);

        // AÑADIR AL MARCO
        contenedor.add(panel1);
        contenedor.add(panel2);
        contenedor.add(panel3);
        contenedor.add(panel4);
        marco.add(contenedor);
        marco.setVisible(true);

    }
}

class Main {
    public static void main(String[] args) {
        GUI ventana = new GUI();
        ventana.creaGUI();
    }
}