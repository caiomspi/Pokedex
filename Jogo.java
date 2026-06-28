import java.util.ArrayList;
import java.util.Random;
public class Jogo{
    static ArrayList<Pokemon> pokelista= new ArrayList<>();
    static Random gerador = new Random();

    public static void album(){
        for(int i=0;i<Admin.pokexistentes.size();i++){
            Jogo.pokelista.add(Admin.pokexistentes.get(i));
        }
    }

    public static void jogo(){
        int resposta=0, number, i;
        Jogo.album();
        System.out.print("-------MENU-------\n1 - Procurar novo pokémon\n2 - Listar pokémon pegos\n3 - Sair\nResposta: ");
        resposta = Main.sc.nextInt();
        switch(resposta){
            //Procurar novo pokémon
            case 1:
                number=Jogo.gerador.nextInt();
                
                break;
            
            //Listar pokémon capturados
            case 2:
                for(i=0;i<Jogo.pokelista.size();i++){
                    if(Jogo.pokelista.get(i).flag==true){
                        System.out.println("Nome: " + Jogo.pokelista.get(i).nome + "\nNivel: " + Jogo.pokelista.get(i).nivel"\n");
                    }
                    else{
                        System.out.println("Nome: -------\nNivel: --");
                    }
                }
                break;
            
            //Sair
            case 3:
                System.out.println("Obrigado por Jogar!");
                break;
        }
    }
}