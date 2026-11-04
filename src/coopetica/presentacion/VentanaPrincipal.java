
package coopetica.presentacion;

import coopetica.logica.AsociadoServicio;
import coopetica.modelo.Asociado;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class VentanaPrincipal extends JFrame {
    
    private AsociadoServicio servicio;
    
    private JTextField txtCedula = new JTextField (12);    
    private JTextField txtNombre = new JTextField (12);           
    private JTextField txtSaldo= new JTextField (12);    
    private JTextArea areaSalida = new JTextArea (12, 35);      
    private JButton btnListar = new JButton("Listar");
    private JButton btnRegistrar = new JButton("Registrar");
    private JButton btnResumen = new JButton("Resumen");
    private JTextField txtBuscar = new JTextField(12);
    private JButton btnBuscar = new JButton("Buscar");
    
    
public VentanaPrincipal(){
    super("Coopetica - Asociados - José Ignacio Chavarría Delgado");
    try {
        servicio = new AsociadoServicio();
    }
    catch(IOException e){
    JOptionPane.showMessageDialog(null, "No se pudo preparar el almacenamiento de datos");
    System.exit(1);
    }
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout(8,8));
    
    
    JPanel panelCampos = new JPanel(new GridLayout(0,2,5,5));
    add(new JLabel("Estudiante: José Ignacio Chavarría Delgado"), BorderLayout.NORTH);
    panelCampos.add(new JLabel("Cedula: "));    
    panelCampos.add(txtCedula);   
    panelCampos.add(new JLabel("Nombre: "));   
    panelCampos.add(txtNombre); 
    panelCampos.add(new JLabel("Saldo Aportes: "));   
    panelCampos.add(txtSaldo); 
    panelCampos.add(new JLabel("Listar : "));   
    panelCampos.add(btnListar);
    panelCampos.add(new JLabel("Registrar: "));
    panelCampos.add(btnRegistrar);
    panelCampos.add(new JLabel("Resumen: "));
    panelCampos.add(btnResumen);
    add(panelCampos, BorderLayout.WEST);
    panelCampos.add(new JLabel("Buscar cedula: "));
    panelCampos.add(txtBuscar);
    panelCampos.add(new JLabel("Buscar: "));
    panelCampos.add(btnBuscar);
    
    areaSalida.setEditable(false);
   add(new JScrollPane(areaSalida), BorderLayout.CENTER);
   
   btnListar.addActionListener(e -> Listar());
   btnRegistrar.addActionListener(e -> registrar());
   btnResumen.addActionListener(e -> resumen());
   btnBuscar.addActionListener(e -> buscar());
   pack();
   setLocationRelativeTo(null);  
}
private void Listar(){

try{

ArrayList<Asociado> lista = servicio.listar();
StringBuilder texto = new StringBuilder();
for (Asociado a : lista){
texto.append(a).append("\n");
}
areaSalida.setText(texto.toString());
}
catch(IOException e) {
    
    JOptionPane.showMessageDialog(this, "Ocurrió un problema al leer los datos");
}
}
private void registrar(){
try{
    String mensaje = servicio.registrar(txtCedula.getText(), txtNombre.getText(), txtSaldo.getText());
    
    if (mensaje.equals("OK")){
    JOptionPane.showMessageDialog(this, "Asociado registrado exitosamente ","Registro exitoso ", JOptionPane.INFORMATION_MESSAGE);
    txtCedula.setText("");
    txtNombre.setText("");
    txtSaldo.setText("");
    txtCedula.requestFocus();
    Listar();
    
}else {
    
    JOptionPane.showMessageDialog(this , mensaje, "No se pudo registrar", JOptionPane.WARNING_MESSAGE);
    }
}catch (IOException e){
JOptionPane.showMessageDialog(this, "Ocurrió un problema al guardar los datos","ERROR", JOptionPane.ERROR_MESSAGE);

}
}
private void resumen() {
    try {
        int cantidad = servicio.CantidadAsociados();
        double total = servicio.totalAportes();
        areaSalida.setText("Asociados registrados: " + cantidad
                + "\nTotal de aportes: " + total);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this,
                "Ocurrio un problema al leer los datos.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
private void buscar() {
    try {
        Asociado a = servicio.buscarPorCedula(txtBuscar.getText());
        if (a == null) {
            areaSalida.setText("No existe un asociado con esa cedula.");
        } else {
            areaSalida.setText("Asociado encontrado:\n" + a);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this,
                "Ocurrio un problema al leer los datos.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
}

    

