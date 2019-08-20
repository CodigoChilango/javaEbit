/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eb;

import java.util.Scanner;

/**
 *
 * @author ManuelGarnica
 */
public class Eb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        String nombre = entrada.next();
        System.out.println("Introduce tu edad: ");
        String edad = entrada.next();
        System.out.println("Introduce tu sexo: ");
        String sexo = entrada.next();
        System.out.println("Introduce tu peso: ");
        String peso = entrada.next();
        System.out.println("Introduce tu altura: ");
        String altura = entrada.next();

        persona1(nombre,Integer.parseInt(edad),sexo.charAt(0),Double.parseDouble(peso) ,Double.parseDouble(altura));
        persona2(nombre,Integer.parseInt(edad),sexo.charAt(0) ,Double.parseDouble(altura));
        persona3();

    }

    public static void persona1(String nombre, int edad, char sexo, double peso,double altura) {
        Persona persona1 = new Persona(nombre, edad, sexo, peso,altura);
        System.out.println("Persona 1");
        personaImprime(persona1);
    }
    public static void persona2(String nombre, int edad, char sexo,double altura) {
        Persona persona2 = new Persona(nombre, edad, sexo);
        persona2.setAltura(altura);
         System.out.println("Persona 2\n");
        personaImprime(persona2);
    }
    public static void persona3() {
        Persona persona3 = new Persona();
        
        persona3.setNombre("Manuel");
        persona3.setEdad(25);
        persona3.setSexo('H');
        persona3.setPeso(80.5);
        persona3.setAltura(1.75);
         System.out.println("Persona 3\n");
        personaImprime(persona3);
    }
    public static void personaImprime(Persona persona1) {
        System.out.println(mensajePeso(persona1.calcularIMC()));
        System.out.println(persona1.esMayorDeEdad()==false ?"Eres menor de edad":"Eres mayor de edad");
        System.out.println(persona1.toString());
    }

    private static String mensajePeso(int pesoIdeal) {

        String mensaje = "";
        if (pesoIdeal == -1) {
            mensaje = "Por debajo del peso ideal";
        } else if (pesoIdeal == 0) {
            mensaje = "Por debajo del peso ideal";
        } else if (pesoIdeal == 1) {
            mensaje = "Por debajo del peso ideal";
        }
        return mensaje;
    }
}
