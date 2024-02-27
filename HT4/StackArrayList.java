import java.util.ArrayList;

public class StackArrayList<T> extends Stack<T> implements IStack<T> {

    private ArrayList<T> Listas;

    public  StackArrayList() {
        this.Listas = new ArrayList<T>();
    }

    public int count() {
        return this.Listas.size();
    }

    public boolean isEmpty() {
        return this.Listas.isEmpty();
    }

    public void push(T value) {
        this.Listas.add(0,value);
    }

    public T pull() {
        return this.Listas.remove(0);
    }

    public T peek() {
        return this.Listas.get(0);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía. No se puede realizar pop.");
        }
        return this.Listas.remove(this.Listas.size() - 1);
    }

}