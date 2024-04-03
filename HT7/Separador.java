public class Separador extends Trad{

    public Separador (String Detalle){
        int i = Detalle.indexOf(",");
        Ingles = Detalle.substring(0, i).trim();
        Detalle = Detalle.replaceFirst(Detalle.substring(0, i+1).trim(), "");
        i = Detalle.indexOf(",");
        Español = Detalle.substring(0, i);
        Frances = Detalle.replaceFirst(Detalle.substring(0, i+1).trim(), "");
    }
    
}
