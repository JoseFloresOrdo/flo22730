import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Estudiante {

    private Map<String, Float> Pagos;
    private Map<String, Float> Nota;


    public Estudiante(){
        Pagos = new HashMap<>();
        Nota = new HashMap<>();
    }

    public void AddPAgo(String Mes, float Precio){
        Pagos.put(Mes, Precio);
    }

    public void AddNote(String Clase, float Note){
        Nota.put(Clase, Note);
    }

    public Float RevPagos(String Palabra){
        return Pagos.get(Palabra);
    }

    public Float RevNotas(String Palabra){
        return Pagos.get(Palabra);
    }

    public Map<String,Float> getPagos() {
        return this.Pagos;
    }

    public void setPagos(Map<String,Float> Pagos) {
        this.Pagos = Pagos;
    }

    public Map<String,Float> getNota() {
        return this.Nota;
    }

    public void setNota(Map<String,Float> Nota) {
        this.Nota = Nota;
    }
     
}
