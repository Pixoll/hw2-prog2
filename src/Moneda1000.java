public class Moneda1000 extends Moneda implements Comparable<Moneda> {
    public Moneda1000() {
        super();
    }

    public int getValor() {
        return 1000;
    }

    @Override
    public int compareTo(Moneda moneda) {
        return Integer.compare(moneda.getValor(), this.getValor());
    }
}
