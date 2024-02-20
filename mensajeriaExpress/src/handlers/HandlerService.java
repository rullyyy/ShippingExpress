/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

/**
 *
 * @author xfs85
 */
public abstract class HandlerService {
     HandlerService nextHandler;
    
    
    public void setNextHandler(HandlerService nextHandler){
        this.nextHandler = nextHandler;
    }
    
    public abstract double calculateCost(Request request);
    
    
}
