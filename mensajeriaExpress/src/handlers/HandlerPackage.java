/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import model.Transport;
import model.TypePackage;

/**
 *
 * @author xfs85
 */
public class HandlerPackage extends HandlerService{

    @Override
    public double calculateCost(Request request) {
       double adicionalCost = 0;
       
       if(request.getTypePackage() == TypePackage.ENVELOPE){
           adicionalCost = 5;
           
       }else if(request.getTypePackage() == TypePackage.SMALL_BOX){
           adicionalCost = 10;
       }else if(request.getTypePackage() == TypePackage.MEDIUM_BOX){
           adicionalCost = 20;
       }else if(request.getTypePackage() == TypePackage.BIG_BOX){
           adicionalCost = 50;
       }
       
       return adicionalCost + (nextHandler != null ? nextHandler.calculateCost(request) : 0);
    }

    

   
       
    
}
