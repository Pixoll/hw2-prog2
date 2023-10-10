import java.util.ArrayList;

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
