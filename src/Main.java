import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    }
}

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

class Moneda1500 extends Moneda {
    public Moneda1500() {
        super();
    }

    public int getValor() {
        return 1500;
    }
}

class Moneda1000 extends Moneda {
    public Moneda1000() {
        super();
    }

    public int getValor() {
        return 1000;
    }
}

class Moneda500 extends Moneda {
    public Moneda500() {
        super();
    }

    public int getValor() {
        return 500;
    }
}

class Moneda100 extends Moneda {
    public Moneda100() {
        super();
    }

    public int getValor() {
        return 100;
    }
}

abstract class Moneda {
    public Moneda() {
    }

    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();
}

class DepositoM {
    private final ArrayList<Moneda> monedas;

    public DepositoM() {
        this.monedas = new ArrayList<>();
    }

    public void addMoneda(Moneda moneda) {
        this.monedas.add(moneda);
    }

    public Moneda getMoneda() {
        if (this.monedas.isEmpty()) return null;
        return this.monedas.remove(0);
    }
}

class Deposito {
    private final ArrayList<Bebida> bebidas;

    public Deposito() {
        this.bebidas = new ArrayList<>();
    }

    public void addBebida(Bebida bebida) {
        this.bebidas.add(bebida);
    }

    public Bebida getBebida() {
        if (this.bebidas.isEmpty()) return null;
        return this.bebidas.remove(0);
    }
}

abstract class Bebida {
    private final int serie;

    public Bebida(int serie) {
        this.serie = serie;
    }

    public int getSerie() {
        return this.serie;
    }

    public abstract String beber();
}

class Sprite extends Bebida {
    public Sprite(int serie) {
        super(serie);
    }

    public String beber() {
        return "sprite";
    }
}

class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }

    public String beber() {
        return "cocacola";
    }
}
