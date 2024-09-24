/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

/**
 *
 * @author crisc
 */
public class Ejercicio_5_Alumno {
    //ATRIBUTOS
    private String nombre;
    private int numAlumno;
    private double nota1, nota2;
    
    //CONSTRUCTORES
    public Ejercicio_5_Alumno(){
    }

    public Ejercicio_5_Alumno(String nombre, String numAlumno, String nota1, String nota2) throws Exception {
        setNombre(nombre);
        setNumAlumno(numAlumno);
        setNota1(nota1);
        setNota2(nota2);
    }
    
    public Ejercicio_5_Alumno(String nombre, String numAlumno) throws Exception {
        setNombre(nombre);
        setNumAlumno(numAlumno);
    }
    
    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumAlumno() {
        return numAlumno;
    }

    public void setNumAlumno(String numAlumno) throws Exception{
        this.numAlumno = Integer.parseInt(numAlumno);
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(String nota1) throws Exception{
        this.nota1 = Double.parseDouble(nota1);
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(String nota2) throws Exception{
        this.nota2 = Double.parseDouble(nota2);
    }
    
    //METODOS
    public void ponNota(String nota1, String nota2) throws Exception{
        double nota = Double.parseDouble(nota1);
        setNota1(nota1);
        
        nota = Double.parseDouble(nota2);
        setNota2(nota2);
    }
    
    public double dameMedia() throws Exception{
        double nota = (this.nota1 + this.nota2)/2;
        return nota;
    }
    
    public String muestraAlumno() throws Exception{
        return "\t" + numAlumno + " | " + nombre + " | nota media: " + dameMedia();
    }


    
    
}
