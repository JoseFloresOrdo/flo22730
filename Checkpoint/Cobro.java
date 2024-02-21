public class Cobro {

    private String Mes;
    private Float Precio;
    private String Estado;

    public Cobro(String Mes, float Precio, String Estado){
        this.Mes = Mes;
        this.Precio = Precio;
        this.Estado = Estado;
    }

    public String getMes() {
        return this.Mes;
    }

    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    public Float getPrecio() {
        return this.Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }

    public String getEstado() {
        return this.Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }    
}
