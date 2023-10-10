class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    private final Deposito coca;
    private final Deposito sprite;
    private final DepositoM monVu;
    private final int precioBebidas;

    public Expendedor(int numeroBebidas, int precioBebidas) {
        this.coca = new Deposito();
        this.sprite = new Deposito();
        this.monVu = new DepositoM();
        this.precioBebidas = precioBebidas;

        for (int i = 0; i < numeroBebidas; i++) {
            this.coca.addBebida(new CocaCola(100 + i));
            this.sprite.addBebida(new Sprite(200 + i));
        }
    }

    public Bebida comprarBebida(Moneda moneda, int tipo) {
        if (moneda == null) return null;
        if (moneda.getValor() < this.precioBebidas) {
            this.monVu.addMoneda(moneda);
            return null;
        }

        Deposito deposito = tipo == Expendedor.COCA ? this.coca
                : tipo == Expendedor.SPRITE ? this.sprite
                : null;
        if (deposito == null) return null;

        Bebida bebida = deposito.getBebida();
        if (bebida == null) {
            this.monVu.addMoneda(moneda);
            return null;
        }

        int vuelto = moneda.getValor() - this.precioBebidas;
        while (vuelto != 0) {
            this.monVu.addMoneda(new Moneda100());
            vuelto -= 100;
        }

        return bebida;
    }

    public Moneda getVuelto() {
        return this.monVu.getMoneda();
    }
}
