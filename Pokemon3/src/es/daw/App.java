package es.daw;

import java.util.Arrays;
import java.util.Scanner;

import es.daw.model.Pokemon;
import es.daw.utils.Utils;
import es.daw.model.CombatePokemon;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Scanner lector = new Scanner(System.in);
    static final int vidaPokemons = 100;
    static CombatePokemon combate = new CombatePokemon(vidaPokemons);

    public static void main(String[] args) throws Exception {

        Scanner eleccion = new Scanner(System.in);
        int opcion = 0;
        int cantidadPokemonAmpliar;
        boolean pokemonsDisponibles = false;

        System.out.println("Bienvenido a la sala de combates pokemon");

        while (opcion != 4) {

            Utils.pintarMenu();
            System.out.print("> ");
            opcion = eleccion.nextInt();
            System.out.println("----------------------------------");
            switch (opcion) {
                case 1:
                    if (!pokemonsDisponibles) {
                        pokemonsDisponibles = true;
                    }                         
                        System.out.println("Cuantos Pokemons quieres añadir?");
                        System.out.print("> ");
                        cantidadPokemonAmpliar = sc.nextInt();
                        Utils.ampliarPokedex(cantidadPokemonAmpliar);                     
                    break;

                case 2:
                    if (Utils.combatePosible()) {
                        Utils.leerPokedex();
                        System.out.println("----------------------------------");
                        combate.combate(Utils.elegirPokemonPropio(), Utils.elegirPokemonRival());
                    } else {
                        System.out.println("Todavia no has creado Pokemons suficientes");
                    }
                    break;

                case 3:

                    if (pokemonsDisponibles) {
                        Utils.leerPokedex();
                    } else {
                        System.out.println("Todavia no has creado Pokemons");
                    }
                    break;
                case 4:
                    System.out.println("Vas a salir del programa");
                    break;
                default:
                    System.out.println("Elige una opcion correcta");
                    break;
            }

        }
    }

}
