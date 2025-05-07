package model;

public class Console extends Produto {

    private String modelo;


    public Console(int id, String nome, int tipo, double preco, int quantidade, String modelo) {
        super(id, nome, tipo, preco, quantidade);
        this.modelo = modelo;
    }

    public String getMarca() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.modelo = marca;
    }

    @Override
    public void visualizar(){
        super.visualizar();
        System.out.println("Modelo: "+this.modelo);
    }
}
