import java.util.HashMap;
import java.util.Map;

public class Diccionario {
    
    private Map<String, Clases> Diccionario;
    private Map<String, Pagos> Pagos;
    private Map<String, Cobro> Cobro;

    public Diccionario(){
        Diccionario = new HashMap<>();
        Pagos = new HashMap<>();
        Cobro = new HashMap<>();
    }

    public void Agregar(String Palabra, String Clase, float Nota, String Alumno, String Docente){
        Diccionario.put(Palabra, new Clases(Clase, Nota, Alumno, Docente));
    }

    public void AgregarPago(String Word, String Mes, float Precio, String Estado){
        Pagos.put(Word, new Pagos(Mes, Precio, Estado));
    }

    public void AgregarCobro(String Palabra, String Mes, float Precio, String Estado){
        Cobro.put(Palabra, new Cobro(Mes, Precio, Estado));
    }

    public void CamPago(String Palabra, String Mes, float Precio, String Estado){
        if (Pagos.containsKey(Palabra)){
            Pagos Pago = Pagos.get(Palabra);
            Pago.setMes(Mes);
            Pago.setPrecio(null);
            Pago.setEstado(Estado);
            Pagos.put(Palabra, Pago);
        }
        else {
            System.out.println("Error");
        }
    }

    public void CamCobro(String Palabra, String Mes, float Precio, String Estado){
        if (Cobro.containsKey(Palabra)){
            Cobro Cobros = Cobro.get(Palabra);
            Cobros.setMes(Mes);
            Cobros.setPrecio(null);
            Cobros.setEstado(Estado);
            Cobro.put(Palabra, Cobros);
        }
        else {
            System.out.println("Error");
        }
    }

}
