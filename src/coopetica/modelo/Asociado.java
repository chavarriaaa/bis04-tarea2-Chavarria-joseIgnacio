package coopetica.modelo;
public class Asociado {
    
    private String nombre;
    private String cedula;
    private double SaldoAporte;
    
 public Asociado (String cedula,String nombre , double SaldoAporte){
 this.nombre = nombre;
 this.cedula = cedula;
 this.SaldoAporte = SaldoAporte;
 }
 public String getcedula() {return cedula;}
  public String getnombre() {return nombre;}
   public double getSaldoAporte() {return SaldoAporte;}

public void setSaldoAporte(double SaldoAporte){
  this.SaldoAporte = SaldoAporte;
}    
@Override 
public String toString(){
    return cedula + " - "+ nombre + " - Aportes: "+ SaldoAporte ;
}
}
