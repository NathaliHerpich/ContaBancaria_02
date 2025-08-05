package br.com.biblioteca;

public class Cliente {
    private String nome;
    private String tipoDeConta;
    private double saldo;

    public Cliente(String nome, String tipoDeConta, double saldoInicial, int codigo) {
        this.nome = nome;
        this.tipoDeConta = tipoDeConta;
        this.saldo = saldoInicial;

    }

    public String getNome() {
        return nome;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setDepositaValor(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
        System.out.println(getExtrato());
    }

    public void setSaqueValor(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saque inválido ou saldo insuficiente.");
        }
        System.out.println(getExtrato());
    }

    public void setPix(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Pix enviado com sucesso.");
        } else if (valor < 0) {
            saldo += Math.abs(valor); // valor negativo = recebimento
            System.out.println("Pix recebido com sucesso.");
        } else {
            System.out.println("Pix inválido ou saldo insuficiente.");
        }
        System.out.println(getExtrato());
    }

    public String getExtrato() {
        return String.format("Saldo atual da conta %s: R$ %.2f", tipoDeConta, saldo);
    }

    @Override
    public String toString() {
        return """
                ========================
                DADOS INICIAIS DO CLIENTE:
                =========================
                Nome: %s
                Tipo de Conta: %s
                Saldo Inicial: R$
                =========================
                """.formatted(nome, tipoDeConta, saldo);
    }
}
