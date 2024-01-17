package es.daw;

import java.util.Arrays;
import java.util.Scanner;

import es.daw.model.Pokemon;
import es.daw.model.CombatePokemon;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Scanner lector = new Scanner(System.in);
    static String tipoPokemon1;
    static String nombrePokemon1;
    static String tipoPokemon2;
    static String nombrePokemon2;
    static int nivelPokemon1;
    static int nivelPokemon2;
    static String[] tipos = { "agua", "planta", "fuego", "hielo", "tierra" };
    static int contadorPokemon = 0;
    static final int ataqueInicial = 10;
    static final int numeroTotalPokemos = 300;
    static final int vidaPokemons = 100;
    static double ataquePokemon1 = 0;
    static double ataquePokemon2 = 0;
    static CombatePokemon combate = new CombatePokemon(vidaPokemons);
    static String[][] pokedex = new String[numeroTotalPokemos][2];

    public static void main(String[] args) throws Exception {

        Scanner eleccion = new Scanner(System.in);
        int opcion = 0;
        int opcion2 = 0;

        boolean pokemonsDisponibles = false;

        System.out.println("Bienvenido a la sala de combates pokemon");
        pintarMenu();
        System.out.print("> ");
        opcion = eleccion.nextInt();
        System.out.println("----------------------------------");

        while (opcion != 4) {
            opcion2 = 0;
            switch (opcion) {
                case 1:

                    if (pokemonsDisponibles) {
                        darMasPokemons();
                    } else {

                        pokemonsDisponibles = true;
                        darPokemon1();
                        ataquePokemon1 = ataqueInicial + (0.5 * nivelPokemon1);

                        System.out.println("Tu pokemon tiene de ataque: " + ataquePokemon1);
                        contadorPokemon++;
                        darPokemon2();
                        ataquePokemon2 = ataqueInicial + (0.5 * nivelPokemon2);

                        System.out.println("Tu pokemon tiene de ataque: " + ataquePokemon2);
                        contadorPokemon++;

                    }
                    Pokemon pokemon1 = new Pokemon(tipoPokemon1, nombrePokemon1, nivelPokemon1, ataquePokemon1);
                    Pokemon pokemon2 = new Pokemon(tipoPokemon2, nombrePokemon2, nivelPokemon2, ataquePokemon2);
                    ampliarPokedex(contadorPokemon, pokemon1, pokemon2);

                    while (opcion2 != 4) {
                        pintarMenu();
                        System.out.print("> ");
                        opcion2 = eleccion.nextInt();
                        System.out.println("----------------------------------");
                        switch (opcion2) {
                            // Poner pokemons
                            case 1:
                                opcion2 = 4;
                                opcion = 1;
                                break;
                            // Combate entre pokemons
                            case 2:
                                if (pokemonsDisponibles) {
                                    combate.combate(pokemon1, pokemon2);
                                }

                                else {
                                    System.out.println("Todavia no has creado pokemons!!");
                                }
                                break;
                            // Ver la Pokedex
                            case 3:
                                leerPokedex(contadorPokemon);
                                System.out.println("----------------------------------");
                                break;
                            // Salir
                            case 4:
                                System.out.println("Vas a salir del programa");
                                opcion = 4;
                                break;
                            default:
                                System.out.println("Elige una opcion correcta");
                                break;
                        }
                    }

                    break;
                case 4:
                    System.out.println("Vas a salir del programa");
                    break;
                default:
                    System.out.println("Todavia no has creado pokemons!!");  
                    pintarMenu();
                    System.out.print("> ");
                    opcion = eleccion.nextInt();
                    System.out.println("----------------------------------");
                    break;
            }

        }
    }

    public static boolean tipoCorrecto(String[] tipos, String tipo) {

        for (int i = 0; i < tipos.length; i++) {
            if (tipos[i].equals(tipo)) {
                return true;
            }
        }

        return false;
    }

    public static void darPokemon1() {
        boolean nivelCorrecto = false;

        System.out.println("Dime el nombre del  pokemon");
        System.out.print("> ");
        nombrePokemon1 = lector.nextLine();
        System.out.println("Ahora dime el tipo del pokemon");
        System.out.print("> ");
        tipoPokemon1 = lector.nextLine();
        tipoPokemon1 = tipoPokemon1.toLowerCase();
        while (!tipoCorrecto(tipos, tipoPokemon1)) {
            System.out.println("No es un tipo correcto, por favor vuelve a intentarlo.");
            System.out.print("> ");
            tipoPokemon1 = sc.nextLine();
            tipoPokemon1 = tipoPokemon1.toLowerCase();
        }
        System.out.println("Por ultimo dime su nivel");
        while (!nivelCorrecto) {
            System.out.println("Dime su nivel");
            System.out.print("> ");
            nivelPokemon1 = sc.nextInt();
            if (nivelPokemon1 > 100 || nivelPokemon1 < 0) {
                System.out.println("No es un nivel correcto, tiene que ser entre 0 y 100");
            } else {
                nivelCorrecto = true;
            }
        }

    }

    public static void darPokemon2() {
        boolean nivelCorrecto = false;

        System.out.println("Dime el nombre del  pokemon");
        System.out.print("> ");
        nombrePokemon2 = lector.nextLine();
        System.out.println("Ahora dime el tipo del pokemon");
        System.out.print("> ");
        tipoPokemon2 = lector.nextLine();
        tipoPokemon2 = tipoPokemon2.toLowerCase();
        while (!tipoCorrecto(tipos, tipoPokemon1)) {
            System.out.println("No es un tipo correcto, por favor vuelve a intentarlo.");
            System.out.print("> ");
            tipoPokemon2 = sc.nextLine();
            tipoPokemon2 = tipoPokemon2.toLowerCase();
        }
        System.out.println("Por ultimo dime su nivel");
        while (!nivelCorrecto) {
            System.out.println("Dime su nivel");
            System.out.print("> ");
            nivelPokemon2 = sc.nextInt();
            if (nivelPokemon2 > 100 || nivelPokemon2 < 0) {
                System.out.println("No es un nivel correcto, tiene que ser entre 0 y 100");
            } else {
                nivelCorrecto = true;
            }
        }

    }

    public static void pintarMenu() {
        System.out.println("Que desea hacer?");
        System.out.println("----------------------------------");
        System.out.println("    1.Añadir Pokemons\n    2.Empezar el combate\n    3.Ver la Pokedex\n    4.Salir");

    }

    public static void ampliarPokedex(int contadorPokemon, Pokemon pokemon1, Pokemon pokemon2) {

        pokedex[contadorPokemon - 1][0] = pokemon1.getNombre();
        pokedex[contadorPokemon - 1][1] = pokemon1.getTipo();
        pokedex[contadorPokemon][0] = pokemon2.getNombre();
        pokedex[contadorPokemon][1] = pokemon2.getTipo();

    }

    public static void leerPokedex(int contadorPokemon) {
        for (int i = 1; i <= contadorPokemon; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 2; j++) {
                System.out.print(pokedex[i][j] + " ");

            }
            System.out.println("");
        }
    }

    public static void darMasPokemons() {
        Scanner opcionPokemon = new Scanner(System.in);
        int opcion;
        int opcionPokedex;
        boolean opcionCorrecta = false;

        System.out.println("    1.Añadir Pokemon nuevo\n    2.Usar un Pokemon de la PokeDex");
        System.out.print("> ");
        opcion = opcionPokemon.nextInt();
        System.out.println("----------------------------------");
        switch (opcion) {
            case 1:
                darPokemon1();
                ataquePokemon1 = ataqueInicial + (0.5 * nivelPokemon1);

                System.out.println("Tu pokemon tiene de ataque: " + ataquePokemon1);
                contadorPokemon++;
                darPokemon2();
                ataquePokemon2 = ataqueInicial + (0.5 * nivelPokemon2);

                System.out.println("Tu pokemon tiene de ataque: " + ataquePokemon2);
                contadorPokemon++;

                break;
            case 2:
                elegirPokemonPokedex();

                break;
            default:
                break;
        }

    }

    public static void elegirPokemonPokedex() {
        Scanner opcionPokemon = new Scanner(System.in);
        int opcion;
        int opcionPokedex;
        boolean opcionCorrecta = false;

        leerPokedex(contadorPokemon);
        System.out.println("Cual quieres que sea tu Pokemon");
        System.out.print("> ");
        opcionPokedex = opcionPokemon.nextInt();
        if (opcionPokedex > contadorPokemon || opcionPokedex < contadorPokemon) {
            opcionPokedex = pokemonCorrecto(opcionPokedex);
        }
        System.out.println("Tu Pokemon va a ser " + pokedex[opcionPokedex][0]);
        System.out.println("Que nivel quieres que sea?");
        System.out.print("> ");
        nivelPokemon1 = opcionPokemon.nextInt();
        nombrePokemon1 = pokedex[opcionPokedex][0];
        tipoPokemon1 = pokedex[opcionPokedex][1];

        System.out.println("Ahora elige el Pokemon rival");
        System.out.print("> ");
        opcionPokedex = opcionPokemon.nextInt();
        if (opcionPokedex > contadorPokemon || opcionPokedex < contadorPokemon) {
            opcionPokedex = pokemonCorrecto(opcionPokedex);
        }
        System.out.println("El Pokemon rival va a ser " + pokedex[opcionPokedex][0]);
        System.out.println("Que nivel quieres que sea?");
        System.out.print("> ");
        nivelPokemon2 = opcionPokemon.nextInt();
        nombrePokemon2 = pokedex[opcionPokedex][0];
        tipoPokemon2 = pokedex[opcionPokedex][1];
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

}
