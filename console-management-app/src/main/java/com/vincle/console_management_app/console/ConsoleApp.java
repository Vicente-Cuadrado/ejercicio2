package com.vincle.console_management_app.console;

import com.vincle.console_management_app.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.vincle.console_management_app.service.ItemManagementService;
import java.util.Scanner;

@Component
public class ConsoleApp implements CommandLineRunner {

    @Autowired
    private ItemManagementService itemManagementService;

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        String command;
        System.out.println("Bienvenido a la gestión de Items. Escribe un comando (crear, listar, actualizar, eliminar, salir):");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del sistema...");
                break;
            }

            switch (command.toLowerCase()) {
                case "listar":
                    listarItems();
                    break;
                case "crear":
                    crearItem(scanner);
                    break;
                case "actualizar":
                    actualizarItem(scanner);
                    break;
                case "eliminar":
                    eliminarItem(scanner);
                    break;
                default:
                    System.out.println("Comando no reconocido. Prueba con crear, listar, actualizar, eliminar, salir.");
            }
        }
    }

    private void listarItems() {
        Item[] items = itemManagementService.getAllItems();
        if (items != null && items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("No hay items disponibles.");
        }
    }

    private void crearItem(Scanner scanner) {
        String name = getValidatedName(scanner);
        String type = getValidatedType(scanner);
        boolean needsRefrigeration = getValidatedBoolean(scanner, "¿Precisa refrigeración? (S/N): ");
        int capacity = getValidatedCapacity(scanner);
        String container = getValidatedContainer(scanner);
        String createdBy = getValidatedName(scanner, "Nombre del cliente que creó el item: ");

        Item newItem = new Item(name, type, needsRefrigeration, capacity, container, createdBy, null, "CREATED");
        itemManagementService.createItem(newItem);
        System.out.println("Item creado con éxito.");
    }

    private void actualizarItem(Scanner scanner) {
        System.out.print("ID del item a actualizar: ");
        Long id = Long.parseLong(scanner.nextLine());
        String name = getValidatedName(scanner);
        String type = getValidatedType(scanner);
        boolean needsRefrigeration = getValidatedBoolean(scanner, "¿Precisa refrigeración? (S/N): ");
        int capacity = getValidatedCapacity(scanner);
        String container = getValidatedContainer(scanner);
        String createdBy = getValidatedName(scanner, "Nombre del cliente: ");

        Item updatedItem = new Item(name, type, needsRefrigeration, capacity, container, createdBy, null, "UPDATED");
        itemManagementService.updateItem(id, updatedItem);
        System.out.println("Item actualizado con éxito.");
    }

    private void eliminarItem(Scanner scanner) {
        System.out.print("ID del item a eliminar: ");
        Long id = Long.parseLong(scanner.nextLine());
        itemManagementService.deleteItem(id);
        System.out.println("Item eliminado con éxito.");
    }

    // Validaciones
    private String getValidatedType(Scanner scanner) {
        String type;
        while (true) {
            System.out.print("Tipo (bebida, comida, salsas, especies): ");
            type = scanner.nextLine().trim().toUpperCase();
            if (type.equals("BEBIDA") || type.equals("COMIDA") || type.equals("SALSAS") || type.equals("ESPECIES")) {
                break;
            } else {
                System.out.println("Error: El tipo debe ser 'bebida', 'comida', 'salsas' o 'especies'.");
            }
        }
        return type;
    }

    private int getValidatedCapacity(Scanner scanner) {
        int capacity;
        while (true) {
            System.out.print("Capacidad (100 o 1000): ");
            try {
                capacity = Integer.parseInt(scanner.nextLine().trim());
                if (capacity == 100 || capacity == 1000) {
                    break;
                } else {
                    System.out.println("Error: La capacidad debe ser 100 o 1000.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número válido.");
            }
        }
        return capacity;
    }

    private String getValidatedContainer(Scanner scanner) {
        String container;
        while (true) {
            System.out.print("Tipo de envase (botella/caja): ");
            container = scanner.nextLine().trim().toUpperCase();
            if (container.equals("BOTELLA") || container.equals("CAJA")) {
                break;
            } else {
                System.out.println("Error: El envase debe ser 'botella' o 'caja'.");
            }
        }
        return container;
    }

    private boolean getValidatedBoolean(Scanner scanner, String message) {
        boolean value;
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("S")) {
                value = true;
                break;
            } else if (input.equals("N")) {
                value = false;
                break;
            } else {
                System.out.println("Error: Debes introducir 'S' para Sí o 'N' para No.");
            }
        }
        return value;
    }

    private String getValidatedName(Scanner scanner) {
        return getValidatedName(scanner, "Nombre: ");
    }

    private String getValidatedName(Scanner scanner, String message) {
        String name;
        while (true) {
            System.out.print(message);
            name = scanner.nextLine().trim().toUpperCase();
            if (!name.isEmpty()) {
                break;
            } else {
                System.out.println("Error: El nombre no puede estar vacío. Inténtalo de nuevo.");
            }
        }
        return name;
    }

}
