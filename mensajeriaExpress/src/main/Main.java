/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import enums.TypePackage;
import enums.TypeService;
import factory.DeliverService;
import factory.FactoryService;
import handlers.Request;
import java.util.Scanner;


/**
 *
 * @author xfs85
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
         System.out.println("Welcome to Shipping System");

        // Solicitar al usuario el tipo de servicio
        System.out.println("Select a service:");
        System.out.println("1. Standard ($30)");
        System.out.println("2. Express ($50)");
        int serviceSelected = scanner.nextInt();
        TypeService typeService = (serviceSelected == 1) ? TypeService.STANDARD : TypeService.EXPRESS;

        // Solicitar al usuario el tipo de paquete
        System.out.println("Pick an option for your package:");
        System.out.println("1. Envelope (+ $5)");
        System.out.println("2. Small Box (+ $10)");
        System.out.println("3. Medium Box (+ $20)");
        System.out.println("4. Big Box (+ $50)");
        int packageSelected = scanner.nextInt();
        TypePackage typePackage = null;
        switch (packageSelected) {
            case 1:
                typePackage = TypePackage.ENVELOPE;
                break;
            case 2:
                typePackage = TypePackage.SMALL_BOX;
                break;
            case 3:
                typePackage = TypePackage.MEDIUM_BOX;
                break;
            case 4:
                typePackage = TypePackage.BIG_BOX;
                break;
            default:
                System.out.println("Invalid option. Pick another one");
                
                break;
        }

        // Solicitar al usuario la distancia
        System.out.println("Enter distance (km):");
        double distance = scanner.nextDouble();

        // Crear la solicitud
        Request request = new Request(typePackage, distance, typeService);

        // Crear el servicio de entrega
        DeliverService service = FactoryService.createService(request);

          // Solicitar al usuario la moneda en la que desea ver el precio
        System.out.println("Pick a currency");
        System.out.println("1. USD");
        System.out.println("2. MXN");
        int opcion = scanner.nextInt();

        // Mostrar el precio en la moneda seleccionada
        if (opcion == 1) {
              // Mostrar resultados
        System.out.println("Package: " + typePackage);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Service: " + typeService);
        System.out.println("Transport: " + request.getTransport());
        System.out.println("Cost: $" + service.convertUSD());
        System.out.println("Deliver Time: " + service.getDeliverTime());
        } else {
            
        System.out.println("Package: " + typePackage);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Service: " + typeService);
        System.out.println("Transport: " + request.getTransport());
        System.out.println("Cost: $" + service.getCost());
        System.out.println("Deliver Time: " + service.getDeliverTime());
        }
            
    }
    
    
}
