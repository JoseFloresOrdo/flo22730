public class Nodo {
    
    Association<String, String> palabra;
    Nodo left, right;

    Nodo(Association<String, String> palabra){
        this.palabra = palabra;
        left = right = null;
    }
}
