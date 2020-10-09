/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ITroncales;
import modelo.Troncales;
import util.SessionManagment;

/**
 *
 * @author migue
 */
public class TroncalesService implements ITroncales{

    @Override
    public void agregarTroncal(Troncales troncales) {
        SessionManagment.openSessionHibernate(troncales);
    }
    
}
