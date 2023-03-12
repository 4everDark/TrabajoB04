package B04.Interfaz;

import B04.PaqB04.Contenedores;
import B04.PaqB04.Puerto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JTextField textNId;
    private JTextField textPeso;
    private JTextArea textAreaDescripcion;
    private JComboBox comboBox1;
    private JCheckBox Prioridad3CheckBox;
    private JCheckBox Prioridad2CheckBox;
    private JCheckBox Prioridad1CheckBox;
    private JTextField TextFieldRemitente;
    private JTextField textFieldReceptora;
    private JCheckBox inspeccionadoCheckBox;
    private JTextArea textArea2;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JButton mostrarDatosDelContenedorButton;
    private JButton cuantosButton;
    private JTextField textFieldMostrarDatos;
    private JTextField textField6;
    private JTextField textFieldDesapilar;
    private JComboBox comboBox2;
    private JPanel operaciones;
    private JPanel mainPanel;
    private JTextField textField1;
    private JPanel Logo;

    public MainFrame() {
        setTitle("GESTOR DE CONTENEDORES");
        setSize(1500,920);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);

        Contenedores c1=new Contenedores();
        Puerto p1=new Puerto();
        p1.inicializar();

        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                c1.setIdentificador(Integer.parseInt(textNId.getText()));
                c1.setPrioridad(3);
                p1.agregarContenedor(c1);
                textArea2.setText(p1.toString());
            }
        });
    }

}
