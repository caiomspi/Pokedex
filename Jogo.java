import java.util.ArrayList;
import java.util.Random;
public class Jogo{
    static int resposta=0;
    static ArrayList<Pokemon> pokelista= new ArrayList<>();
    static Random gerador = new Random();

    public static void album(){ //funcao para cadastrar pokemons existentes na pokedex
        for(int i=0;i<Admin.pokexistentes.size();i++){
            Jogo.pokelista.add(Admin.pokexistentes.get(i));
        }
    }

    public static void jogo(){ //funcao main do jogo
        if(Jogo.pokelista.size()!=Admin.pokexistentes.size()){ //verificacao se houve mudança na pokedex
                Jogo.album();
            }

        if(Jogo.pokelista.size()==0){ //verificacao se existem pokemons cadastrados
            System.out.println("Nenhum pokémon encontrado!");
            Main.loop = false;
        }

        else{
            int number, i, nivel, chance;
            System.out.print("\n-------MENU-------\n1 - Procurar novo pokémon\n2 - Listar pokémon pegos\n3 - Sair\nResposta: ");
            try {
                Jogo.resposta = Integer.valueOf(Main.sc.nextLine());
            } catch (Exception e) {
                // TODO: handle exception
            }
            switch(Jogo.resposta){
                //Procurar novo pokémon
                case 1:
                    number = Jogo.gerador.nextInt(Jogo.pokelista.size());
                    chance = Jogo.gerador.nextInt(10);
                    if(Jogo.pokelista.get(number).nivelmax!=Jogo.pokelista.get(number).nivelmin){
                        nivel = Jogo.gerador.nextInt(Jogo.pokelista.get(number).nivelmax - Jogo.pokelista.get(number).nivelmin) + Jogo.pokelista.get(number).nivelmin;
                    }

                    else{
                        nivel=Jogo.pokelista.get(number).nivelmax;
                    }

                    System.out.print("\nApareceu um pokemon!\n\nNome: " + Jogo.pokelista.get(number).nome + "\nNivel: " + nivel + "\n\n1 - Capturar\n2 - Fugir\n\nResposta: ");
                    Jogo.resposta=Integer.valueOf(Main.sc.nextLine());
                    if(Jogo.resposta==1){
                        if(chance%2==0){ //chance de 50% de captura
                            for(i=0;i<Jogo.pokelista.size();i++){
                                if(Jogo.pokelista.get(i).nome.equals(Jogo.pokelista.get(number).nome)){
                                    Jogo.pokelista.get(i).nivel=nivel;
                                    Jogo.pokelista.get(i).capturado=true;
                                }
                            }
                            System.out.println("\nVoce capturou ele!");
                        }
                        else{
                            System.out.println("Voce nao capturou ele...");
                        }
                    }
                    else{
                        System.out.println("Voce Fugiu!");
                    }
                    Jogo.resposta=1;
                break;
            
            //Listar pokémon capturados
            case 2:
                for(i=0;i<Jogo.pokelista.size();i++){
                    if(Jogo.pokelista.get(i).capturado==true){
                        System.out.println("Nome: " + Jogo.pokelista.get(i).nome + "\nNivel: " + Jogo.pokelista.get(i).nivel + "\n");
                    }
                    else{
                        System.out.println("\nNome: -------\nNivel: --");
                    }
                }
                break;
            
            //Sair
            case 3:
                System.out.println("Obrigado por Jogar!");
                Main.loop=false;
                break;
            
            default:
                System.out.println("Opção inválida!");
            }
        }
    }
}