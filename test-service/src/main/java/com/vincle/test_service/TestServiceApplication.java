package com.vincle.test_service;

import com.vincle.test_service.service.TestService;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestServiceApplication implements CommandLineRunner {

    private final TestService testService;

    // Inyección de TestService por constructor
    public TestServiceApplication(TestService testService) {
        this.testService = testService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }

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

        System.out.println("Programa finalizado.");    }

}
