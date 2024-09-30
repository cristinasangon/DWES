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
    //ATRIBUTOS
    private String nombre;
    private double lipidos, hidratos, proteinas;
    private boolean animal;
    private String minerales, vitaminas;
    
    //CONSTRUCTOR
    public Alimento(String nombre, double lipidos, double hidratos, double proteinas, String animal, String minerales, String vitaminas) {
        this.nombre = nombre;
        this.lipidos = lipidos;
        this.hidratos = hidratos;
        this.proteinas = proteinas;
        setAnimal(animal);
        this.minerales = minerales;
        this.vitaminas = vitaminas;
    }
    
    //GETTERS Y SETTERS
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
    
    public boolean recomendableParaDeportistas(){
        if((proteinas < 10) || (proteinas > 15)){
            return false;
        }
        if((lipidos < 30) || (lipidos > 35)){
            return false;
        }
        if((hidratos < 55) || (hidratos > 65)){
            return false;
        }
        return true;
    }
    
    public String contenidoEnergetico(){
        double contenido = (lipidos * 9.4) + (proteinas * 5.3) + (hidratos * 4.1);
        return contenido + " Kcal/g";
    }
    
    public String calcularAMB(String dato){
        if(dato.equals("A")){
            return "alto";
        }else if(dato.equals("M")){
            return "medio";
        }else{
            return "bajo";
        }
    }
    public String mostrarAlimento(){
        String orAnim = "SI";
        if(!animal){
            orAnim = "NO";
        }
        
        String dietetico = "SI";
        if(!esDietetico()){
            dietetico = "NO";
        }
        
        String recomDepor = "SI";
        if(!recomendableParaDeportistas()){
            recomDepor = "NO";
        }
        
        return "- - - - - - - - - - - - - - - - - - - - - - - - - - -\nNombre: " + nombre + 
               "\nAnalisis:\n\tLipidos: " + lipidos + 
               "%\n\tHidratos de carbono: " + hidratos + 
               "%\n\tProteinas: " + proteinas + 
               "%\nContenido en vitaminas: " + calcularAMB(vitaminas) + 
               "\nContenido en minerales: " + calcularAMB(minerales) + 
               "\n" + orAnim + " es de origen animal" + 
               "\n" + dietetico + " es dietético" +
               "\n" + recomDepor + " es recomendable para deportistas" +
               "\nContenido enérgetico: " + contenidoEnergetico();
    }
    
    
}
