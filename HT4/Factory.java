/*
 * Autores: Allen Estuardo Ramírez De Paz, 22326.
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * 
 * 
 */
public class Factory<T> {

    private IStack<T> Factorio = null;
    
    public IStack<T> createStack(String Elec) {
        switch (Elec) {
            case "Vector":
                Factorio = new StackVector<T>();
                break;
            case "ArrayList":
                Factorio = new StackArrayList<T>();
                break;
            case "ListaSimple":
                Factorio = new StackList<T>(new SinglyLinkedList<T>());
                break;
            case "ListaDoble":
            Factorio = new StackList<T>(new DoublyLinkedList<T>());
            break;

        }
        return Factorio;
    }
}