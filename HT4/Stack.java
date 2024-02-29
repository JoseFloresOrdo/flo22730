/*
 * Autores: Allen Estuardo Ramírez De Paz, 22326.
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * 
 * 
 */
import java.util.AbstractCollection;

public abstract class Stack <T> implements IStack<T>{

    public int count() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public void push(T value) {
    }
    
    public T pull() {
        return null;
    }

    public T peek() {
        return null;
    }

}