class Moneda100 extends Moneda implements Comparable<Moneda> {
    public Moneda100() {
        super();
    }

    public int getValor() {
        return 100;
    }

    @Override
    public int compareTo(Moneda moneda) {
        if (moneda.getValor() > this.getValor()) return 1;
        if (moneda.getValor() < this.getValor()) return -1;
        return 0;
    }
}
