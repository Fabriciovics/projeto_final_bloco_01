package model;

public class Jogos extends Produto {

    private String plataforma;

    public Jogos(int id, String nome, int tipo, double preco, int quantidade, String plataforma) {
        super(id, nome, tipo, preco, quantidade);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    @Override
    public void visualizar(){
        super.visualizar();
        System.out.println("Plataforma: "+this.plataforma);
    }
}
