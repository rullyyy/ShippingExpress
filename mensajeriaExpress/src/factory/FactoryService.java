/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import handlers.*;

/**
 *
 * @author xfs85
 */
public class FactoryService {

    public static DeliverService createService(Request request) {
        HandlerService handlerTransportService = new HandlerTransportService();
        HandlerService handlerPackage = new HandlerPackage();
        HandlerService handlerDistance = new HandlerDistance();

        handlerDistance.setNextHandler(handlerPackage);
        handlerPackage.setNextHandler(handlerTransportService);

        double cost = handlerTransportService.calculateCost(request);
        DeliverService deliverService = new DeliverService(cost, request.getTransport());

       
        

        double deliverTime = deliverService.calculateDeliverTime(request.getDistance());
        deliverService.setDeliverTime(deliverTime);

        return deliverService;
    }
}
