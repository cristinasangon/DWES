/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author crisc
 */
public class codigosAMBException extends Exception{
    public codigosAMBException(){
        super("Dato inválido, solo puedes introducir 'A', 'M' o 'B'");
    }
}
