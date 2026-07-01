import java.util.ArrayList;

public class Admin{
    static ArrayList<Pokemon> pokexistentes = new ArrayList<>();
    static int id=1;
    boolean loop=false;

    public static void adicionar(){
        Admin a = new Admin();
        int i;
        Pokemon poke = new Pokemon();
        System.out.print("\nQual o nome do pokémon a ser adicionado: ");
        poke.nome=Main.sc.nextLine();
        for(i=0;i<Admin.pokexistentes.size();i++){
            if(Admin.pokexistentes.get(i).nome.equals(poke.nome)){
                System.out.println("\nPokemon ja cadastrado!");
                return;
            }
        }
        System.out.print("Qual o tipo do pokémon a ser adicionado: ");
        poke.tipo=Main.sc.nextLine();
        while(a.loop==false){
            System.out.print("Qual o nível minímo em que ele poderá aparecer: ");
            try {
                poke.nivelmin=Integer.valueOf(Main.sc.nextLine());
                a.loop=true;
            } catch (Exception e) {
                System.out.println("Digite um número válido!");
                // TODO: handle exception
            }
        }
        a.loop=false;
        while(a.loop==false){
            System.out.print("Qual o nível máximo em que ele poderá aparecer: ");
            try {
                poke.nivelmax=Integer.valueOf(Main.sc.nextLine());
                a.loop=true;
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        poke.id=Admin.id;
        Admin.id++;
        poke.capturado = false;
        Admin.pokexistentes.add(poke);
        System.out.println("\nPokémon adicionado com sucesso!");
    }

    //função para listar os pokemon adicionados
    public static void listar_adm(){
        for(Pokemon poke : Admin.pokexistentes){
            System.out.println("\nNome: " + poke.nome + "\n" + "Tipo: " + poke.tipo + "\n" + "Nível: " + poke.nivelmin + "-" + poke.nivelmax + "\n" + "ID: " + poke.id + "\n");
        }
    }

    public static void remover_adm(){
        int escolha, cont=0, i;
        boolean verifica=false;

        System.out.println("Pokémon adicionados:");
        for(Pokemon poke : Admin.pokexistentes){
            System.out.println("\nNome: " + poke.nome + "\n" + "Tipo: " + poke.tipo + "\n" + "Nível: " + poke.nivelmin + "-" + poke.nivelmax + "\n" + "ID: " + poke.id + "\n");
        }
        System.out.print("Escreva o ID do Pokémon que será removido: ");
        while(verifica==false){
            try {
                escolha=Integer.valueOf(Main.sc.nextLine());
                for(i=0;i<Admin.pokexistentes.size();i++){
                    if(escolha==Admin.pokexistentes.get(i).id){
                    Admin.pokexistentes.remove(i);
                }
            }
        System.out.println("\nRemovido com sucesso!\n");
                verifica=true;
            } catch (Exception e) {
                System.out.print("Opção inválida!\nResposta: ");
            }
        }
    }
}