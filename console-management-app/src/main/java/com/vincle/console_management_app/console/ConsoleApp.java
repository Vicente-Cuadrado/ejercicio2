package com.vincle.console_management_app.console;

import com.vincle.console_management_app.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.vincle.console_management_app.service.ItemManagementService;
import java.util.Scanner;

/**
 *
 * Intefaz de usuario en consola para gestionar los items.
 *
 * @author Vicente Cuadrado
 */
@Component
public class ConsoleApp implements CommandLineRunner {

    @Autowired
    private ItemManagementService itemManagementService; // Servicio para gestionar los items

    private static final Scanner scanner = new Scanner(System.in); // Entrada de consola.

    /**
     *
     * Interfaz en la consola para gestionar los items.
     *
     * @param args Argumentos desde la línea de comandos.
     * @throws Exception Excepción.
     */
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

    /**
     *
     * Litar todos los items almacenados.
     *
     */
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

    /**
     *
     * Crear un item.
     *
     * @param scanner Input para los campos de los items.
     */
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

    /**
     *
     * Actualizar un item.
     *
     * @param scanner Input para los campos de los items.
     */
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

    /**
     *
     * Eliminar un item.
     *
     * @param scanner Input para los campos de los items.
     */
    private void eliminarItem(Scanner scanner) {
        System.out.print("ID del item a eliminar: ");
        Long id = Long.parseLong(scanner.nextLine());
        itemManagementService.deleteItem(id);
        System.out.println("Item eliminado con éxito.");
    }

    /**
     *
     * Valida que el tipo de item sea uno de los permitidos (bebida, comida,
     * salsas, especies).
     *
     * @param scanner Inpunt del campo.
     * @return Tipo de item validado.
     */
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

    /**
     *
     * Valida que la capacidad sea 100 o 1000.
     *
     * @param scanner Input del campo.
     * @return La capacidad validada.
     */
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

    /**
     *
     * Valida que el envase sea 'botella' o 'caja'.
     *
     * @param scanner Input del campo.
     * @return El envase validado en mayúsculas.
     */
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

    /**
     * Valida una respuesta S/N para una pregunta booleana.
     *
     * @param scanner Input del campo
     * @param message Mensaje que se muestra al usuario
     * @return true si la respuesta es 'S', false si es 'N'
     */
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

    /**
     * 
     * Valida que el nombre no esté vacío y lo convierte a mayúsculas.
     *
     * @param scanner Input del campo.
     * @return El nombre validado en mayúsculas
     */
    private String getValidatedName(Scanner scanner) {
        return getValidatedName(scanner, "Nombre: ");
    }


    /**
     * 
     * Valida que un campo no esté vacío y lo convierte a mayúsculas.
     * 
     * @param scanner Input del campo.
     * @param message Mensaje que se muestra al usuario
     * @return El valor validado en mayúsculas
     */    
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
