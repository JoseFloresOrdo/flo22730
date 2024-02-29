/*
 * Autores: Allen Estuardo Ramírez De Paz, 22326.
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * 
 * 
 */
public class StackList<T> extends Stack<T> implements IStack<T> {
    private AbstractList<T> list;

    public StackList(AbstractList list) {
        this.list = list;
    }

    
    /** 
     * @param value
     */
    public void push(T value) {
        list.enqueue(value);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("El stack está vacío. No se puede realizar pop.");
        }
        return list.dequeue();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("El stack está vacío. No se puede realizar peek.");
        }
        return list.peek();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
