public class Factory {
    public Traduce getCambio(String entrada) {
           return new Change(entrada);   
    }
}