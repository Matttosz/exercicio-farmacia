package farmacia;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import farmacia.controller.FarmaciaController;
import farmacia.model.Farmaco;
import farmacia.model.Cosmetico;
import farmacia.util.CoresFarmacia;

public class Menu {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        FarmaciaController farmaciaController = new FarmaciaController();

        float preco;
        boolean generico;
        int opcaoProduto, idProduto, tipoProduto = 0;
        String tipo, nomeProduto, fragancia;

        while (true) {
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT);
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT + CoresFarmacia.TEXT_BLUE_BOLD + "=========================================");
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT + CoresFarmacia.TEXT_RED_BOLD  + "     Farmácia Gekyume - Menu Principal   ");
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT + CoresFarmacia.TEXT_BLUE_BOLD + "=========================================");
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT + CoresFarmacia.TEXT_RED_BOLD  + "0 - Sair                                 ");
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT + CoresFarmacia.TEXT_RED_BOLD  + "1 - Adicionar um Produto                 ");
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT + CoresFarmacia.TEXT_RED_BOLD  + "2 - Listar todos os Fármacos e Cosméticos");
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT + CoresFarmacia.TEXT_RED_BOLD  + "3 - Procurar um Produto por Nome         ");
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT + CoresFarmacia.TEXT_RED_BOLD  + "4 - Atualizar Informações de um Produto  ");
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT + CoresFarmacia.TEXT_RED_BOLD  + "5 - Deletar Produto em Estoque           ");
            System.out.println(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT + CoresFarmacia.TEXT_BLUE_BOLD + "=========================================");
            System.out.print(CoresFarmacia.ANSI_WHITE_BACKGROUND_BRIGHT   + CoresFarmacia.TEXT_RED_BOLD  + "\nEscolha uma opção: ");

            try {
                opcaoProduto = read.nextInt();
                read.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println(CoresFarmacia.TEXT_RED_BOLD + "\nEntrada inválida! Digite apenas números.");
                read.nextLine();
                continue;
            }

            switch (opcaoProduto) {
                case 0:
                    System.out.println(CoresFarmacia.TEXT_BLUE_BOLD + "=======================================");
                    System.out.println("\nEncerrando o sistema...");
                    System.out.println(CoresFarmacia.TEXT_BLUE_BOLD + "=======================================");
                    sobre();
                    read.close();
                    System.exit(0);
                    break;

                case 1:
                    System.out.println(CoresFarmacia.TEXT_BLUE_BOLD + "=======================================");
                    System.out.println(CoresFarmacia.TEXT_GREEN_BOLD_BRIGHT + "\nMenu de Adição ");
                    System.out.println(CoresFarmacia.TEXT_BLUE_BOLD + "=======================================");

                    System.out.println("Qual o nome do produto?");
                    System.out.println("Ex: Omeprazol 25mg");
                    System.out.print("R: ");
                    nomeProduto = read.nextLine();

                    System.out.println("\n=======================================\n");
                    System.out.println("Qual o tipo do produto (Farmaco/Cosmetico) ?");
                    System.out.print("R: ");
                    tipo = read.next().toLowerCase();

                    System.out.println("\n=======================================\n");
                    System.out.println("Qual o valor Unitário do produto? ");
                    System.out.println("Ex: 50,00");
                    System.out.print("R: ");
                    preco = read.nextFloat();

                    tipoProduto = tipo.equals("farmaco") ? 1 : 2;

                    switch (tipo) {
                        case "farmaco":
                            System.out.println("\n=======================================\n");
                            System.out.println("Se trata de um Fármaco genérico? (sim/não): ");
                            String resposta = read.next().toLowerCase();

                            if (resposta.equals("sim")) {
                                generico = true;
                            } else {
                                generico = false;
                            }

                            farmaciaController.CadastrarProdutos(
                                new Farmaco(farmaciaController.gerarId(), nomeProduto, tipoProduto, preco, generico)
                            );
                            //keypress();
                            break;

                        case "cosmetico":
                            System.out.println("\n=======================================\n");
                            System.out.println("Qual o nome da fragância do cosmético?");
                            System.out.println("Ex: Paixão do Sol");
                            System.out.print("R: ");
                            read.nextLine();
                            fragancia = read.nextLine().toLowerCase();
                            
                            farmaciaController.CadastrarProdutos(
                                    new Cosmetico(farmaciaController.gerarId(), nomeProduto, tipoProduto, preco, fragancia));
                            keypress();
                            break;

                        default:
                            System.out.println(CoresFarmacia.TEXT_RED_BOLD + "Tipo inválido. Digite 'farmaco' ou 'cosmetico'.");
                            break;
                    }
                    keypress();
                    break;

                case 2:
                    System.out.println("=======================================");
                    System.out.println("\nAqui estão nossos produtos em estoque:");
                    System.out.println("=======================================");
                    farmaciaController.ListarProdutos();
                    keypress();
                    break;

                case 3:
                    System.out.println("===============================================");
                    System.out.println("\nDigite o nome do produto que deseja procurar:");
                    System.out.println("===============================================");
                    String nome = read.nextLine();
                    farmaciaController.ProcurarPorNome(nome);
                    keypress();
                    break;

                case 4:
                    System.out.println("==================================================");
                    System.out.println("\nAtualizar Produto (implementar lógica com dados):");
                    System.out.println("==================================================");
                    farmaciaController.AtualizarProduto(null);
                    keypress();
                    break;

                case 5:
                    System.out.println("============================================");
                    System.out.println("\nDigite o ID do produto que deseja deletar:");
                    System.out.println("============================================");
                    try {
                        int id = read.nextInt();
                        farmaciaController.DeletarProdutoPorId(id);
                    } catch (InputMismatchException e) {
                        System.out.println(CoresFarmacia.TEXT_RED_BOLD + "ID inválido.");
                        read.nextLine();
                    }
                    keypress();
                    break;    
                default:
                    System.out.println(CoresFarmacia.TEXT_BLUE_BOLD + "================================================================");
                    System.out.println(CoresFarmacia.TEXT_RED_BOLD  + "\nOpção inválida! Tente novamente.");
                    System.out.println(CoresFarmacia.TEXT_BLUE_BOLD + "================================================================");
                    keypress();
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println(CoresFarmacia.TEXT_PURPLE_BOLD_BRIGHT + "\n=========================================================");
        System.out.println(CoresFarmacia.TEXT_PURPLE_BOLD_BRIGHT + "Projeto Desenvolvido por: Muris");
        System.out.println(CoresFarmacia.TEXT_PURPLE_BOLD_BRIGHT + "Generation Brasil - murilom@generation.org");
        System.out.println(CoresFarmacia.TEXT_PURPLE_BOLD_BRIGHT + "https://github.com/Matttosz");
        System.out.println(CoresFarmacia.TEXT_PURPLE_BOLD_BRIGHT + "===========================================================");
    }

    public static void keypress() {
        try {
            System.out.println(CoresFarmacia.TEXT_RESET + "\nPressione Enter para continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Erro ao esperar tecla. Continue.");
        }
    }
}
