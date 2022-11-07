import lombok.Getter;

interface IConta {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, Conta contaDestino);
    void imprimirExtrato();
}
@Getter
public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected double saldo;
    protected int agencia;
    protected int numero;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo){
            saldo -= valor;
        } else System.out.println("Saldo Insuficiente para sacar: " + saldo);

    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor <= saldo){
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else System.out.println("Saldo Insuficiente para transferencia: " + saldo);

    }

    protected void ImprimirInfo() {
        System.out.println("Nome: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }

}

class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Corrente");
        ImprimirInfo();
    }

}

class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupanca");
        ImprimirInfo();
    }


}
