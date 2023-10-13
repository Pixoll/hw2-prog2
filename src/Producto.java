public abstract class Producto {
    private final int serie;

    public Producto(int serie) {
        this.serie = serie;
    }

    public int getSerie() {
        return this.serie;
    }
}
