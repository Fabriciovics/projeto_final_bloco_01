package repository;

import model.Produto;

public interface ProdutoRepository {

    //Metodos Crud
    public void criarProduto(Produto produto);
    public void listarProdutos();
    public void consultarProduto(int numero);
    public void atualizarProduto(Produto produto);
    public void excluirProduto(int numero);

}
