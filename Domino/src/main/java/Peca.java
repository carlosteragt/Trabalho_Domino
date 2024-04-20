public class Peca {
    private int numero1;
    private int numero2;

    public Peca(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
    public boolean eValida(Peca outra) {
        return this.numero1 == outra.numero1 || this.numero1 == outra.numero2 ||
                this.numero2 == outra.numero1 || this.numero2 == outra.numero2;
    }

    @Override
    public String toString() {
        return "{" + numero1 + ", " + numero2 + '}';
    }
}

