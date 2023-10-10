class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        Bebida bebida = exp.comprarBebida(m, cualBebida);
        if (bebida != null) this.sonido = bebida.beber();
        while (true) {
            Moneda moneda = exp.getVuelto();
            if (moneda == null) break;
            this.vuelto += moneda.getValor();
        }
    }

    public int cuantoVuelto() {
        return this.vuelto;
    }

    public String queBebiste() {
        return this.sonido;
    }
}
