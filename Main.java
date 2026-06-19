import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //declarando variaveis
        int resp=0, senha=123;
        Scanner sc = new Scanner(System.in);

        //menu
        System.out.println("Bem vindo ao Simulador de Pokédex\n");
        while(resp!=3){
            System.out.print("-------MENU-------\n1 - Jogar\n2 - Admin\n3 - Sair\n\nResposta: ");
            resp=sc.nextInt();
            switch(resp){
                case 1: //tela para entrar no jogo

                    break;
                    
                case 2: //tela para editar pokemons que aparecem
                    System.out.print("\nDigite a senha: ");
                    resp=sc.nextInt();
                    System.out.println(resp + " " + senha);
                    if(resp==senha){
                        System.out.println("\nBem vindo!");
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