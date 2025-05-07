package controller;

import model.Produto;
import repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.Optional;

public class ProdutoController implements ProdutoRepository {

    int id = 0;

    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    @Override
    public void criarProduto(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    @Override
    public void listarProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto para listar.");
        } else {
            for (var produto : listaProdutos) {
                produto.visualizar();
            }
        }
    }

    @Override
    public void consultarProduto(int numero) {

    }

    @Override
    public void atualizarProduto(Produto produto) {
        Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());
        if(buscaProduto.isPresent()) {
            listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
            System.out.printf("Produto %s ID: %d atualizado com sucesso",produto.getNome(),produto.getId());
        } else {
            System.out.printf("Produto %s ID: %d nao foi encontrada",produto.getNome(), produto.getId());
        }
    }

    @Override
    public void excluirProduto(int id) {
        Optional<Produto> conta = buscarNaCollection(id);
        if (conta.isPresent()) {
            if (listaProdutos.remove(conta.get())) {
                System.out.printf(" Produto  Id: %d ,foi excluido com sucesso!", id);
            } else {
                System.out.printf("Produto Id: %d ,nao foi encontrada", id);
            }
        }
    }

    @Override
    public void procurarPorID(int id){
        Optional<Produto> produto = buscarNaCollection(id);
        if(produto.isPresent()) {
            produto.get().visualizar();

        }else {
            System.out.printf("Produto id: %d , nao foi encontrado", id);
        }
    }

    //Metodos auxiliares
    public int gerarNumero(){
        return ++ id;
    }

    public Optional<Produto> buscarNaCollection(int id){
        for(var  produto : listaProdutos) {
            if (produto.getId() == id)
                return Optional.of(produto);
        }
        return Optional.empty();
    }

}
