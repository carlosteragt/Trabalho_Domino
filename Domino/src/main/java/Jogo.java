public class Jogo {
    Lista todasPecas = new Lista();
    Lista jogadorHumano = new Lista();
    Lista jogadorComputador = new Lista();
    Lista mesa;
    private boolean emJogo;

    public Jogo() {
        this.mesa = new Lista();
        this.emJogo = true;
    }

    public void IniciarJogo() {
        Lista.CriarPecas(todasPecas);
        jogadorHumano = jogadorHumano.distribuirPecasJogadores(todasPecas);
        jogadorComputador = jogadorComputador.distribuirPecasJogadores(todasPecas);
        mesa = mesa.distribuirPecasJogadores(todasPecas);
        Output.printDistribuicaoInicialPecas(jogadorHumano, jogadorComputador, mesa);
        jogar();
    }
    private void pecaInicial() {
        Peca pecaInicial = todasPecas.removerNaPosicao(0);
        this.mesa.inserir(pecaInicial);
    }

    private void jogar() {
        pecaInicial();
        Lista ultimoJogador = jogadorComputador;
        int contadorPassagem = 0;
        int pecasJogadorHumano = jogadorHumano.tamanhoLista();
        int pecasJogadorComputador = jogadorComputador.tamanhoLista();

        while (emJogo) {
            Peca ultimaPecaMesa = mesa.UltimaPeca();
            Lista jogadorDaVez = (ultimoJogador == jogadorHumano) ? jogadorComputador : jogadorHumano;
            Peca pecaJogavel = jogadorDaVez.obterPecaValida(ultimaPecaMesa, jogadorDaVez);

            if (pecaJogavel != null) {
                contadorPassagem = 0;
                if (jogadorDaVez == jogadorComputador) {
                    vezJogadorComputador(jogadorDaVez, ultimaPecaMesa, pecaJogavel, pecasJogadorComputador);
                } else {
                    vezJogadorHumano(jogadorDaVez, ultimaPecaMesa, pecaJogavel,pecasJogadorHumano);
                }
            }else {
                Output.mensagemSemPecaValida(jogadorDaVez, jogadorHumano);
                contadorPassagem++;
                if (contadorPassagem >= 2 && pecasJogadorHumano == pecasJogadorComputador) {
                    Output.mensagemEmpate();
                    emJogo = false;
                } else if (contadorPassagem >= 2) {
                    String vencedor = (pecasJogadorHumano < pecasJogadorComputador) ? "principal" : "robô";
                    Output.mensagemVencedorMenosPecas(vencedor);
                    emJogo = false;
                }
            }
            verificarVencedor(jogadorDaVez);
            ultimoJogador = jogadorDaVez;
        }
    }
    private void vezJogadorHumano(Lista jogadorDaVez, Peca ultimaPecaMesa, Peca pecaJogavel, int pecasJogadorHumano) {
        if (pecaJogavel != null) {
            Output.suaVezDeJogar();
            Output.suasPecas();
            jogadorDaVez.imprimirPecas();
            Output.pedirPosicaoParaJogar(jogadorDaVez.tamanhoLista());

            boolean jogadaValida = false;
            while (!jogadaValida) {
                int indiceEscolhido = Input.lerOpcao();
                if (indiceEscolhido >= 1 && indiceEscolhido <= jogadorDaVez.tamanhoLista()) {
                    Peca pecaEscolhida = jogadorDaVez.obterPecaPorPosicao(indiceEscolhido - 1);
                    if (pecaEscolhida.eValida(ultimaPecaMesa)) {
                        Output.mostrarJogadaRealizada(pecaEscolhida);
                        jogadorDaVez.removerPeca(pecaEscolhida);
                        mesa.inserir(pecaEscolhida);
                        Output.pecaNaMesaAposJogada();
                        Output.separacao();
                        mesa.imprimirPecas();
                        Output.separacao();

                        jogadaValida = true;

                        pecasJogadorHumano--;
                    } else {
                        Output.pecaEscolhidaNaoValida();
                        Output.suasPecas();
                        jogadorDaVez.imprimirPecas();
                        Output.pedirPosicaoParaJogar(jogadorDaVez.tamanhoLista());
                    }
                } else {
                    Output.posicaoInvalido();
                }
            }
        } else {
            Output.passouAVez();
        }
    }

    private void vezJogadorComputador(Lista jogadorDaVez, Peca ultimaPecaMesa, Peca pecaJogavel, int pecasJogadorComputador) {
        if (pecaJogavel != null) {
            if (pecaJogavel.eValida(ultimaPecaMesa)) {
                Output.vezDoComputaddor();
                Output.computadorJogouPeca(pecaJogavel);
                jogadorDaVez.removerPeca(pecaJogavel);
                mesa.inserir(pecaJogavel);
                Output.pecaNaMesaJogadorComputador();

                Output.separacao();
                mesa.imprimirPecas();
                Output.separacao();

                Output.pecasJogadorComputador();
                jogadorDaVez.imprimirPecas();

                pecasJogadorComputador--;
                pecasJogadorComputador--;

            }
        } else {
            Output.computadorPassouAVez();
        }
    }
    private void verificarVencedor(Lista jogadorAtual) {
        if (jogadorAtual.tamanhoLista() == 0) {
            System.out.println("Jogador " + (jogadorAtual == jogadorHumano ? "Humano" : "Computador") + " venceu!");
            emJogo = false;
        }
    }
}






