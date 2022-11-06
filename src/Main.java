public class Main {
    public static void main(String[] args) {
        Banco Itau = new Banco("Itau");
        Banco Caixa = new Banco("Caixa");

        Cliente henrique = new Cliente("Henrique");
        Cliente marques = new Cliente("Marques");
        Cliente jessica = new Cliente("Jessica");

        Conta corrente1 = new ContaCorrente(henrique);
        Conta corrente2 = new ContaCorrente(marques);
        Conta poupanca1 = new ContaPoupanca(jessica);


        corrente1.depositar(100);
        corrente1.transferir(70, poupanca1);

        corrente1.imprimirExtrato();
        poupanca1.imprimirExtrato();
    }
}
