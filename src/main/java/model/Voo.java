package model;

public class Voo {
    private String origem;
    private String destino;
    private String data;
    private int qtdPessoas;
    private double valor;
    private String horario;

    public Voo(String origem, String destino, String data, int qtdPessoas) {
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.qtdPessoas = qtdPessoas;
        this.valor = 0.0;
        this.horario = "";
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }


    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
