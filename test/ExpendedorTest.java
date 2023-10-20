import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpendedorTest {
    @Test
    void comprarProducto() {
        Expendedor expendedor = new Expendedor(5);
        Moneda pago = new Moneda1500();
        System.out.println("ComprarUnProducto");
        try {
            expendedor.comprarProducto(TipoProductos.COCA_COLA, pago);
        } catch (PagoIncorrectoException error) {
            System.out.println("Error: Pago Incorrecto");
        } catch (PagoInsuficienteException error) {
            System.out.println("Error: Pago Insuficiente");
        } catch (NoHayProductoException error) {
            System.out.println("Error: No hay producto");
        }

        try {
            expendedor.comprarProducto(TipoProductos.SPRITE, pago);
        } catch (PagoIncorrectoException error) {
            System.out.println("Error: Pago Incorrecto");
        } catch (PagoInsuficienteException error) {
            System.out.println("Error: Pago Insuficiente");
        } catch (NoHayProductoException error) {
            System.out.println("Error: No hay producto");
        }
        try {
            expendedor.comprarProducto(TipoProductos.FANTA, pago);
        } catch (PagoIncorrectoException error) {
            System.out.println("Error: Pago Incorrecto");
        } catch (PagoInsuficienteException error) {
            System.out.println("Error: Pago Insuficiente");
        } catch (NoHayProductoException error) {
            System.out.println("Error: No hay producto");
        }
        try {
            expendedor.comprarProducto(TipoProductos.SNICKERS, pago);
        } catch (PagoIncorrectoException error) {
            System.out.println("Error: Pago Incorrecto");
        } catch (PagoInsuficienteException error) {
            System.out.println("Error: Pago Insuficiente");
        } catch (NoHayProductoException error) {
            System.out.println("Error: No hay producto");
        }
        try {
            expendedor.comprarProducto(TipoProductos.SUPER8, pago);
        } catch (PagoIncorrectoException error) {
            System.out.println("Error: Pago Incorrecto");
        } catch (PagoInsuficienteException error) {
            System.out.println("Error: Pago Insuficiente");
        } catch (NoHayProductoException error) {
            System.out.println("Error: No hay producto");
        }
    }

    @Test
    void getVuelto() {
        Expendedor expendedor = new Expendedor(5);
        Moneda pago = new Moneda1500();
        try {
            expendedor.comprarProducto(TipoProductos.COCA_COLA, pago);
        } catch (PagoIncorrectoException error) {
            System.out.println("Error: Pago Incorrecto");
        } catch (PagoInsuficienteException error) {
            System.out.println("Error: Pago Insuficiente");
        } catch (NoHayProductoException error) {
            System.out.println("Error: No hay producto");
        }

        int vuelto = 0;
        while (true) {
            Moneda mVuelto = expendedor.getVuelto();
            if (mVuelto == null) break;
            assertEquals(100, mVuelto.getValor());
            vuelto += mVuelto.getValor();
        }

        assertEquals(500, vuelto);

        try {
            expendedor.comprarProducto(TipoProductos.SPRITE, pago);
        } catch (PagoIncorrectoException error) {
            System.out.println("Error: Pago Incorrecto");
        } catch (PagoInsuficienteException error) {
            System.out.println("Error: Pago Insuficiente");
        } catch (NoHayProductoException error) {
            System.out.println("Error: No hay producto");
        }

        vuelto = 0;
        while (true) {
            Moneda mVuelto = expendedor.getVuelto();
            if (mVuelto == null) break;
            assertEquals(100, mVuelto.getValor());
            vuelto += mVuelto.getValor();
        }

        assertEquals(600, vuelto);

        try {
            expendedor.comprarProducto(TipoProductos.SNICKERS, pago);
        } catch (PagoIncorrectoException error) {
            System.out.println("Error: Pago Incorrecto");
        } catch (PagoInsuficienteException error) {
            System.out.println("Error: Pago Insuficiente");
        } catch (NoHayProductoException error) {
            System.out.println("Error: No hay producto");
        }

        vuelto = 0;
        while (true) {
            Moneda mVuelto = expendedor.getVuelto();
            if (mVuelto == null) break;
            assertEquals(100, mVuelto.getValor());
            vuelto += mVuelto.getValor();
        }

        assertEquals(300, vuelto);

        try {
            expendedor.comprarProducto(TipoProductos.SPRITE, pago);
        } catch (PagoIncorrectoException error) {
            System.out.println("Error: Pago Incorrecto");
        } catch (PagoInsuficienteException error) {
            System.out.println("Error: Pago Insuficiente");
        } catch (NoHayProductoException error) {
            System.out.println("Error: No hay producto");
        }

        vuelto = 0;
        while (true) {
            Moneda mVuelto = expendedor.getVuelto();
            if (mVuelto == null) break;
            assertEquals(100, mVuelto.getValor());
            vuelto += mVuelto.getValor();
        }

        assertEquals(600, vuelto);

        try {
            expendedor.comprarProducto(TipoProductos.SUPER8, pago);
        } catch (PagoIncorrectoException error) {
            System.out.println("Error: Pago Incorrecto");
        } catch (PagoInsuficienteException error) {
            System.out.println("Error: Pago Insuficiente");
        } catch (NoHayProductoException error) {
            System.out.println("Error: No hay producto");
        }

        vuelto = 0;
        while (true) {
            Moneda mVuelto = expendedor.getVuelto();
            if (mVuelto == null) break;
            assertEquals(100, mVuelto.getValor());
            vuelto += mVuelto.getValor();
        }
        assertEquals(1400, vuelto);
    }
}
