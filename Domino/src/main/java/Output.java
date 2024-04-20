public class Output {

    public static void printDistribuicaoInicialPecas(Lista jogadorHumano, Lista jogadorComputador, Lista mesa) {
        System.out.println("Distribuição inicial:");
        System.out.println("\nPeças do jogador Humano:");
        jogadorHumano.imprimirPecas();
        System.out.println("\nPeças do jogador Computador:");
        jogadorComputador.imprimirPecas();
        System.out.println("\nPeças na mesa:");
        mesa.imprimirPecas();
    }
    public static void pecasJogadorComputador() {
        System.out.println("Peças restantes do jogador Computador");
    }
    public static void pecaNaMesaJogadorComputador() {
        System.out.println("\nPeças na mesa após a jogada do computador:");
    }

    public static void posicaoInvalido(){
        System.out.println("Posição Invalida! Escolha um posição dentro do intervalo.");
    }

    public static void pecaEscolhidaNaoValida(){
        System.out.println("A peça escolhida não é Valida. Selecione outra peça.");
    }

    public static void suasPecas() {
        System.out.println("Suas peças:");
    }

    public static void suaVezDeJogar() {
        System.out.println("\nSua vez de jogar:");
    }


    public static void passouAVez() {
        System.out.println("\nVocê não tem uma peça valida. Você passou a vez.");
    }
    public static void computadorPassouAVez() {
        System.out.println("\n Jogador computador não tem uma peça jogável. Ele passou a vez.");
    }


    public static void mensagemEmpate() {
        System.out.println("\nNenhum dos jogadores tem uma peça jogável e ambos têm a mesma quantidade de peças. O jogo termina em empate!");
    }

    public static void mensagemSemPecaValida(Lista jogadorAtual, Lista jogadorPrincipal) {
        System.out.println("\n" + (jogadorAtual == jogadorPrincipal ? "Você" : "Jogador computador") + " não tem uma peça jogável. " + (jogadorAtual == jogadorPrincipal ? "Você" : "Ele") + " passou a vez.");
    }

    public static void mensagemVencedorMenosPecas(String vencedor) {
        System.out.println("\nNenhum dos jogadores tem uma peça jogável. O jogador " + vencedor + " venceu por ter menos peças!");
    }

    public static void pedirPosicaoParaJogar(int tamanhoLista) {
        System.out.println("Digite a posição da peça que deseja jogar (1 - " + tamanhoLista + "): ");
    }

    public static void mostrarJogadaRealizada(Peca pecaJogada) {
        System.out.println("Você jogou a peça " + pecaJogada);
    }

    public static void pecaNaMesaAposJogada(){
        System.out.println("\nPeças na mesa após a sua jogada:");
    }

    public static void vezDoComputaddor(){
        System.out.println("\nVez do computador jogar:");
    }
    public static void computadorJogouPeca(Peca pecaJogavel) {
        System.out.println("Jogador Computador jogou uma peça: " + pecaJogavel);
    }

    public static void separacao(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
    }
    public static void espaco(){
        System.out.println(" ");
    }

}

