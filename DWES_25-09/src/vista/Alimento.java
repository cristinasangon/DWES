/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author crisc
 */
public class Alimento {
    //ATRIBUTOS
    private String nombre, minerales, vitaminas;
    private double lipidos, hidratos, proteinas;
    private boolean origAnimal;
    
    //CONSTRUCTORES

    public Alimento(String nombre, String minerales, String vitaminas, double lipidos, double hidratos, double proteinas, String origAnimal) {
        setNombre(nombre);
        setMinerales(minerales);
        setVitaminas(vitaminas);
        setLipidos(lipidos);
        setHidratos(hidratos);
        setProteinas(proteinas);
        setOrigAnimal(origAnimal);
    }
    
    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMinerales() {
        return minerales;
    }

    public void setMinerales(String minerales) {
        this.minerales = minerales;
    }

    public String getVitaminas() {
        return vitaminas;
    }

    public void setVitaminas(String vitaminas) {
        this.vitaminas = vitaminas;
    }

    public double getLipidos() {
        return lipidos;
    }

    public void setLipidos(double lipidos) {
        this.lipidos = lipidos;
    }

    public double getHidratos() {
        return hidratos;
    }

    public void setHidratos(double hidratos) {
        this.hidratos = hidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public boolean isOrigAnimal() {
        return origAnimal;
    }

    public void setOrigAnimal(String origAnimal) {
        if(origAnimal.equals("S")){
            this.origAnimal = true;
        }else{
            this.origAnimal = false;
        }
        
    }
    
    //METODOS
    public boolean esDietetico(){
        if((this.lipidos < 20) && (!this.vitaminas.equals("B"))){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean recomendableParaDeportistas(){
        if(this.proteinas < 10 || this.proteinas > 15){
            return false;
        }
        if(this.lipidos < 30 || this.lipidos >35){
            return false;
        }
        if(this.hidratos < 55 || this.hidratos > 65){
            return false;
        }
        return true;
    }
    
    public String contenidoEnergetico(){
        double contenido = (this.lipidos * 9.4) + (this.proteinas * 5.3) + (this.hidratos * 4.1);
        String cont = String.format("%.2f", contenido);
        return cont + " Kcal/gr";
    }
    
    public String obtenerAMB(String valor){
        if(valor.equals("A")){
            return "alto";
        }else if(valor.equals("M")){
            return "medio";
        }else if(valor.equals("B")){
            return "bajo";
        }else{
            return "fallo";
        }
    }
    
    public String mostrarAlimento(){
        String origen = "";
        if(origAnimal){
            origen = "SI";
        }else{
            origen = "NO";
        }
        
        String dietetico = "";
        if(esDietetico()){
            dietetico = "SI";
        }else{
            dietetico = "NO";
        }
        
        String deportistas = "";
        if(recomendableParaDeportistas()){
            deportistas = "SI";
        }else{
            deportistas = "NO";
        }
        
        return "- - - - - - - - - - - - - - - - - - - - - - - - - -" + 
               "\nNombre: " + this.nombre + 
               "\nAnalisis:\n\tLipidos: " + this.lipidos + 
               "%\n\tHidratos de carbono: " + this.hidratos + 
               "%\n\tProteinas: " + this.proteinas + 
               "%\nContenido en vitaminas: " + obtenerAMB(this.vitaminas) + 
               "\nContenido en minerales: " + obtenerAMB(this.minerales) + 
               "\n" + origen + " es de origen animal" + 
               "\n" + dietetico + " es dietetico" + 
               "\n" + deportistas + " es recomendable para deportistas" + 
               "\nContenido energetico: " + contenidoEnergetico() +
               "\n- - - - - - - - - - - - - - - - - - - - - - - - - -";
    }
    
}
