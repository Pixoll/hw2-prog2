public enum TipoProductos {
    COCA_COLA("Coca Cola", 200),
    FANTA("Fanta", 300),
    SPRITE("Sprite", 400),
    SNICKERS("Snickers", 500),
    SUPER8("Super 8", 600);

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
