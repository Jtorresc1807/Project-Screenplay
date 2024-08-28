package co.com.screenplay.project.utils;

import com.github.javafaker.Faker;

import java.util.Locale;
//10

public class DataFaker {        //Esta clase se utiliza para generar datos falsos o aleatorios.
    private DataFaker(){}       //Constructor privado vacío
    //Dentro del directorio busca información de Colombia
    private static Faker faker = Faker.instance(new Locale("es","CO"));

    public static String fakerNumberOneAndNine(){
        return String.valueOf(faker.number().numberBetween(1,9));  // Genera un número entero aleatorio entre 1 y 9.
    }  //Convierte este número entero a una cadena
}
