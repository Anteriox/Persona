import java.util.Scanner;

public class Persona {
    private static final char sexo_Def= 'H';
    private String nombre;
    private Integer edad;
    private final String DNI;
    private char sexo;
    private Double peso;
    private Double altura;

    public Persona() {
        nombre = "";
        edad = 0;
        DNI= generaDNI();
        sexo = comprobarSexo();               
        peso = 0.0;
        altura = 0.0;
    }

    public Persona(String nombre, Integer edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI= generaDNI();
        this.sexo = sexo;
    }

    public Persona(String nombre, Integer edad, String DNI, char sexo, Double peso, Double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = generaDNI();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public void calcularIMC() {
        final Integer DEBAJO_PESO_IDEAL = -1;
        final Integer PESO_IDEAL = 0;
        final Integer SOBREPESO = 1;
        Double imc;

        imc = peso / altura * altura;

        if (imc < 18.5) {
            System.out.println(DEBAJO_PESO_IDEAL);
        } else if (imc >= 18.5 && imc <= 25) {
            System.out.println("Tiene el peso Ideal");
        } else {
            System.out.println("Tiene sobrepeso Adelgaze");
        }

    }

    public boolean esMayorDeEdad() {
        if (edad >= 18){
            return true;
        }
        else{
            return false;
        }
       
    }

    private char comprobarSexo() {
        if (sexo != 'H' || sexo != 'M') {
            sexo = 'H';
        }
        return sexo;
    }

    public String toString() {
        return nombre+"/"+edad+"/"+DNI+"/"+sexo+"/"+peso+"/"+altura;
    }
     

    private String generaDNI() {
        double numero;
        int numero2;
        int dnirandom=0;
        char letra;
        String juegoCaracteres;
        String nif;

        for (int i = 0; i < 8; i++) {
            numero = Math.floor(Math.random() * (0 - 9) + 9);
            numero2 = (int) numero;
            dnirandom = dnirandom*10+numero2;           
        }               
        juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKET";
        int modulo = dnirandom % 23;
        letra = juegoCaracteres.charAt(modulo);
        nif = (""+dnirandom+letra+"");
       
        return nif;       
    }
   
   
   
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

}