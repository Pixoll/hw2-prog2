class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    private final Deposito<Bebida> coca;
    private final Deposito<Bebida> sprite;
    private final Deposito<Moneda> monedasVuelto;
    private final int precioBebidas;

    public Expendedor(int numeroBebidas, int precioBebidas) {
        this.coca = new Deposito<>();
        this.sprite = new Deposito<>();
        this.monedasVuelto = new Deposito<>();
        this.precioBebidas = precioBebidas;

        for (int i = 0; i < numeroBebidas; i++) {
            this.coca.add(new CocaCola(i));
            this.sprite.add(new Sprite(i));
        }
    }

    public Bebida comprarBebida(Moneda moneda, int tipo) {
        if (moneda == null) return null;
        if (moneda.getValor() < this.precioBebidas) {
            this.monedasVuelto.add(moneda);
            return null;
        }

        Deposito<Bebida> depositoBebidas = tipo == Expendedor.COCA ? this.coca
                : tipo == Expendedor.SPRITE ? this.sprite
                : null;
        if (depositoBebidas == null) return null;

        Bebida bebida = depositoBebidas.get();
        if (bebida == null) {
            this.monedasVuelto.add(moneda);
            return null;
        }

        int vuelto = moneda.getValor() - this.precioBebidas;
        while (vuelto != 0) {
            this.monedasVuelto.add(new Moneda100());
            vuelto -= 100;
        }

        return bebida;
    }

    public Moneda getVuelto() {
        return this.monedasVuelto.get();
    }
}
