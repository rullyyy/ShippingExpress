/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

/**
 *
 * @author xfs85
 */
public class HandlerDistance extends HandlerService{

    @Override
    public double calculateCost(Request request) {
        double adicionalCost = (request.getDistance() > 10) ? request.getDistance() * 5 : 0;
        return adicionalCost;
    }

    

    
    
}
