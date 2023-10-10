class Moneda500 extends Moneda implements Comparable<Moneda> {
    public Moneda500() {
        super();
    }

    public int getValor() {
        return 500;
    }

    @Override
    public int compareTo(Moneda moneda) {
        if (moneda.getValor() > this.getValor()) return 1;
        if (moneda.getValor() < this.getValor()) return -1;
        return 0;
    }
}


