import java.util.Scanner;
public class Main{
public static Scanner sc = new Scanner(System.in);
public static void main(String[] args){
    //declarando variaveis
    int resp=0, senha=123;
    

    //menu
    System.out.println("Bem vindo ao Simulador de Pokédex\n");
    while(resp!=3){
        System.out.print("-------MENU-------\n1 - Jogar\n2 - Admin\n3 - Sair\n\nResposta: ");
        resp=Integer.valueOf(sc.nextLine()); //usando assim pois o \n estava ficando no buffer e conflitando com o prox nextLine()
            switch(resp){
                case 1: //tela para entrar no jogo
                    
                    break;
                    
                case 2: //tela para editar pokemons que aparecem
                    System.out.print("\nDigite a senha: ");
                    resp=Integer.valueOf(sc.nextLine());
                    if(resp==senha){
                        System.out.println("\nBem vindo!\n");
                        System.out.print("-------MENU-------\n1 - Adicionar Pokémon\n2 - Remover Pokémon\n3 - Listar Pokémon\n4 - Sair\n\nResposta: ");
                        resp=Integer.valueOf(sc.nextLine());
                        switch(resp){
                            case 1: //adicionar pokemons novos
                                Admin.adicionar();
                                break;

                            case 2: //remover pokemons
                                Admin.remover_adm();
                                System.out.println("Teste 1");
                                break;
                            
                            case 3: //listar pokemons existentes
                                Admin.listar_adm();
                                break;
                            
                            case 4: //sair
                                System.out.println("Obrigado!\n");
                                break;
                            
                            default:
                                System.out.println("Opção Inválida!\n");
                        }
                        resp=2;
                    }
                    else{
                        System.out.println("\nSenha inválida!");
                    }
                    resp=2;
                    break;

                case 3: //sair
                    System.out.println("\nObrigado por jogar!");
                    break;

                default: //opção não citada
                    System.out.println("\nOpção inválida!\n");
                    break;
        }
    }
}
}