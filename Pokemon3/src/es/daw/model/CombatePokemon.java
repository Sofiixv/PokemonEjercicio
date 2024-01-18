package es.daw.model;

import java.util.Random;
import java.util.Scanner;

import es.daw.App;
import es.daw.utils.CalculoTipos;
import es.daw.utils.Utils;

public class CombatePokemon {
    // ATRIBUTOS
    private int vidaPokemons;

    // GETTERS AND SETTER

    public int getVidaPokemons() {
        return vidaPokemons;
    }

    public void setVidaPokemons(int vidaPokemons) {
        this.vidaPokemons = vidaPokemons;
    }

    // CONSTRUCTORES

    public CombatePokemon(int vidaPokemons) {
        this.vidaPokemons = vidaPokemons;
    }

    // METODOS
    public double calculoAtaqueFinal(Pokemon pokemonSeleccionado, Pokemon pokemonRival) {
        double ataquePokemon = pokemonSeleccionado.getAtaque();
        ataquePokemon = CalculoTipos.calculoEfectividadTipos(pokemonSeleccionado, pokemonRival, ataquePokemon);
        System.out.println("El ataque de " + pokemonSeleccionado.getNombre() + " ha pasado a ser: " + ataquePokemon);
        return ataquePokemon;
        
    }

    public void combate(Pokemon pokemon1, Pokemon pokemon2) {
        Scanner scc = new Scanner(System.in);
        boolean pokemonMuerto = false;
        boolean defensaExitosa = false;
        double vidaPokemon1 = vidaPokemons;
        double vidaPokemon2 = vidaPokemons;
        System.out.println("----------------------------------");
        double ataquePokemon1 = calculoAtaqueFinal(pokemon1, pokemon2);
        double ataquePokemon2 = calculoAtaqueFinal(pokemon2, pokemon1);
        int opcion;

        System.out.println("----------------------------------");
        System.out.println("Va a empezar un combate entre " + pokemon1.getNombre() + " y " + pokemon2.getNombre());

        while (!pokemonMuerto) {
            defensaExitosa = false;

            System.out.println("----------------------------------");
            System.out.println(pokemon1.getNombre() + " " + pokemon1.getNivel() + "lvl " + vidaPokemon1 + "%");
            System.out.println(pokemon2.getNombre() + " " + pokemon2.getNivel() + "lvl " + vidaPokemon2 + "%");
            System.out.println("----------------------------------");

            System.out.println("Que quieres que haga " + pokemon1.getNombre());
            System.out.println("    1.Atacar\n    2.Defenderse");
            System.out.print("> ");
            opcion = scc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(pokemon1.getNombre() + " va a realizar un ataque");
                    System.out.println(
                            pokemon1.getNombre() + " le va a quitar " + ataquePokemon1 + " a " + pokemon2.getNombre());
                    vidaPokemon2 -= ataquePokemon1;
                    break;

                case 2:
                    System.out.println(pokemon1.getNombre() + " va a intentar defenderse");
                    switch (intentoDefensa()) {
                        case 1:
                            System.out.println(pokemon1.getNombre()
                                    + " se ha defendido con exito, el pokemon rival no puede atacar");
                            defensaExitosa = true;
                            break;
                        case 2:
                            System.out.println(pokemon1.getNombre() + " no ha conseguido defenderse");
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("Esa no es una opcion correcta!");
                    break;
            }
            System.out.println("----------------------------------");
            if (!defensaExitosa) {
                switch (decisionRival()) {
                    case 1:
                        System.out.println(pokemon2.getNombre() + " va a realizar un ataque");
                        System.out.println(pokemon2.getNombre() + " le va a quitar " + ataquePokemon2 + " a "
                                + pokemon1.getNombre());
                        vidaPokemon1 -= ataquePokemon2;
                        break;
                    case 2:
                        System.out.println(pokemon2.getNombre() + " va a intentar defenderse");
                        switch (intentoDefensa()) {
                            case 1:
                                System.out.println(pokemon2.getNombre()
                                        + " se ha defendido con exito, el ataque rival no tendra efecto");
                                defensaExitosa = true;
                                if (vidaPokemon2 < 100) {
                                    vidaPokemon2 += ataquePokemon1;
                                }
                                break;
                            case 2:
                                System.out.println(pokemon2.getNombre() + " no ha conseguido defenderse");
                                break;
                            default:
                                break;
                        }
                        break;

                    default:
                        break;
                }
            }

            if (vidaPokemon1 <= 0 || vidaPokemon2 <= 0) {
                pokemonMuerto = true;
            }

        }
        if (vidaPokemon1 <= 0) {
            System.out.println("----------------------------------");
            System.out.println(pokemon1.getNombre() + " se ha debilitado");
            System.out.println("----------------------------------");
        } else if (vidaPokemon2 <= 0) {
            System.out.println("----------------------------------");
            System.out.println(pokemon2.getNombre() + " se ha debilitado");
            System.out.println("----------------------------------");
        }

    }

    public int decisionRival() {

        if (randomAccionRival() == 5 || randomAccionRival() == 3) {
            return 2;
        } else {
            return 1;
        }

    }

    public int intentoDefensa() {
        if (randomDefensa() % 2 == 0) {
            return 1;
        } else if (randomDefensa() % 2 != 0) {
            return 2;
        }
        return -1;
    }

    public int randomDefensa() {
        Random r = new Random();

        int numAleatorio;
        numAleatorio = r.nextInt(10) + 1;

        return numAleatorio;
    }

    public int randomAccionRival() {
        Random r = new Random();

        int numAleatorio;
        numAleatorio = r.nextInt(5);

        return numAleatorio;
    }

    
}
