class Moneda1000 extends Moneda implements Comparable<Moneda> {
    public Moneda1000() {
        super();
    }

    public int getValor() {
        return 1000;
    }

    @Override
    public int compareTo(Moneda moneda) {
        if (moneda.getValor() > this.getValor()) return 1;
        if (moneda.getValor() < this.getValor()) return -1;
        return 0;
    }
}
