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

public String registrar(Asociado a)throws IOException{
    
    if(a.getcedula().isEmpty()||a.getnombre().isEmpty()){
        return "La cedula y el nombre son obligatorias.";
    }
    if (a.getSaldoAporte()<0){
     return "El saldo no puede ser negativo";   
    }
     for (Asociado asociado : dao.listar()){
     
      if (asociado.getcedula().equals(a.getcedula()) )
        return "Ya existe un asociado con esa cedula";
 
    }
  dao.agregar(a);
  return "OK";
}
    
    
    
}
