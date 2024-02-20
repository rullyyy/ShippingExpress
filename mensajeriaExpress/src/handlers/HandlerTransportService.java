/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import enums.Transport;
import enums.TypePackage;
import enums.TypeService;





/**
 *
 * @author xfs85
 */
public class HandlerTransportService extends HandlerService {

    @Override
    public double calculateCost(Request request) {
    double additionalCost = 0;

    // Si el tipo de paquete es un sobre o caja pequeña
    if (request.getTypePackage() == TypePackage.ENVELOPE || request.getTypePackage() == TypePackage.SMALL_BOX) {
        // Si la distancia es 1 Km o menos
        if (request.getDistance() <= 1) {
            // Si el tipo de servicio es Express, utilizar dron como medio de transporte
            if (request.getTypeService() == TypeService.EXPRESS) {
                request.setTransport(Transport.DRON);
                additionalCost = 20;
            } 
            // Si el tipo de servicio es Estándar, utilizar bicicleta como medio de transporte
            else if (request.getTypeService() == TypeService.STANDARD) {
                request.setTransport(Transport.BIKE);
                additionalCost = 5;
            }
        } 
        // Si la distancia es mayor a 1 Km
        else {
            // Si el tipo de servicio es Estándar, utilizar bicicleta como medio de transporte
            if (request.getTypeService() == TypeService.STANDARD) {
                request.setTransport(Transport.BIKE);
                additionalCost = 5;
            } 
            // Si el tipo de servicio es Express, utilizar moto como medio de transporte
            else if (request.getTypeService() == TypeService.EXPRESS) {
                request.setTransport(Transport.MOTOCYCLE);
                additionalCost = 15;
            }
        }
    } 
    // Si el tipo de paquete es mediano
    else if (request.getTypePackage() == TypePackage.MEDIUM_BOX) {
        // Si la distancia es hasta 5 Km y el tipo de servicio es Estándar, utilizar bicicleta como medio de transporte
        if (request.getDistance() <= 5 && request.getTypeService() == TypeService.STANDARD) {
            request.setTransport(Transport.BIKE);
            additionalCost = 5;
        } 
        // Si la distancia es mayor a 5 Km o el tipo de servicio es Express, utilizar moto como medio de transporte
        else {
            request.setTransport(Transport.BIKE);
            additionalCost = 5;
        }
    } 
    // Si el tipo de paquete es grande, utilizar auto como medio de transporte sin importar la distancia o el tipo de servicio
    else if (request.getTypePackage() == TypePackage.BIG_BOX) {
        request.setTransport(Transport.CAR);
        additionalCost = 30;
    }

    // Calcular costo adicional en función de la distancia
    if (request.getDistance() > 10) {
        additionalCost += (request.getDistance() - 10) * 5;
    }

    return additionalCost + (nextHandler != null ? nextHandler.calculateCost(request) : 0);
}


    
}
