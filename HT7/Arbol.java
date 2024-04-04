public class Arbol {

    Nodo root;

    public Nodo insertar(Nodo current, Association<String, String> palabra){
        if(current == null){
            return new Nodo(palabra);
        }
        if(palabra.getLlave().compareToIgnoreCase(current.palabra.getLlave()) < 0){
            current.left = insertar(current.left, palabra);
        }
        else if (palabra.getLlave().compareToIgnoreCase(current.palabra.getLlave()) > 0){
            current.right = insertar(current.right, palabra);
        }

        return current;
    }

    public void empezar(Association<String, String> palabra){
        root = insertar(root, palabra);
    }

    private String buscarNodo(Nodo current, String palabra) {
        if (current == null) {
            return "";
        } 
        if (palabra.equalsIgnoreCase(current.palabra.getLlave())) {
            return current.palabra.getValor();
        } 
        return palabra.compareToIgnoreCase(current.palabra.getLlave()) < 0
          ? buscarNodo(current.left, palabra)
          : buscarNodo(current.right, palabra);
    }

    public String empezarb(String palabra) {
        return buscarNodo(root, palabra);
    }
}
