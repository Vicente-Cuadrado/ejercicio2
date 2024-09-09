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

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
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
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Tipo (bebida, comida, etc.): ");
        String type = scanner.nextLine();
        System.out.print("¿Precisa refrigeración? (true/false): ");
        boolean needsRefrigeration = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Capacidad (100 o 1000): ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo de envase (botella/caja): ");
        String container = scanner.nextLine();
        System.out.print("Nombre del cliente que creó el item: ");
        String createdBy = scanner.nextLine();
        Item newItem = new Item(name, type, needsRefrigeration, capacity, container, createdBy, null, "CREATED");
        itemManagementService.createItem(newItem);
        System.out.println("Item creado con éxito.");
    }

    private void actualizarItem(Scanner scanner) {
        System.out.print("ID del item a actualizar: ");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.print("Nuevo nombre: ");
        String name = scanner.nextLine();
        System.out.print("Nuevo tipo (bebida, comida, etc.): ");
        String type = scanner.nextLine();
        System.out.print("¿Precisa refrigeración? (true/false): ");
        boolean needsRefrigeration = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Capacidad (100 o 1000): ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo de envase (botella/caja): ");
        String container = scanner.nextLine();
        System.out.print("Nombre del cliente: ");
        String createdBy = scanner.nextLine();
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
}
