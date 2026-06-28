import java.util.ArrayList;

public class Admin{
    static ArrayList<Pokemon> pokexistentes = new ArrayList<>();
    static int id=1;

    public static void adicionar(){
        Pokemon poke = new Pokemon();
        System.out.print("\nQual o nome do pokémon a ser adicionado: ");
        poke.nome=Main.sc.nextLine();
        System.out.print("Qual o tipo do pokémon a ser adicionado: ");
        poke.tipo=Main.sc.nextLine();
        System.out.print("Qual o nível minímo em que ele poderá aparecer: ");
        poke.nivelmin=Integer.valueOf(Main.sc.nextLine());;
        System.out.print("Qual o nível máximo em que ele poderá aparecer: ");
        poke.nivelmax=Integer.valueOf(Main.sc.nextLine());
        poke.id=Admin.id;
        Admin.id++;
        poke.capturado=false;
        Admin.pokexistentes.add(poke);
        System.out.println("\n\nPokémon adicionado com sucesso!\n");
    }

    //função para listar os pokemon adicionados
    public static void listar_adm(){
        for(Pokemon poke : Admin.pokexistentes){
            System.out.println("\nNome: " + poke.nome + "\n" + "Tipo: " + poke.tipo + "\n" + "Nível: " + poke.nivelmin + "-" + poke.nivelmax + "\n" + "ID: " + poke.id + "\n");
        }
    }

    public static void remover_adm(){
        int escolha, cont=0;

        System.out.println("Pokémon adicionados:");
        for(Pokemon poke : Admin.pokexistentes){
            System.out.println("\nNome: " + poke.nome + "\n" + "Tipo: " + poke.tipo + "\n" + "Nível: " + poke.nivelmin + "-" + poke.nivelmax + "\n" + "ID: " + poke.id + "\n");
        }
        System.out.print("Escreva o ID do Pokémon que será removido: ");
        escolha=Integer.valueOf(Main.sc.nextLine());
        for(Pokemon poke : Admin.pokexistentes){
            if(escolha==poke.id){
                Admin.pokexistentes.remove(cont);
                break;
            }
            cont++;
        }
        System.out.println("\nRemovido com sucesso!\n");
    }
}