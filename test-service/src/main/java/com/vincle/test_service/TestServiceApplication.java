package com.vincle.test_service;

import com.vincle.test_service.service.TestService;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Clase principal de la aplicación TestService
 *
 * @author Vicente Cuadrado
 */
@SpringBootApplication
public class TestServiceApplication implements CommandLineRunner {

    private final TestService testService; // Servicio encargado de realizar las operaciones

    /**
     * Método principal que lanza la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }

    /**
     * Constructor que inyecta una instancia de TestService.
     *
     * @param testService Servicio que gestiona las operaciones de prueba.
     */
    public TestServiceApplication(TestService testService) {
        this.testService = testService;
    }

    /**
     * Método que se ejecuta al iniciar la aplicación. Permite ejecutar un bucle
     * donde se solicitan iteraciones para realizar operaciones aleatorias.
     *
     * @param args Argumentos de la línea de comandos.
     * @throws Exception Si ocurre algún error durante la ejecución.
     */
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numberOfOperations;

        // Bucle que se ejecuta mientras el usuario no introduzca 0
        do {
            System.out.print("Por favor, introduce el número de iteraciones (0 para salir): ");
            numberOfOperations = scanner.nextInt();

            if (numberOfOperations > 0) {
                // Ejecutar las operaciones aleatorias
                testService.performRandomOperations(numberOfOperations);
            }

        } while (numberOfOperations != 0);

        System.out.println("Programa finalizado.");
    }

}
