/*
 * Autores: Allen Estuardo Ramírez De Paz, 22326.
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * 
 * 
 */
import java.util.Vector;

public class StackVector <T> extends Stack<T> implements IStack<T>{

    private Vector<T> Vector;

    public StackVector() {
        this.Vector = new Vector<T>();
    }

    
    /** 
     * @return int
     */
    public int count() {
        return this.Vector.size();
    }

    public boolean isEmpty() {
        return this.Vector.isEmpty();
    }

    public void push(T value) {
        this.Vector.add(0,value);
    }

    public T pull() {
        return this.Vector.remove(0);
    }

    public T peek() {
        return this.Vector.get(0);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("El stack está vacío");
        }
       
        return Vector.remove(Vector.size()-1);
    }
}