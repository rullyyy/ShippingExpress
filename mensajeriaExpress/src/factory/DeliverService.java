/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import enums.Transport;

/**
 *
 * @author xfs85
 */
public class DeliverService {
    private double cost;
    private double deliverTime;
    private double usd = 18;
    private Transport transport;
    private double distance;

    public DeliverService(double cost, double deliverTime) {
        this.cost = cost;
        this.deliverTime = deliverTime;
        
    }

    public DeliverService(double cost, Transport transport) {
        this.cost = cost;
        this.transport = transport;
    }
    
    

    public DeliverService(double cost) {
        this.cost = cost;
    }
   
    public double getCost() {
        return cost;
    }

    public double getDeliverTime() {
        return deliverTime;
    }
    
    public double convertUSD(){
        return cost * usd;
    }

    public void setDeliverTime(double deliverTime) {
        this.deliverTime = deliverTime;
    }
    
    
     public double calculateDeliverTime(double distance) {
        if (transport == null) {
            throw new IllegalStateException("Transport not selected");
        }
         
         double speed;
        switch (transport) {
            case BIKE:
                speed = 20; // Velocidad en km/h de la bicicleta
                break;
            case DRON:
                speed = 60; // Velocidad en km/h del dron
                break;
            case MOTOCYCLE:
                speed = 45; // Velocidad en km/h de la moto
                break;
            case CAR:
                speed = 40; // Velocidad en km/h del auto
                break;
            default:
                throw new IllegalArgumentException("Medio de transporte no válido");
        }

        return (distance / speed) * 60; // Convertimos el tiempo de entrega a minutos
    }
    
}
