
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
    
    
public VentanaPrincipal(){
    super("Coopetica - Asociados");
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
    add(panelCampos, BorderLayout.WEST);
    
    areaSalida.setEditable(false);
   add(new JScrollPane(areaSalida), BorderLayout.CENTER);
   
   btnListar.addActionListener(e -> Listar());
   btnRegistrar.addActionListener(e -> registrar());
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
    
}

    

