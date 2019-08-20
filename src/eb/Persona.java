/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eb;

/**
 *
 * @author ManuelGarnica
 */
public class Persona {

    private static final char DEFAUL_SEXO = 'H';
    private static final int DEFAUL_INT = 0;
    private static final String DEFAUL_STRING = "";
    private static final double DEFAUL_FLOAT = 0.0f;

    private String nombre;
    private int edad;
    private String nss;
    private char sexo;
    private double peso;
    private double altura;

    {

        nombre = DEFAUL_STRING;
        edad = DEFAUL_INT;
        sexo = DEFAUL_SEXO;
        peso = DEFAUL_FLOAT;
        altura = DEFAUL_FLOAT;
        nss = generaNSS();
    }

    public Persona() {

    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        if (comprobarSexo(sexo)) {
            this.sexo = sexo;
        } else {
            this.sexo = DEFAUL_SEXO;
        }
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;

        this.peso = peso;
        this.altura = altura;
        if (comprobarSexo(sexo)) {
            this.sexo = sexo;
        } else {
            this.sexo = DEFAUL_SEXO;
        }
    }

    /**
     * Calcula la masa muscular de la persona
     *
     * @return int peso idel
     */
    public int calcularIMC() {
        int estado = 0;

        final int PESO_HOMBRE_NORMAL_MENOR = 20;
        final int PESO_HOMBRE_NORMAL_MAYOR = 25;

        final int PESO_MUJER_NORMAL_MENOR = 19;
        final int PESO_MUJER_NORMAL_MAYOR = 24;

        final int DEBAJO_PESO_IDEAL = -1;
        final int PESO_IDEAL = 0;
        final int SOBREPESO = 1;

        double imc;
        imc = (peso / (altura * altura));
        if (sexo == 'H') {
            if (imc < PESO_HOMBRE_NORMAL_MENOR) {
                estado = DEBAJO_PESO_IDEAL;
            } else if (imc >= PESO_HOMBRE_NORMAL_MENOR && imc <= PESO_HOMBRE_NORMAL_MAYOR) {
                estado = PESO_IDEAL;
            } else if (imc > PESO_HOMBRE_NORMAL_MAYOR) {
                estado = SOBREPESO;
            }
        } else {
            if (imc < PESO_MUJER_NORMAL_MENOR) {
                estado = DEBAJO_PESO_IDEAL;
            } else if (imc >= PESO_MUJER_NORMAL_MENOR && imc <= PESO_MUJER_NORMAL_MAYOR) {
                estado = PESO_IDEAL;
            } else if (imc > PESO_MUJER_NORMAL_MAYOR) {
                estado = SOBREPESO;
            }
        }

        return estado;
    }

    /**
     * Valida si una persona es mayor de edad
     *
     * @return boolean 
     */
    public boolean esMayorDeEdad() {
        if (edad >= 18) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Valida si el sexo ingreso es valido si no toma valor por default
     *
     * @return boolean 
     */
    private boolean comprobarSexo(char sexo) {
        boolean respuesta = true;
        if (sexo != 'H' || sexo != 'M') {
            respuesta = false;
        }
        return respuesta;

    }
    /**
     * Genera el numero de seguro social 
     *
     * @return  numero de seguro socila aleatorio
     */
    public String generaNSS() {

        int numero;
        int dnirandom = 0;
        String juegoCaracteres;
        for (int i = 0; i < 8; i++) {
            numero = (int) Math.floor(Math.random() * (0 - 9) + 9);
            dnirandom = dnirandom * 10 + numero;
        }
        juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKET";
        int modulo = dnirandom % 23;

        return ("" + dnirandom + juegoCaracteres.charAt(modulo) + "");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (comprobarSexo(sexo)) {
            this.sexo = sexo;
        } else {
            this.sexo = DEFAUL_SEXO;
        }

    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", nss=" + nss + ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura + '}';
    }

}
