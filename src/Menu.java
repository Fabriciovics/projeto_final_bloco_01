import controller.ProdutoController;
import model.Console;
import model.Jogos;
import model.Produto;
import util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        //Declaração de variaveis
        int opcao,id,tipo,quantidade;
        String nome,modelo,plataforma,buscaTipo;
        double preco;


        ProdutoController produtos = new ProdutoController();

        //Scanner - para entrada de dados
        Scanner leia = new Scanner(System.in);

        //Menu
        while (true) {
            System.out.println(Cores.TEXT_YELLOW);
            System.out.println("*****************************************************");
            System.out.println("                  <<< ZÉ GAMES >>>                   ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Cadastrar Produto                    ");
            System.out.println("            2 - Listar todos os Produtos             ");
            System.out.println("            3 - Buscar Produto por ID                ");
            System.out.println("            4 - Atualizar Produto                    ");
            System.out.println("            5 - Excluir Produto                      ");
            System.out.println("            6 - Buscar por Tipo                      ");
            System.out.println("            0 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.print("Entre com a opção desejada:                            ");
            try {
            //Armazena a opcao de entrada digitada
            opcao = leia.nextInt();

            if (opcao == 0) {
                System.out.print("Até breve!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar Produto\n\n");
                    System.out.println("Digite o nome do produto: ");
                    leia.skip("\\R");
                    nome = leia.nextLine();

                    System.out.println("Digite o Tipo (1 -Console | 2 - Jogos): ");
                    tipo= leia.nextInt();

                    System.out.println("Digite o preço: ");
                    preco = leia.nextDouble();

                    System.out.println("Quantidade: ");
                    quantidade = leia.nextInt();

                    switch(tipo){
                        case 1 -> {
                            System.out.println("Digite o modelo do console: ");
                            leia.skip("\\R");
                            modelo = leia.nextLine();
                            produtos.criarProduto(
                                    new Console(produtos.gerarNumero(),nome,tipo,preco,quantidade,modelo)
                            );
                        }
                        case 2 -> {
                            System.out.println("Digite a plataforma do jogo: ");
                            leia.skip("\\R");
                            plataforma = leia.nextLine();
                            produtos.criarProduto(
                                    new Jogos(produtos.gerarNumero(),nome,tipo,preco,quantidade,plataforma)
                            );
                        }
                    }
                    keyPress();
                    break;
                case 2:
                    System.out.println("Listar todos os Produtos\n\n");
                    produtos.listarProdutos();
                    keyPress();
                    break;
                case 3:
                    System.out.println("Buscar Produto por ID \n\n");
                    System.out.println("Digite o ID do produto: ");
                    id = leia.nextInt();
                    produtos.procurarPorID(id);
                    keyPress();
                    break;
                case 4:
                    System.out.println("Atualizar Produto\n\n");
                    System.out.println("Digite o ID: ");
                    id = leia.nextInt();

                    Optional<Produto> produto = produtos.buscarNaCollection(id);
                    if(produto.isPresent()){
                        System.out.println("Digite o nome: ");
                        leia.skip("\\R");
                        nome = leia.nextLine();

                        //Recuperar tipo da conta
                        tipo = produto.get().getTipo() ;

                        System.out.println("Altere o preço: ");
                        preco = leia.nextDouble();

                        System.out.println("Altere a quantidade: ");
                        quantidade = leia.nextInt();
                        //Identificar o tipo
                        switch(tipo){
                            case 1 -> {
                                System.out.println("Digite o modelo do console: ");
                                leia.skip("\\R");
                                modelo = leia.nextLine();
                                produtos.atualizarProduto(
                                        new Console(id,nome,tipo,preco,quantidade,modelo)
                                );
                            }
                            case 2 -> {
                                System.out.println("Digite a plataforma do jogo: ");
                                leia.skip("\\R");
                                plataforma = leia.nextLine();
                                produtos.atualizarProduto(
                                        new Jogos(id,nome,tipo,preco,quantidade,plataforma)
                                );
                            }
                        }

                    }else{
                        System.out.printf("\n O Produto ID: %d , nao existe", id);
                    }
                    keyPress();
                    break;
                case 5:
                    System.out.println("Excluir Produto \n\n");
                    System.out.println("Digite o ID: ");
                    id = leia.nextInt();
                    produtos.excluirProduto(id);
                    keyPress();
                    break;
                case 6:
                    System.out.println("Buscar por tipo \n\n");
                    System.out.println("Digite o tipo: ");
                    leia.skip("\\R");
                    buscaTipo = leia.nextLine();
                    produtos.buscarPorTipo(buscaTipo);
                    keyPress();
                    break;
            }
                System.out.println();

            } catch (InputMismatchException e) {
                System.out.println("\nErro: Por favor, digite um número inteiro para a opção.");
                leia.nextLine();
                keyPress();
                opcao = -1;
                System.out.println();
            }
        }
    }
    public static void keyPress() {

        try {

            System.out.println("\n\nPressione Enter para Continuar...");
            System.in.read();

        } catch (IOException e) {

            System.err.println("Ocorreu um erro ao tentar ler o teclado");

        }
    }
    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: ");
        System.out.println("Fabricio Soares - fabricios@genstudents.org");
        System.out.println("github.com/Fabriciovics/projeto_bloco_final1");
        System.out.println("*********************************************************");
    }
}