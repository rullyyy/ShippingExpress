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
public class Request {
    private TypePackage typePackage;
    private double distance;
    private TypeService typeService;
    private Transport transport;

    public Request(TypePackage typePackage, double distance, TypeService typeService) {
        this.typePackage = typePackage;
        this.distance = distance;
        this.typeService = typeService;
    }

    public TypePackage getTypePackage() {
        return typePackage;
    }

    public double getDistance() {
        return distance;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTypePackage(TypePackage typePackage) {
        this.typePackage = typePackage;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }
    
    
    
}
