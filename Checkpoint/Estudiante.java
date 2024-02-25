public class Estudiante {

   private String Nombre;
   private String Apellido;
   private String Pagos;

   public Estudiante(String Nombre, String Apellido, String Pagos){
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Pagos = Pagos;
   }

    public String getPagos() {
    return this.Pagos;
    }

    public void setPagos(String Pagos) {
        this.Pagos = Pagos;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return this.Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

}
