/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

/**
 *
 * @author crisc
 */
public class Ejercicio_4_DVD {
    //Escribe una clase que represente un pelicula DVD de nombre DVD-Cine con los atributos necesarios para mostrar
    //la ficha que se recoge en el apartado segundo. Esta clase contará con un constructor que admite como argumentos 
    //todos los atributos de la clase.
    
    //ATRIBUTOS
    private String titulo;
    private String actores;
    private String director;
    private String genero;
    private int duracion;
    private String resumen;
    
    //CONSTRUCTOR VACIO
    public Ejercicio_4_DVD(){
    }
    
    //CONSTRUCTOR COMPLETO
    public Ejercicio_4_DVD(String titulo, String actores, String director, String genero, String duracion, String resumen) {
        setTitulo(titulo);
        setActores(actores);
        setDirector(director);
        setGenero(genero);
        setDuracion(duracion);
        setResumen(resumen);
    }
   
   //GETTERS Y SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = Integer.parseInt(duracion);
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
    //METODOS
    public String muesraDVDcine(){
       return titulo + "\nDe:" + director + "\nCon:" + actores + "\n" + genero + " - " + muestraDuracion(duracion) + "\nResumen=" + resumen + '}';  
    }
    
    public String muestraDuracion(int duracion){
        return duracion + " min";
    }
    
    public boolean esThriller(){
        String thrill = "Thriller";
        if(thrill.equals(this.genero)){
            return true;
        }
        return false;
    }
    
    public boolean tieneResumen(){
        if(this.resumen.length() > 0){
            return true;
        }
        return false;
    }

    
    
}
