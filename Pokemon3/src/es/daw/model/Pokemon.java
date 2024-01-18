package es.daw.model;

public class Pokemon {
    //ATRIBUTOS    
    private String tipo;
    private String nombre;
    private int nivel;
    private double ataque;

    //GETTERS AND SETTERS
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public double getAtaque() {
        return ataque;
    }
    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }
    //CONSTRUCTORES
    public Pokemon(String tipo, String nombre, int nivel, double ataque) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.ataque = ataque;
    }
    public Pokemon() {
    }

    
    
    public Pokemon(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }
    public Pokemon(String tipo, String nombre, double ataque) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.ataque = ataque;
    }
    //METODOS
    public void aumentarNivel(){
        //Mas adelante
    }

}
