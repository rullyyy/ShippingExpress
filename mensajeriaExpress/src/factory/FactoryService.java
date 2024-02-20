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

        double cost = handlerDistance.calculateCost(request);
        DeliverService deliverService = new DeliverService(cost);

       
        

        double deliverTime = deliverService.calculateDeliverTime();
        deliverService.setDeliverTime(deliverTime);

        return deliverService;
    }
}
