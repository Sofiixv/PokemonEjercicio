package es.daw.utils;

import java.util.Random;
import java.util.Scanner;

import es.daw.model.CombatePokemon;
import es.daw.model.Pokemon;

public class Utils {
    static Scanner sc = new Scanner(System.in);
    static Scanner lector = new Scanner(System.in);    
    static String[] tipos = { "agua", "planta", "fuego", "hielo", "tierra", "electrico", "roca", "normal", "lucha", "volador", "dragon" };
    static int contadorPokemon = 0;
    static final int ataqueInicial = 10;
    static final int numeroTotalPokemos = 300;
    static final int vidaPokemons = 100;
    static CombatePokemon combate = new CombatePokemon(vidaPokemons);
    static Pokemon[] pokedex = new Pokemon[numeroTotalPokemos];

    public static void pintarMenu() {
        System.out.println("Que desea hacer?");
        System.out.println("----------------------------------");
        System.out.println(
                "    1.Añadir Pokemons\n    2.Empezar el combate\n    3.Ver la Pokedex\n    4.Salir");

    }

    public static boolean tipoCorrecto(String[] tipos, String tipo) {

        for (int i = 0; i < tipos.length; i++) {
            if (tipos[i].equals(tipo)) {
                return true;
            }
        }

        return false;
    }

    public static void leerPokedex() {
        for (int i = 0; i < contadorPokemon; i++) {
            System.out.println((i + 1) + " " + pokedex[i].getNombre() + " " + pokedex[i].getTipo());
        }
    }

    public static int pokemonCorrecto(int opcion) {
        Scanner opcionPokemon = new Scanner(System.in);
        boolean opcionCorrecta = false;

        while (!opcionCorrecta) {
            if (opcion > contadorPokemon || opcion <= 0) {
                System.out.println("Elige una opcion Correcta!");
                System.out.print("> ");
                opcion = opcionPokemon.nextInt();
            } else {
                opcionCorrecta = true;
                return opcion;
            }
        }
        return -1;
    }

    public static void ampliarPokedex(int cantidadAmpliar) {
        String nombrePokemon;
        String tipoPokemon;
        int nivelPokemon = 0;
        int contador = 0;

        for (int i = contadorPokemon; contador < cantidadAmpliar; i++) {
            boolean nivelCorrecto = false;

            System.out.println("Dime el nombre del  pokemon " + (contador + 1));
            System.out.print("> ");
            nombrePokemon = lector.nextLine();
            System.out.println("Ahora dime el tipo del pokemon");
            System.out.print("> ");
            tipoPokemon = lector.nextLine();
            tipoPokemon = tipoPokemon.toLowerCase();
            while (!tipoCorrecto(tipos, tipoPokemon)) {
                System.out.println("No es un tipo correcto, por favor vuelve a intentarlo.");
                System.out.print("> ");
                tipoPokemon = sc.nextLine();
                tipoPokemon = tipoPokemon.toLowerCase();
            }
            
            contadorPokemon++;
            contador++;
            Pokemon pokemon = new Pokemon(tipoPokemon, nombrePokemon);
            pokedex[i] = pokemon;

        }
    }

    public static double calculoAtaque(int nivelPokemon) {
        double ataque = 0;
        ataque = ataqueInicial + (0.5 * nivelPokemon);
        return ataque;
    }

    public static Pokemon elegirPokemonPropio() {
        int eleccion = 0;
        boolean opcionCorrecta = false;
        boolean nivelCorrecto = false;
        int nivelPokemon = 0;

        System.out.println("Cual quieres que sea tu Pokemon?");
        System.out.print("> ");
        eleccion = sc.nextInt();

        if (eleccion > contadorPokemon || eleccion <= 0) {
            eleccion = pokemonCorrecto(eleccion);
        }
        System.out.println("Tu Pokemon va a ser " + pokedex[eleccion - 1].getNombre());

        while (!nivelCorrecto) {
            System.out.println("Dime su nivel");
            System.out.print("> ");
            nivelPokemon = sc.nextInt();
            if (nivelPokemon > 100 || nivelPokemon <= 0) {
                System.out.println("No es un nivel correcto, tiene que ser entre 0 y 100");
            } else {
                nivelCorrecto = true;
            }
        }
        pokedex[eleccion - 1].setNivel(nivelPokemon);
        pokedex[eleccion - 1].setAtaque(calculoAtaque(nivelPokemon));
        return pokedex[eleccion - 1];
    }

    public static Pokemon elegirPokemonRival() {
        int eleccion = 0;
        boolean opcionCorrecta = false;
        boolean nivelCorrecto = false;
        int nivelPokemon = 0;

        System.out.println("Cual quieres que sea el Pokemon rival?");
        System.out.print("> ");
        eleccion = sc.nextInt();

        if (eleccion > contadorPokemon || eleccion <= 0) {
            eleccion = pokemonCorrecto(eleccion);
        }
        System.out.println("El Pokemon rival va a ser " + pokedex[eleccion - 1].getNombre());

        while (!nivelCorrecto) {
            System.out.println("Dime su nivel");
            System.out.print("> ");
            nivelPokemon = sc.nextInt();
            if (nivelPokemon > 100 || nivelPokemon <= 0) {
                System.out.println("No es un nivel correcto, tiene que ser entre 0 y 100");
            } else {
                nivelCorrecto = true;
            }
        }
        pokedex[eleccion - 1].setNivel(nivelPokemon);
        pokedex[eleccion - 1].setAtaque(calculoAtaque(nivelPokemon));
        return pokedex[eleccion - 1];
    }

    public static boolean combatePosible(){
        if (contadorPokemon<=1) {
            return false;
        }
        else{
            return true;
        }
    }
}
