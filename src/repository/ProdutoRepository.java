package repository;

import model.Produto;

public interface ProdutoRepository {

    //Metodos Crud
    public void criarProduto(Produto produto);
    public void listarProdutos();
    public void consultarProduto(int id);
    public void atualizarProduto(Produto produto);
    public void excluirProduto(int id);

    //Auxiliares
    public void procurarPorID(int id);

}
