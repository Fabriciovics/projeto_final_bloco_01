import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        //Declaração de variaveis
        int opcao;

        //Scanner - para entrada de dados
        Scanner leia = new Scanner(System.in);

        //Menu
        while (true) {
            System.out.println("*****************************************************");
            System.out.println("                  <<< ZÉ GAMES >>>                   ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Cadastrar Produto                    ");
            System.out.println("            2 - Listar todos os Produtos             ");
            System.out.println("            3 - Buscar Produto por ID                ");
            System.out.println("            4 - Atualizar Produto                    ");
            System.out.println("            5 - Excluir Produto                      ");
            System.out.println("            0 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.print("Entre com a opção desejada:                            ");

            //Armazena a opcao de entrada digitada
            opcao = leia.nextInt();

            if (opcao == 0) {
                System.out.print("");
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar Produto\n\n");

                    break;
                case 2:
                    System.out.println("Listar todos os Produtos\n\n");
                    break;
                case 3:
                    System.out.println("Buscar Produto por ID \n\n");
                    break;
                case 4:
                    System.out.println("Atualizar Produto\n\n");
                    break;
                case 5:
                    System.out.println("Excluir Produto \n\n");
                    break;
            }
        }
    }
}