public class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, TipoProductos tipoProducto, Expendedor exp)
            throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        Producto producto = exp.comprarProducto(m, tipoProducto);

        if (producto instanceof Bebida bebida) {
            this.sonido = bebida.beber();
        } else if (producto instanceof Dulce dulce) {
            this.sonido = dulce.comer();
        }

        while (true) {
            Moneda moneda = exp.getVuelto();
            if (moneda == null) break;
            this.vuelto += moneda.getValor();
        }
    }

    public int cuantoVuelto() {
        return this.vuelto;
    }

    public String queBebiste() {
        return this.sonido;
    }
}
