public class Change extends Traduce{
    public Change(String s){

        int i = s.indexOf(",");
        ingles = s.substring(0, i).trim();
        s = s.replaceFirst(s.substring(0, i+1).trim(), "");

        //Busca para la segunda coma y guarda desde el nuevo inicio para la palabra en ingles y el resto para frances
        i = s.indexOf(",");
        espanol = s.substring(0, i);
        frances = s.replaceFirst(s.substring(0, i+1).trim(), "");
    }
}

