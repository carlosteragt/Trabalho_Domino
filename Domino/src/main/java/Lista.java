import java.util.Random;

public class Lista {

    private No inicio;
    private No ultimo;


    public Lista() {
        this.inicio = null;
        this.ultimo = null;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }
    public int tamanhoLista() {
        int tamanho = 0;
        No noDaVez = inicio;
        while (noDaVez != null) {
            tamanho++;
            noDaVez = noDaVez.proximo;
        }
        return tamanho;
    }
    public void inserir(Peca peca) {
        No novoNo = new No();
        novoNo.peca = peca;
        if(inicio == null) {
            inicio = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
            ultimo = novoNo;
        }
    }
    public void inserirNoComeco(Peca peca) {
        No noDaVez = new No();
        noDaVez.peca = peca;
        if (inicio == null) {
            inicio = noDaVez;
            ultimo = noDaVez;
        } else {
            noDaVez.proximo = inicio;
            inicio.anterior = noDaVez;
            inicio = noDaVez;
        }
    }

    public Peca UltimaPeca() {
        if (isVazia()) {
            return null;
        }
        return ultimo.peca;
    }
    public Peca obterPecaValida(Peca pecaAnterior, Lista jogador) {
        for (int i = 0; i < jogador.tamanhoLista(); i++) {
            Peca peca = jogador.obterPecaPorPosicao(i);
            if (peca.eValida(pecaAnterior)) {
                return peca;
            }
        }
        return null;
    }
    public Peca obterPecaPorPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanhoLista()) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        No atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.peca;
    }
    public void imprimirPecas() {
        No noDaVez = inicio;
        while (noDaVez != null) {
            System.out.print(noDaVez.peca + " | ");
            noDaVez = noDaVez.proximo;
        }
        System.out.println();
    }
    public Peca removerNaPosicao(int posicao) {
        if (isVazia() || posicao < 0 || posicao >= tamanhoLista()) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        No noDaVez = inicio;
        No anterior = null;

        for (int i = 0; i < posicao; i++) {
            anterior = noDaVez;
            noDaVez = noDaVez.proximo;
        }

        if (anterior == null) {
            inicio = noDaVez.proximo;
        } else {
            anterior.proximo = noDaVez.proximo;
        }

        if (noDaVez == ultimo) {
            ultimo = anterior;
        }

        return noDaVez.peca;
    }

    public Peca removerPeca(Peca peca) {
        No noDaVez = inicio;
        while (noDaVez != null) {
            if (noDaVez.peca.equals(peca)) {
                No anterior = noDaVez.anterior;
                No proximo = noDaVez.proximo;

                if (anterior != null) {
                    anterior.proximo = proximo;
                } else {
                    inicio = proximo;
                }

                if (proximo != null) {
                    proximo.anterior = anterior;
                } else {
                    ultimo = anterior;
                }

                return noDaVez.peca;
            }
            noDaVez = noDaVez.proximo;
        }
        return null;
    }


    public boolean isVazia(){
        return inicio == null;
    }
    public static void CriarPecas(Lista lista) {
        Random random = new Random();
        while (lista.tamanhoLista() != 15) {
            int ladoA = random.nextInt(7);
            int ladoB = random.nextInt(7);
            Peca novaPeca = new Peca(ladoA, ladoB);
            lista.inserir(novaPeca);

        }
    }
    public Lista distribuirPecasJogadores(Lista pecas) {
        No noDaVez = pecas.inicio;
        Lista pecasJogadores = new Lista();
        int contador = 1;
        while(noDaVez != null) {
            if(contador < 7) {
                pecasJogadores.inserir(noDaVez.peca);
                pecas.removerNaPosicao(1);
            }
            noDaVez = noDaVez.proximo;
            contador++;
        }
        return pecasJogadores;
    }
}