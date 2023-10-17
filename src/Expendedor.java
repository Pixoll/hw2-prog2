public class Expendedor {
    private final Deposito<Producto> cocaCola;
    private final Deposito<Producto> sprite;
    private final Deposito<Producto> fanta;
    private final Deposito<Producto> snickers;
    private final Deposito<Producto> super8;
    private final Deposito<Moneda> monedasVuelto;

    public Expendedor(int numeroProductos) {
        this.cocaCola = new Deposito<>();
        this.fanta = new Deposito<>();
        this.sprite = new Deposito<>();
        this.snickers = new Deposito<>();
        this.super8 = new Deposito<>();
        this.monedasVuelto = new Deposito<>();

        for (int i = 0; i < numeroProductos; i++) {
            this.cocaCola.add(new CocaCola(i));
            this.fanta.add(new Fanta(i));
            this.sprite.add(new Sprite(i));
            this.snickers.add(new Snickers(i));
            this.super8.add(new Super8(i));
        }
    }

    public Producto comprarProducto(Moneda moneda, TipoProductos tipo)
            throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        if (moneda == null) {
            throw new PagoIncorrectoException("No ingresaste dinero.");
        }
        if (moneda.getValor() < tipo.getPrecio()) {
            this.monedasVuelto.add(moneda);
            throw new PagoInsuficienteException("Debes ingresar al menos $"
                    + tipo.getPrecio()
                    + " (ingresaste $" + moneda.getValor() + ")");
        }

        Deposito<Producto> deposito = tipo == TipoProductos.COCA_COLA ? this.cocaCola
                : tipo == TipoProductos.FANTA ? this.fanta
                : tipo == TipoProductos.SPRITE ? this.sprite
                : tipo == TipoProductos.SNICKERS ? this.snickers
                : this.super8;

        Producto producto = deposito.get();
        if (producto == null) {
            this.monedasVuelto.add(moneda);
            throw new NoHayProductoException("No quedan más " + tipo.getTipo());
        }

        int vuelto = moneda.getValor() - tipo.getPrecio();
        while (vuelto != 0) {
            this.monedasVuelto.add(new Moneda100());
            vuelto -= 100;
        }

        return producto;
    }

    public Moneda getVuelto() {
        return this.monedasVuelto.get();
    }
}
