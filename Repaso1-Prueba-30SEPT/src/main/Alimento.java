/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author crisc
 */
public class Alimento {
    //ARIBUTOS
    private String nombre;
    private double lipidos, hCarbono, proteinas;
    private boolean animal;
    private String minerales, vitaminas;
    
    //CONSTRUCTOR
    public Alimento(String nombre, double lipidos, double hCarbono, double proteinas, String animal, String minerales, String vitaminas) {
        this.nombre = nombre;
        this.lipidos = lipidos;
        this.hCarbono = hCarbono;
        this.proteinas = proteinas;
        setAnimal(animal);
        this.minerales = minerales;
        this.vitaminas = vitaminas;
    }
    
    //SETTERS Y GETTERS

    public void setAnimal(String animal) {
        if(animal.equals("S")){
            this.animal = true;
        }else{
            this.animal = false;
        }
    }
    
    
    //METODOS
    public boolean esDietetico(){
        if(lipidos >= 20){
            return false;
        }
        if(vitaminas.equals("B")){
            return false;
        }
        return true;
    }
    
    public boolean recomendableDeportistas(){
        if((proteinas < 10) || (proteinas > 15)){
            return false;
        }
        if((lipidos < 30) || (lipidos > 35)){
            return false;
        }
        if((hCarbono < 55) || (hCarbono > 65)){
            return false;
        }
        return true;
    }
    
    public String contenidoEnergetico(){
        double contenido = (lipidos * 9.4) + (proteinas * 5.3) + (hCarbono * 4.1);
        return contenido + " Kcal/g";
    }
    
    private String calculaAMB(String dato){
        if(dato.equals("A")){
            return "alto";
        }else if(dato.equals("M")){
            return "medio";
        }else{
            return "bajo";
        }
    }
    public String mostrarAlimento(){
        String origAnimal = "SI";
        if(!animal){
            origAnimal = "NO";
        }
        
        String dietetico = "SI";
        if(!esDietetico()){
            dietetico = "NO";
        }
        
        String deportistas = "SI";
        if(!recomendableDeportistas()){
            deportistas = "NO";
        }
        return "- - - - - - - - - - - - - - - - - - - - - -\nNombre: " + nombre + 
               "\nAnalisis: \n\tLipidos: " + lipidos + 
               "% \n\tHidratos de carbono: " + hCarbono +
               "% \n\tProteinas: " + proteinas +
               "% \nContenido en vitaminas: " + calculaAMB(vitaminas) + 
               "\nContenido en minerales: " + calculaAMB(minerales) +
               "\n" + origAnimal + " es de origen animal" +
               "\n" + dietetico + " es dietético" +
               "\n" + deportistas + " es recomendable para deportistas" + 
               "\nContenido energetico: " + contenidoEnergetico() + "\n\"- - - - - - - - - - - - - - - - - - - - - -";
    }
}
