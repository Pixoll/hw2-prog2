import java.util.ArrayList;

public class Deposito<T> {
    private final ArrayList<T> almacen;

    public Deposito() {
        this.almacen = new ArrayList<>();
    }

    public void add(T item) {
        this.almacen.add(item);
    }

    public T get() {
        if (this.almacen.isEmpty()) return null;
        return this.almacen.remove(0);
    }
}
