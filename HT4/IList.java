/*
 * Autores: Allen Estuardo Ramírez De Paz, 22326.
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * 
 * 
 */
public interface IList<T> {
    void enqueue(T value);
    T dequeue();
    T peek();
    int size();
    boolean isEmpty();
}
