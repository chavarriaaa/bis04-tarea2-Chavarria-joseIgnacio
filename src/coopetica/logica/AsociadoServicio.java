package coopetica.logica;

import coopetica.datos.AsociadoArchivoDAO;
import coopetica.modelo.Asociado;
import java.io.IOException;
import java.util.ArrayList;

public class AsociadoServicio {
    
    private AsociadoArchivoDAO dao;
    
public AsociadoServicio() throws IOException {
  this.dao = new AsociadoArchivoDAO();
}    

public ArrayList<Asociado> listar() throws IOException {
return dao.listar();
}

public String registrar(String cedula, String nombre, String saldoTexto)throws IOException{
    
    cedula = cedula.trim();
    nombre = nombre.trim();
    saldoTexto = saldoTexto.trim();
    
    if(cedula.isEmpty()||nombre.isEmpty()||saldoTexto.isEmpty()){
        return "La cedula, nombre y saldo son obligatorias.";
    }
    double saldo;
    try{
    
    saldo = Double.parseDouble(saldoTexto);
    
    }catch (NumberFormatException e){
        return "El saldo debe ser un número. ";
    
    
    }
   
  return registrar (new Asociado(cedula, nombre, saldo));
}
public String registrar (Asociado a)throws IOException{
if(a.getcedula().isEmpty()||a.getnombre().isEmpty()){
return "La cedula y el nombre son obligatorios. ";
}
if(a.getSaldoAporte()<0){
return "El saldo no puede ser nagativo.";
}
for (Asociado asociado : dao.listar()){
if(asociado.getcedula().equals(a.getcedula())){
return "Ya existe un asociado con esa cedula";
}
}
dao.agregar(a);
return"OK";
}public int CantidadAsociados() throws IOException{
return dao.listar().size();
}
public double totalAportes() throws IOException{
double total = 0;
for (Asociado a : dao.listar()){
total += a.getSaldoAporte();
}
return total;
}

}
    
