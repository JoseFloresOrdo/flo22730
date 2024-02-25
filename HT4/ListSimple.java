public class ListSimple<T> extends Stack<T> implements IStack<T> {

    private ListSimple<T> Sample;

    public ListSimple()
    {
        this.Sample = new ListSimple<T>();
    }

    public int count() {
        return this.Sample.size();
    }

    public boolean isEmpty() {
        return this.Sample.isEmpty();
    }

    public void push(T value) {
        this.Sample.add(value);
    }

    public T pull() {
        return this.Sample.remove(0);
    }

    public T peek() {
        return this.Sample.get(0);
    }
}