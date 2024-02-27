public interface IList<T> {
    void enqueue(T value);
    T dequeue();
    T peek();
    int size();
    boolean isEmpty();
}
