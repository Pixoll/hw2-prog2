/**
 * Quien compra un producto en el expendedor.
 */
public class Comprador {
    /**
     * Lo que sabe el producto.
     */
    private String sabor;
    /**
     * Lo que se devuelve si se paga un valor mayor a lo comprado.
     */
    private int vuelto;

    /**
     * Quien compra un producto en el expendedor.
     * @param moneda Con la que se compra el producto.
     * @param tipoProducto El tipo de producto que se compra.
     * @param expendedor Máquina expendedora que vende los productos.
     * @throws NoHayProductoException Excepción tirada cuando no hay productos en el depósito.
     * @throws PagoIncorrectoException Excepción tirada cuando el pago es incorrecto.
     * @throws PagoInsuficienteException Excepción tirada cuando el valor pagado es menor al del producto.
     */
    public Comprador(Moneda moneda, TipoProductos tipoProducto, Expendedor expendedor)
            throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        Producto producto = expendedor.comprarProducto(moneda, tipoProducto);

        if (producto instanceof Bebida bebida) {
            this.sabor = bebida.beber();
        } else if (producto instanceof Dulce dulce) {
            this.sabor = dulce.comer();
        }

        while (true) {
            Moneda vuelto = expendedor.getVuelto();
            if (vuelto == null) break;
            this.vuelto += vuelto.getValor();
        }
    }

    /**
     * Cuanto recibe el comprador de vuelto.
     * @return El vuelto.
     */
    public int cuantoVuelto() {
        return this.vuelto;
    }

    /**
     * El sabor de lo que compró.
     * @return El sabor del producto.
     */
    public String queCompraste() {
        return this.sabor;
    }
}
