public class Docente {
    
    private String Nombre;
    private String Materia;
    private int Nota;
    private String Cobro;

    public Docente(String Nombre, String Materia, int Nota, String Cobro){
        this.Nombre = Nombre;
        this.Materia = Materia;
        this.Nota = Nota;
        this.Cobro = Cobro;
    }

    public String getCobro() {
        return this.Cobro;
    }
    
    public void setCobro(String Cobro) {
        this.Cobro = Cobro;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMateria() {
        return this.Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

    public int getNota() {
        return this.Nota;
    }

    public void setNota(int Nota) {
        this.Nota = Nota;
    }

}
