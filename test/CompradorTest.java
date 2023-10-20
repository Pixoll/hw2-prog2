import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {
    private Expendedor expendedor;
    private Moneda m100;
    private Moneda m500;
    private Moneda m1000;
    private Moneda m1500;

    @BeforeEach
    void setUp() {
        this.expendedor = new Expendedor(5);
        this.m100 = new Moneda100();
        this.m500 = new Moneda500();
        this.m1000 = new Moneda1000();
        this.m1500 = new Moneda1500();
    }

    @Test
    void cuantoVuelto() {
        try {
            Comprador comprador = new Comprador(TipoProductos.SPRITE, this.m1000, expendedor);
        } catch (Exception error) {
            // No pasa
        }
    }

    @Test
    void queCompraste() {
    }
}