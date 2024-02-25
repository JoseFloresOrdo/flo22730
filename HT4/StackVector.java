import java.util.Vector;

public class StackVector <T> extends Stack<T> implements IStack<T>{

    private Vector<T> Vector;

    public StackVector() {
        this.Vector = new Vector<T>();
    }

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
}