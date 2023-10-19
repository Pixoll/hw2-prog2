public enum TipoProductos {
    COCA_COLA("Coca Cola", 1000),
    FANTA("Fanta", 800),
    SPRITE("Sprite", 900),
    SNICKERS("Snickers", 1200),
    SUPER8("Super 8", 400);

    private final String tipo;
    private final int precio;

    TipoProductos(String tipo, int precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getPrecio() {
        return this.precio;
    }
}
