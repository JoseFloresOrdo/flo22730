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
            case "ArrayListEncadenado":
                Factorio = new ListSimple<T>();
                break;
        }
        return Factorio;
    }
}