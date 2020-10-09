/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.impl.TroncalesService;
import modelo.Troncales;

/**
 *
 * @author migue
 */
public class TransmilenioJpaController {
    
    private TroncalesService troncalesService;

    public TransmilenioJpaController() {
        troncalesService = new TroncalesService();
    }
    
    public void agregarTroncal(Troncales troncales){
        troncalesService.agregarTroncal(troncales);
    }
    
    
}
