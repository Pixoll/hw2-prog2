class Moneda100 extends Moneda implements Comparable<Moneda> {
    public Moneda100() {
        super();
    }

    public int getValor() {
        return 100;
    }

    @Override
    public int compareTo(Moneda moneda) {
        return Integer.compare(moneda.getValor(), this.getValor());
    }
}
