class Moneda1500 extends Moneda implements Comparable<Moneda> {
    public Moneda1500() {
        super();
    }

    public int getValor() {
        return 1500;
    }

    @Override
    public int compareTo(Moneda moneda) {
        return Integer.compare(moneda.getValor(), this.getValor());
    }
}
