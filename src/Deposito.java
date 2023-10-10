import java.util.ArrayList;

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
