public class Clases {

    private String Clase;
    private Float Nota;
    private String Alumno;
    private String Docente;

    public Clases(String Clase, Float Nota, String Alumno, String Docente){
        this.Clase = Clase;
        this.Nota = Nota;
        this.Alumno = Alumno;
        this.Docente = Docente;
    }

    public String getClase() {
        return this.Clase;
    }

    public void setClase(String Clase) {
        this.Clase = Clase;
    }

    public Float getNota() {
        return this.Nota;
    }

    public void setNota(Float Nota) {
        this.Nota = Nota;
    }

    public String getAlumno() {
        return this.Alumno;
    }

    public void setAlumno(String Alumno) {
        this.Alumno = Alumno;
    }

    public String getDocente() {
        return this.Docente;
    }

    public void setDocente(String Docente) {
        this.Docente = Docente;
    }
    
}
