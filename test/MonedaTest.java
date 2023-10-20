import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {
    private Moneda m100;
    private Moneda m500;
    private Moneda m1000;
    private Moneda m1500;

    @BeforeEach
    void setUp() {
        this.m100 = new Moneda100();
        this.m500 = new Moneda500();
        this.m1000 = new Moneda1000();
        this.m1500 = new Moneda1500();
    }

    @Test
    void getSerieNotNull() {
        assertNotNull(this.m100.getSerie());
        assertNotNull(this.m500.getSerie());
        assertNotNull(this.m1000.getSerie());
        assertNotNull(this.m1500.getSerie());
    }

    @Test
    void getSerieEqualsSelf() {
        assertEquals(this.m100, this.m100.getSerie());
        assertEquals(this.m500, this.m500.getSerie());
        assertEquals(this.m1000, this.m1000.getSerie());
        assertEquals(this.m1500, this.m1500.getSerie());
    }

    @Test
    void getSerieNotEqualsOther() {
        assertNotEquals(this.m100.getSerie(), this.m500.getSerie());
        assertNotEquals(this.m100.getSerie(), this.m1000.getSerie());
        assertNotEquals(this.m100.getSerie(), this.m1500.getSerie());
        assertNotEquals(this.m500.getSerie(), this.m1000.getSerie());
        assertNotEquals(this.m500.getSerie(), this.m1500.getSerie());
        assertNotEquals(this.m1000.getSerie(), this.m1500.getSerie());
    }

    @Test
    void getValor() {
        assertEquals(100, this.m100.getValor());
        assertEquals(500, this.m500.getValor());
        assertEquals(1000, this.m1000.getValor());
        assertEquals(1500, this.m1500.getValor());
    }

    @Test
    void m100CompareTo() {
        assertEquals(0, this.m100.compareTo(this.m100));
        assertTrue(this.m100.compareTo(this.m500) < 0);
        assertTrue(this.m100.compareTo(this.m1000) < 0);
        assertTrue(this.m100.compareTo(this.m1500) < 0);
    }

    @Test
    void m500CompareTo() {
        assertTrue(this.m500.compareTo(this.m100) > 0);
        assertEquals(0, this.m500.compareTo(this.m500));
        assertTrue(this.m500.compareTo(this.m1000) < 0);
        assertTrue(this.m500.compareTo(this.m1500) < 0);
    }

    @Test
    void m1000CompareTo() {
        assertTrue(this.m1000.compareTo(this.m100) > 0);
        assertTrue(this.m1000.compareTo(this.m500) > 0);
        assertEquals(0, this.m1000.compareTo(this.m1000));
        assertTrue(this.m1000.compareTo(this.m1500) < 0);
    }

    @Test
    void m1500CompareTo() {
        assertTrue(this.m1500.compareTo(this.m100) > 0);
        assertTrue(this.m1500.compareTo(this.m500) > 0);
        assertTrue(this.m1500.compareTo(this.m1000) > 0);
        assertEquals(0, this.m1500.compareTo(this.m1500));
    }
}
