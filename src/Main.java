public class Main {
    public static void main(String[] args) {
        Banco Itau = new Banco("Itau");
        Banco Caixa = new Banco("Caixa");

        Cliente henrique = new Cliente("Henrique");
        Cliente jessica = new Cliente("Jessica");
        Cliente marques = new Cliente("Marques");

        Conta corrente1 = new ContaCorrente(henrique);
        Conta poupanca1 = new ContaPoupanca(jessica);
        Conta corrente2 = new ContaCorrente(marques);

        Itau.addContas(corrente1);
        Itau.addContas(corrente2);
        Itau.addContas(poupanca1);


        corrente1.depositar(100);
        corrente1.transferir(70, poupanca1);
        poupanca1.transferir(20, corrente2);


        corrente1.imprimirExtrato();
        poupanca1.imprimirExtrato();
        corrente2.imprimirExtrato();

        System.out.println("Testando lombok: " + corrente1.getAgencia());
        System.out.println("Testando lombok: " + corrente1.getCliente().getNome());

    }
}
