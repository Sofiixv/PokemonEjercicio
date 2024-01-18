package es.daw.utils;

import es.daw.model.Pokemon;

public class CalculoTipos {
    public static double calculoEfectividadTipos(Pokemon pokemonSeleccionado, Pokemon pokemonRival, double ataque) {

        switch (pokemonSeleccionado.getTipo()) {
            case "fuego":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 0.5;

                    case "agua":

                        return ataque * 0.5;
                    case "planta":

                        return ataque * 2;

                    case "tierra":

                        return ataque * 1;
                    case "hielo":

                        return ataque * 2;
                    case "electrico":
                        return ataque * 1;

                    case "roca":

                        return ataque * 0.5;
                    case "normal":

                        return ataque * 1;

                    case "lucha":

                        return ataque * 1;
                    case "volador":

                        return ataque * 1;

                    case "dragon":
                        return ataque * 0.5;        
                    default:
                        break;
                }
                break;

            case "agua":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 2;

                    case "agua":

                        return ataque * 0.5;
                    case "planta":

                        return ataque * 0.5;

                    case "tierra":

                        return ataque * 2;
                    case "hielo":

                        return ataque * 1;
                    case "electrico":
                        return ataque * 1;

                    case "roca":

                        return ataque * 2;
                    case "normal":

                        return ataque * 1;

                    case "lucha":

                        return ataque * 1;
                    case "volador":

                        return ataque * 1;
                    case "dragon":
                        return ataque * 0.5;        
                    default:
                        break;
                }
                break;
            case "planta":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 0.5;

                    case "agua":

                        return ataque * 2;
                    case "planta":

                        return ataque * 0.5;

                    case "tierra":

                        return ataque * 2;
                    case "hielo":

                        return ataque * 1;
                    case "electrico":
                        return ataque * 1;

                    case "roca":

                        return ataque * 2;
                    case "normal":

                        return ataque * 1;

                    case "lucha":

                        return ataque * 1;
                    case "volador":

                        return ataque * 0.5;
                    case "dragon":
                        return ataque * 0.5;        
                    default:
                        break;
                }
                break;

            case "tierra":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 2;

                    case "agua":

                        return ataque * 1;
                    case "planta":

                        return ataque * 0.5;

                    case "tierra":

                        return ataque * 1;
                    case "hielo":

                        return ataque * 1;
                    case "electrico":
                        return ataque * 2;

                    case "roca":

                        return ataque * 2;
                    case "normal":

                        return ataque * 1;

                    case "lucha":

                        return ataque * 1;
                    case "volador":

                        return ataque * 0;
                    case "dragon":
                        return ataque * 1;        
                    default:
                        break;
                }
                break;
            case "hielo":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 0.5;

                    case "agua":

                        return ataque * 0.5;
                    case "planta":

                        return ataque * 2;

                    case "tierra":

                        return ataque * 2;
                    case "hielo":

                        return ataque * 0.5;
                    case "electrico":
                        return ataque * 1;

                    case "roca":

                        return ataque * 1;
                    case "normal":

                        return ataque * 1;

                    case "lucha":

                        return ataque * 1;
                    case "volador":

                        return ataque * 2;
                    case "dragon":
                        return ataque * 2;        
                    default:
                        break;
                }
                break;
            case "electrico":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 1;

                    case "agua":

                        return ataque * 2;
                    case "planta":

                        return ataque * 0.5;

                    case "tierra":

                        return ataque * 0;
                    case "hielo":

                        return ataque * 1;
                    case "electrico":
                        return ataque * 0.5;

                    case "roca":

                        return ataque * 1;
                    case "normal":

                        return ataque * 1;

                    case "lucha":

                        return ataque * 1;
                    case "volador":

                        return ataque * 2;
                    case "dragon":
                        return ataque * 0.5;        
                    default:
                        break;
                }
                break;
            case "roca":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 2;

                    case "agua":

                        return ataque * 1;
                    case "planta":

                        return ataque * 1;

                    case "tierra":

                        return ataque * 0.5;
                    case "hielo":

                        return ataque * 2;
                    case "electrico":
                        return ataque * 1;

                    case "roca":

                        return ataque * 1;
                    case "normal":

                        return ataque * 1;

                    case "lucha":

                        return ataque * 0.5;
                    case "volador":

                        return ataque * 2;
                    case "dragon":
                        return ataque * 1;        
                    default:
                        break;
                }
                break;       
            case "normal":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 1;

                    case "agua":

                        return ataque * 1;
                    case "planta":

                        return ataque * 1;

                    case "tierra":

                        return ataque * 1;
                    case "hielo":

                        return ataque * 1;
                    case "electrico":
                        return ataque * 1;

                    case "roca":

                        return ataque * 0.5;
                    case "normal":

                        return ataque * 1;

                    case "lucha":

                        return ataque * 1;
                    case "volador":

                        return ataque * 1;
                    case "dragon":
                        return ataque * 1;        
                    default:
                        break;
                }
                break;   
            case "lucha":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 1;

                    case "agua":

                        return ataque * 1;
                    case "planta":

                        return ataque * 1;

                    case "tierra":

                        return ataque * 1;
                    case "hielo":

                        return ataque * 2;
                    case "electrico":
                        return ataque * 1;

                    case "roca":

                        return ataque * 2;
                    case "normal":

                        return ataque * 2;

                    case "lucha":

                        return ataque * 1;
                    case "volador":

                        return ataque *0.5 ;
                    case "dragon":
                        return ataque * 1;        
                    default:
                        break;
                }
                break;                                      
            case "volador":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 1;

                    case "agua":

                        return ataque * 1;
                    case "planta":

                        return ataque * 2;

                    case "tierra":

                        return ataque * 1;
                    case "hielo":

                        return ataque * 1;
                    case "electrico":
                        return ataque * 0.5;

                    case "roca":

                        return ataque * 0.5;
                    case "normal":

                        return ataque * 1;

                    case "lucha":

                        return ataque * 2;
                    case "volador":

                        return ataque * 1;
                    case "dragon":
                        return ataque * 1;        
                    default:
                        break;
                }
                break;    

            case "dragon":
                switch (pokemonRival.getTipo()) {
                    case "fuego":
                        return ataque * 1;

                    case "agua":

                        return ataque * 1;
                    case "planta":

                        return ataque * 1;

                    case "tierra":

                        return ataque * 1;
                    case "hielo":

                        return ataque * 1;
                    case "electrico":
                        return ataque * 1;

                    case "roca":

                        return ataque * 1;
                    case "normal":

                        return ataque * 1;

                    case "lucha":

                        return ataque * 1;
                    case "volador":

                        return ataque * 1;
                    case "dragon":
                        return ataque * 2;    
                    default:
                        break;
                }
                break;   
                
            default:
                break;
        }
        return 0;
    }

}
