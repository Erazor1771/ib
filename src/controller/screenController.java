/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author lars
 */
public interface screenController {
    
    //This method will allow the injection of the Parent ScreenPane
    public void setScreenParent(screensController screenPage, String sessie);
    
}
