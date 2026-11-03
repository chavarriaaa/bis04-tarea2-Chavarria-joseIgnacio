
package coopetica.presentacion;

import coopetica.logica.AsociadoServicio;
import coopetica.modelo.Asociado;
import java.io.IOException;

public class Prueba {
    
    public static void main(String[] args) throws IOException {
        
        AsociadoServicio Servicio = new AsociadoServicio();
        
        System.out.println(Servicio.registrar(new Asociado("70111097", "Pedro Herrera", 6700)));
           System.out.println(Servicio.registrar(new Asociado("110450837", "Diego Chavarria", 95000)));
        
        System.out.println("---Lista---");
        for (Asociado a: Servicio.listar() ){
        
            System.out.println(a);
        }
     
    }
    
 
}
