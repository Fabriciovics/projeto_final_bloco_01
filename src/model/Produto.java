package model;

import java.text.NumberFormat;

public abstract class Produto {

    private int id;
    private String nome;
    private int tipo;
    private double preco;
    private int  quantidade;

    public Produto(int id, String nome, int tipo, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void visualizar(){

        NumberFormat nfMoeda =  NumberFormat.getCurrencyInstance();

        String tipo = "";

        switch (this.tipo) {
            case 1 -> tipo = "Console";
            case 2 -> tipo = "Jogo";
            default -> tipo = "Tipo Inválido";
        }
        System.out.println("**********************************");
        System.out.println("DADOS DO PRODUTO                  ");
        System.out.println("**********************************");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Preço: " + nfMoeda.format(this.preco));
        System.out.println("Quantidade: " + this.quantidade);
    }
}
